package vista;

import modelo.Jugador;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaDatosJugador extends JFrame {

    private ArrayList<JPanel> paneles;

    public VentanaDatosJugador(Jugador jugador) {
        iniciarComponentes(jugador);
        iniciarVentana();
    }

    private JPanel panelSuperiorDPersonales(Jugador jugador) {
        JPanel panelSuperior = new JPanel(new GridLayout(2, 3));
        panelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        panelSuperior.add(new JLabel(""));
        panelSuperior.add(new JLabel("Nombre:"+jugador.getNombre()));
        panelSuperior.add(new JLabel("Nacionalidad:"+jugador.getNacionalidad()));
        panelSuperior.add(new JLabel(""));
        panelSuperior.add(new JLabel("Edad:"+jugador.getEdad()));
        panelSuperior.add(new JLabel("Club:"+jugador.getClub()));
        return panelSuperior;
    }

    private JPanel panelCentralSkills(Jugador jugador) {
        JPanel panelCentral = new JPanel(new GridLayout(4, 1));
        panelCentral.setBorder(javax.swing.BorderFactory.createTitledBorder("Habilidades"));
        panelCentral.add(new JLabel("Velocidad:"+jugador.getVelocidad()));
        panelCentral.add(new JLabel("Resistencia:"+jugador.getResistencia()));
        panelCentral.add(new JLabel("Control:"+jugador.getControlBalon()));
        panelCentral.add(new JLabel("Agilidad:"+jugador.getAgilidad()));
        return panelCentral;
    }

    private JPanel panelInferiorValor(Jugador jugador) {
        JPanel panelInferior = new JPanel(new GridLayout(2, 1));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor"));
        panelInferior.add(new JLabel("Rating:"+jugador.getRating()));
        panelInferior.add(new JLabel("Potencial:"+jugador.getPotencial()));
        return panelInferior;
    }

    private void iniciarComponentes(Jugador jugador) {
        this.setLayout(new GridLayout(3, 1));
        paneles = new ArrayList<JPanel>();
        paneles.add(panelSuperiorDPersonales(jugador));
        paneles.add(panelCentralSkills(jugador));
        paneles.add(panelInferiorValor(jugador));
        for (int i = 0; i < 3; i++) {
            this.add(paneles.get(i));
        }
    }

    private void iniciarVentana() {
        Toolkit tamanioPantalla = Toolkit.getDefaultToolkit();
        Dimension pantalla = tamanioPantalla.getScreenSize();
        this.setSize(pantalla.width / 2, pantalla.height / 2);
        this.setLocation(pantalla.width / 4, pantalla.height / 4);
        this.setTitle("Menu Jugadores:");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }


}