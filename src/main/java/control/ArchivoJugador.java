package control;

import modelo.Jugador;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoJugador {

    public ArchivoJugador() {

    }

    public ArrayList<Jugador> traerJugadoresArchivo(File ruta) {
        String lineaTexto;
        ArrayList<Jugador> jugadoresArchivos = new ArrayList<Jugador>();
        try {
            FileReader fReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fReader);
            while ((lineaTexto = bufferedReader.readLine()) != null) {
                String[] datosJugador = lineaTexto.split(";");
                Jugador j = new Jugador();
                j.setNombre(datosJugador[0]);
                j.setNacionalidad(datosJugador[1]);
                j.setEdad(Integer.parseInt(datosJugador[2]));
                j.setClub(datosJugador[3]);
                j.setFotografia(datosJugador[4]);
                j.setVelocidad(Integer.parseInt(datosJugador[5]));
                j.setAgilidad(Integer.parseInt(datosJugador[6]));
                j.setResistencia(Integer.parseInt(datosJugador[7]));
                j.setControlBalon(Integer.parseInt(datosJugador[8]));
                j.setRating(Integer.parseInt(datosJugador[9]));
                j.setPotencial(Double.parseDouble(datosJugador[10]));
                jugadoresArchivos.add(j);
            }
            bufferedReader.close();
            fReader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Archivo no encontrado");
            System.exit(0);
        }
        return jugadoresArchivos;
    }

}