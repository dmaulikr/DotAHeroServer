package com.wolf.tool;


public interface client_const {
    
    public static final String kActionStartGame = "startGame"; // 开始游戏
    public static final String kActionUseCard = "useCard"; // 使用卡牌
    public static final String kActionUseHeroSkill = "useHeroSkill"; // 使用英雄技能
    public static final String kActionCancel = "cancel"; // 取消
    //        public static final String kActionDiscard = "discard"; // 确定弃牌
    
    public static final String kActionHeroList = "heroList"; // 所有玩家选中的英雄
    
    public static final String kActionChooseHeroId = "chooseHeroId"; // 选择英雄牌
    public static final String kActionChooseCardId = "chooseCardId"; // 选择卡牌ID
    public static final String kActionChooseColor = "chooseColor"; // 选择卡牌颜色
    public static final String kActionChooseSuits = "chooseSuits"; // 选择卡牌花色
    public static final String kActionChooseYesNo = "chooseYesNo"; // 选择Yes/No
    
    public static final String kActionArrangeCardId = "arrangeCardId";
    
    interface action {
        int count_down = -100;
        int choosing_hero = 2;
        //        int 
    }
    
    //    typedef NS_ENUM(NSInteger, BGCardColor) {
    //        kCardColorInvalid = 0,
    //        kCardColorRed = 1,                  // 红色
    //        kCardColorBlack                     // 黑色
    //    };
    //    
    //    typedef NS_ENUM(NSInteger, BGCardSuits) {
    //        kCardSuitsInvalid = 0,
    //        kCardSuitsHearts = 1,               // 红桃
    //        kCardSuitsDiamonds,                 // 方块
    //        kCardSuitsSpades,                   // 黑桃
    //        kCardSuitsClubs                     // 梅花
    //    };
    //
    //    typedef NS_ENUM(NSInteger, BGCardType) {
    //        kCardTypeBasic = 0,                 // 基本牌
    //        kCardTypeMagic,                     // 魔法牌
    //        kCardTypeSuperSkill,                // S技能牌
    //        kCardTypeEquipment                  // 装备牌
    //    };
    //
    //    typedef NS_ENUM(NSInteger, BGEquipmentType) {
    //        kEquipmentTypeWeapon = 0,           // 武器
    //        kEquipmentTypeArmor                 // 防具
    //    };
    //    typedef NS_ENUM(NSInteger, BGHeroCardEnum) {
    //        kHeroCardDefault = -1,
    //        kHeroCardLordOfAvernus = 0,             // 死亡骑士
    //        kHeroCardSkeletonKing = 1,              // 骷髅王
    //        kHeroCardBristleback = 2,               // 刚背兽
    //        kHeroCardSacredWarrior = 3,             // 神灵武士
    //        kHeroCardOmniknight = 4,                // 全能骑士
    //        kHeroCardAxe = 5,                       // 斧王
    //        kHeroCardCentaurWarchief = 6,           // 半人马酋长
    //        kHeroCardDragonKnight = 7,              // 龙骑士
    //        kHeroCardGuardianKnight = 8,            // 守护骑士
    //        
    //        kHeroCardGorgon = 9,                    // 蛇发女妖
    //        kHeroCardLightningRevenant = 10,        // 闪电幽魂
    //        kHeroCardJuggernaut = 11,               // 剑圣
    //        kHeroCardVengefulSpirit = 12,           // 复仇之魂
    //        kHeroCardStrygwyr = 13,                 // 血魔
    //        kHeroCardTrollWarlord = 14,             // 巨魔战将
    //        kHeroCardDwarvenSniper = 15,            // 矮人火枪手
    //        kHeroCardNerubianAssassin = 16,         // 地穴刺客
    //        kHeroCardAntimage = 17,                 // 敌法师
    //        kHeroCardNerubianWeaver = 18,           // 地穴编织者
    //        kHeroCardUrsaWarrior = 19,              // 熊战士
    //        kHeroCardChenYunSheng = 20,             // 陈云生
    //        
    //        kHeroCardSlayer = 21,                   // 秀逗魔导师
    //        kHeroCardNecrolyte = 22,                // 死灵法师
    //        kHeroCardTwinHeadDragon = 23,           // 双头龙
    //        kHeroCardCrystalMaiden = 24,            // 水晶室女
    //        kHeroCardLich = 25,                     // 巫妖
    //        kHeroCardShadowPriest = 26,             // 暗影牧师
    //        kHeroCardOrgeMagi = 27,                 // 食人魔法师
    //        kHeroCardKeeperOfTheLight = 28,         // 光之守卫
    //        kHeroCardGoblinTechies = 29,            // 哥布林工程师
    //        kHeroCardStormSpirit = 30,              // 风暴之灵
    //        kHeroCardEnchantress = 31,              // 魅惑魔女
    //        kHeroCardElfLily = 32                   // 精灵莉莉
    //    };
    //
    //    typedef NS_ENUM(NSInteger, BGHeroAttribute) {
    //        kHeroAttributeStrength = 1,             // 力量型
    //        kHeroAttributeAgility,                  // 敏捷型
    //        kHeroAttributeIntelligence              // 智力型
    //    };
    //    typedef NS_ENUM(NSInteger, BGHeroSkillEnum) {
    //        kHeroSkillDefault = -1,
    //        kHeroSkillDeathCoil = 0,                // 死亡缠绕
    //        kHeroSkillFrostmourne = 1,              // 霜之哀伤
    //        
    //        kHeroSkillReincarnation = 2,            // 重生
    //        kHeroSkillVampiricAura = 3,             // 吸血
    //        
    //        kHeroSkillWarpath = 4,                  // 战意
    //        kHeroSkillBristleback = 5,              // 刚毛后背
    //        
    //        kHeroSkillLifeBreak = 6,                // 牺牲
    //        kHeroSkillBurningSpear = 7,             // 沸血之矛
    //        
    //        kHeroSkillPurification = 8,             // 洗礼
    //        kHeroSkillHolyLight = 9,                // 圣光
    //        
    //        kHeroSkillBattleHunger = 10,            // 战争饥渴
    //        kHeroSkillCounterHelix = 11,            // 反转螺旋
    //        
    //        kHeroSkillDoubleEdge = 12,              // 双刃剑
    //        
    //        kHeroSkillBreatheFire = 13,             // 火焰气息
    //        kHeroSkillDragonBlood = 14,             // 龙族血统
    //
    //        kHeroSkillGuardian = 15,                // 援护
    //        kHeroSkillFaith = 16,                   // 信仰
    //        kHeroSkillFatherlyLove = 17,            // 父爱
    //        
    //        kHeroSkillMysticSnake = 18,             // 秘术异蛇
    //        kHeroSkillManaShield = 19,              // 魔法护盾
    //        
    //        kHeroSkillPlasmaField = 20,             // 等离子场
    //        kHeroSkillUnstableCurrent = 21,         // 不定电流
    //        
    //        kHeroSkillOmnislash = 22,               // 无敌斩
    //        kHeroSkillBladeDance = 23,              // 剑舞
    //        
    //        kHeroSkillNetherSwap = 24,              // 移形换位
    //        kHeroSkillWaveOfTerror = 25,            // 恐怖波动
    //        
    //        kHeroSkillBloodrage = 26,               // 血之狂暴
    //        kHeroSkillStrygwyrsThirst = 27,         // 嗜血
    //        kHeroSkillBloodBath = 28,               // 屠戮
    //        
    //        kHeroSkillBattleTrance = 29,            // 战斗专注
    //        kHeroSkillFervor = 30,                  // 热血战魂
    //        
    //        kHeroSkillHeadshot = 31,                // 爆头
    //        kHeroSkillTakeAim = 32,                 // 瞄准
    //        kHeroSkillShrapnel = 33,                // 散弹
    //        
    //        kHeroSkillManaBurn = 34,                // 法力燃烧
    //        kHeroSkillVendetta = 35,                // 复仇
    //        kHeroSkillSpikedCarapace = 36,          // 穿刺护甲
    //        
    //        kHeroSkillManaBreak = 37,               // 法力损毁
    //        kHeroSkillBlink = 38,                   // 闪烁
    //        kHeroSkillManaVoid = 39,                // 法力虚空
    //        
    //        kHeroSkillTheSwarm = 40,                // 蝗虫群
    //        kHeroSkillTimeLapse = 41,               // 时光倒流
    //        
    //        kHeroSkillFurySwipes = 42,              // 怒意狂击
    //        kHeroSkillEnrage = 43,                  // 激怒
    //        
    //        kHeroSkillOrdeal = 44,                  // 神判
    //        kHeroSkillSpecialBody = 45,             // 特殊体质
    //        
    //        kHeroSkillFierySoul = 46,               // 炽魂
    //        kHeroSkillLagunaBlade = 47,             // 神灭斩
    //        kHeroSkillFanaticismHeart = 48,         // 狂热之心
    //        
    //        kHeroSkillHeartstopperAura = 49,        // 竭心光环
    //        kHeroSkillSadist = 50,                  // 施虐之心
    //        
    //        kHeroSkillIcePath = 51,                 // 冰封
    //        kHeroSkillLiquidFire = 52,              // 液态火
    //        
    //        kHeroSkillFrostbite = 53,               // 冰封禁制
    //        kHeroSkillBrillianceAura = 54,          // 辉煌光环
    //        
    //        kHeroSkillDarkRitual = 55,              // 邪恶祭祀
    //        kHeroSkillFrostArmor = 56,              // 霜冻护甲
    //        
    //        kHeroSkillShallowGrave = 57,            // 薄葬
    //        kHeroSkillShadowWave = 58,              // 暗影波
    //        
    //        kHeroSkillFireblast = 59,               // 火焰爆轰
    //        kHeroSkillMultiCast = 60,               // 多重施法
    //        
    //        kHeroSkillIlluminate = 61,              // 冲击波
    //        kHeroSkillChakraMagic = 62,             // 查克拉
    //        kHeroSkillGrace = 63,                   // 恩惠
    //        
    //        kHeroSkillRemoteMines = 64,             // 遥控炸弹
    //        kHeroSkillFocusedDetonate = 65,         // 引爆
    //        kHeroSkillSuicideSquad = 66,            // 自爆
    //        
    //        kHeroSkillOverload = 67,                // 超负荷
    //        kHeroSkillBallLightning = 68,           // 球状闪电
    //        
    //        kHeroSkillUntouchable = 69,             // 不可侵犯
    //        kHeroSkillEnchant = 70,                 // 魅惑
    //        kHeroSkillNaturesAttendants = 71,       // 自然之助
    //        
    //        kHeroSkillHealingSpell = 72,            // 治疗术
    //        kHeroSkillDispelWizard = 73,            // 驱散精灵
    //        kHeroSkillMagicControl = 74             // 魔法掌控
    //    };
    //
    //    typedef NS_ENUM(NSInteger, BGHeroSkillCategory) {
    //        kHeroSkillCategoryActive = 0,           // 主动技能
    //        kHeroSkillCategoryPassive,              // 被动技能
    //    };
    //
    //    typedef NS_ENUM(NSInteger, BGHeroSkillType) {
    //        kHeroSkillTypeGeneral = 0,              // 普通技
    //        kHeroSkillTypeRestricted,               // 限制技
    //        kHeroSkillTypeLimited                   // 限定技
    //    };
    
}