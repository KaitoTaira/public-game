package bullet;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class BulletManager {

    Panel p;
    Bullet[] bullet;

    public BulletManager(Panel p){

        this.p = p;
        bullet = new Bullet[1];
        getBulletImage();
    }

    public void getBulletImage(){
        try{
            bullet[0] = new Bullet();
            bullet[0].image = ImageIO.read(getClass().getResourceAsStream("/res/bullet/bullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(bullet[0].image,0,0, 1, 2, null);
    }
}
