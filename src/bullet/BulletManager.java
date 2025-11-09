package bullet;


import entity.Enemy;
import entity.EnemyManager;
import entity.Player;
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
    BufferedImage bulletImage;
    Panel p;
    Player player;
    Bullet bullet;
    EnemyManager enemyManager;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 200;
    public int bulletheight = 200;
    public int timer;
    public int second = 60;
    public boolean playerBullet;
    public boolean enemyBullet;
    Enemy enemy;



    public BulletManager(Panel p, Player player, Bullet bullet, EnemyManager enemyManager, Enemy enemy){
        this.p = p;
        this.player = player;
        this.bullet = bullet;
        this.enemyManager = enemyManager;
        this.enemy = enemy;
        try{
            bulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));
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
        if(timer % (second) == 0){
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
        bullets.add(new Bullet(player.x, player.y, bulletImage, p, enemy, enemyManager, false, player));
    }
    public void enemyShoot(){
         for(EnemyManager enemyManager : enemy.getEnemy()){
        bullets.add(new Bullet(enemyManager.enemyX, enemyManager.enemyY + 60, bulletImage, p, enemy, enemyManager, true, player));
         }
    }
    
    public void draw(Graphics2D g2){
        ArrayList<Bullet> bulletsCopy = new ArrayList<>(bullets);
        for (Bullet b: bulletsCopy){
            if(b.bulletActive){
            g2.drawImage(b.image, b.bulletx - (p.tileSize + 25), b.bullety - (p.tileSize + 75), bulletwidth, bulletheight, null);  
        }
        }
    }
    public ArrayList<Bullet> getBullets() {
    return bullets;
}
}
