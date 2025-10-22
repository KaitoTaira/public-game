package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class Enemy extends Entity{
    Panel panel;
    

    public Enemy(Panel panel){
        this.panel = panel;
    }

    public void getEnemyImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/planeup1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/planeup2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/planedown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/planedown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/planeleft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/planeleft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/planeright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/planeright2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setDefaultValues(){
        x = 
        y =
        
    }
}
