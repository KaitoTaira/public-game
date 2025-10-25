package entity;

import bullet.Bullet;

import static java.lang.Math.sqrt;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Panel;

public class Enemy extends Entity{
    Panel panel;
    Bullet bullet;
    BufferedImage enemyImage;
    public double distance = Math.sqrt((bullet.bulletx - x) * (bullet.bulletx - x) + (bullet.bullety - y) * (bullet.bullety - y));
    

    public Enemy(Panel panel, Bullet bullet){
        this.panel = panel;
        this.bullet = bullet;
        getEnemyImage();
        setDefaultValues();
    }

    public void update(){
        y += 3;
        if(distance <= 5){
            System.out.println("Enemy");
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
       y = -50;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(enemyImage, x, y, panel.tileSize, panel.tileSize, null);
    }
}
