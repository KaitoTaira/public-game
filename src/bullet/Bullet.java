package bullet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bullet {

    public BufferedImage image;
    public boolean collision = false;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 150;
    public int bulletheight = 150;
    public boolean bulletActive;

    public Bullet(int startX, int startY, BufferedImage img) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.bulletActive = true;
    }

    public void update(){
        bullety -= 4;
        if(bullety < 0){
            bulletActive = false;
        }
    }
    public void draw(Graphics2D g2){
        if(bulletActive){
            g2.drawImage(image, bulletx, bullety, bulletwidth, bulletheight, null);
        }
    }
}
