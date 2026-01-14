package bullet;

import entity.Enemy;
import entity.EnemyManager;
import entity.Player;
import entity.WhiteMonster;
import entity.WhiteMonsterManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Panel;

public class Bullet {

     
    public BufferedImage image;
    public boolean collision = false;
    public double bulletx;
    public double bullety;
    public int bulletwidth = 100;
    public int bulletheight = 100;
    public int playerSpeed = 10;
    public int enemySpeed = 2;
    public boolean bulletActive;
    public boolean isEnemyBullet;
    public double dx;
    public double dy;
    public double distance;
    public boolean isSpinning = false;
    public double centerX, centerY;
    public double angle;
    public double radius;
    public double rotationSpeed;
    public double outwardSpeed; 
    public double centerAngle;

    Panel panel;
    Enemy enemy;
    EnemyManager enemyManager;
    Player player;
    WhiteMonsterManager whitemonstermanager;
    WhiteMonster whitemonster;

    public enum Type{
         PLAYER, ENEMY, PLAYERLEFT, PLAYERRIGHT, ENEMYLASER
    }
    public Type type;
    public Type getType() { return type; }
    public Bullet(int startX, int startY, BufferedImage img, Panel panel, Enemy enemy, 
        EnemyManager enemyManager, double angle, Player player, Type type, WhiteMonsterManager whitemonstermanager,
        WhiteMonster whitemonster) {
        this.bulletx = startX;
        this.bullety = startY;
        this.image = img;
        this.panel = panel;
        this.bulletActive = true;
        this.enemy = enemy;
        this.enemyManager = enemyManager;
        this.player = player;
        this.type = type;
        this.whitemonstermanager = whitemonstermanager;

        if(type == Type.ENEMY){
            dx = Math.cos(angle) * enemySpeed;
            dy = Math.sin(angle) * enemySpeed;
            this.isEnemyBullet = true;
        }
        else if(type == Type.ENEMYLASER){
            dx = Math.cos(angle) * enemySpeed * 3;
            dy = Math.sin(angle) * enemySpeed * 3;
            this.isEnemyBullet = true;

        }
        else if(type == Type.PLAYERLEFT){
            dx = Math.cos(4 * Math.PI /3) * playerSpeed;
            dy = Math.sin(4 *Math.PI /3) * playerSpeed;
        }
        else if(type == Type.PLAYERRIGHT){
            dx = Math.cos(5 * Math.PI /3) * playerSpeed;
            dy = Math.sin(5 * Math.PI /3) * playerSpeed;
        }
        else{
            dx = 0;
            dy = -playerSpeed;
            this.isEnemyBullet = false;
        }
    }

    public void update(){
        if (isSpinning) {
            for(EnemyManager e : enemy.getEnemy()){
        double dx = player.x - e.enemyX;
        double dy = player.y - e.enemyY;
        double centerAngle = Math.atan2(dy, dx);
        centerX += Math.cos(centerAngle) * enemySpeed * 2;
        centerY += Math.sin(centerAngle) * enemySpeed * 2;
            }
        angle += rotationSpeed;
        radius += outwardSpeed;
        bulletx = centerX + Math.cos(angle) * radius;
        bullety = centerY + Math.sin(angle) * radius;
    } else {
        bulletx += dx;
        bullety += dy;
    }
        if((bullety > 576 || bullety < -100) || (bulletx < -100 || bulletx > 576)){
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
            whitemonstermanager.whiteMonsterSpawned = true;
            WhiteMonster w = new WhiteMonster(enemyCenterX, enemyCenterY, enemyManager,player, panel);
            whitemonstermanager.whitemonsters.add(w);   
            break;
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
        if(distance < 8 && isEnemyBullet){
            // player.playerActive = false;
            bulletActive = false;
            }
    }
    public void draw(Graphics2D g2){

    }
}
