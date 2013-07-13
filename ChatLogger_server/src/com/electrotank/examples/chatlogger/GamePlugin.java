package com.electrotank.examples.chatlogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.electrotank.electroserver5.extensions.BasePlugin;
import com.electrotank.electroserver5.extensions.api.value.EsObject;
import com.electrotank.electroserver5.extensions.api.value.EsObjectRO;
import com.electrotank.electroserver5.extensions.api.value.UserValue;
import com.electrotank.examples.chatlogger.components.CardEnum;
import com.electrotank.examples.chatlogger.components.CharacterEnum;
import com.electrotank.examples.chatlogger.components.DeskModel;
import com.electrotank.examples.chatlogger.components.Player;
import com.electrotank.examples.chatlogger.components.PluginConstants;

public class GamePlugin extends BasePlugin {
    private List<CharacterEnum> allCharactersForChoose           = new ArrayList<CharacterEnum>();
    private List<String>        players;
    private Player[]            realPlayers;
    private int[]               playerChoseCharactors;
    private boolean             gameStarted                      = false;
    private List<CardEnum>      cardStack;
    private List<CardEnum>      dropStack;
    
    private String[]            playerStates;
    private final String        player_state_character_confirmed = "char_confirmed";
    private final String        player_state_staked              = "staked";
    private final String        player_state_waiting_for_stake   = "wait_stake";
    //势力
    private Integer[]           force;
    private final int           force_a                          = 1;
    private final int           force_b                          = 5;
    
    /******** game state start ********/
    private final int           playerFlagInGameState            = 1;
    private final int           stateFlagInGameState             = 0;
    private final int           gameStage_none                   = -1;
    private final int           playerIndex_none                 = -1;
    private int[]               gameState                        = new int[2];
    {
        gameState[stateFlagInGameState] = gameStage_none;
        gameState[playerFlagInGameState] = playerIndex_none;
    }
    
    private int[]               playerStakes;
    @SuppressWarnings("unused")
    private DeskModel           desk;
    
    /******** game state end ********/
    
    @Override
    public void init(EsObjectRO parameters) {
        
        initCharactorsRandomly();
        getApi().getLogger().debug("ChatPlugin initialized");
    }
    
    private void initCharactorsRandomly() {
        allCharactersForChoose = Arrays.asList(CharacterEnum.values());
        Collections.shuffle(allCharactersForChoose);
        d.debug("List<CharacterEnum> charactors is ready");
    }
    
    @Override
    public void request(String user, EsObjectRO message) {
        EsObject messageIn = new EsObject();
        messageIn.addAll(message);
        getApi().getLogger().debug(user + " requests: " + messageIn.toString());
        
        int action = messageIn.getInteger(PluginConstants.ACTION);
        
        if (action == PluginConstants.ACTION_START_GAME && !gameStarted) {
            getApi().getLogger().debug("got action start game");
            players = new ArrayList<String>();
            reorderUsers();
            
            /*  init information depending on player size and order   */
            initSizes();
            chooseCharacters(messageIn);
            gameStarted = true;
            
        } else if (action == PluginConstants.ACTION_CHOSE_CHARACTER) {
            choseCharacter(user, messageIn);
            
        } else if (action == PluginConstants.ACTION_DRAW_CARDS) {
            dispatchHandCards(user);
        } else if (action == PluginConstants.ACTION_STAKE) {
            gotStakeCard(user, messageIn);
        }
        
    }
    
    private void initSizes() {
        playerChoseCharactors = new int[players.size()];
        force = new Integer[players.size()];
        playerStates = new String[players.size()];
        playerStakes = new int[players.size()];
        realPlayers = new Player[players.size()];
        //TODO deprecating above logics, change to use desk model
        desk = new DeskModel(players.size());
    }
    
    private void gotStakeCard(String user, EsObject messageIn) {
        playerStates[players.indexOf(user)] = player_state_staked;
        playerStakes[players.indexOf(user)] = messageIn
                .getInteger(PluginConstants.STAKE_CARD);
        dropStack.add(CardEnum.valueOf("_" + playerStakes[players.indexOf(user)]));
        for (String playerState : playerStates) {
            if (!playerState.equals(player_state_staked)) { return; }
        }
        
        int biggestNumber = CardEnum.valueOf("_" + playerStakes[0]).getPokerValue();
        String startPlayer = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            int stake = CardEnum.valueOf("_" + playerStakes[i]).getPokerValue();
            if (stake > biggestNumber) {
                biggestNumber = stake;
                startPlayer = players.get(i);
            }
        }
        //        players = reorderPlayer(startPlayer);
        //TODO reorder playerChoseCharactors
        //TODO reorder force
        
