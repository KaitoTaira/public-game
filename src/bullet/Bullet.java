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
    public int bulletwidth = 200;
    public int bulletheight = 200;
    public boolean bulletActive;
    public int type = 0;
    Panel panel;
    Enemy enemy;
    EnemyManager enemyManager;
    public double distance;
    public boolean isEnemyBullet;
    Player player;

    public Bullet(int startX, int startY, BufferedImage img, Panel panel, Enemy enemy, EnemyManager enemyManager, boolean isEnemyBullet, Player player) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
        this.enemy = enemy;
        this.enemyManager = enemyManager;
        this.isEnemyBullet = isEnemyBullet;
        this.player = player;
    }

    public void update(){
        if (isEnemyBullet) {
            bullety += 7;
        } else {
            bullety -= 7;
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
        if(distance < 30 && isEnemyBullet){
            player.playerActive = false;
            bulletActive = false;
            }
    }
    public void draw(Graphics2D g2){
      
    }
}
