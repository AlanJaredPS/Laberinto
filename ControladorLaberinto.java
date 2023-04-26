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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class ControladorLaberinto implements KeyListener{
    LaberintoGUI lGUI;
    Laberinto lab;
    
    ControladorLaberinto(LaberintoGUI lGUI, Laberinto lab){
        this.lGUI = lGUI;
        this.lab  = lab;
        this.lGUI.getFrame().addKeyListener(this);
    }
    
    public void start(){
        lGUI.launch();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case 37 : lab.updateCurrentCol(lab.getCurrent()[1]-1); break;//- left arrow    col-1
            case 38 : lab.updateCurrentRow(lab.getCurrent()[0]-1); break;//- upper arrow   ren-1
            case 39 : lab.updateCurrentCol(lab.getCurrent()[1]+1); break;//- right arrow   col+1
            case 40 : lab.updateCurrentRow(lab.getCurrent()[0]+1); break;//- down arrow    ren+1
        }        
        lab.dibujaPanel(lGUI.getPanel().getGraphics());
        if(lab.isGameOver()){
            lGUI.bye();
            System.exit(0);
        }    
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    
    }
    
    
}
