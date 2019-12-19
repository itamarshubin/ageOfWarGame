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
        this.leftSoldiers = new ArrayList<Soldier>();
        this.rightSoldiers = new ArrayList<Soldier>();
        this.leftLife=1000;
        this.rightLife=1000;
        this.leftMoney= 500;
        this.rightMoney=500;

    }

}
