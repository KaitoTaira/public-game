package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;


public class EnemyManager {
    public enum Type{
        LEFT, RIGHT, CENTER
    }
    Panel panel;
    public int enemyX;
    public int enemyY;
    public BufferedImage image;
    public boolean enemyActive;
    public double distance;
    public Type type;
    public Type getType() { return type; }
    public int t;
    public int second = 60;
    public boolean enemyLeft;
    public boolean enemyRight;
    public boolean boss;
    public int health = 10;

    public EnemyManager(int startX, int startY, BufferedImage img, Panel panel, Type type, boolean boss) {
        this.enemyX = startX;
        this.enemyY = startY;
        this.image = img;
        this.panel = panel;
        this.enemyActive = true;
        this.type = type;
        this.boss = boss;
    }

    public void update(){
        System.out.println(health);
        t++;
        if(enemyY > 576 || (enemyX < 0 || enemyX > 576)){
            enemyActive = false;
        }
        
    }
    public void draw(Graphics2D g2){
        if(enemyActive){
            g2.drawImage(image, enemyX, enemyY, 50, 50, null);
        }
    }
    public void left(){
        enemyLeft = true;
        if(t <= 3 * second){
            enemyY += 3;
        }
        else if(t <= 10 * second){
            enemyX -= 1;
        }
    }
    public void right(){
        enemyRight = true;
        if(t <= 3 * second){
            enemyY += 3;
        }
        else if(t <= 10 * second){
            enemyX += 1;
        }
    }
    public void center(){
        if(t <= 1 * second){
            enemyY += 3;
        }
        else if(t < 100 * second){
            enemyY += 0;
        }
    }
}
