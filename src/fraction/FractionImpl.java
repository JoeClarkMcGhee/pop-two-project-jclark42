package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) {

        if(denominator == 0){
            throw new ArithmeticException("The denominator can't be zero");
        }

        initialiseAttributes(numerator, denominator);

    }

    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    public FractionImpl(String fraction) {
        String cleanedFractionStr = fraction.replaceAll("\\s", "");
        boolean isFullFraction = fraction.contains("/");
        if(isFullFraction){
            String[] parts = cleanedFractionStr.split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);

            if(denominator == 0){
                throw new ArithmeticException("The denominator can't be zero");
            }

            initialiseAttributes(numerator, denominator);
        }

        else {
            int numerator = Integer.parseInt(cleanedFractionStr);
            int denominator = 1;

            initialiseAttributes(numerator, denominator);
        }
    }

    private void initialiseAttributes(int numerator, int denominator) {
        int gcf = getGreatestCommonFactor(Math.abs(numerator), Math.abs(denominator));
        boolean shouldFlipSign = denominator < 0;
        this.numerator = normalise(numerator, gcf, shouldFlipSign);
        this.denominator = normalise(denominator, gcf, shouldFlipSign);
    }

    private int getGreatestCommonFactor(int numerator, int denominator) {
        int gcd = 1;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    private int normalise(int num, int gcf, boolean shouldFlipSign) {
        int numToReturn = num;
        if (shouldFlipSign) {
            numToReturn = num * -1;
        }
        return numToReturn / gcf;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }
}
