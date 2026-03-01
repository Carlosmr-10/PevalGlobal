package model;

/**
 * Clase hija que deriva de la clase padre Dron y define los drones de montaña.
 */
public class DronMontaña extends Dron {

	/**
	 * Variable que define la altitud a la que puede volar el dron de montaña.
	 */
	private double altitud;
	
	/**
	 * Constructor con variables para definir un dron de montaña.
	 * 
	 * @param identificador Define el identificador del dron.
	 * @param autonmíaMax Define la autonomía máxima del dron.
	 * @param velocidadMax Define la velocidad máxima del dron.
	 * @param operativo Define si el dron está activo o no.
	 * @param altitud Define la altitud a la que puede volar el dron.
	 */
	public DronMontaña(String identificador, int autonmíaMax,
			int velocidadMax, boolean operativo, double altitud) {
		super(identificador, autonmíaMax, velocidadMax, operativo);
		
		if (altitud < 0) {
			// Si la altitud introducida es menor a 0, se lanza una excepción
			throw new IllegalArgumentException("La altitud debe ser mayor que 0");
		}
		
		this.altitud = altitud;
	}

	/**
	 * Método que recoge la altitud del dron de montaña.
	 * @return Altitud a la que puede volar el dron de montaña.
	 */
	public double getAltitud() {
		return altitud;
	}

	/**
	 * Método que establece la altitud del dron de montaña.
	 * @param altitud Define la altitud a la que puede volar el dron.
	 */
	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}

	@Override
	/**
	 * Método abstracto para calcular el tiempo de respuesta.
	 * @param distanciaMision Define la distancia en la que se localiza la misión.
	 * @return El tiempo de respuesta ya calculado.
	 */
	public double calculoTiempoRespuesta(double distanciaMision) {

		double tiempoRespuesta;
		
		if (distanciaMision < 0) {
			
			throw new IllegalArgumentException("La distancia no puede ser negativa");
		}
		
		comprobarEstado();
		
		tiempoRespuesta = distanciaMision / this.velocidadMax;
		
		tiempoRespuesta *= this.altitud;
		
		if (tiempoRespuesta > autonmíaMax) {
			
			throw new IllegalArgumentException("El tiempo de respuesta del dron"
					+ " no puede superar a la autonomía máxima");
		}
		
		return tiempoRespuesta;
	}
}
