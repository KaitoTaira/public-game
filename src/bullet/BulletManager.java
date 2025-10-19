package bullet;


import entity.Player;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Panel;



public class BulletManager{
    ArrayList<Bullet> bullet = new ArrayList<>();
    int cooldown = 0;
    int cooldownMax = 10;
    BufferedImage bulletImage;
    Panel p;
    Player player;
    public int bulletx;
    public int bullety;
    public int bulletwidth = 150;
    public int bulletheight = 150;


    public BulletManager(Panel p, Player player){
        this.p = p;
        this.player = player;
        try{
            bulletImage = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public void update(){
        if(cooldown > 0) cooldown --;
        
        if(player.shoot && cooldown == 0){
            shoot();
            cooldown = cooldownMax;
        }

        for (int i = 0; i < bullet.size(); i++) {
            Bullet b = bullet.get(i);
            b.update();
            if (!b.bulletActive) {
                bullet.remove(i);
                i--;
            }
        }
    }
    
    public void shoot(){
        bulletx = player.x - (p.tileSize);
        bullety = player.y - ((p.tileSize/2) + (bulletheight/2));
        bullet.add(new Bullet(bulletx, bullety, bulletImage));
    }

    public void draw(Graphics2D g2){
        for (Bullet b: bullet){
            b.draw(g2);
        }
    }
}
