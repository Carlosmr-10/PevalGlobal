package model;

/**
 * Clase que representa un dron especializado en entornos marítimos. [cite: 26, 79]
 * Esta clase hereda de la clase base Dron y añade la variable de resistencia a la salinidad. [cite: 26, 28]
 * @author María Roche Durán
 * @since 27/02/2026
 * @version 1.0.0
 */
public class DronMaritimo extends Dron {

	/**
	 * Variable que define el factor de resistencia a la salinidad (0-100). [cite: 28, 81]
	 */
	private int resistenciaSal;

	/**
	 * Constructor con atributos específicos para el dron marítimo. 
	 * @param identificador Define el identificador del dron. [cite: 23]
	 * @param autonmíaMax Define la autonomía máxima del dron en minutos. [cite: 23]
	 * @param velocidadMax Define la velocidad máxima del dron. [cite: 23]
	 * @param operativo Define si el dron está activo o no. [cite: 23]
	 * @param resistenciaSal Define el factor de resistencia a la salinidad (0-100). [cite: 28]
	 */
	public DronMaritimo(String identificador, int autonmíaMax, int velocidadMax, boolean operativo,
			int resistenciaSal) {
		super(identificador, autonmíaMax, velocidadMax, operativo);
		this.resistenciaSal = resistenciaSal;
	}

	/**
	 * Calcula el tiempo de respuesta para una misión marítima basándose en la distancia. [cite: 25, 29, 82]
	 * @param distancia La distancia de la misión.
	 * @return El tiempo calculado en minutos.
	 */
	@Override
	public double calculoTiempoRespuesta(double distancia) {
		// Condición: si la distancia es negativa, lanzar excepción [cite: 36, 14]
		if (distancia < 0) {
			throw new IllegalStateException("La distancia no puede ser negativa.");
		}

		// Revisar el estado del dron (excepción si no está operativo) [cite: 30, 47]
		if (!this.operativo) {
			throw new IllegalStateException("El dron no está operativo.");
		}

		// Dividir la distancia entre la velocidad máxima [cite: 31]
		double tiempo = (double) distancia / this.velocidadMax;

		// Si la resistencia es < 30, aumentar el tiempo en un 20% [cite: 32, 33]
		if (this.resistenciaSal < 30) {
			tiempo = tiempo * 1.2;
		}

		// Comprobar que el tiempo no exceda la autonomía disponible [cite: 34, 35]
		if (tiempo > this.autonmíaMax) {
			throw new IllegalStateException("El tiempo calculado excede la autonomía disponible.");
		}

		return tiempo;
	}

	/**
	 * Metodo que recoge el factor de resistencia a la salinidad. 
	 * @return una variable con la resistencia a la salinidad.
	 */
	public int getResistenciaSal() {
		return resistenciaSal;
	}

	/**
	 * Metodo que establece el factor de resistencia a la salinidad. [cite: 10, 82]
	 * @param resistenciaSal Define la resistencia a la salinidad (0-100).
	 */
	public void setResistenciaSal(int resistenciaSal) {
		if (resistenciaSal >= 0 && resistenciaSal <= 100) {
			this.resistenciaSal = resistenciaSal;
		}
	}
}