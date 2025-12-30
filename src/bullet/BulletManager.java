package bullet;


import entity.Enemy;
import entity.EnemyManager;
import entity.Player;
import entity.WhiteMonster;
import entity.WhiteMonsterManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Panel;



public class BulletManager{
    ArrayList<Bullet> bullets = new ArrayList<>();
    int cooldown = 0;
    int cooldownMax = 10;
    BufferedImage bulletImage, playerBulletImage;
    Panel p;
    Player player;
    Bullet bullet;
    EnemyManager enemyManager;
    WhiteMonsterManager whitemonstermanager;
    WhiteMonster whitemonster;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 100;
    public int bulletheight = 100;
    public int timer;
    public int second = 60;
    public boolean playerBullet;
    public boolean enemyBullet;
    public int num = 16; 
    Enemy enemy;



    public BulletManager(Panel p, Player player, Bullet bullet, EnemyManager enemyManager, Enemy enemy, WhiteMonsterManager whitemonstermanager){
        this.p = p;
        this.player = player;
        this.bullet = bullet;
        this.enemyManager = enemyManager;
        this.enemy = enemy;
        this.whitemonstermanager = whitemonstermanager;
        try{
            bulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));
            playerBulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/playerbullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public void update(){
        timer ++;
        if(cooldown > 0) cooldown --;
        
        if(player.shoot && cooldown == 0){
            playerShoot();
            cooldown = cooldownMax;
        }
        if(timer % (1 * second) == 0){
            enemyShoot();
        }
        for (int i = bullets.size()-1; i >= 0; i--) {
            Bullet b = bullets.get(i);
            b.update();
            if (!b.bulletActive) {
                bullets.remove(i);
            }
        }
    }
    
    public void playerShoot(){
        bullets.add(new Bullet(player.x, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYER, whitemonstermanager, whitemonster));
        if(player.whiteMonsterCount >= 10){
            bullets.add(new Bullet(player.x + 20, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYERRIGHT, whitemonstermanager, whitemonster));
            bullets.add(new Bullet(player.x - 20, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYERLEFT, whitemonstermanager, whitemonster));
        }
        if(player.whiteMonsterCount >= 20){
           bullets.add(new Bullet(player.x + 20, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYER, whitemonstermanager, whitemonster));
            bullets.add(new Bullet(player.x - 20, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYER, whitemonstermanager, whitemonster));
        }
    }
    public void enemyShoot(){
        for(EnemyManager enemyManager : enemy.getEnemy()){
            for(int i = 0; i < num; i++){
        double angle = i * 2 * Math.PI / num;
        if(!enemyManager.boss){
        bullets.add(new Bullet(enemyManager.enemyX - p.tileSize/2, enemyManager.enemyY, bulletImage, p, enemy, enemyManager, angle, player, Bullet.Type.ENEMY, whitemonstermanager, whitemonster));
        }
        if(enemyManager.boss){
        num = 32;
            if(enemyManager.bulletPattern == 1){
                bullets.add(new Bullet(enemyManager.enemyX - p.tileSize/2, enemyManager.enemyY, bulletImage, p, enemy, enemyManager, angle, player, Bullet.Type.ENEMY, whitemonstermanager, whitemonster));
            }
            if(enemyManager.bulletPattern == 2){
                System.out.println("2");
            }
            if(enemyManager.bulletPattern == 3){
                System.out.println("3");
            }
            if(enemyManager.bulletPattern == 4){
                System.out.println("4");
            }
        }
        }
    }
    }
    
    public void draw(Graphics2D g2){
        ArrayList<Bullet> bulletsCopy = new ArrayList<>(bullets);
        for (Bullet b: bulletsCopy){
            if(b.bulletActive){
                if(b.isEnemyBullet){
                    g2.drawImage(b.image, (int)b.bulletx, (int)b.bullety, bulletwidth, bulletheight, null);
                }  
                else{
                g2.drawImage(playerBulletImage, (int)b.bulletx -25, (int)b.bullety - 75, bulletwidth, bulletheight, null);
            }
        }
        }
    }
    public ArrayList<Bullet> getBullets() {
    return bullets;
}
}
