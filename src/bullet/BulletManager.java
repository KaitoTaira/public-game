package bullet;


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
    public int bulletx;
    public int bullety;
    public int bulletwidth = 150;
    public int bulletheight = 150;
    public int timer;



    public BulletManager(Panel p, Player player, Bullet bullet){
        this.p = p;
        this.player = player;
        this.bullet = bullet;
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
            shoot(1);
            cooldown = cooldownMax;
        }
        if(timer == fps) {
            timer = 0;
            for (int i = 0; i < enemy.size(); i ++) {
                shoot(2, enemy.get(i));
            }
        }

        for (int i = bullets.size()-1; i >= 0; i--) {
            Bullet b = bullets.get(i);
            b.update();
            if (!b.bulletActive) {
                bullets.remove(i);
            }
        }
    }
    
    public void shoot(int type, Enemy e = null)
    {
        if (type == 1) {
            bullets.add(new Bullet(player.x, player.y, bulletImage, p));
        } else (type == 2) {
            bullet.add(new Bullet(e.x, e.y, bulletImage, p, 1));
        }
    }
    
    public void draw(Graphics2D g2){
        ArrayList<Bullet> bulletsCopy = new ArrayList<>(bullets);
        for (Bullet b: bulletsCopy){
            b.draw(g2);
        }
    }
    public ArrayList<Bullet> getBullets() {
    return bullets;
}
}
