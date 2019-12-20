import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientData implements Serializable {
    private List<Soldier> Soldiers;
    private int myLife;
    private int enemyLife;
    private int myMoney;
    private int enemyMoney;
    final int BASE_LIFE = 1000;
    final int STARTING_MONEY = 500;


    public ClientData(){
        this.Soldiers = new ArrayList<Soldier>();
        this.myLife=BASE_LIFE;
        this.enemyLife=BASE_LIFE;
        this.myMoney= STARTING_MONEY;
        this.enemyMoney=STARTING_MONEY;

    }



    public List<Soldier> getSoldiers() {
        return Soldiers;
    }

    public void setSoldiers(List<Soldier> mySoldiers) {
        this.Soldiers = mySoldiers;
    }


    public int getMyLife() {
        return myLife;
    }

    public void setMyLife(int myLife) {
        this.myLife = myLife;
    }

    public int getEnemyLife() {
        return enemyLife;
    }

    public void setEnemyLife(int enemyLife) {
        this.enemyLife = enemyLife;
    }

    public int getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(int myMoney) {
        this.myMoney = myMoney;
    }

    public int getEnemyMoney() {
        return enemyMoney;
    }

    public void setEnemyMoney(int enemyMoney) {
        this.enemyMoney = enemyMoney;
    }

    @Override
    public String toString() {
        return  Soldiers +
                "|" + myLife +
                "|" + enemyLife +
                "|" + myMoney +
                "|" + enemyMoney;
    }
}
