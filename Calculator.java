import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 양의 정수 2개 입력
            Integer a = getInteger(sc);
            if (a == null) continue;
            Integer b = getInteger(sc);
            if(b == null) continue;

            // 사칙연산 기호 입력받기
            Character op = null;
            try {
                op = getOperator(sc);
            } catch (RuntimeException e) {
                continue;
            }
            
            int result = 0;
            try {
                result = getResult(op, a, b);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                continue;
            }
            list.add(result);

            System.out.println(a + "" + op + "" + b + "=" + result);

            boolean flag = continueFunction(sc);
            if (flag) {
                break;
            }
        }
    }

    private static boolean continueFunction(Scanner sc) {
        System.out.print("중지하려면 exit를 입력해주세요:");
        String str = sc.nextLine();
        return str.toLowerCase().equals("exit");
    }

    private static Integer getInteger(Scanner sc) {
        System.out.print("양의 정수을 입력해주세요:");
        int a;
        try {
            a = sc.nextInt();
            if (a < 0) {
                throw new RuntimeException("양의 정수를 입력해주세요");
            }
        } catch (RuntimeException e) {
            System.out.println("양의 정수를 입력해주세요");
            return null;
        }finally {
            sc.nextLine();
        }
        return a;
    }

    private static Character getOperator(Scanner sc) throws RuntimeException {
        System.out.print("사칙연산 기호('+', '-', '*', '/')를 입력해주세요:");
        char op = sc.nextLine().charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new RuntimeException("사칙연산 기호('+', '-', '*', '/')를 입력해주세요");
        }
        return op;
    }

    private static int getResult(char op, int a, int b) throws RuntimeException{
        boolean errHappened = false;
        int result = 0;
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
                result = a / b;
                break;
        }
        return result;
    }
}
