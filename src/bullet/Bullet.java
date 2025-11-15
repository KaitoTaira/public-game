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
    int speed = 2;
    Panel panel;
    Enemy enemy;
    EnemyManager enemyManager;
    public double distance;
    Player player;
    public enum Type{
        ENEMYDOWN, ENEMYLEFT, ENEMYDOWNRIGHT, ENEMYDOWNLEFT, ENEMYUPLEFT, ENEMYUPRIGHT, ENEMYRIGHT, PLAYER, ENEMYUP
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
        if((bullety > 576 || bullety < -10) || (bulletx < -10 || bulletx > 576)){
            bulletActive = false;
        }
        
        for(EnemyManager enemyManager : enemy.getEnemy()){
        double enemyCenterX = enemyManager.enemyX + panel.tileSize;
        double enemyCenterY = enemyManager.enemyY + panel.tileSize;
        double bulletCenterX = bulletx + bulletwidth / 2.0;
        double bulletCenterY = bullety + bulletheight / 2.0;
        double distanceX = enemyCenterX - bulletCenterX;
        double distanceY = enemyCenterY - bulletCenterY;
        this.distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 30 && !isEnemyBullet){
            if(enemyManager.boss){
                enemyManager.health -= 1;
            }
            else {
            enemyManager.enemyActive = false;
            bulletActive = false;
            }
            
            }
        }
        double playerCenterX = player.x + panel.tileSize/2;
        double playerCenterY = player.y + panel.tileSize/2;
        double bulletCenterX = bulletx + bulletwidth / 2.0;
        double bulletCenterY = bullety + bulletheight / 2.0;
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
        bullety -= 7;
    }
    public void enemyDown(){
        isEnemyBullet = true;
        bullety += speed;
    }
    public void enemyLeft(){
        isEnemyBullet = true;
        bulletx -= speed;
    }
    public void enemyRight(){
        isEnemyBullet = true;
        bulletx += speed;
    }
    public void enemyUpLeft(){
        isEnemyBullet = true;
        bulletx += (speed * Math.cos((3 * Math.PI)/4));
        bullety += (speed * Math.sin((3 * Math.PI)/4));

    }
    public void enemyUpRight(){
        isEnemyBullet = true;
        bulletx += (speed * Math.cos((Math.PI)/4));
        bullety += (speed * Math.sin((Math.PI)/4));

    }
    public void enemyDownLeft(){
        isEnemyBullet = true;
        bulletx += (speed * Math.cos((5 * Math.PI)/4));
        bullety += (speed * Math.sin((5 * Math.PI)/4));

    }
    public void enemyDownRight(){
        isEnemyBullet = true;
        bulletx += (speed * Math.cos((7 * Math.PI)/4));
        bullety += (speed * Math.sin((7 * Math.PI)/4));

    }
    public void enemyUp(){
        isEnemyBullet = true;
        bullety -= speed;
    }
}
