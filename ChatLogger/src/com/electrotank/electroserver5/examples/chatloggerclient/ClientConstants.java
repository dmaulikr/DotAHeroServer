package com.electrotank.electroserver5.examples.chatloggerclient;

public interface ClientConstants {
    public static final String ACTION = "action";
    public static final int
            ACTION_USER_READY = 0,
            ACTION_START_GAME = 1,
            ACTION_CHOOSE_CHARACTER = 2,
            ACTION_CHOSE_CHARACTER = 3,
            ACTION_ALL_HEROS = 4,
            ACTION_DISPATCH_FORCE = 5,
            ACTION_DISPATCH_HANDCARD = 6, //should along with cards
            ACTION_START_TURN = 7,
            ACTION_DRAW_CARDS = 8, //client send to server
            ACTION_STAKE = 9,
            ACTION_SEND_CARDS = 10, //server send to client
            ACTION_USED_CARD = 11,
            ACTION_HP_DAMAGED = 13,
            ACTION_HP_RESTORE = 14,
            ACTION_SP_UP = 15,
            ACTION_SP_LOST = 16,
            
            ACTION_BASE = 100,
            ACTION_NORMAL_ATTACK = ACTION_BASE + 1,
            ACTION_EVASION = ACTION_BASE + 2;
    
    public static final String
            CHARACTORS_TO_CHOOSE = "toBeSelectedHeroIds",
            SORTED_PLAYER_NAMES = "sortedPlayerNames",
            STACK_CARD_COUNT = "remainingCardCount",
            SELECTED_HERO_ID = "heroId",
            ALL_HEROS = "allHeroIds",
            ROLE_IDS = "roleIds", //value for dispatch force action
            DISPATCH_CARDS = "gotPlayingCardIds",
            USED_CARDS = "UsedPlayingCardIds",
            PLAYER_NAME = "playerName",
            TARGET_PLAYERS = "targetPlayerNames",
            FORCE = "force",
            ALL_STAKE_CARDS = "allCuttingCardIds",
            HP_CHANGED = "hpChanged",
            SP_CHANGED = "spChanged";
    /** client message */
    
    public static final String USER_INPUT_MESSAGE_CHOSE_CHARACTER = "chose_character";
    public static final String USER_INPUT_MESSAGE_START = "start";
}
