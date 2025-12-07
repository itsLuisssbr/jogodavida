package com.pots.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.pots.menu.Menu;
import com.pots.utils.FileLoader;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int SCALE = 1;
    public static final int FRAMEPSEC = 60;
    public static FileLoader loader;


    public boolean isRunning;

    public JFrame frame;

    public BufferedImage image = new BufferedImage(WIDTH * SCALE, HEIGHT * SCALE, BufferedImage.TYPE_INT_RGB);

    public Main() {

        JFrameInit();
    }

    public void JFrameInit() {
        frame = new JFrame("Jogo da vida");

        frame.add(this);
        frame.setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Main main = new Main();

        main.start();
    }

    public synchronized void start() {
        Thread thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public void tick() {
        
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();

        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, null);
        bs.show();

    }

    @Override
    public void run() {

        while (isRunning) {
            tick();
            render();

            try {
                Thread.sleep(1000 / FRAMEPSEC);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
