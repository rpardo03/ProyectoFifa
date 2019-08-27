package control;

import java.io.File;
import java.util.*;

import modelo.*;

public class GestorJugador {

    private ArrayList<Jugador> jugadores;

    public GestorJugador() {
        jugadores = new ArrayList<Jugador>();
        ingresarJugadores();
    }

    private void ingresarJugadores() {
        ArchivoJugador aJugador = new ArchivoJugador();
        this.jugadores = aJugador.traerJugadoresArchivo(new File("src/archivos/jugadores.txt"));
    }

    public ArrayList<Jugador> listarJugadores(String busqueda) {
        ArrayList<Jugador> jugadoresBuscados = new ArrayList<Jugador>();
        try {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getRating() == Integer.parseInt(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                } else if (jugadores.get(i).getEdad() == Integer.parseInt(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                } else if (jugadores.get(i).getPotencial()== Double.parseDouble(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                }
            }
            return jugadoresBuscados;
        } catch (NumberFormatException e) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getNombre().equals(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                } else if (jugadores.get(i).getNacionalidad().equals(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                } else if (jugadores.get(i).getClub().equals(busqueda)) {
                    jugadoresBuscados.add(jugadores.get(i));
                }
            }
            return jugadoresBuscados;
        }
    }

    public Jugador buscarJugador(String nombreJugador){
        for (int i=0;i<jugadores.size();i++){
            if (jugadores.get(i).getNombre().equals(nombreJugador)){
                return jugadores.get(i);
            }
        }
        return null;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}