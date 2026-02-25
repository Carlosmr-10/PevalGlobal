package model;

/**
 * Clase abstracta que define las caracteristicas generales de un dron 
 * independientemente del tipo de dron que sea.
 * @author Carlos Michelena/María
 * @since 25/02/2026
 * @version 1.0.0
 */
public abstract class Dron {

	/**
	 * Variable que define el identificador del dron.
	 */
	protected String identificador;
	
	/**
	 * Variable que define la autonomía máxima del dron.
	 */
	protected int autonmíaMax;
	
	/**
	 * Variable que define la velocidad máxima del dron.
	 */
	protected float velocidadMax;
	
	/**
	 * Variable que define si el dron está activo o no.
	 */
	protected boolean operativo;
	
	/*
	 * Constructor con atributos.
	 */
	/**
	 * Constructor con atributos predefinidos.
	 * @param identificador Define el identificador del dron.
	 * @param autonmíaMax Define la autonomía máxima del dron.
	 * @param velocidadMax Define la velocidad máxima del dron.
	 * @param operativo Define si el dron está activo o no.
	 */
	public Dron(String identificador, int autonmíaMax, float velocidadMax, boolean operativo) {
		
		this.identificador = identificador;
		this.autonmíaMax = autonmíaMax;
		this.velocidadMax = velocidadMax;
		this.operativo = operativo;
	}
	
	/*
	 * Constructor desde 0.
	 */
	/**
	 * Constructor desde 0 con todos los atributos en 0, null o false
	 * para crearlos posteriormente.
	 */
	public Dron() {
		
		this.identificador = null;
		this.autonmíaMax = 0;
		this.velocidadMax = 0;
		this.operativo = false;
	}

	/*
	 * Getters & setters.
	 */
	
	/**
	 * Metodo que recoge el identificador del dron.
	 * @return una variable con el identificador del dron.
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Metodo que establece el identificador del dron.
	 * @param identificador Define el identificador del dron.
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * Metodo que recoge la autonomía máxima del dron.
	 * @return una variable con la autonomía máxima del dron.
	 */
	public int getAutonmíaMax() {
		return autonmíaMax;
	}

	/**
	 * Metodo que establece la autonomía máxima del dron.
	 * @param autonmíaMax Define la autonomía máxima del dron.
	 */
	public void setAutonmíaMax(int autonmíaMax) {
		this.autonmíaMax = autonmíaMax;
	}

	/**
	 * Metodo que recoge la velocidad máxima del dron.
	 * @return una variable con la velocidad máxima del dron.
	 */
	public float getVelocidadMax() {
		return velocidadMax;
	}

	/**
	 * Metodo que establece la velocidad máxima del lol.
	 * @param velocidadMax Define la velocidad máxima del dron.
	 */
	public void setVelocidadMax(float velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	/**
	 * Metodo que recoge el estado del dron.
	 * @return <ul>
	 *             <li>True: si el dron está operativo.</li>
	 *             <li>False: si el dron no está operativo.</li>
	 *         </ul>
	 */
	public boolean isOperativo() {
		return operativo;
	}

	/**
	 * Metodo que establece el estado del dron.
	 * @param operativo Define si el dron está operativo o no.
	 */
	public void setOperativo(boolean operativo) {
		this.operativo = operativo;
	}
	
	/*
	 * Metodo requerido para calcular el tiempo de respuesta.
	 */
	
	/**
	 * Metodo abstracto para calcular el tiempo de respuesta.
	 */
	protected abstract void calculoTiempoRespuesta();
}
