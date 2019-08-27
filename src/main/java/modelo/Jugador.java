package modelo;

public class Jugador {

	private String nombre;
	private String nacionalidad;
	private int edad;
	private String club;
	private String fotografia;
	private int velocidad;
	private int agilidad;
	private int resistencia;
	private int controlBalon;
	private int rating;
	private double potencial;

	public Jugador() {

	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPotencial() {
		return potencial;
	}

	public void setPotencial(double potencial) {
		this.potencial = potencial;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getControlBalon() {
		return controlBalon;
	}

	public void setControlBalon(int controlBalon) {
		this.controlBalon = controlBalon;
	}
}