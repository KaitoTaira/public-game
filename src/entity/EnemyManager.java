package entity;

import bullet.Bullet;
import bullet.BulletManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;

public class EnemyManager {
    Panel panel;
    BulletManager bulletManager;
    public int enemyX;
    public int enemyY;
    public BufferedImage image;
    public boolean enemyActive;
    public double distance;

    public EnemyManager(int startX, int startY, BufferedImage img, Panel panel, BulletManager bulletManager) {
        this.enemyX = startX;
        this.enemyY = startY;
        this.image = img;
        this.panel = panel;
        this.enemyActive = true;
        this.bulletManager = bulletManager;
    }

    public void update(){
        enemyY += 3;
        if(enemyY > 550){
            enemyActive = false;
        }
    }
    public void draw(Graphics2D g2){
        if(enemyActive){
            g2.drawImage(image, enemyX, enemyY, 50, 50, null);
        }
    }
}
