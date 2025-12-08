import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 양의 정수 2개 입력
            System.out.print("양의 정수1을 입력해주세요:");
            int a;
            try {
                a = sc.nextInt();
                if (a < 0) {
                    throw new RuntimeException("양의 정수를 입력해주세요");
                }
            } catch (RuntimeException e) {
                System.out.println("양의 정수를 입력해주세요");;
                continue;
            }finally {
                sc.nextLine();
            }
            System.out.print("양의 정수2을 입력해주세요:");
            int b;
            try {
                b = sc.nextInt();
                if (b < 0) {
                    throw new RuntimeException("양의 정수를 입력해주세요");
                }
            } catch (RuntimeException e) {
                System.out.println("양의 정수를 입력해주세요");
                continue;
            }finally {
                sc.nextLine();
            }
            // 사칙연산 기호 입력받기
            System.out.print("사칙연산 기호('+', '-', '*', '/')를 입력해주세요:");
            char op = sc.nextLine().charAt(0);
            int result = 0;
            boolean errHappened = false;
            switch(op) {
                case '+' :
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    try {
                        result = a / b;
                    } catch (ArithmeticException e) {
                        errHappened = true;
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
                    }
                    finally {
                        break;
                    }
                default:
                    System.out.println("유효한 사칙연산 기호('+', '-', '*', '/')를 입력해 주세요");
                    errHappened = true;
                    break;
            }

            if (!errHappened) {
                System.out.println(a + "" + op + "" + b + "=" + result);
            }
            System.out.print("중지하려면 exit를 입력해주세요:");
            String str = sc.nextLine();
            if (str.toLowerCase().equals("exit")) {
                break;
            }
        }
    }
}
