package bullet;

import entity.Enemy;
import entity.EnemyManager;
import entity.Player;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;

public class Bullet {

    public BufferedImage image;
    public  boolean collision = false;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 100;
    public int bulletheight = 100;
    public boolean bulletActive;
    public boolean isEnemyBullet;
    int speed = 8;
    Panel panel;
    Enemy enemy;
    EnemyManager enemyManager;
    public double distance;
    Player player;
    public enum Type{
        ENEMYDOWN, ENEMYLEFT, ENEMYRIGHT, PLAYER
    }
    public Type type;
    public Type getType() { return type; }
    public Bullet(int startX, int startY, BufferedImage img, Panel panel, Enemy enemy, EnemyManager enemyManager, Type type, Player player) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
        this.enemy = enemy;
        this.enemyManager = enemyManager;
        this.player = player;
        this.type = type;
    }

    public void update(){
        if(bullety > 576 || (bulletx < 0 || bulletx > 576)){
            bulletActive = false;
        }
        
        for(EnemyManager enemyManager : enemy.getEnemy()){
        double enemyCenterX = enemyManager.enemyX + 24.0;
        double enemyCenterY = enemyManager.enemyY + 24.0;
        double bulletCenterX = bulletx + (panel.tileSize/2 - 5);
        double bulletCenterY = bullety - 30;
        double distanceX = enemyCenterX - bulletCenterX;
        double distanceY = enemyCenterY - bulletCenterY;
        this.distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 30 && !isEnemyBullet){
            enemyManager.enemyActive = false;
            bulletActive = false;
            }
        }
        double playerCenterX = player.x + 24.0;
        double playerCenterY = player.y + 24.0;
        double bulletCenterX = bulletx + (panel.tileSize/2 - 5);
        double bulletCenterY = bullety - 30;
        double playerDistanceX = playerCenterX - bulletCenterX;
        double playerDistanceY = playerCenterY - bulletCenterY;
        this.distance = Math.sqrt((playerDistanceX * playerDistanceX) + (playerDistanceY * playerDistanceY));
        if(distance < 10 && isEnemyBullet){
            player.playerActive = false;
            bulletActive = false;
            }
    }
    public void draw(Graphics2D g2){
      
    }
    public void player(){
        isEnemyBullet = false;
        bullety -= speed;
    }
    public void enemyDown(){
        isEnemyBullet = true;
        bullety += speed;
    }
    public void enemyLeft(){
        isEnemyBullet = true;
        bullety += speed / Math.sqrt(2);
        bulletx -= speed/1.5 / Math.sqrt(2);
    }
    public void enemyRight(){
        isEnemyBullet = true;
        bullety += speed / Math.sqrt(2);
        bulletx += speed/1.5 / Math.sqrt(2);
    }
}
