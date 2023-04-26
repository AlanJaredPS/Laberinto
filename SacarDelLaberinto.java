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
public class SacarDelLaberinto {

    public static void main(String[] args) {
        new SacarDelLaberinto().run();
    }

    private void run() {
        //- Creamos el laberinto invocando al constructor por default
        Laberinto l = new Laberinto();
        SmartMaze labyrinth = new SmartMaze(l.getLaberinto(), 
                                            new int [][]{{0, 1}, {8,9}});
        LaberintoGUI gui = new LaberintoGUI(new Laberinto(labyrinth.getGrid(), // laberinto
                                            new int[]{9, 1},                   // entrada
                                            new int [][]{{0,1}, {8,9}}));      // salidas
        gui.launch();
        labyrinth.setGUI(gui);
        System.out.println(labyrinth);
        if (labyrinth.traverse(9, 1)) 
            System.out.println("Se puede salir del laberinto");
        else
            System.out.println("No se encuentra una ruta de salida");
        
        System.out.println(labyrinth);
        gui.paint(gui.getPanel().getGraphics());
        
    }

}
