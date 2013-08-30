package com.wolf.dotah.server.cmpnt.table.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.electrotank.electroserver5.extensions.api.ScheduledCallback;
import com.wolf.dotah.server.MessageDispatcher;
import com.wolf.dotah.server.cmpnt.Data;
import com.wolf.dotah.server.cmpnt.Player;
import com.wolf.dotah.server.cmpnt.TableModel.tablevar;
import com.wolf.dotah.server.cmpnt.card.Card;
import com.wolf.dotah.server.cmpnt.table.table_const.tablecon;
import com.wolf.dotah.server.util.c;
import com.wolf.dotah.server.util.client_const;
import com.wolf.dotah.server.util.u;

public class CutCard implements ScheduledCallback {
    
    MessageDispatcher disp;
    int waitingType;
    int tickCounter = tablevar.wait_time;
    
    public CutCard(MessageDispatcher dispatcher, int waitingType) {
        this.disp = dispatcher;
        this.waitingType = waitingType;
    }
    
    @Override
    public void scheduledCallback() {
        boolean allConfirmed = checkWaitingState();
        boolean autoDesided = tick();
        if (allConfirmed || autoDesided) {
            goon(autoDesided);
        }
        //TODO 2种条件cancel count down, 
        //一种是所有人都选完, 
        //另一种是时间到
    }
    
    private void goon(boolean autoDesided) {
        
        waitingType = c.game_state.waiting_type.none;
        //TODO 给每个人手里都减少一张牌
        //TODO 发给client id list
        Map<String, Integer> cutCards = disp.getTableTranslator().getTable().getCutCards();
        List<Player> pl = disp.getTableTranslator().getPlayerList().getPlayerList();
        List<Integer> cards = new ArrayList<Integer>();
        for (int i = 0; i < cutCards.size(); i++) {
            Player p = pl.get(i);
            int card = cutCards.get(p.getUserName());
            cards.add(card);
            p.getProperty().getHandCards().remove(card, autoDesided);
        }
        Data data = new Data();
        data.setAction(c.ac.cutted);
        data.setIntegerArray(c.param_key.id_list, u.intArrayMapping(cards.toArray(new Integer[cards.size()])));
        data.setInteger(client_const.param_key.hand_card_count, pl.get(0).getProperty().getHandCards().getCards().size());
        disp.sendMessageToAll(data);
        //TODO 先拼点, 
        String biggestPlayer = "";
        int biggestFaceNumber = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card c = disp.getTableTranslator().getTable().getDeck().getCardById(cards.get(i));
            if (c.getFaceNumber() > biggestFaceNumber) {
                biggestFaceNumber = c.getFaceNumber();
                biggestPlayer = pl.get(i).getUserName();
            }
        }
        disp.getTableTranslator().startTurn(biggestPlayer);
    }
    
    private boolean checkWaitingState() {
        if (disp.getTableTranslator().getTable().getCutCards().size() == disp.getTableTranslator().getTable().getPlayers().getCount()) {
            disp.cancelScheduledExecution(disp.cutting);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean tick() {
        
        if (waitingType == c.game_state.waiting_type.none) {
            disp.cancelScheduledExecution(disp.cutting);
        } else if (tickCounter < 1) {
            boolean autoDesided = false;
            if (disp.getTableTranslator().getTable().getState().getState() == tablecon.state.not_started.cutting) {
                autoDesideCutting();
                autoDesided = true;
            }
            disp.cancelScheduledExecution(disp.cutting);
            waitingType = c.game_state.waiting_type.none;
            return autoDesided;
        } else {
            tickCounter--;
        }
        return false;
    }
    
    private void autoDesideCutting() {
        for (Player p : disp.getTableTranslator().getTable().getPlayers().getPlayerList()) {
            if (!disp.getTableTranslator().getTable().getCutCards().keySet().contains(p.getUserName())) {
                p.performSimplestChoice();
            }
        }
    }
}
