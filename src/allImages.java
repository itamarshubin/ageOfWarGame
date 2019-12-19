import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class allImages {

    private BufferedImage RBAttack;
    private BufferedImage RBWalking;
    private BufferedImage RBStanding;
    private BufferedImage soldierL1Attack;
    private BufferedImage soldierL1Walking;
    private BufferedImage soldierL1Standing;

    public allImages() throws IOException {

        loadImages();

    }
    //loads images
    private void loadImages() throws IOException {

        RBAttack = ImageIO.read(Board.class.getResource("RB Attacking.png"));
        RBStanding = ImageIO.read(Board.class.getResource("RB Standing.png"));
        RBWalking = ImageIO.read(Board.class.getResource("RB Walking.png"));
        soldierL1Attack = ImageIO.read(Board.class.getResource("Soldier L1 Attacking.png"));
        soldierL1Standing = ImageIO.read(Board.class.getResource("Soldier L1 Standing.png"));
        soldierL1Walking = ImageIO.read(Board.class.getResource("Soldier L1 Walking.png"));

    }

    public BufferedImage getRBAttack() {
        return RBAttack;
    }

    public BufferedImage getRBWalking() {
        return RBWalking;
    }

    public BufferedImage getRBStanding() {
        return RBStanding;
    }

    public BufferedImage getSoldierL1Attack() {
        return soldierL1Attack;
    }

    public BufferedImage getSoldierL1Walking() {
        return soldierL1Walking;
    }

    public BufferedImage getSoldierL1Standing() {
        return soldierL1Standing;
    }
}
