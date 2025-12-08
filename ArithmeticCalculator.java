import java.util.LinkedList;
import java.util.Scanner;

public class ArithmeticCalculator {
    private LinkedList<Double> list = new LinkedList<>();

    public LinkedList<Double> getList() {
        return list;
    }

    public void setList(LinkedList<Double> list) {
        this.list = list;
    }

    public void removeFirst() {
        list.removeFirst();
    }

    public void removeFirstFunction(Scanner sc) {
        System.out.println("현재 저장된 계산 결과들: " + list);
        System.out.print("저장된 첫번째 결과를 제거하겠습니까[y/n]? ");
        String line = sc.nextLine();
        if (line.toLowerCase().equals("y")) {
            removeFirst();
            System.out.println("명령 결과: " + list);
        }
    }

    public boolean continueFunction(Scanner sc) {
        System.out.print("중지하려면 exit를 입력해주세요:");
        String str = sc.nextLine();
        return str.toLowerCase().equals("exit");
    }

    public Number getNumber(Scanner sc) throws RuntimeException {
        System.out.print("양의 숫자를 입력해주세요:");
        double d = -1;
        int i = -1;
        String line = sc.nextLine();
        if (line.contains(".")) {
            d = Double.parseDouble(line);
            if (d < 0) {
                throw new RuntimeException("양의 숫자를 입력해주세요");
            }
        } else {
            i = Integer.parseInt(line);
            if (i < 0) {
                throw new RuntimeException("양의 숫자를 입력해주세요");
            }
        }

        if (i != -1) {
            return i;
        } else {
            return d;
        }
    }

    public OperatorType getOperator(Scanner sc) throws RuntimeException {
        System.out.print("사칙연산 기호('+', '-', '*', '/')를 입력해주세요:");
        char op = sc.nextLine().charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new RuntimeException("사칙연산 기호('+', '-', '*', '/')를 입력해주세요");
        }
        switch (op) {
            case '+':
                return OperatorType.PLUS;
            case '-':
                return OperatorType.MINUS;
            case '*':
                return OperatorType.MULTIPLY;
            case '/':
                return OperatorType.DIVIDE;
        }
        return null;
    }

    public <A extends Number, B extends Number> void calFunc(OperatorType op, A a, B b) {
        if (a instanceof Integer) {
            if (b instanceof Integer) {
                calculate(op, (int) a, (int) b);
            } else {
                calculate(op, (int) a, (double) b);
            }
        } else {
            if (b instanceof Integer) {
                calculate(op, (double) a, (int) b);
            } else {
                calculate(op, (double) a, (double) b);
            }
        }

    }

    private void calculate(OperatorType op, int a, double b) {
        double result = 0;
        switch (op) {
            case op.PLUS:
                result = a + b;
                break;
            case op.MINUS:
                result = a - b;
                break;
            case op.MULTIPLY:
                result = a * b;
                break;
            case op.DIVIDE:
                result = a / b;
                if (b == 0) {
                    throw new ArithmeticException();
                }
                break;
        }
        list.add(result);
    }

    private void calculate(OperatorType op, int a, int b) {
        double result = 0;
        switch (op) {
            case op.PLUS:
                result = a + b;
                break;
            case op.MINUS:
                result = a - b;
                break;
            case op.MULTIPLY:
                result = a * b;
                break;
            case op.DIVIDE:
                result = a / b;
                if (b == 0) {
                    throw new ArithmeticException();
                }
                break;
        }
        list.add(result);
    }

    private void calculate(OperatorType op, double a, int b) {
        double result = 0;
        switch (op) {
            case op.PLUS:
                result = a + b;
                break;
            case op.MINUS:
                result = a - b;
                break;
            case op.MULTIPLY:
                result = a * b;
                break;
            case op.DIVIDE:
                result = a / b;
                if (b == 0) {
                    throw new ArithmeticException();
                }
                break;
        }
        list.add(result);
    }

    private void calculate(OperatorType op, double a, double b) {
        double result = 0;
        switch (op) {
            case op.PLUS:
                result = a + b;
                break;
            case op.MINUS:
                result = a - b;
                break;
            case op.MULTIPLY:
                result = a * b;
                break;
            case op.DIVIDE:
                result = a / b;
                if (b == 0) {
                    throw new ArithmeticException();
                }
                break;
        }
        list.add(result);
    }
}
