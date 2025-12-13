package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class WhiteMonsterManager {

EnemyManager enemymanager;
WhiteMonster whitemonster;
public ArrayList<WhiteMonster> whitemonsters = new ArrayList<>();



public BufferedImage whiteMonsterImage;

public boolean whiteMonsterSpawned = false;

    public WhiteMonsterManager(EnemyManager enemymanager, WhiteMonster whitemonster){
        this.enemymanager = enemymanager;
         try{
            whiteMonsterImage = ImageIO.read(getClass().getResourceAsStream("/enemy/whitemonster.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
      if(whiteMonsterSpawned){
        whiteMonsterSpawned = false;
      }
       for (int i = whitemonsters.size()-1; i >= 0; i--) {
            WhiteMonster w = whitemonsters.get(i);
            w.update();
            if (!w.whiteMonsterActive) {
                whitemonsters.remove(i);
            }
        }
    }

     public void draw(Graphics2D g2){
        for (WhiteMonster w: whitemonsters){
        g2.drawImage(whiteMonsterImage, (int)w.whitemonsterX, (int)w.whitemonsterY, 40, 40, null);
        }
    }
    }

