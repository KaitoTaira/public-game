package entity;

import bullet.Bullet;
import bullet.BulletManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import main.Panel;


public class EnemyManager {
    Panel panel;
    BulletManager bulletManager;
    public int enemyX;
    public int enemyY;
    public BufferedImage image;
    public boolean enemyActive;
    public double distance;
    ArrayList<Integer> path;
    private int t = 0;

    public EnemyManager(int startX, int startY, BufferedImage img, Panel panel, BulletManager bulletManager, ArrayList<Integer> p) {
        this.enemyX = startX;
        this.enemyY = startY;
        this.image = img;
        this.panel = panel;
        this.enemyActive = true;
        this.bulletManager = bulletManager;
        path = p;
    }

    public void update(){
        enemyY += 3;
        if(enemyY > 550){
            enemyActive = false;
        }
        t++;
        enemyX += path.get((t/20)%path.size());
        for(Bullet bullet : bulletManager.getBullets()){
        double enemyCenterX = enemyX + 24.0;
        double enemyCenterY = enemyY + 24.0;
        double bulletCenterX = bullet.bulletx + (panel.tileSize/2 - 5);
        double bulletCenterY = bullet.bullety - 30;
        double distanceX = enemyCenterX - bulletCenterX;
        double distanceY = enemyCenterY - bulletCenterY;

        this.distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 30){
            enemyActive = false;
            bullet.bulletActive = false;
            }
        }
    }
    public void draw(Graphics2D g2){
        if(enemyActive){
            g2.drawImage(image, enemyX, enemyY, 50, 50, null);
        }
    }
}
