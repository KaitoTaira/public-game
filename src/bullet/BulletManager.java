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
    public int bulletwidth = 100;
    public int bulletheight = 100;
    public int timer;
    public int second = 60;
    public boolean playerBullet;
    public boolean enemyBullet;
    BufferedImage enemyBulletImage;
    Enemy enemy;



    public BulletManager(Panel p, Player player, Bullet bullet, EnemyManager enemyManager, Enemy enemy){
        this.p = p;
        this.player = player;
        this.bullet = bullet;
        this.enemyManager = enemyManager;
        this.enemy = enemy;
        try{
            bulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));
            enemyBulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/enemybullet.png"));
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
        if(timer % (15) == 0){
            enemyShoot();
        }
        for (int i = bullets.size()-1; i >= 0; i--) {
            Bullet b = bullets.get(i);
            switch(b.getType()){
                case PLAYER:
                    b.player();
                    break;
                case ENEMYDOWN:
                    b.enemyDown();
                    break;
                case ENEMYLEFT:
                    b.enemyLeft();
                    break;
                case ENEMYRIGHT:
                    b.enemyRight();
                    break;
            }
            b.update();
            if (!b.bulletActive) {
                bullets.remove(i);
            }
        }
    }
    
    public void playerShoot(){
        bullets.add(new Bullet(player.x, player.y, bulletImage, p, enemy, enemyManager, Bullet.Type.PLAYER, player));
    }
    public void enemyShoot(){
        for(EnemyManager enemyManager : enemy.getEnemy()){
        if(enemyManager.enemyRight){
        bullets.add(new Bullet(enemyManager.enemyX - 60, enemyManager.enemyY + 60, enemyBulletImage, p, enemy, enemyManager, Bullet.Type.ENEMYLEFT, player));
        }
        else if(enemyManager.enemyLeft){
        bullets.add(new Bullet(enemyManager.enemyX + 60, enemyManager.enemyY + 60, enemyBulletImage, p, enemy, enemyManager, Bullet.Type.ENEMYRIGHT, player));
        }
        }
    }
    
    public void draw(Graphics2D g2){
        ArrayList<Bullet> bulletsCopy = new ArrayList<>(bullets);
        for (Bullet b: bulletsCopy){
            if(b.bulletActive){
                if(bullet.isEnemyBullet){
                    g2.drawImage(enemyBulletImage, b.bulletx -25, b.bullety - 75, bulletwidth, bulletheight, null);
                    System.out.println("fe");
                }  
                else{
                g2.drawImage(b.image, b.bulletx -25, b.bullety - 75, bulletwidth, bulletheight, null);
            }
        }
        }
    }
    public ArrayList<Bullet> getBullets() {
    return bullets;
}
}
