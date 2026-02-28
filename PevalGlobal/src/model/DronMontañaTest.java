package model;

import static org.junit.Assert.*;

import org.junit.*;

public class DronMontañaTest {

	private static DronMontaña dMontaña;
	
	@BeforeClass   // Al nicio de la batreía de pruebas creamos un dron con parametros preestablecidos.
	public static void setUpBeforeClass() {

		System.out.println("Inicializando pruebas, creando dron de montaña");
		dMontaña = new DronMontaña("DMO1", 120, 10, false, 1.5f);
	}

	@AfterClass   // Al final de la batría de pruebas eliminamos el dron.
	public static void tearDownAfterClass() {

		System.out.println("Finalizando todas las pruebas, eliminando dron");
		dMontaña = null;
	}

	@Before   // Al inicio de cada prueba activamos el dron.
	public void setUp() {

		System.out.println("Iniciando prueba, activando dron");
		dMontaña.setOperativo(true);
	}

	@After   // Al final de cada prueba desactivamos el dron.
	public void tearDown() {

		System.out.println("Finalizando prueba, desactivando dron");
		dMontaña.setOperativo(false);
	}

	@Test(timeout = 2000)   // Método a ignorar durante los test
	@Ignore("Faltan datos para la ejecucion de este test")
	public void testResistenciaBaja() {
		fail("Not yet implemented");
	}
	
	
	/* =================================================================
	 * Métodos con tiempos de respuesta correctos con distintas distancias.
	 */
	@Test(timeout = 2000)
	public void calculoTiempoRespuestaCorrectoUno() {
		
		double resultado = 0.75;
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(5), 0.001);
	}
	
	@Test(timeout = 2000)
	public void calculoTiempoRespuestaCorrectoDos() {
		
		double resultado = 1.05;
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(7), 0.001);
	}
	
	@Test(timeout = 2000)
	public void calculoTiempoRespuestaCorrectoTres() {
		
		double resultado = 1.5;
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(10), 0.001);
	}
	/* Fin de los métodos de tiempos de respuesta correctos.
	 * =================================================================
	 */
	
	/* =================================================================
	 * Métodos con fallos en el tiempo de respuesta.
	 */
	// Método con distancia de misión negativa.
	@Test(timeout = 2000, expected = IllegalArgumentException.class)
	public void calculoTiempoRespuestaDistanciaNegativa() {
		
		double resultado = 6;
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(-1), 0.001);
	}
	
	// Método con autonomía menor a la distancia de misión.
	@Test(timeout = 2000, expected = IllegalArgumentException.class)
	public void calculoTiempoRespuestaMenorAutonomía() {
		
		dMontaña.setAutonmíaMax(2);
		double resultado = 6;
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(31), 0.001);
	}
	/* Fin de los métodos con fallos en el tiempo de respuesta.
	 * =================================================================
	 */
	
	
	@Test(timeout = 2000) // Método para comprobar que el estado del dron sea operativo.
	public void dronOperativo() {
		
		assertTrue(dMontaña.comprobarEstado());
	}
	
	// Método con el estado del dron en no operativo para que salte la excepción.
	@Test(timeout = 2000, expected = IllegalStateException.class)
	public void dronNoOperativo() {
		
		dMontaña.setOperativo(false);
		assertTrue(dMontaña.comprobarEstado());
	}
}
