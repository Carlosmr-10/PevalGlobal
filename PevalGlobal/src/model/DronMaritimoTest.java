package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DronMaritimoTest {

	private static DronMaritimo dMaritimo;

	@BeforeClass // Al empezar el inicio de la batería creamos un dron con unos parámetros.
	public static void setUpBeforeClass() {
		System.out.println("Empiezan las pruebas, creando dron marítimo.");
		// Valores del enunciado: "DMR17", 110, 10, false, 80
		dMaritimo = new DronMaritimo("DMR17", 110, 10, false, 80);
	}

	@AfterClass // Al acabar nuestras pruebas dejamos el objeto dron vacío.
	public static void tearDownAfterClass() {
		System.out.println("Han finalizado todas las pruebas, eliminando dron.");
		dMaritimo = null;
	}

	@Before // Al empezar cada prueba iniciamos el dron poniendolo operativo.
	public void setUp() {
		System.out.println("Inicia la prueba, activando dron.");
		dMaritimo.setOperativo(true);
	}

	@After // Con la misma lógica que el test anterior, al acabar las pruebas hacemos que
			// deje de estar operativo
	public void tearDown() {
		System.out.println("Fin de la prueba, desactivando dron.");
		dMaritimo.setOperativo(false);
	}

	@Test(timeout = 2000) // Test que debe ser ignorado durante los tests
	@Ignore("No hay datos suficientes para la ejecución de este test.")
	public void testResistenciaBaja() {
		fail("Not yet implemented");
	}

	/*
	 * 
	 */

	@Test(timeout = 2000) // Test con tiempo de respuesta con distancia correcta.
	public void calculoTiempoRespuestaCorrectoUno() {
		double resultado = 0.5;
		assertEquals(resultado, dMaritimo.calculoTiempoRespuesta(5), 0.001);
	}

	@Test(timeout = 2000) // Test con tiempo de respuesta con otra distancia correcta.
	public void calculoTiempoRespuestaCorrectoDos() {
		double resultado = 2.0;
		assertEquals(resultado, dMaritimo.calculoTiempoRespuesta(20), 0.001);
	}

	@Test(timeout = 2000) // Último test con tiempo de respuesta con otra distancia correcta.
	public void calculoTiempoRespuestaCorrectoTres() {
		double resultado = 1.0;
		assertEquals(resultado, dMaritimo.calculoTiempoRespuesta(10), 0.001);
	}
	/*
	 * Fin de los métodos de tiempos de respuesta correctos.
	 * =================================================================
	 */

	/*
	 * ================================================================= Métodos
	 * tiempos de respuesta incorrectos.
	 */
	// Método con distancia de misión negativa.

	// Distancia negativa lanza IllegalStateException
	@Test(timeout = 2000, expected = IllegalStateException.class)
	public void calculoTiempoRespuestaDistanciaNegativa() {
		dMaritimo.calculoTiempoRespuesta(-5);
	}

	// Autonomía insuficiente lanza IllegalStateException
	@Test(timeout = 2000, expected = IllegalStateException.class)
	public void calculoTiempoRespuestaInsuficienteAutonomia() {
		dMaritimo.calculoTiempoRespuesta(2000);
	}

	@Test(timeout = 2000) // Método para comprobar que el estado del dron sea operativo.
	public void dronOperativo() {

		assertTrue(dMaritimo.comprobarEstado());
	}

	// Método con el estado del dron en no operativo para que salte la excepción.
	@Test(timeout = 2000, expected = IllegalStateException.class)
	public void dronNoOperativo() {

		dMaritimo.setOperativo(false);
		assertTrue(dMaritimo.comprobarEstado());
	}
}
