package model;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DronMaritimoTest {

	private static DronMontaña dMontaña;
	private int velocidadMax;
	private float altitud;
	
	@Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {}, {}
        });
    }
    
	@BeforeClass
	public static void setUpBeforeClass() {

		System.out.println("Inicializando pruebas, creando dron de montaña");
		dMontaña = new DronMontaña("DMO1", 120, 10, false, 1.5f);
	}

	@AfterClass
	public static void tearDownAfterClass() {

		System.out.println("Finalizando todas las pruebas, eliminando dron");
		dMontaña = null;
	}

	@Before
	public void setUp() {

		System.out.println("Iniciando prueba, activando dron");
		dMontaña.setOperativo(true);
	}

	@After
	public void tearDown() {

		System.out.println("Finalizando prueba, desactivando dron");
		dMontaña.setOperativo(false);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
