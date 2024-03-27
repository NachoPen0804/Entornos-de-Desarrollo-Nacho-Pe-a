package calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testSumar() {
        assertAll(
                () -> assertEquals(8, Calculadora.sumar(4, 4)),
                () -> assertEquals(1, Calculadora.sumar(-4, 5))
        );
    }

    @Test
    void testRestar() {
        assertAll(
                () -> assertEquals(5, Calculadora.restar(10, 5)),
                () -> assertEquals(-12, Calculadora.restar(-10, 2))
        );
    }

    @Test
    void testMultiplicar() {
        assertAll(
                () -> assertEquals(12, Calculadora.multiplicar(3, 4)),
                () -> assertEquals(-6, Calculadora.multiplicar(-2, 3))
        );
    }

    @Test
    void testDividir() {
        assertThrows(ArithmeticException.class, () -> Calculadora.dividir(35, 0));
        assertAll(
                () -> assertEquals(12, Calculadora.dividir(24, 2)),
                () -> assertEquals(10, Calculadora.dividir(20, 2))
        );
    }
}