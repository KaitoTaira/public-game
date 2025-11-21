package entity;

import bullet.Bullet;
import bullet.BulletManager;
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
        if(timer == 30){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(200, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            
        }
        if(timer == 3 * second){
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(400, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 6 * second){
            enemy.add(new EnemyManager(400, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(350, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(200, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(250, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        }
        if(timer == 9 * second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 12 * second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 14 * second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 16 * second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 60 *second){
            enemy.add(new EnemyManager(150, -100, enemyImage, panel, EnemyManager.Type.CENTER, true));
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
            if(timer > 60 * second && timer < 90 * second){
            g2.fillRect(10, 10, e.health, 10);
           }
           
        }
        
        
        
        
    }
    public ArrayList<EnemyManager> getEnemy() {
    return enemy;
}
}
