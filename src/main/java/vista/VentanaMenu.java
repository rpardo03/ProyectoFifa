package vista;

import control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMenu extends JFrame implements ActionListener {

    private GestorJugador gJugador;
    private ArrayList<JLabel> etiquetas;
    private ArrayList<JButton> botones;

    public VentanaMenu() {
        iniciarComponentes();
        iniciarVentana();
    }

    private void iniciarEtiquetas() {
        this.etiquetas = new ArrayList<JLabel>();
        this.etiquetas.add(new JLabel("1.-Listar Jugadores."));
        this.etiquetas.add(new JLabel("2.-Buscar Jugador."));
        this.etiquetas.add(new JLabel("3.-Comparar Jugadores."));
        this.etiquetas.add(new JLabel("4.-Salir."));
    }

    private void iniciarBotones() {
        this.botones = new ArrayList<JButton>();
        for (int i = 0; i < 4; i++) {
            this.botones.add(new JButton("Realizar"));
        }
    }

    private void iniciarComponentes() {
        this.gJugador = new GestorJugador();
        this.setLayout(new GridLayout(4,2));
        iniciarEtiquetas();
        iniciarBotones();
        for (int i = 0; i < botones.size(); i++) {
            this.add(etiquetas.get(i));
            this.add(botones.get(i));
            botones.get(i).addActionListener(this);
        }
    }

    public void iniciarVentana() {
        Toolkit tamanioPantalla = Toolkit.getDefaultToolkit();
        Dimension pantalla = tamanioPantalla.getScreenSize();
        this.setSize(pantalla.width / 2, pantalla.height / 2);
        this.setLocation(pantalla.width / 4, pantalla.height / 4);
        this.setTitle("Menu Jugadores:");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(botones.get(0))){
            VentanaListaJugador vLista = new VentanaListaJugador(gJugador.getJugadores());dispose();
        }
        else if (actionEvent.getSource().equals(botones.get(1))){
          String busqueda=JOptionPane.showInputDialog("Ingrese el Nombre/Nacionalidad/Edad/Club/Rating o Potencial");
          VentanaListaJugador vListaBusqueda = new VentanaListaJugador(gJugador.listarJugadores(busqueda));dispose();
        }else if (actionEvent.getSource().equals(botones.get(2))){

        }else{
            System.exit(0);
        }
    }
}