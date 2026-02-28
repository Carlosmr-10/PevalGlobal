package model;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DronMaritimoParamTest {

	private static DronMaritimo dMaritimo;
	private double distanciaMision;
	private double resultado;
	
	public DronMaritimoParamTest(double distanciaMision, double resultado) {
		super();
		this.distanciaMision = distanciaMision;
		this.resultado = resultado;
	}

	@Parameters // Método donde introducimos los parámetros sugeridos para el dron.
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {10, 1.0}, {20, 2.0}, {5, 0.5} // Valores del enunciado.
        });
    }
    
	@BeforeClass   // Al inicio de la batería de pruebas creamos el dron con parámetros preestablecidos
	public static void setUpBeforeClass() {
		System.out.println("Inicializando pruebas parametrizadas, creando dron marítimo");
		// Valores: "DMR17", 110, 10, false, 80 
		dMaritimo = new DronMaritimo("DM1", 110, 10, false, 80);
	}

	@AfterClass   // Al finalizar la batería de pruebas liberamos la memoria.
	public static void tearDownAfterClass() {
		System.out.println("Finalizando todas las pruebas parametrizadas, eliminando dron");
		dMaritimo = null;
	}

	@Before   // Al inicio de cada prueba activamos el dron.
	public void setUp() {
		System.out.println("Iniciando prueba, activando dron");
		dMaritimo.setOperativo(true);
	}

	@After   // Al final de cada prueba desactivamos el dron.
	public void tearDown() {
		System.out.println("Finalizando prueba, desactivando dron");
		dMaritimo.setOperativo(false);
	}

	@Test(timeout = 2000)   // El tiempo de respuesta no puede superar los 2 segundos.
	public void calculoTiempoRespuestaTest() {
		// Se establece un margen de error de 0.001 por el uso de doubles.
		assertEquals(resultado, dMaritimo.calculoTiempoRespuesta(distanciaMision), 0.001); 
	}
}