/**
 * Albores, Allyssa
 * Bedio, Aiden Justin
 * Malaki, Earl Timothy
 * Paler, Timothy River
 * <p>
 * BSCS - II | UP - Cebu
 * CMSC22 - OOP
 * Final Project
 * <p>
 * Done:
 * - basic skeleton code for concrete monster
 * <p>
 * To Do:
 * - add specific identity/behaviour (skills, capabilities, etc.)
 * - do this to the remaining monsters
 * <p>
 * game.Note:
 * <p>
 * Done:
 * - basic skeleton code for concrete monster
 * <p>
 * To Do:
 * - add specific identity/behaviour (skills, capabilities, etc.)
 * - do this to the remaining monsters
 * <p>
 * game.Note:
 * <p>
 * Done:
 * - basic skeleton code for concrete monster
 * <p>
 * To Do:
 * - add specific identity/behaviour (skills, capabilities, etc.)
 * - do this to the remaining monsters
 * <p>
 * game.Note:
 */

/**
 * Done:
 * - basic skeleton code for concrete monster
 *
 * To Do:
 * - add specific identity/behaviour (skills, capabilities, etc.)
 * - do this to the remaining monsters
 * <p>
 * game.Note:
 */

/**
 * Done:
 * - basic skeleton code for concrete monster
 *
 * To Do:
 * - add specific identity/behaviour (skills, capabilities, etc.)
 * - do this to the remaining monsters
 *
 * game.Note:
 *
 */

package game.monsters;

import game.SkillCost;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Monster1 extends Monster {

    private Animation animationIdle;
    private Animation animationSkill1;
    private Animation animationSkill2;
    private Animation animationSkillUlt;

    private Image[] skillIcons;
    private Animation animationHumanIdle;


    private final SkillCost costSkill1 = new SkillCost(3, 0, 0, 3);
    private final SkillCost costSkill2 = new SkillCost(0, 7, 7, 0);
    private final SkillCost costSkillUlt = new SkillCost(12, 12, 12, 12);
    private Audio monsterSfx1;
    private Audio monsterSfx2;
    private Audio monsterSfx3;
    private static final int skill1Duration = 1400;
    private static final int skill2Duration = 2990;
    private static final int skillUltDuration = 2000;

    private static final int skill1Cooldown = 3000;
    private static final int skill2Cooldown = 7000;
    private static final int skillUltCooldown = 15000;

    private static final int frameDurationMonsterIdle = 250;
    private static final int frameDurationHumanIdle = 200;
    private static final int frameDurationSkill1 = 200;
    private static final int frameDurationSkill2 = 230;
    private static final int frameDurationSkillUlt = 200;

    private static final int damageSkill1 = 15;
    private static final int damageSkill2 = 25;
    private static final int damageSkillUlt = 35;

    private Image imageFaceHealthBar;


    public Monster1(int playerNumber) throws SlickException, IOException {
        super();

        skillIcons = new Image[]{
                new Image("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 1 Blistol Icon.png"),
                new Image("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 2 Gatling Icon.png"),
                new Image("Assets/Graphics/Monster and Human Sprites/Blueffy/B3rd.png")
        };
        //TODO replace with correct files
        monsterSfx1 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Blueffy/Storm_Hammer.ogg")); //PWEDE PWEDE
        monsterSfx2 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Blueffy/Rocket_Barrage.ogg")); //NOT SYNC
        monsterSfx3 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Blueffy/Reverse_Polarity.ogg")); //NOT SYNC



        if (playerNumber == 1) {
            animationIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Idle P1.png", 600, 300, 0), frameDurationMonsterIdle);
            animationHumanIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Human P1.png", 150, 150, 0), frameDurationHumanIdle);

            animationSkill1 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 1 Blistol P1.png", 600, 300, 0), frameDurationSkill1);
            animationSkill2 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 2 Gatling P1.png", 600, 300, 0), frameDurationSkill2);
            animationSkillUlt = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 3 Bluezooka P1.png", 600, 300, 0), frameDurationSkillUlt);

            imageFaceHealthBar = new Image("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Face Health Bar P1.png");

        } else if (playerNumber == 2) {
            animationIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Idle P2.png", 600, 300, 0), frameDurationMonsterIdle);
            animationHumanIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Human P2.png", 150, 150, 0), frameDurationHumanIdle);

            animationSkill1 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 1 Blistol P2.png", 600, 300, 0), frameDurationSkill1);
            animationSkill2 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 2 Gatling P2.png", 600, 300, 0), frameDurationSkill2);
            animationSkillUlt = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - 3 Bluezooka P2.png", 600, 300, 0), frameDurationSkillUlt);

            imageFaceHealthBar = new Image("Assets/Graphics/Monster and Human Sprites/Blueffy/Blueffy - Face Health Bar P2.png");
        }
    }

    public void skill1() {
        super.setDamage(damageSkill1);
        super.doSkillCost (costSkill1);
        getAnimationSkill1().restart();
        monsterSfx1.playAsSoundEffect(1.0f, 1.0f, false);

//        monsterSfx1.playAsMusic(1.0f, 1.0f, true);

    }

    public void skill2() {
        super.setDamage(damageSkill2);
        super.doSkillCost(costSkill2);
        getAnimationSkill2().restart();
        monsterSfx2.playAsSoundEffect(1.0f, 1.0f, false);
//        monsterSfx2.playAsMusic(1.0f, 1.0f, true);
    }

    public void skillUlt() {
        super.setDamage(damageSkillUlt);
        super.doSkillCost(costSkillUlt);
        getAnimationSkillUlt().restart();
//        monsterSfx3.playAsMusic(1.0f, 1.0f, true);
        monsterSfx3.playAsSoundEffect(1.0f, 1.0f, false);
    }

    public Image[] getSkillIcons() {
        return skillIcons;
    }

    @Override
    public int getDurationSkill1() {
        return skill1Duration;
    }

    @Override
    public int getDurationSkill2() {
        return skill2Duration;
    }

    @Override
    public int getDurationSkillUlt() {
        return skillUltDuration;
    }

    @Override
    public int getCooldownSkill1() {
        return skill1Cooldown;
    }

    @Override
    public int getCooldownSkill2() {
        return skill2Cooldown;
    }

    @Override
    public int getCooldownSkillUlt() {
        return skillUltCooldown;
    }

    @Override
    public SkillCost getCostSkill1() {
        return costSkill1;
    }

    @Override
    public SkillCost getCostSkill2() {
        return costSkill2;
    }

    @Override
    public SkillCost getCostSkillUlt() {
        return costSkillUlt;
    }

    @Override
    public Animation getAnimationIdle() {
        return animationIdle;
    }

    @Override
    public Animation getAnimationHumanIdle() {
        return animationHumanIdle;
    }

    @Override
    public Animation getAnimationSkill1() {
        return animationSkill1;
    }

    @Override
    public Animation getAnimationSkill2() {
        return animationSkill2;
    }

    @Override
    public Animation getAnimationSkillUlt() {
        return animationSkillUlt;
    }

    public static int getFrameDurationMonsterIdle() {
        return frameDurationMonsterIdle;
    }

    public static int getFrameDurationHumanIdle() {
        return frameDurationHumanIdle;
    }

    public Image getImageFaceHealthBar() {
        return imageFaceHealthBar;
    }
}