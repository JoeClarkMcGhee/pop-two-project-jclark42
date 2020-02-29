package fraction;

public class FractionImpl implements Fraction {

    private final int numerator;
    private final int denominator;

    public FractionImpl(int numerator, int denominator) {

        if (denominator == 0) {
            throw new ArithmeticException("The denominator can't be zero");
        }
        this.numerator = calculateAttribute(numerator, denominator, true);
        this.denominator = calculateAttribute(numerator, denominator, false);
    }

    public FractionImpl(int wholeNumber) {
        int denominator = 1;
        this.numerator = calculateAttribute(wholeNumber, denominator, true);
        this.denominator = calculateAttribute(numerator, denominator, false);
    }

    public FractionImpl(String fraction) {
        String cleanedFractionStr = fraction.replaceAll("\\s", "");
        boolean isFullFraction = fraction.contains("/");
        if (isFullFraction) {
            String[] parts = cleanedFractionStr.split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);

            if (denominator == 0) {
                throw new ArithmeticException("The denominator can't be zero");
            }
            this.numerator = calculateAttribute(numerator, denominator, true);
            this.denominator = calculateAttribute(numerator, denominator, false);
        } else {
            int numerator = Integer.parseInt(cleanedFractionStr);
            int denominator = 1;
            this.numerator = calculateAttribute(numerator, denominator, true);
            this.denominator = calculateAttribute(numerator, denominator, false);
        }
    }

    private int calculateAttribute(int numerator, int denominator, boolean is_numerator) {
        int gcf = getGreatestCommonFactor(Math.abs(numerator), Math.abs(denominator));
        boolean shouldFlipSign = denominator < 0;
        if (is_numerator){
            return normalise(numerator, gcf, shouldFlipSign);
        }
        else {
            return normalise(denominator, gcf, shouldFlipSign);
        }
    }

    public static int getGreatestCommonFactor(int numerator, int denominator) {
        int gcd = 1;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int normalise(int num, int gcf, boolean shouldFlipSign) {
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
        int a = this.numerator, b = this.denominator;
        int c = ((FractionImpl) f).numerator, d = ((FractionImpl) f).denominator;

        int numerator = (a * d + b * c), denominator = b * d;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        int a = this.numerator, b = this.denominator;
        int c = ((FractionImpl) f).numerator, d = ((FractionImpl) f).denominator;

        int numerator = (a * d - b * c), denominator = b * d;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        int a = this.numerator, b = this.denominator;
        int c = ((FractionImpl) f).numerator, d = ((FractionImpl) f).denominator;

        int numerator = a * c, denominator = b * d;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        int a = this.numerator, b = this.denominator;
        int c = ((FractionImpl) f).numerator, d = ((FractionImpl) f).denominator;

        int numerator = a * d, denominator = b * c;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        int numerator = Math.abs(this.numerator), denominator = Math.abs(this.denominator);
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int numerator = this.numerator * -1, denominator = this.denominator;
        return new FractionImpl(numerator, denominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  FractionImpl) {
            return this.numerator == ((FractionImpl) obj).numerator &&
                    this.denominator == ((FractionImpl) obj).denominator;
        } else {
            return false;
        }
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return new FractionImpl(this.denominator, this.numerator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        float thisValue = (float) this.numerator / this.denominator;
        float objectValue = (float) ((FractionImpl) o).numerator / ((FractionImpl) o).denominator;
        return Float.compare(objectValue, thisValue);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.numerator == 0 ) {return "0/1";}
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        }
        else {
            return this.numerator + "/" + this.denominator;
        }
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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
