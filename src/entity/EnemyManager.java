package entity;

import bullet.Bullet;
import bullet.BulletManager;
import java.awt.Graphics2D;
import java.awt.Point;
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
    ArrayList<Point> path;
    private int t = 0;

    public EnemyManager(int startX, int startY, BufferedImage img, Panel panel, BulletManager bulletManager, ArrayList<Point> p) {
        this.enemyX = startX;
        this.enemyY = startY;
        this.image = img;
        this.panel = panel;
        this.enemyActive = true;
        this.bulletManager = bulletManager;
        path = p;
    }

    public void update(){
        if(enemyY > 576 || (enemyX < 0 || enemyX > 576)){
            enemyActive = false;
        }
        t++;
        Point p = path.get((t / 20) % path.size());
        enemyX += p.x;
        enemyY += p.y;
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
