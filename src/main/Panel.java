package main;

import background.Background;
import bullet.Bullet;
import bullet.BulletManager;
import entity.Enemy;
import entity.Player;
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

    int fps = 60;

    Input input = new Input();
    Player player = new Player(this, input);
    
    public int startX = player.x;
    public int startY = player.y;
    Bullet bullet = new Bullet(startX, startY, null, this);
    BulletManager bulletManager = new BulletManager(this, player, bullet);
    Enemy enemy = new Enemy(this, bullet, bulletManager);
    
    Thread gameThread;

    

    Background bg = new Background(this);

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
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        bg.draw(g2);
        player.draw(g2);
        bulletManager.draw(g2);
        enemy.draw(g2);
        g2.dispose();
       
    }
}