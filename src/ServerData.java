import java.util.ArrayList;
import java.util.List;

public class ServerData {
    private List<Soldier> rightSoldiers;
    private List<Soldier> leftSoldiers;
    private int rightLife;
    private int leftLife;
    private int rightMoney;
    private int leftMoney;

    public ServerData(){
        this.rightSoldiers = new ArrayList<Soldier>();
        this.leftSoldiers = new ArrayList<Soldier>();
        this.rightLife=1000;
        this.leftLife=1000;
        this.rightMoney= 500;
        this.leftMoney=500;

    }



}
