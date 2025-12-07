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
    BufferedImage bulletImage, playerBulletImage;
    Panel p;
    Player player;
    Bullet bullet;
    EnemyManager enemyManager;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 100;
    public int bulletheight = 100;
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
        if(timer % (1*second) == 0){
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
        bullets.add(new Bullet(player.x, player.y, playerBulletImage, p, enemy, enemyManager, 90, player, Bullet.Type.PLAYER));
    }
    public void enemyShoot(){
        int num = 16;
        for(EnemyManager enemyManager : enemy.getEnemy()){
            for(int i = 0; i < num; i++){
        double angle = i * 2 * Math.PI / num;
        bullets.add(new Bullet(enemyManager.enemyX - p.tileSize/2, enemyManager.enemyY + p.tileSize/2, bulletImage, p, enemy, enemyManager, angle, player, Bullet.Type.ENEMY));
        if(enemyManager.boss){
          num = 32;
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
