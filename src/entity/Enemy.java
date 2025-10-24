package entity;

import bullet.Bullet;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Panel;

public class Enemy extends Entity{
    Panel panel;
    Bullet bullet;
    BufferedImage enemyImage;
    

    public Enemy(Panel panel, Bullet bullets){
        this.panel = panel;
        this.bullet = bullets;
        getEnemyImage();
        setDefaultValues();
    }

    public void update(){
        y += 3;
        if(bullet.bulletx == x && bullet.bullety == y){
            System.out.println("Killed enemy");
        }
    }

    public void getEnemyImage(){
        try{
            enemyImage = ImageIO.read(getClass().getResourceAsStream("/enemy/enemy.png"));
            System.out.println("Enemy");
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
