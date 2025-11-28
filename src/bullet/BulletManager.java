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
                case ENEMYUPRIGHT:
                    b.enemyUpRight();
                    break;
                case ENEMYUPLEFT:
                    b.enemyUpLeft();
                    break;
                case ENEMYDOWNRIGHT:
                    b.enemyDownRight();
                    break;
                case ENEMYDOWNLEFT:
                    b.enemyDownLeft();
                    break;
                case ENEMYUP:
                    b.enemyUp();
                    break;

            }
            b.update();
            if (!b.bulletActive) {
                bullets.remove(i);
            }
        }
    }
    
    public void playerShoot(){
        bullets.add(new Bullet(player.x, player.y, playerBulletImage, p, enemy, enemyManager, Bullet.Type.PLAYER, player));
    }
    public void enemyShoot(){
        double radius = 20;
        int num = 8;
        Bullet.Type[] types = {
        Bullet.Type.ENEMYRIGHT,      // 0
        Bullet.Type.ENEMYDOWNRIGHT,  // 45°
        Bullet.Type.ENEMYDOWN,       // 90°
        Bullet.Type.ENEMYDOWNLEFT,   // 135°
        Bullet.Type.ENEMYLEFT,       // 180°
        Bullet.Type.ENEMYUPLEFT,     // 225°
        Bullet.Type.ENEMYUP,         // 270°
        Bullet.Type.ENEMYUPRIGHT     // 315°
};
        for(EnemyManager enemyManager : enemy.getEnemy()){
            for(int i = 0; i < num; i++){
        double angle = i * 2 * Math.PI / num;
        double enemyX = enemyManager.enemyX + (radius * Math.cos(angle));
        double enemyY = enemyManager.enemyY + (radius * Math.sin(angle));
        bullets.add(new Bullet((int)enemyX - (p.tileSize/2), (int)enemyY, bulletImage, p, enemy, enemyManager, types[i], player));
        if(enemyManager.boss){
            bullets.add(new Bullet((int)enemyX - (p.tileSize/2) + 250, (int)player.y - p.tileSize/2, bulletImage, p, enemy, enemyManager, types[i], player));
            bullets.add(new Bullet((int)enemyX - (p.tileSize/2) - 250, (int)player.y - p.tileSize/2, bulletImage, p, enemy, enemyManager, types[i], player));
            // bullets.add(new Bullet(0, 0, bulletImage, p, enemy, enemyManager, types[i], player));
            // bullets.add(new Bullet(576, 0, bulletImage, p, enemy, enemyManager, types[i], player));
        }
        }
    }
    }
    
    public void draw(Graphics2D g2){
        ArrayList<Bullet> bulletsCopy = new ArrayList<>(bullets);
        for (Bullet b: bulletsCopy){
            if(b.bulletActive){
                if(b.isEnemyBullet){
                    g2.drawImage(b.image, b.bulletx, b.bullety, bulletwidth, bulletheight, null);
                }  
                else{
                g2.drawImage(playerBulletImage, b.bulletx -25, b.bullety - 75, bulletwidth, bulletheight, null);
            }
        }
        }
    }
    public ArrayList<Bullet> getBullets() {
    return bullets;
}
}
