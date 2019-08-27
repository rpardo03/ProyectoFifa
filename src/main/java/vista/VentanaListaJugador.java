package vista;

import control.GestorJugador;
import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VentanaListaJugador extends JFrame implements ActionListener {

    private JTable listaJugadores;
    private ArrayList<JButton> botones;
    private JTextField areaTexto;

    public VentanaListaJugador(ArrayList<Jugador> lista) {
        crearListaJugadores(lista);
        iniciarComponentes();
        iniciarVentana();
    }


    private Object[] columnasTabla() {
        Object[] columnas = {"Fotografía", "Nombre", "Nacionalidad", "Rating", "Edad", "Club", "Potencial"};
        return columnas;
    }

    private Object[][] datosTabla(ArrayList<Jugador> lista) {
        Object[][] datosTabla = new Object[lista.size()][7];
        for (int i = 0; i < lista.size(); i++) {
            datosTabla[i][0] = lista.get(i).getFotografia();
            datosTabla[i][1] = lista.get(i).getNombre();
            datosTabla[i][2] = lista.get(i).getNacionalidad();
            datosTabla[i][3] = lista.get(i).getRating();
            datosTabla[i][4] = lista.get(i).getEdad();
            datosTabla[i][5] = lista.get(i).getClub();
            datosTabla[i][6] = lista.get(i).getPotencial();
        }
        return datosTabla;
    }

    private void crearListaJugadores(ArrayList<Jugador> lista) {
        listaJugadores = new JTable(datosTabla(lista), columnasTabla());
    }

    private void iniciarBotones() {
        botones = new ArrayList<JButton>();
        botones.add(new JButton("Buscar"));
        botones.add(new JButton("Ver info"));
        botones.add(new JButton("Volver Al Menú"));
        for (int i=0;i<botones.size();i++){
            botones.get(i).addActionListener(this);
        }
    }

    private JPanel panelSuperiorBusqueda() {
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Buscar Jugador"));
        areaTexto = new JTextField(30);
        panelSuperior.add(areaTexto);
        panelSuperior.add(botones.get(0));
        return panelSuperior;
    }

    private JPanel panelCentralLista() {
        JPanel panelCentral = new JPanel(new GridLayout(1, 1));
        panelCentral.add(new JScrollPane(listaJugadores));
        return panelCentral;
    }

    private JPanel panelInferiorBotonera() {//arreglar :c
        JPanel panelInfierior = new JPanel();
        panelInfierior.add(botones.get(1));
        panelInfierior.add(botones.get(2));
        return panelInfierior;
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        iniciarBotones();
        this.add(panelSuperiorBusqueda(), BorderLayout.NORTH);
        this.add(panelCentralLista(), BorderLayout.CENTER);
        this.add(panelInferiorBotonera(), BorderLayout.SOUTH);
    }

    private void iniciarVentana() {
        Toolkit tamanioPantalla = Toolkit.getDefaultToolkit();
        Dimension pantalla = tamanioPantalla.getScreenSize();
        this.setSize(pantalla.width / 2, pantalla.height / 2);
        this.setLocation(pantalla.width / 4, pantalla.height / 4);
        this.setTitle("Menu Jugadores:");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private String seleccionarTabla(){
        int row = listaJugadores.getSelectedRow();
        return listaJugadores.getValueAt(row,1).toString();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(botones.get(0))){
            GestorJugador gj = new GestorJugador();
            VentanaListaJugador vLista = new VentanaListaJugador(gj.listarJugadores(areaTexto.getText().trim()));
            dispose();
        }else if(actionEvent.getSource().equals(botones.get(1))){
            GestorJugador gestorJugador = new GestorJugador();
            VentanaDatosJugador vJugador = new VentanaDatosJugador(gestorJugador.buscarJugador(seleccionarTabla()));
        }else if (actionEvent.getSource().equals(botones.get(2))){
            VentanaMenu vm = new VentanaMenu();dispose();
        }
    }
}