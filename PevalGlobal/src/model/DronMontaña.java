package model;

public class DronMontaña extends Dron {

	private float altitud;
	
	public DronMontaña(String identificador, int autonmíaMax, float velocidadMax, boolean operativo, float altitud) {
		super(identificador, autonmíaMax, velocidadMax, operativo);
		
		if (altitud < 0) {
			
			throw new IllegalArgumentException("La altitud debe ser mayor que 0");
		}
		
		this.altitud = altitud;
	}

	public float getAltitud() {
		return altitud;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

	@Override
	protected float calculoTiempoRespuesta(float distanciaMision) {

		float tiempoRespuesta;
		
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
