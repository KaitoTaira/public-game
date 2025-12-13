package entity;

import main.Panel;


public class WhiteMonster {
EnemyManager enemymanager;
Player player;
Panel panel;

public double whitemonsterX;
public double whitemonsterY;

public boolean whiteMonsterActive = true;


    public WhiteMonster(double startX, double startY, EnemyManager enemymanager, Player player, Panel panel){
        this.enemymanager = enemymanager;
        this.whitemonsterX = enemymanager.enemyX;
        this.whitemonsterY = enemymanager.enemyY;
        this.player = player;
        this.panel = panel;
}

public void update(){
    whitemonsterY += 3;
    if((whitemonsterY > 576 || whitemonsterY < -100) || (whitemonsterX < -100 || whitemonsterX > 576)){
            whiteMonsterActive = false;
        }
    System.out.println(player.whiteMonsterCount);
    double playerCenterX = player.x + panel.tileSize/2;
    double playerCenterY = player.y + panel.tileSize/2;
    double distanceX = playerCenterX - whitemonsterX + panel.tileSize/2;
    double distanceY = playerCenterY - whitemonsterY + panel.tileSize/2;
    double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        if(distance < 80){
            whiteMonsterActive = false;
            player.whiteMonsterCount ++;
            }
}
}
