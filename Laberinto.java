/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto1;

/**
 *
 * @author Jorge
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Laberinto {
    private final int renglones;
    private final int columnas;
    private final int [][] laberinto;
    private int [] current, start;
    
    public Laberinto(int[][] lab, int[] par, int[][] par1){
        this.laberinto = lab;
        this.renglones = lab.length;
        this.columnas  = lab[0].length;
    }
    
    public Laberinto(){
        laberinto = new int [][]{
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        renglones = laberinto.length;
        columnas  = laberinto[0].length;
        current = new int[]{4,9};
        start = new int[]{4,9};
        
        setCurrent(current[0], current[1], 2);
    }
    
    public int [][] getLaberinto(){
        return laberinto;
    }
    
    public void setCurrent(int ren, int col, int value){
        laberinto[ren][col] = value;
        current[0] = ren;
        current[1] = col;
    }
    
    public void updateCurrentRow(int newRow){
        if(newRow >= 0 && newRow < 10){
            if(laberinto[newRow][current[1]] == 0){
                setCurrent(current[0], current[1], 0);
                current[0] = newRow;
                setCurrent(newRow, current[1], 2);
            }    
        }  

    }
    
    public void updateCurrentCol(int newCol){
        if(newCol >= 0 && newCol < 10){
            if(laberinto[current[0]][newCol] == 0){
                setCurrent(current[0], current[1], 0);
                current[1] = newCol;
                setCurrent(current[0], newCol, 2);
            }    
        }    

    }
    
    public boolean isGameOver(){
        if(!(current[0] == start[0] && current[1] == start[1])){
            if(laberinto[current[0]][current[1]] == 2){
                if(current[0] == 9 || current[0] == 0 || current[1] == 0 || current[1] == 9){
                    return true;
                }    
            }
        }    
        return false;
    }
    
    public int[] getCurrent(){
        return current;
    }
    
    public int get(int ren, int col){
        return laberinto[ren][col];
    }
    
    public void dibujaPanel(Graphics g){
        g.drawString("", 0, 0);
        
        for(int ren = 0, y = 0; ren < getLaberinto().length; ren++, y += 46)
            for(int col = 0, x = 0; col < getLaberinto()[0].length; col++, x += 50){
                switch(get(ren, col)){
                    case 3:
                    case 0: g.setColor(Color.white); g.fillRect(x, y, x+50, y+46); break;
                    case 1: g.setColor(Color.black); g.fillRect(x, y, x+50, y+46); break;
                    case 2: g.setColor(Color.red);   g.fillRect(x, y, x+50, y+46); break;
                }
//                try{
//                    Thread.sleep(125);
//                }catch(InterruptedException e){}
            } 
        for(int col = 500/10; col < 500; col+=50)    g.drawLine(col, 0, col, 500);
        for(int ren = 46; ren < 500; ren+=46)        g.drawLine(0, ren, 500, ren);
        
    }
}