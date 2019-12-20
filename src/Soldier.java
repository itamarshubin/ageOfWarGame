import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Soldier extends JLabel {
    String type;
    int life;
    int damage;
    boolean isDead;
    boolean isAttack;
    boolean isWalking;
    int speed;
    int position;
    BufferedImage attackingImg;
    BufferedImage standingImg;
    BufferedImage walkingImg;
    BufferedImage currentImage;

//

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public Soldier(String type, boolean isDerechChaim) throws IOException {
        this.setBackground(Color.RED);
        if (isDerechChaim)
            this.setBounds(70,550,150,150);
        else
            this.setBounds(910,550,150,150);

        allImages pics = new allImages();
        this.type=type;
        this.position=0;
        if (type.equals("normal")){
            this.type="normal";
            this.life=100;
            this.damage = 10;
            if (isDerechChaim) {
                this.attackingImg = pics.getSoldierL1Attack();
                this.standingImg = pics.getSoldierL1Standing();
                this.walkingImg = pics.getSoldierL1Walking();
                this.speed=3;
            }else{
                this.attackingImg = pics.getCHsoldierL1Attack();
                this.standingImg = pics.getCHsoldierL1Standing();
                this.walkingImg = pics.getCHsoldierL1Walking();
                this.speed=-3;
            }
            this.isWalking = true;
            this.currentImage = standingImg;
            this.setIcon(new ImageIcon(currentImage));
        }
        else if (type.equals("archer")) {
            this.type = "archer";
            this.life = 50;
            this.damage = 10;
            if (isDerechChaim) {
                this.attackingImg = pics.getArcherAttacking();
                this.standingImg = pics.getArcherStanding();
                this.walkingImg = pics.getArcherWalking();
                this.speed=3;
            }else{
                this.attackingImg = pics.getCHarcherAttacking();
                this.standingImg = pics.getCHarcherStanding();
                this.walkingImg = pics.getCHarcherWalking();
                this.speed=-3;
            }

        }
        else {
            this.type = "defender";
            this.life  = 300;
            this.damage = 10;
            if (isDerechChaim) {
                this.attackingImg = pics.getRBAttack();
                this.standingImg = pics.getRBStanding();
                this.walkingImg = pics.getRBWalking();
                this.speed=3;
            }else{
                this.attackingImg = pics.getCHRBAttack();
                this.standingImg = pics.getCHRBStanding();
                this.walkingImg = pics.getCHRBWalking();
                this.speed=-3;
            }
            if(isDerechChaim)
                this.setBounds(30,550,150,150);
            else
                this.setBounds(850,550,150,150);



        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCurrentImage(BufferedImage currentImage) {
        this.currentImage = currentImage;
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
