import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            int a;
            try {
                a = calculator.getInteger(sc);
            } catch (RuntimeException e) {
                System.out.println("양의 정수를 입력해주세요");
                continue;
            }
            int b;
            try {
                b = calculator.getInteger(sc);
            } catch (RuntimeException e) {
                System.out.println("양의 정수를 입력해주세요");
                continue;
            }
            char op;
            try {
                op = calculator.getOperator(sc);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
            try {
                calculator.calculate(op, a, b);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }
            System.out.println(a + "" + op + b + "=" + calculator.getList().getLast());
            boolean flag = calculator.continueFunction(sc);
            if (flag) {
                break;
            }
        }

    }
}
