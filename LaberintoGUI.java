/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 *
 * @author Jorge
 */
import javax.swing.*;
import java.awt.*;

public class LaberintoGUI extends JPanel {
    private Laberinto laberinto;

    public LaberintoGUI(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoCelda = getWidth() / laberinto.getColumnas();
        int altoCelda = getHeight() / laberinto.getFilas();

        for (int fila = 0; fila < laberinto.getFilas(); fila++) {
            for (int columna = 0; columna < laberinto.getColumnas(); columna++) {
                int x = columna * anchoCelda;
                int y = fila * altoCelda;

                if (laberinto.esObstaculo(fila, columna)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, anchoCelda, altoCelda);
                } else if (laberinto.esCamino(fila, columna)) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, anchoCelda, altoCelda);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, anchoCelda, altoCelda);
                }
            }
        }
    }

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto(10, 10);
        // Agregar obstáculos al laberinto aquí

        LaberintoGUI gui = new LaberintoGUI(laberinto);

        JFrame frame = new JFrame("Laberinto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gui);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Resolver el laberinto aquí
    }
}
