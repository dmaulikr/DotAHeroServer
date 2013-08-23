package com.wolf.dotah.server.layer.translator;

import com.electrotank.electroserver5.extensions.api.ScheduledCallback;
import com.electrotank.electroserver5.extensions.api.value.EsObject;
import com.wolf.dotah.server.GamePlugin;
import com.wolf.dotah.server.util.c;
import com.wolf.dotah.server.util.u;
import com.wolf.tool.client_const;

public class MessageDispatcher {
    
    private TableTranslator tableTranslator;
    private PlayerTranslator playerTranslator;
    private DecisionTranslator decisionTranslator;
    private GamePlugin plugin;
    
    public void sendMessageToSingleUser(String user, EsObject msg) {
    
        plugin.getApi().sendPluginMessageToUser(user, msg);
    }
    
    public void sendMessageToAll(EsObject msg) {
    
    }
    
    public void sendMessageToAllWithoutSpecificUser(EsObject msg, String exceptionUser) {
    
    }
    
    private int schedule_waiting_for_everybody_id = -1;
    private int tickCounter = -1;
    
    //TODO 想想能不能抽出来waiter之类的 组件
    public MessageDispatcher waitingForEverybody() {
    
        schedule_waiting_for_everybody_id = plugin.getApi().scheduleExecution(1000, -1, new WaitingForEverybody());
        return this;
    }
    
    class WaitingForEverybody implements ScheduledCallback {
        
        @Override
        public void scheduledCallback() {
        
            tick();
            
            //TODO 2种条件cancel count down, 
            //一种是所有人都选完, 
            //另一种是时间到
        }
        
        public void tick() {
        
            //            if (gameState != GameState.Waiting) { return; }
            if (tickCounter < 1) {
                //TODO 自动发给每个人牌, 然后cancel tick
                plugin.getApi().cancelScheduledExecution(schedule_waiting_for_everybody_id);
            } else {
                sendCountDownSecondsLeftMessage();
            }
        }
        
        private void sendCountDownSecondsLeftMessage() {
        
            EsObject message = new EsObject();
            message.setInteger(c.action, client_const.action.count_down);
            message.setInteger(c.param_key.left, tickCounter);
            //            sendAndLog("GoFishGame.sendCountDownSecondsLeftMessage", message);
            tickCounter--;
        }
        
    }
    
    public void becauseOf(String serverAction) {
    
        // TODO 根据becauseOf莱判断waiting结束条件
        
    }
    
    public void handleMessage(String user, EsObject msg) {
    
        int client_message = msg.getInteger(c.action, -1);
        if (client_const.ACTION_START_GAME == client_message) {
            System.out.println("plugin: " + plugin);
            tableTranslator.translateGameStartFromClient(plugin, msg);
        } else if (client_const.ACTION_code_CHOSE_hero == client_message) {
            decisionTranslator.translateChose(user, msg);
        }
        //TODO 这个chose hero id的action, 就该交给decision translator?
        //        else if (c.client_constants.kActionChooseHeroId.equals(client_message)) {
        //            Player p = desk.getPlayerByUserName(user);
        //            p.setHeroId(message.getIntegerArray(c.choosing.id_list)[0]);
        //            //            desk.
        //        }
    }
    private static MessageDispatcher dispatcher;
    
    public static MessageDispatcher getDispatcher(GamePlugin gamePlugin) {
    
        if (dispatcher == null) {
            dispatcher = new MessageDispatcher(gamePlugin);
        }
        return dispatcher;
    }
    
    private MessageDispatcher(GamePlugin gamePlugin) {
    
        this.plugin = gamePlugin;
        tableTranslator = TableTranslator.getTranslator();
        playerTranslator = PlayerTranslator.getTranslator();
        decisionTranslator = DecisionTranslator.getTranslator();
        playerTranslator.setDecisionTranslator(decisionTranslator);
    }
    
}
