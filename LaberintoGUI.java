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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LaberintoGUI {
    JFrame ventana;
    JPanel panel;
    Laberinto lab;
    
    public LaberintoGUI(Laberinto lab){
        this.lab = lab;
        ventana = new JFrame();
        panel   = new JPanel();
        
        initComponents();
    }
    
    private void initComponents(){
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setTitle("Laberinto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setLayout(null);
                
        ventana.getContentPane().add(panel);
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public JFrame getFrame(){
        return ventana;
    }
    
    public void bye(){
        JOptionPane.showMessageDialog(null, "Usted ha salido del laberinto");
    }
    
    public void launch(){
        ventana.setVisible(true); 
        this.paint(panel.getGraphics());
        //lab.dibujaPanel(panel.getGraphics());
    }
    
    public void paint(Graphics g){
        g.drawString("", 0, 0);

        
        for(int ren = 0, y = 0; ren < lab.getLaberinto().length; ren++, y += 46)
            for(int col = 0, x = 0; col < lab.getLaberinto()[0].length; col++, x += 50){
                switch(lab.get(ren, col)){
                    case 3:g.setColor(Color.blue); 
                            g.fillRect(x+2, y+2, x+48, y+44); break;
                    case 0: g.setColor(Color.white); 
                            g.fillRect(x+2, y+2, x+46, y+42); break;
                    case 1: g.setColor(Color.black); 
                            g.fillRect(x+2, y+2, x+48, y+44); break;
                    case 2: g.setColor(Color.red);   
                            g.fillRect(x+2, y+2, x+48, y+44); break;
                }
                
            } 
        for(int col = 500/10; col < 500; col+=50)    
            g.drawLine(col, 0, col, 500);
        for(int ren = 46; ren < 500; ren+=46)        
            g.drawLine(0, ren, 500, ren);
        
    }
    
    public void pintarPorPixel(Graphics g){
        g.drawString("", 0, 0);
        
        g.fillRect(10, 10, 12, 12);
    }
    
}
