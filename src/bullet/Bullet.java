package bullet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;
public class Bullet {

    public BufferedImage image;
    public  boolean collision = false;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 200;
    public int bulletheight = 200;
    public boolean bulletActive;
    public int type = 0;
    Panel panel;

    public Bullet(int startX, int startY, BufferedImage img, Panel panel) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
    }

    public void update(){
        if (type == 0) {
            bullety -= 8;
            if(bullety < -75){
                bulletActive = false;
            }
        }
        if (type == 1) {
            bullety += 8;
            if(bullety > 300+75){
                bulletActive = false;
            }
        }
    }
    public void draw(Graphics2D g2){
        if(bulletActive){
            g2.drawImage(image, bulletx - (panel.tileSize + 25), bullety - (panel.tileSize + 75), bulletwidth, bulletheight, null);
        }
    }
}
