package fraction;

public class FractionImpl implements Fraction {

    private final int numerator;
    private final int denominator;

    /**
     * Initialise a fraction instance given a passed in numerator and denominator.
     *
     * @param numerator   as stated, a numerator.
     * @param denominator as stated, a denominator.
     */
    public FractionImpl(int numerator, int denominator) {

        if (denominator == 0) {
            throw new ArithmeticException("The denominator can't be zero");
        }
        // Initialise variables
        this.numerator = calculateAttribute(numerator, denominator, true);
        this.denominator = calculateAttribute(numerator, denominator, false);
    }

    /**
     * Initialise a fraction instance given a passed in numerator. The denominator is implicitly set to 1.
     *
     * @param wholeNumber an int representing the numerator.
     */
    public FractionImpl(int wholeNumber) {
        int denominator = 1;
        // Initialise variables
        this.numerator = calculateAttribute(wholeNumber, denominator, true);
        this.denominator = calculateAttribute(numerator, denominator, false);
    }

    /**
     * Given the passed in string, faction, Initialise a fraction instance. Whole fractions i.e. '2/3' and numerator
     * only string are permitted.
     *
     * @param fraction a string representing the faction.
     */
    public FractionImpl(String fraction) {
        // Remove all the empty spaces from the string
        String cleanedFractionStr = fraction.replaceAll("\\s", "");
        // The fraction is a "full" fraction if it contains the numerator and the denominator.
        boolean isFullFraction = fraction.contains("/");
        if (isFullFraction) {
            // Split the sting up into the numerator and denominator
            String[] parts = cleanedFractionStr.split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);

            if (denominator == 0) {
                throw new ArithmeticException("The denominator can't be zero");
            }
            // Initialise variables
            this.numerator = calculateAttribute(numerator, denominator, true);
            this.denominator = calculateAttribute(numerator, denominator, false);
        } else {
            int numerator = Integer.parseInt(cleanedFractionStr);
            int denominator = 1;
            // Initialise variables
            this.numerator = calculateAttribute(numerator, denominator, true);
            this.denominator = calculateAttribute(numerator, denominator, false);
        }
    }

    /**
     * Calculate a normalise value that will be used to initialise the numerator or denominator.
     *
     * @param numerator   as stated, a numerator.
     * @param denominator as stated, a denominator.
     * @param isNumerator a boolean indicating if the attribute is the numerator or not
     * @return a normalised integer that will be used to initialise either the numerator or denominator.
     */
    private int calculateAttribute(int numerator, int denominator, boolean isNumerator) {
        int gcf = getGreatestCommonFactor(Math.abs(numerator), Math.abs(denominator));
        boolean shouldFlipSign = denominator < 0;
        if (isNumerator) {
            return normalise(numerator, gcf, shouldFlipSign);
        } else {
            return normalise(denominator, gcf, shouldFlipSign);
        }
    }

    /**
     * Work of the greatest common factor of two numbers.
     *
     * @param numerator   as stated, a numerator.
     * @param denominator as stated, a denominator.
     * @return the gcf
     */
    private static int getGreatestCommonFactor(int numerator, int denominator) {
        int gcd = 1;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /**
     * Return the passed in num (with the sign flipped, if required) reduced to its smallest form.
     *
     * @param num            the number to be normalised. This will be a int representing the numerator or denominator.
     * @param gcf            the greatest common factor.
     * @param shouldFlipSign a boolean indicating if the sign in the num should be flipped.
     * @return The number divided by the gcf. The greatest common divisor of this number will be 1.
     */
    private static int normalise(int num, int gcf, boolean shouldFlipSign) {
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
        if (obj instanceof FractionImpl) {
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
        if (this.numerator == 0) {
            return "0/1";
        }
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
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
