package model;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DronMontañaParamTest {

	private static DronMontaña dMontaña;
	private double distanciaMision;
	private double resultado;
	
	// Cosntructor con las variables a implementar
	public DronMontañaParamTest(double distanciaMision, double resultado) {
		super();
		this.distanciaMision = distanciaMision;
		this.resultado = resultado;
	}

	@Parameters // Método donde introducir los parametros sugeridos.
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {10, 1.5}, {7, 1.05}, {5, 0.75}
        });
    }
    
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

	@Test(timeout = 2000)   // Método para hacer el test del metodo con los parametros dados.
	public void calculoTiempoRespuestaTest() {

		// Se establece un parametro como 0.001 para ajustar el margen de error al trabajar con tipo double
		assertEquals(resultado, dMontaña.calculoTiempoRespuesta(distanciaMision), 0.001); 
	}

}
