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
    

    public Enemy(Panel panel, Bullet bullet, BulletManager bulletManager, EnemyManager enemyManager){
        this.panel = panel;
        this.bullet = bullet;
        this.bulletManager = bulletManager;
        this.enemyManager = enemyManager;
        setDefaultValues();
        getEnemyImage();
    }

    public void update(){
        timer ++;
        if(timer == second){
            enemy.add(new EnemyManager(300, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
        }
        if (timer == 2 * second){
            enemy.add(new EnemyManager(200, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
            enemy.add(new EnemyManager(400, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
        }


        if(timer == 5 * second){
            enemy.add(new EnemyManager(200, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(250, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
        }
        if(timer == 7 * second){
            enemy.add(new EnemyManager(100, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(400, -100, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
        }
        

        if(timer == 10 * second){
            enemy.add(new EnemyManager(300, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
            enemy.add(new EnemyManager(400, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
            enemy.add(new EnemyManager(500, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
            enemy.add(new EnemyManager(600, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
        }
        if(timer == 12 * second){
            enemy.add(new EnemyManager(200, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
            enemy.add(new EnemyManager(100, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPRIGHT));
        }


        if(timer == 15 * second){
            enemy.add(new EnemyManager(200, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(250, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(300, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(450, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
        }
        if(timer == 17 * second){
            enemy.add(new EnemyManager(100, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(400, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(300, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
            enemy.add(new EnemyManager(500, 50, enemyImage, panel, bulletManager, EnemyManager.Type.TOPLEFT));
        }
        for (int i = 0; i < enemy.size(); i++) {
            EnemyManager e = enemy.get(i);
            switch(e.getType()){
                case TOPLEFT:
                    e.topleft();
                    break;
                case TOPRIGHT:
                    e.topright();
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
        }
        // g2.drawRect(x, y, 50, 50);
        // for(Bullet bullet : bulletManager.getBullets()){
        // g2.drawRect(bullet.bulletx + (panel.tileSize/2 - 5), bullet.bullety - 30, 10, 10);
        // }
    }
}
