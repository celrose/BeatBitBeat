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

public class Monster3 extends Monster {

    private Animation animationIdle;
    private Animation animationSkill1;
    private Animation animationSkill2;
    private Animation animationSkillUlt;
    private Image[] skillIcons;
    // TODO enter proper duration of skill animation when sprites are done
    private Animation animationHumanIdle;

    private final SkillCost costSkill1 = new SkillCost(3, 0, 0, 3);
    private final SkillCost costSkill2 = new SkillCost(0, 7, 7, 0);
    private final SkillCost costSkillUlt = new SkillCost(12, 12, 12, 12);
    private SkillCost currResources;
    // TODO enter proper duration of skill animation when sprites are done
    private static final int skill1Duration = 2100;
    private static final int skill2Duration = 3000;
    private static final int skillUltDuration = 4050;

    private Audio monsterSfx1;
    private Audio monsterSfx2;
    private Audio monsterSfx3;

    private static final int skill1Cooldown = 5000;
    private static final int skill2Cooldown = 7000;
    private static final int skillUltCooldown = 15000;

    private static final int frameDurationMonsterIdle = 260;
    private static final int frameDurationHumanIdle = 300;
    private static final int frameDurationSkill1 = 150;
    private static final int frameDurationSkill2 = 250;
    private static final int frameDurationSkillUlt = 150;

    private static final int damageSkill1 = 15;
    private static final int damageSkill2 = 25;
    private static final int damageSkillUlt = 35;

    private Image imageFaceHealthBar;

    //fire
    public Monster3(int playerNumber) throws SlickException {
        super();
        try {
            monsterSfx1 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Flame/Breathe_Fire.ogg")); //DELAY
            monsterSfx2 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Flame/Scorched_Earth.ogg")); //PWEDE
            monsterSfx3 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("Assets/Sound Effects/Flame/Fireblast.ogg")); //NOPE

        } catch (IOException e) {
            e.printStackTrace();
        }
        skillIcons = new Image[]{
                new Image("Assets/Graphics/Monster and Human Sprites/Flame/Fire fist.png"),
                new Image("Assets/Graphics/Monster and Human Sprites/Flame/Firefly.png"),
                new Image("Assets/Graphics/Monster and Human Sprites/Flame/X-Burner.png")
        };
        if (playerNumber == 1) {
            animationIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Idle P1.png", 600, 300, 0), frameDurationMonsterIdle);
            animationHumanIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Human P1.png", 150, 150, 0), frameDurationHumanIdle);

            animationSkill1 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/firefist p1.png", 600, 300, 0), frameDurationSkill1);
            animationSkill2 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/FireFlyAni.png", 600, 300, 0), frameDurationSkill2);

            imageFaceHealthBar = new Image("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Face Health Bar P1.png");

            Image[] skillUlt = new Image[]{
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn00.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn01.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn02.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn03.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn04.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn05.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn06.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn07.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn08.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn09.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn10.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn11.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn12.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn13.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn14.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn15.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn16.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn17.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn18.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn19.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn20.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn21.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn22.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn23.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn24.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn25.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p1/xburn26.png"),
            };

            int[] duration = new int[]{
                    150,
                    150,
                    150,
                    150,
                    150,
                    150, //6
                    150,
                    150,
                    150,
                    150, //10
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150, //20
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150

            };
            animationSkillUlt = new Animation(skillUlt, duration);
        } else if (playerNumber == 2) {
            animationIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Idle P2.png", 600, 300, 0), frameDurationMonsterIdle);
            animationHumanIdle = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Human P2.png", 150, 150, 0), frameDurationHumanIdle);

            animationSkill1 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/firefist p2.png", 600, 300, 0), frameDurationSkill1);
            animationSkill2 = new Animation(new SpriteSheet("Assets/Graphics/Monster and Human Sprites/Flame/FireFlyAni.png", 600, 300, 0), frameDurationSkill2);

            imageFaceHealthBar = new Image("Assets/Graphics/Monster and Human Sprites/Flame/Flame - Face Health Bar P2.png");
              Image[] skillUlt = new Image[]{
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn00.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn01.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn02.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn03.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn04.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn05.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn06.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn07.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn08.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn09.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn10.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn11.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn12.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn13.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn14.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn15.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn16.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn17.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn18.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn19.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn20.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn21.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn22.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn23.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn24.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn25.png"),
                    new Image("Assets/Graphics/Monster and Human Sprites/Flame/p2/xburn26.png"),
            };

            int[] duration = new int[]{
                    150,
                    150,
                    150,
                    150,
                    150,
                    150, //6
                    150,
                    150,
                    150,
                    150, //10
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150, //20
                    150,
                    150,
                    150,
                    150,
                    150,
                    150,
                    150

            };
            animationSkillUlt = new Animation(skillUlt, duration);
        }

    }

    @Override
    public Image[] getSkillIcons() {
        return skillIcons;
    }

    public void skill1() {
        super.setDamage(damageSkill1);
        super.doSkillCost(costSkill1);
        getAnimationSkill1().restart();
        monsterSfx1.playAsSoundEffect(1.0f, 1.0f, false);

    }

    public void skill2() {
        super.setDamage(damageSkill2);
        super.doSkillCost(costSkill2);
        getAnimationSkill2().restart();
        monsterSfx2.playAsSoundEffect(1.0f, 1.0f, false);

    }

    public void skillUlt() {
        super.setDamage(damageSkillUlt);
        super.doSkillCost(costSkillUlt);
        getAnimationSkillUlt().restart();
        monsterSfx3.playAsSoundEffect(1.0f, 1.0f, false);
    }


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
    public Image getImageFaceHealthBar() {
        return imageFaceHealthBar;
    }


    public static int getFrameDurationMonsterIdle() {
        return frameDurationMonsterIdle;
    }

    public static int getFrameDurationHumanIdle() {
        return frameDurationHumanIdle;
    }
}