package pe.edu.upao.alozanoc.arquitecturaapp.services;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;

public class UserSeviceTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("This run Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This run After All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("This run Before Each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("This run After Each");
    }


    @Test
    void testCheckIfPaswordIsValid() {
        System.out.println("Running test");
        // este es falso por que al menos debe haber una mayúscula
        Assertions.assertFalse(UserService.checkIfPaswordIsValid("&&&&&&&&&"));
        // este es falso por que debe ser mayor de 6 caracteres
        Assertions.assertFalse(UserService.checkIfPaswordIsValid("A&&"));
        // este es falso por que debe haber al menos un símbolo
        Assertions.assertFalse(UserService.checkIfPaswordIsValid("AAAAAAA"));
        // este es verdadero por que cumple todas las condiciones
        Assertions.assertTrue(UserService.checkIfPaswordIsValid("&Ali8393"));
    }


    @Test
    void testCheckIfPaswordIsValidDontThrowExceptionOnNulls() {
        System.out.println("Running test 2");
        // este es falso por que al menos debe haber una mayúscula
        Assertions.assertDoesNotThrow(() -> {
            UserService.checkIfPaswordIsValid(null);
        });

    }
}
