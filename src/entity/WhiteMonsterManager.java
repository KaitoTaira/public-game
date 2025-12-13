package entity;

import java.util.ArrayList;
import bullet.Bullet;

public class WhiteMonsterManager {
ArrayList<WhiteMonster> whitemonsters = new ArrayList<>();
Bullet bullet;

    public WhiteMonsterManager(Bullet bullet){
        this.bullet = bullet;
    }

    public void update(){
        if(bullet.whiteMonsterSpawned){
            System.out.println(bullet.whiteMonsterSpawned);
        }
    }
}
