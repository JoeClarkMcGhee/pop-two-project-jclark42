package fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionImplTest {

    Fraction testFraction = new FractionImpl(1, 2);
    Fraction testFraction2 = new FractionImpl(3, 4);
    Fraction testFraction3 = new FractionImpl(-1, 2);
    Fraction testFraction4 = new FractionImpl(3, -4);

    @Test
    void TestConstructorInitialisedWithNumerator() {
        FractionImpl testFractionInitialised = new FractionImpl(2);
        String result = testFractionInitialised.toString();
        assertEquals(result, "2");
    }

    @Test
    void TestConstructorInitialisedWithWithString() {
        String strFraction = "4/3";
        FractionImpl testFraction = new FractionImpl(strFraction);
        String result = testFraction.toString();
        assertEquals(result, "4/3");

        String strFraction2 = "3";
        FractionImpl testFraction2 = new FractionImpl(strFraction2);
        String result2 = testFraction2.toString();
        assertEquals(result2, "3");


        String strFraction3 = "8 / -12 ";
        FractionImpl testFraction3 = new FractionImpl(strFraction3);
        String result3 = testFraction3.toString();
        assertEquals(result3, "-2/3");
    }

    @Test
    void add() {
        Fraction additionResult = testFraction.add(testFraction2);
        String result = additionResult.toString();
        assertEquals(result, "5/4");

        Fraction additionResult2 = testFraction3.add(testFraction4);
        String result2 = additionResult2.toString();
        assertEquals(result2, "-5/4");
    }

    @Test
    void subtract() {
        Fraction additionResult = testFraction.subtract(testFraction2);
        String result = additionResult.toString();
        assertEquals(result, "-1/4");

        Fraction additionResult2 = testFraction3.subtract(testFraction4);
        String result2 = additionResult2.toString();
        assertEquals(result2, "1/4");
    }

    @Test
    void multiply() {
        Fraction additionResult = testFraction.multiply(testFraction2);
        String result = additionResult.toString();
        assertEquals(result, "3/8");

        Fraction additionResult2 = testFraction3.multiply(testFraction4);
        String result2 = additionResult2.toString();
        assertEquals(result2, "3/8");
    }

    @Test
    void divide() {
        Fraction additionResult = testFraction.divide(testFraction2);
        String result = additionResult.toString();
        assertEquals(result, "2/3");

        Fraction additionResult2 = testFraction3.divide(testFraction4);
        String result2 = additionResult2.toString();
        assertEquals(result2, "2/3");
    }

    @Test
    void abs() {
        Fraction result = testFraction3.abs();
        assertEquals(result.toString(), "1/2");
    }

    @Test
    void negate() {
        Fraction result = testFraction.negate();
        assertEquals(result.toString(), "-1/2");
    }

    @Test
    void inverse() {
        Fraction result = testFraction2.inverse();
        assertEquals(result.toString(), "4/3");
    }

    @Test
    void equals() {
        Fraction sameAsTestFraction = new FractionImpl(1, 2);
        Boolean result = testFraction.equals(sameAsTestFraction);
        assertEquals(result, true);

        Fraction differentToTestFraction = new FractionImpl(1, 3);
        Boolean result2 = testFraction.equals(differentToTestFraction);
        assertEquals(result2, false);
    }

    @Test
    void compareTo() {
        Fraction sameAsTestFraction = new FractionImpl(1, 2);
        int result = testFraction.compareTo(sameAsTestFraction);
        assertEquals(result, 0);

        Fraction greaterThanTestFraction = new FractionImpl(4, 5);
        int result2 = testFraction.compareTo(greaterThanTestFraction);
        assertEquals(result2, 1);

        Fraction lessThanTestFraction = new FractionImpl(1, 8);
        int result3 = testFraction.compareTo(lessThanTestFraction);
        assertEquals(result3, -1);
    }

    @Test
    void testToString() {
        String result = testFraction.toString();
        assertEquals(result, "1/2");

        Fraction zeroFraction = new FractionImpl(0, 1);
        String result2 = zeroFraction.toString();
        assertEquals(result2, "0/1");
    }
}