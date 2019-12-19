import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientData implements Serializable {
    private List<Soldier> mySoldiers;
    private List<Soldier> enemySoldiers;
    private int myLife;
    private int enemyLife;
    private int myMoney;
    private int enemyMoney;


    public ClientData(){
        this.mySoldiers = new ArrayList<Soldier>();
        this.enemySoldiers = new ArrayList<Soldier>();
        this.myLife=1000;
        this.enemyLife=1000;
        this.myMoney= 500;
        this.enemyMoney=500;

    }

    public List<Soldier> getMySoldiers() {
        return mySoldiers;
    }

    public void setMySoldiers(List<Soldier> mySoldiers) {
        this.mySoldiers = mySoldiers;
    }

    public List<Soldier> getEnemySoldiers() {
        return enemySoldiers;
    }

    public void setEnemySoldiers(List<Soldier> enemySoldiers) {
        this.enemySoldiers = enemySoldiers;
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
        return "ClientData{" +
                "mySoldiers=" + mySoldiers +
                ", enemySoldiers=" + enemySoldiers +
                ", myLife=" + myLife +
                ", enemyLife=" + enemyLife +
                ", myMoney=" + myMoney +
                ", enemyMoney=" + enemyMoney +
                '}';
    }
}
