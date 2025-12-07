package com.pots.utils;

import java.awt.Graphics;

public class Button implements Objeto{

    private int x, y, width, height;

    public Button(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(null, 0, 0, null)
    }



}
