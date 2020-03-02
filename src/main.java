import fraction.Fraction;
import fraction.FractionImpl;

public class main {

    public static void main(String[] args) {
        Fraction f1 = new FractionImpl(4);
        Fraction f2 = new FractionImpl("1/ 2");
        Fraction f3 = f1.add(f2);
        Fraction f4 = new FractionImpl(1, 5);
        // 1/5
        System.out.println(f4.toString());
        Fraction f5 = f3.multiply(f4);
        Fraction f6 = new FractionImpl(12, 20);
        Fraction f7 = f5.add(f6);
        // 3/2
        System.out.println(f7.toString());
        Boolean isEqual = f3.equals(f7);
        // false
        System.out.println(isEqual);
        Fraction f8 = new FractionImpl("  3 /  2");
        Fraction f9 = f7.subtract(f8);
        // 0/1
        System.out.println(f9);

        Fraction f10 = new FractionImpl(-5);
        Fraction f11 = new FractionImpl("2/6");
        Fraction f12 = f10.divide(f11);
        System.out.println(f12);
        // -15
        Fraction f13 = f12.abs();
        System.out.println(f13);
        // 15

        Fraction f14 = f12.add(f3);
        System.out.println(f14);
        // -21/2
        Fraction f15 = f14.negate();
        System.out.println(f15);
        // 21/2
        Fraction f16 = f15.inverse();
        System.out.println(f16);
        // 2/21
    }
}

