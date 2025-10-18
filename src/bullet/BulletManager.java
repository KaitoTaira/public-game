package bullet;

import entity.Player;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Panel;


public class BulletManager extends Bullet{

    Panel p;
    Player player;
    Bullet[] bullet;

    public BulletManager(Panel p, Player player){

        this.p = p;
        this.player = player;
        bullet = new Bullet[1];
        getBulletImage();
    }

    public void getBulletImage(){
        try{
            bullet[0] = new Bullet();
            bullet[0].image = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){
        if(player.shoot){
            g2.drawImage(bullet[0].image, player.x - (p.tileSize/2), player.y - ((p.tileSize/2) + 50), 100, 100, null);
            System.out.println("PEW");
        }
    }
}
