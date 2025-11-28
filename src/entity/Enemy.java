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
            enemy.add(new EnemyManager(90, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        }
        if(timer == 6 * second){
            enemy.add(new EnemyManager(400, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(350, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(200, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(250, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(130, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
        }
        if(timer == 9 * second){
            enemy.add(new EnemyManager(100, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(150, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 12 * second){
            enemy.add(new EnemyManager(130, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(180, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(490, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(430, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 15 * second){
            enemy.add(new EnemyManager(230, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(70, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(160, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(510, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(380, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(430, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 18 * second){
            enemy.add(new EnemyManager(210, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(130, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(40, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(500, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 21 * second){
            enemy.add(new EnemyManager(10, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(80, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(130, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(310, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(390, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 24 * second){
            enemy.add(new EnemyManager(50, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(230, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(450, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(390, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 27 * second){
            enemy.add(new EnemyManager(300, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(10, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.LEFT, false));
            enemy.add(new EnemyManager(410, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
            enemy.add(new EnemyManager(480, -((int) (Math.random() * 200 + 100)), enemyImage, panel, EnemyManager.Type.RIGHT, false));
        }
        if(timer == 30 *second){
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
            if(timer > 30 * second && timer < 60 * second){
            g2.fillRect(10, 10, e.health, 10);
           }
           
        }
        
        
        
        
    }
    public ArrayList<EnemyManager> getEnemy() {
    return enemy;
}
}
