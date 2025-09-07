package background;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.Panel;

public class Background {

public BufferedImage bg;
public int x;
public int y;

Panel panel;

    public Background(Panel panel){
        this.panel = panel;

        setDefaultValues();
    }

    public void getBackgroundImage(){
        try {
            bg = ImageIO.read(getClass().getResourceAsStream("/res/background/background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(bg, x, y, panel.getWidth(), panel.getHeight(), null);
        g2.drawImage(bg, x, y - panel.getHeight(), panel.getWidth(), panel.getHeight(), null);
    }

    public void setDefaultValues(){
        x = 0;
        y = 0;
    }

    public void update(){
        y += 1;
        resetBackground(null);
    }

    public void resetBackground(Graphics2D g2){
        if(y >= panel.getHeight()){
            y = 0;
        }
}
}    
