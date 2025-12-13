package main;

import background.Background;
import bullet.Bullet;
import bullet.BulletManager;
import entity.Enemy;
import entity.EnemyManager;
import entity.Player;
import entity.WhiteMonster;
import entity.WhiteMonsterManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    public int tileSize = originalTileSize * scale;
    final int maxScreenCol = 12; //576 pixels 
    final int maxScreenRow = 12; //576 pixels
    public int screenWidth = tileSize * maxScreenRow;
    public int screenHeight = tileSize * maxScreenCol;
    public int drawCount;

    public int fps = 60;

    Input input = new Input();
    Player player = new Player(this, input);
    
    public int startX = player.x;
    public int startY = player.y;
    
    EnemyManager enemyManager = new EnemyManager(startX, startY, null, this, EnemyManager.Type.LEFT, false);
    Enemy enemy = new Enemy(this, enemyManager);
    public int enemyStartX = enemy.x;
    public int enemyStartY = enemy.y;
    WhiteMonster whitemonster = new WhiteMonster(0.0,0.0,enemyManager, player, this);
    WhiteMonsterManager whiteMonsterManager = new WhiteMonsterManager(enemyManager,whitemonster);
    Bullet bullet = new Bullet(startX, startY, null, this, enemy, enemyManager, 90, player, Bullet.Type.PLAYER, whiteMonsterManager, whitemonster);
    BulletManager bulletManager = new BulletManager(this, player, bullet, enemyManager, enemy, whiteMonsterManager);
    
    
    
    Thread gameThread;

    

    Background bg = new Background(this, player);

    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
        bg.getBackgroundImage();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override

    public void run(){

        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
                bg.update();
            }

            if(timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
        bulletManager.update();
        enemy.update();
        whiteMonsterManager.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        bg.draw(g2);
        player.draw(g2);
        bulletManager.draw(g2);
        enemy.draw(g2);
        whiteMonsterManager.draw(g2);
        
        if(player.playerActive == false){
            bg.end(g2);
        }
        g2.dispose();
    }
}