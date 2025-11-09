package background;

import entity.Player;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.Panel;

public class Background {

public BufferedImage bg, gameover;
public int x;
public int y;
Player player;

Panel panel;

    public Background(Panel panel, Player player){
        this.panel = panel;
        this.player = player;

        setDefaultValues();
    }

    public void getBackgroundImage(){
        try {
            bg = ImageIO.read(getClass().getResourceAsStream("/background/background.png"));
            gameover = ImageIO.read(getClass().getResourceAsStream("/background/gameover.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(bg, x, y, panel.getWidth(), panel.getHeight(), null);
        g2.drawImage(bg, x, y - panel.getHeight(), panel.getWidth(), panel.getHeight(), null);
    }
    public void end(Graphics2D g2){
        g2.drawImage(gameover, x, y, panel.getWidth(), panel.getHeight(), null);
    }

    public void setDefaultValues(){
        x = 0;
        y = 0;
    }

    public void update(){
        if(player.playerActive){
            y += 1;
        }
        else{
            y += 0;
            setDefaultValues();
        }
        resetBackground(null);
    }

    public void resetBackground(Graphics2D g2){
        if(y >= panel.getHeight()){
            y = 0;
        }
}
}    
