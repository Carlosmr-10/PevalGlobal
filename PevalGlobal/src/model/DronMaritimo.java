package model;

/*
 
Clase que representa un dron especializado en entornos marítimos.
Esta clase hereda de la clase base Dron y añade la variable de resistencia a la salinidad.
@author María Roche Durán
@since 27/02/2026
@version 1.0.0*/
public class DronMaritimo extends Dron {

//Variable que define el factor de resistencia a la salinidad (0-100).*/
	private int resistenciaSal;

	/*
	 * Constructor con atributos específicos para el dron marítimo.
	 * 
	 * @param identificador Define el identificador del dron.
	 * 
	 * @param autonmíaMax Define la autonomía máxima del dron en minutos.
	 * 
	 * @param velocidadMax Define la velocidad máxima del dron.
	 * 
	 * @param operativo Define si el dron está activo o no.
	 * 
	 * @param resistenciaSal Define el factor de resistencia a la salinidad (0-100).
	 */
	public DronMaritimo(String identificador, int autonmíaMax, int velocidadMax, boolean operativo,
			int resistenciaSal) {
		super(identificador, autonmíaMax, velocidadMax, operativo);
		this.resistenciaSal = resistenciaSal;
	}

	/*
	 * Calcula el tiempo de respuesta para una misión marítima basándose en la
	 * distancia.
	 * 
	 * @param distancia La distancia de la misión.
	 * 
	 * @return El tiempo calculado en minutos.
	 */
	@Override
	public double calculoTiempoRespuesta(double distancia) {// Condición, si la distancia es negativa, lanzar una
															// excepción
		if (distancia < 0) {
			throw new IllegalStateException("La distancia no puede ser negativa.");
		}
// Otra condición para saber el estado del dron (debe lanzar excepción si no está operativo) 
		if (!this.operativo) {
			throw new IllegalStateException("El dron no está operativo.");
		}

		// Dividir la distancia de la misión entre la velocidad máxima
		double tiempo = distancia / this.velocidadMax;

		// Condición para saber y calcular si la resistencia a la salinidad es menor que
		// 30, aumentar el tiempo en un 20%
		if (this.resistenciaSal < 30) {
			tiempo = tiempo * 1.2;
		}

		// Comprobar que el tiempo calculado no exceda la autonomía disponible
		if (tiempo > this.autonmíaMax) {
			throw new IllegalStateException("El tiempo calculado excede la autonomía disponible.");
		}

		return tiempo;
	}

	/*
	 * Metodo que recoge el factor de resistencia a la salinidad.
	 * 
	 * @return una variable con la resistencia a la salinidad.
	 */
	public int getResistenciaSal() {
		return resistenciaSal;
	}

	/*
	 * Metodo que establece el factor de resistencia a la salinidad.
	 * 
	 * @param resistenciaSal Define la resistencia a la salinidad (0-100).
	 */
	public void setResistenciaSal(int resistenciaSal) {
		if (resistenciaSal >= 0 && resistenciaSal <= 100) {
			this.resistenciaSal = resistenciaSal;
		}
	}

}