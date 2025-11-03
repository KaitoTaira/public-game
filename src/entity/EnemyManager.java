package entity;

import bullet.Bullet;
import bullet.BulletManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;


public class EnemyManager {
    public enum Type{
        LEFT, RIGHT, TOPLEFT, TOPRIGHT
    }
    Panel panel;
    BulletManager bulletManager;
    public int enemyX;
    public int enemyY;
    public BufferedImage image;
    public boolean enemyActive;
    public double distance;
    public Type type;
    public Type getType() { return type; }
    public int t;
    public int second = 60;

    public EnemyManager(int startX, int startY, BufferedImage img, Panel panel, BulletManager bulletManager, Type type) {
        this.enemyX = startX;
        this.enemyY = startY;
        this.image = img;
        this.panel = panel;
        this.enemyActive = true;
        this.bulletManager = bulletManager;
        this.type = type;
    }

    public void update(){ 
        System.out.println(t);
        t++;
        if(enemyY > 576 || (enemyX < 0 || enemyX > 576)){
            enemyActive = false;
        }
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
    public void topleft(){
        if(t < 2 *second){
            enemyY += 1;
        }
        else if(t < 5 * second){
            enemyY += 1;
            enemyX +=1;
        }
    }
    public void topright(){
        if(t < 2 *second){
            enemyY += 1;
        }
        else if(t < 5 * second){
            enemyY += 1;
            enemyX -= 1;
        }
    }
    public void left(){

    }
    public void right(){

    }
}
