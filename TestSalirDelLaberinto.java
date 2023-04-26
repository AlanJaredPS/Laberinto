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
public class TestSalirDelLaberinto {

    public static void main(String[] args) {
        Laberinto modelo = new Laberinto();
        LaberintoGUI vista = new LaberintoGUI(modelo);
        ControladorLaberinto c = new ControladorLaberinto(vista, modelo);

        c.start();
    }

}
