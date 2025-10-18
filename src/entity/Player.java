package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.sqrt;
import javax.imageio.ImageIO;
import main.Input;
import main.Panel;

public class Player extends Entity{
    Panel panel;
    Input input;

    int maxSpeed = 4;
    double diagonalSpeed = speed / sqrt(2);
    boolean shoot = false;

    public Player(Panel panel, Input input){
        this.panel = panel;
        this.input = input;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = panel.screenWidth/2 - panel.tileSize/2;
        y = 500;
        speed = 4;  
        direction = "up";

    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeup1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeup2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/planedown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/planedown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeleft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeleft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/planeright2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(input.shiftPressed == true){
            maxSpeed = 2;
        }
        if(input.shiftPressed == false){
            maxSpeed = 4;
            speed = maxSpeed;
        }
        if(speed > maxSpeed) {
            speed = maxSpeed;
        }

        if(input.upPressed == true){
            direction = "up";
            y -= speed;
        }

        if(input.downPressed == true){
            direction = "down";
            y += speed;
        }

        if(input.leftPressed == true){
            direction = "left";
            x -= speed;
        }

        if(input.rightPressed == true){
            direction = "right";
            x += speed;
        }

        if(input.upPressed && input.leftPressed){
            direction = "left";
            y -= diagonalSpeed;
            x -= diagonalSpeed;
        }

        if(input.upPressed && input.rightPressed){
            direction = "right";
            y -= diagonalSpeed;
            x += diagonalSpeed;
        }

        if(input.downPressed && input.leftPressed){
            direction = "left";
            y += diagonalSpeed;
            x -= diagonalSpeed;
        }

        if(input.downPressed && input.rightPressed){
            direction = "right";
            y += diagonalSpeed;
            x += diagonalSpeed;
        }
        if(!input.upPressed && !input.downPressed && !input.leftPressed && !input.rightPressed){
            direction = "up";
        }
        spriteCounter++;
        if(spriteCounter > 30){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if(input.spacePressed == true){
            shoot = true;
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction){
            case "up":
            if(spriteNum == 1){
                image = up1;
            }
            if(spriteNum == 2){
                image = up2;
            }
            break;
            case "down":
            if(spriteNum == 1){
                image = down1;
            }
            if(spriteNum == 2){
                image = down2;
            }
            break;
            case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }
            break;
            case "right":
            if(spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }
            break;
        }

        g2.drawImage(image, x, y, panel.tileSize, panel.tileSize, null);
    }
}
