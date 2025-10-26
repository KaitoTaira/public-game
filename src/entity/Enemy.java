package entity;

import bullet.Bullet;
import bullet.BulletManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Panel;

public class Enemy extends Entity{
    Panel panel;
    Bullet bullet;
    BulletManager bulletManager;
    BufferedImage enemyImage;
    public double distance;
    

    public Enemy(Panel panel, Bullet bullet, BulletManager bulletManager){
        this.panel = panel;
        this.bullet = bullet;
        this.bulletManager = bulletManager;
        setDefaultValues();
        getEnemyImage();
    }

    public void update(){
        y += 3;
        for(Bullet bullet : bulletManager.getBullets()){
        double enemyCenterX = x + 24.0;
        double enemyCenterY = y + 24.0;
        double bulletCenterX = bullet.bulletx + (panel.tileSize/2 - 5);
        double bulletCenterY = bullet.bullety - 30;
        double distanceX = enemyCenterX - bulletCenterX;
        double distanceY = enemyCenterY - bulletCenterY;

        this.distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 50){
            System.out.println("Enemy");
        }
    }

    }

    public void getEnemyImage(){
        try{
            enemyImage = ImageIO.read(getClass().getResourceAsStream("/enemy/enemy.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setDefaultValues(){
       x = 100;
       y = 100;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(enemyImage, x, y, panel.tileSize, panel.tileSize, null);
        g2.drawRect(x, y, 50, 50);
        // for(Bullet bullet : bulletManager.getBullets()){
        // System.out.println("Bullet at: " + bullet.bulletx + ", " + bullet.bullety + " active? " + bullet.bulletActive);
        // g2.drawRect(bullet.bulletx + (panel.tileSize/2 - 5), bullet.bullety - 30, 10, 10); // bigger for visibility
        // }
    }
}