        gameTurn(startPlayer);
        
    }
    
    private List<String> reorderPlayer(String startPlayer) {
        int startCount = players.indexOf(startPlayer);
        List<String> newPlayerList = new ArrayList<String>();
        for (int i = 0; i < players.size(); i++) {
            if ((i + startCount) < players.size()) {
                newPlayerList.add(players.get(i + startCount));
            } else {
                newPlayerList.add(players.get((i + startCount) - players.size()));
            }
        }
        return newPlayerList;
    }
    
    private void gameTurn(String player) {
        EsObject obj = new EsObject();
        obj.setInteger(PluginConstants.ACTION, PluginConstants.ACTION_START_TURN);
        obj.setString(PluginConstants.PLAYER_NAME, player);
        //        sendGamePluginMessageToRoom(obj);
        for (String p : players) {
            sendGamePluginMessageToUser(p, obj);
        }
        //TODO 判断是否跳过摸牌阶段, 如果没跳过, 就抓拍
        dispatchHandCards(player);
    }
    
    //    private void hitOne(String user, EsObject messageIn) {
    
    //TODO drop stack add this card
    
    //TODO someone hitted 
    //        String target = messageIn.getString(PluginConstants.HIT_TARGET);
    //        messageIn.setString(PluginConstants.ACTION, 
    //PluginConstants.ACTION_ATTACHED);
    //        
    //    }
    
    /**************** logic in game loop end ***************************/
    
    /**************** logic before game start start ***************************/
    
    private void initCardStack() {
        cardStack = new LinkedList<CardEnum>(Arrays.asList(CardEnum.values()));
        Collections.shuffle(cardStack);
        getApi().getLogger().debug("card stack is ready to use,");
        dropStack = new LinkedList<CardEnum>();
    }
    
    private void dispatchHandCards(String player) {
        dispatchHandCards(player, 2, PluginConstants.ACTION_SEND_CARDS);
    }
    
    private void dispatchHandCards(String player, int howmany, int action) {
        EsObject obj = new EsObject();
        int[] cards = new int[howmany];
        for (int i = 0; i < howmany; i++) {
            cards[i] = cardStack.get(i).getCardId();
            d.debug(logprefix + "cardStack size : " + cardStack.size());
            cardStack.remove(0);
            
        }
        obj.setInteger(PluginConstants.ACTION, action);
        obj.setIntegerArray(PluginConstants.DISPATCH_CARDS, cards);
        
        sendGamePluginMessageToUser(player, obj);
    }
    
    private synchronized void choseCharacter(String user, EsObject messageIn) {
        getApi().getLogger().debug(
                logprefix + "set to user : " + user + " of index in players list : "
                        + players.indexOf(user));
        playerChoseCharactors[players.indexOf(user)] = messageIn
                .getInteger(PluginConstants.SELECTED_HERO_ID);
        
        playerStates[players.indexOf(user)] = player_state_character_confirmed;
        
        //after all players has chose their characters, then dispatch states
        
        for (int i = 0; i < players.size(); i++) {
            String playerState = playerStates[i];
            if (playerState == null ||
                    !playerState.equals(player_state_character_confirmed)) { return; }
        }
        sendAllHeros();
        initCardStack();
        dispatchForce();
        for (String player : players) {
            dispatchHandCards(player, 5, PluginConstants.ACTION_DISPATCH_HANDCARD);
        }
        
        // then wait for stake
        for (int i = 0; i < players.size(); i++) {
            playerStates[i] = player_state_waiting_for_stake;
        }
        
    }
    
    private int nextPlayer() {
        int nextPlayerIndex = gameState[playerFlagInGameState] + 1;
        if (nextPlayerIndex > players.size()) {
            nextPlayerIndex = 0;
        }
        gameState[playerFlagInGameState] = nextPlayerIndex;
        return nextPlayerIndex;
    }
    
    private void sendAllHeros() {
        EsObject obj = new EsObject();
        obj.setInteger(PluginConstants.ACTION, PluginConstants.ACTION_ALL_HEROS);
        obj.setIntegerArray(PluginConstants.ALL_HEROS, playerChoseCharactors);
        for (String player : players) {
            sendGamePluginMessageToUser(player, obj);
        }
        
        //        sendGamePluginMessageToRoom(obj);
    }
    
    private void dispatchForce() {
        EsObject obj = new EsObject();
        List<Integer> forceList = Arrays.asList(new Integer[] { force_a, force_b });
        
        switch (players.size()) {
            case 1: {
                forceList = Arrays.asList(new Integer[] { force_a });
                break;
            }
            case 2: {
                forceList = Arrays.asList(new Integer[] { force_a, force_b });
                break;
            }
            case 3: {
                forceList = Arrays.asList(new Integer[] { force_a, force_b, force_a });
                break;
            }
            case 4: {
                forceList = Arrays
                        .asList(new Integer[] { force_a, force_b, force_a, force_b });
                break;
            }
            case 5: {
                forceList = Arrays.asList(new Integer[] { force_a, force_b, force_a, force_b,
                        force_a });
                break;
            }
        }
        
        Collections.shuffle(forceList);
        force = forceList.toArray(new Integer[players.size()]);
        getApi().getLogger().debug("dispatching force: " + Arrays.toString(force));
        
        obj.setInteger(PluginConstants.ACTION, PluginConstants.ACTION_DISPATCH_FORCE);
        obj.setInteger(PluginConstants.STACK_CARD_COUNT, cardStack.size());
        for (int i = 0; i < force.length; i++) {
            int f = force[i];
            obj.setInteger(PluginConstants.FORCE, f);
            sendGamePluginMessageToUser(players.get(i), obj);
        }
    }
    
    private void reorderUsers() {
        for (UserValue user : getApi().getUsersInRoom(getApi().getZoneId(),
                getApi().getRoomId())) {
            players.add(user.getUserName());
        }
    }
    
    private void chooseCharacters(EsObject obj) {
        
        getApi().getLogger().debug("players = " + players.size());
        for (int i = 0; i < players.size(); i++) {
            int[] charsToChoose = new int[3];
            String player = players.get(i);
            for (int choosingCount = 0; choosingCount < charsToChoose.length; choosingCount++) {
                int shouldAddCharacterCount = i * charsToChoose.length + choosingCount;
                getApi().getLogger()
                        .debug(
                                "charsToChoose = " + Arrays.toString(charsToChoose) + "\n"
                                        + "choosingCount = " + choosingCount + "\n"
                                        + "shouldAddCharacterCount = "
                                        + shouldAddCharacterCount);
                charsToChoose[choosingCount] = allCharactersForChoose.get(
                        shouldAddCharacterCount).getId();
            }
            obj.setInteger(PluginConstants.ACTION, PluginConstants.ACTION_CHOOSE_CHARACTER);
            obj.setIntegerArray(PluginConstants.CHARACTORS_TO_CHOOSE, charsToChoose);
            sendGamePluginMessageToUser(player, obj);
            getApi().getLogger().debug(
                    "Characters " + Arrays.toString(charsToChoose)
                            + " are sending to player " + player);
        }
        
    }
    
    //    private void sendGamePluginMessageToRoom(EsObject obj) {
    //        if (cardStack != null) {
    //            obj.setInteger(PluginConstants.STACK_CARD_COUNT, cardStack.size());
    //        }
    //        getApi().sendPluginMessageToRoom(getApi().getZoneId(), getApi().getRoomId(), obj);
    //    }
    
    private void sendGamePluginMessageToUser(String user, EsObject obj) {
        if (cardStack != null) {
            obj.setInteger(PluginConstants.STACK_CARD_COUNT, cardStack.size());
        }
        getApi().sendPluginMessageToUser(user, obj);
    }
    
    private static final String logprefix = "======== game =>> ";
    
    private class D {
        public void debug(String message) {
            getApi().getLogger().debug(message);
        }
    }
    
    private D d = new D();
    
    //TODO 所有的发送EsObj都携带牌堆中的牌数
    
}
