public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char sign;

    OperatorType(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
