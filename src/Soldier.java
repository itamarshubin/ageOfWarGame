import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Soldier extends JLabel {
    String type;
    int life;
    int damage;
    boolean isDead;
    boolean isAttack;
    boolean isWalking;
    int position;
    BufferedImage attackingImg;
    BufferedImage standingImg;
    BufferedImage walkingImg;
    BufferedImage currentImage;
    boolean attackState = true;
    boolean walkingState = true;
//

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public Soldier(String type) throws IOException {
        allImages pics = new allImages();
        this.type=type;
        this.position=0;
        if (type.equals("normal")){
            this.type="normal";
            this.life=100;
            this.damage = 10;
            this.attackingImg = pics.getSoldierL1Attack();
            this.standingImg = pics.getSoldierL1Standing();
            this.walkingImg = pics.getSoldierL1Walking();
            this.currentImage = calcImage();
        }
        else if (type.equals("archer")) {
            this.type = "archer";
            this.life = 50;
            this.damage = 10;
        }
        else {
            this.type = "defender";
            this.life  = 300;
            this.damage = 10;
            this.attackingImg = pics.getRBAttack();
            this.standingImg = pics.getRBStanding();
            this.walkingImg = pics.getRBWalking();
        }
    }

    private BufferedImage calcImage() {
        BufferedImage currentState;
        if(isAttack){
            if(this.attackState) {
                currentState = getAttackingImg();
                attackState = false;
            }
            else currentState = getStandingImg();
            attackState = true;
        }
         else if(isWalking){
            if(walkingState){
                currentState = getWalkingImg();
                isWalking = false;
            }
            else
                currentState = getStandingImg();
                isWalking = true;
        }

         else
             currentState = getStandingImg();


        return currentState;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isAttack() {
        return isAttack;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public BufferedImage getAttackingImg() {
        return attackingImg;
    }

    public BufferedImage getStandingImg() {
        return standingImg;
    }

    public BufferedImage getWalkingImg() {
        return walkingImg;
    }
}
