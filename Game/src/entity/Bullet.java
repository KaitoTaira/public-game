package entity;
import main.Panel;
import entity.Player;

public class Bullet extends Entity{

    public int bulletx;
    public int bullety;

    public Bullet(){
        setDefaultValues();
    }

    public void setDefaultValues(){
        bulletx = x;
        bullety = y;
        speed = 4;
    }

    public void update(){
        if(Player.shoot == true){
            bullety += speed;
        }
    }
}