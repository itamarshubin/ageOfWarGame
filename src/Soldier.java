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

    public Soldier(String type) throws IOException {
        this.setBackground(Color.RED);
        this.setBounds(70,550,150,150);
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
            this.isWalking = true;
            this.currentImage = standingImg;
            this.setIcon(new ImageIcon(currentImage));
        }
        else if (type.equals("archer")) {
            this.type = "archer";
            this.life = 50;
            this.damage = 10;
            this.attackingImg = pics.getArcherAttacking();
            this.standingImg = pics.getArcherStanding();
            this.walkingImg = pics.getArcherWalking();

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
