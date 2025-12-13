package entity;

import bullet.Bullet;
import bullet.BulletManager;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Panel;
public class Enemy extends Entity{
    public ArrayList<EnemyManager> enemy = new ArrayList<>();
    Panel panel;
    Bullet bullet;
    EnemyManager enemyManager;
    BulletManager bulletManager;
    BufferedImage enemyImage;
    public double distance;
    public int timer = 0;
    public int second = 60;
    public double bossTimer = 30;
    

    public Enemy(Panel panel, EnemyManager enemyManager){
        this.panel = panel;
        this.bullet = bullet;
        this.bulletManager = bulletManager;
        this.enemyManager = enemyManager;
        setDefaultValues();
        getEnemyImage();
    }

    public void update(){
        timer ++;
        if(enemyManager.boss = true){
            bossTimer = bossTimer - (1.0/60);
        }
        // if(timer == 30){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            
        // }
        // if(timer == 3 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 6 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        // }
        // if(timer == 9 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 12 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 15 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 18 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 21 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 24 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        // if(timer == 27 * second){
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        //     enemy.add(new EnemyManager((int)(Math.random()*510), -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        // }
        if(timer == 1 *second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200)), enemyImage, panel, EnemyManager.Type.CENTER, true));
        }
        for (int i = 0; i < enemy.size(); i++) {
            EnemyManager e = enemy.get(i);
            switch(e.getType()){
                case LEFT:
                    e.left();
                    break;
                case RIGHT:
                    e.right();
                    break;
                case CENTER:
                    e.center();
                    break;
            }
            e.update();
            if (!e.enemyActive) {
                enemy.remove(i);
                i--;
            }
        }

        y += 3;
        if(y > 550){
            enemyManager.enemyActive = false;
            x = 100;
            y = -100;
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
       y = -100;
    }

    public void draw(Graphics2D g2){
        for (EnemyManager e: enemy){
            e.draw(g2);
            if(timer > 1 * second && timer < 30 * second){
            g2.fillRect(10, 10, e.health, 10);
            Font font = new Font("Arial", Font.BOLD, 20);
            g2.setFont(font);
            g2.drawString(String.valueOf((int)bossTimer), 10, 50);
           }
           
        }
    }
    public ArrayList<EnemyManager> getEnemy() {
    return enemy;
}
}
