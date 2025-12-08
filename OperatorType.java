public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private char sign;

    OperatorType(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
