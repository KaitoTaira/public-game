package bullet;

import entity.Enemy;
import entity.EnemyManager;
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
    Enemy enemy;
    EnemyManager enemyManager;
      public double distance;

    public Bullet(int startX, int startY, BufferedImage img, Panel panel, Enemy enemy, EnemyManager enemyManager) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
        this.enemy = enemy;
        this.enemyManager = enemyManager;
    }

    public void update(){
        bullety -= 5;
        for(EnemyManager enemyManager : enemy.getEnemy()){
        double enemyCenterX = enemyManager.enemyX + 24.0;
        double enemyCenterY = enemyManager.enemyY + 24.0;
        double bulletCenterX = bulletx + (panel.tileSize/2 - 5);
        double bulletCenterY = bullety - 30;
        double distanceX = enemyCenterX - bulletCenterX;
        double distanceY = enemyCenterY - bulletCenterY;

        this.distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 30){
            enemyManager.enemyActive = false;
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
