package model;

public abstract class Dron {

	protected String identificador;
	protected int autonmíaMax;
	protected float velocidadMax;
	protected boolean operativo;
	
	/*
	 * Constructor con atributos
	 */
	public Dron(String identificador, int autonmíaMax, float velocidadMax, boolean operativo) {
		
		this.identificador = identificador;
		this.autonmíaMax = autonmíaMax;
		this.velocidadMax = velocidadMax;
		this.operativo = operativo;
	}
	
	/*
	 * Constructor desde 0
	 */
	public Dron() {
		
		this.identificador = null;
		this.autonmíaMax = 0;
		this.velocidadMax = 0;
		this.operativo = false;
	}

	/*
	 * Getters & setters
	 */
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getAutonmíaMax() {
		return autonmíaMax;
	}

	public void setAutonmíaMax(int autonmíaMax) {
		this.autonmíaMax = autonmíaMax;
	}

	public float getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(float velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public boolean isOperativo() {
		return operativo;
	}

	public void setOperativo(boolean operativo) {
		this.operativo = operativo;
	}
	
	/*
	 * Metodo requerido para calcular el tiempo de respuesta
	 */
	protected abstract void calculoTiempoRespuesta();
}
