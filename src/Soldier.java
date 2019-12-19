import javax.swing.*;

public class Soldier extends JLabel {
    String type;
    int life;
    int damage;
    boolean isDead;
    boolean isAttack;
    int position;


    public Soldier(String type){
        this.type=type;
        this.position=0;
        if (type.equals("normal")){
            this.type="normal";
            this.life=100;
            this.damage = 10;
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
        }
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



}
