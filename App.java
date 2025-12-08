import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        while (true) {
            Number n1;
            try {
                n1 = calculator.getNumber(sc);
            } catch (RuntimeException e) {
                System.out.println("양의 숫자를 입력해주세요");
                continue;
            }
            Number n2;
            try {
                n2 = calculator.getNumber(sc);
            } catch (RuntimeException e) {
                System.out.println("양의 숫자를 입력해주세요");
                continue;
            }
            OperatorType op;
            try {
                op = calculator.getOperator(sc);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
            try {
                calculator.calFunc(op, n1, n2);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }
            System.out.println(n1 + "" + op.getSign() + n2 + "=" + calculator.getList().getLast());
            calculator.removeFirstFunction(sc);
            boolean flag = calculator.continueFunction(sc);
            if (flag) {
                break;
            }
        }
    }
}
