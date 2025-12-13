package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Input;
import main.Panel;

public class Player extends Entity{
    Panel panel;
    Input input;

    int maxSpeed = 2;
    int diagonalSpeed = speed /100;
    public boolean shoot = false;
    public boolean playerActive = true;
    public int whiteMonsterCount;

    public Player(Panel panel, Input input){
        this.panel = panel;
        this.input = input;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = panel.screenWidth/2 - panel.tileSize/2;
        y = 500;
        speed = 2;  
        direction = "up";

    }

    public void getPlayerImage(){
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
        if(diagonalSpeed > maxSpeed){
            diagonalSpeed = maxSpeed;
        }

        if(input.upPressed == true){
            direction = "up";
            if(y > -20){
            y -= speed;
            }
            
        }

        if(input.downPressed == true){
            direction = "down";
            if(y < 596 - panel.tileSize){
            y += speed;
            }

        }

        if(input.leftPressed == true){
            direction = "left";
            if(x > -20){
            x -= speed;
            }
        }

        if(input.rightPressed == true){
            direction = "right";
            if(x < 596 - panel.tileSize){
            x += speed;
            }
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
        if(input.spacePressed == false){
            shoot = false;
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
        int playerCenterX = x + panel.tileSize/2;
        int playerCenterY = y + panel.tileSize/2;
        g2.drawImage(image, x, y, panel.tileSize, panel.tileSize, null);
    }
}
