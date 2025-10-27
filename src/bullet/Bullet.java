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

    public Bullet(int startX, int startY, BufferedImage img, Panel panel, int t = 0) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
        this.type = t;
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

    public void collide(){
        if (type == 0) {
            for (Enemy e: enemy) {
                double distanceX = e.enemyX+24.0 - bulletx;
                double distanceY = e.enemyY+24.0 - bullety;
                double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
                if (distance < 30) {
                    e.enemyActive = false;
                    bulletActive = false
                }
            }
        } else if (type == 1) {
            
        }
    }
}
