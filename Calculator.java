import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean continueFunction(Scanner sc) {
        System.out.print("중지하려면 exit를 입력해주세요:");
        String str = sc.nextLine();
        return str.toLowerCase().equals("exit");
    }

    public Integer getInteger(Scanner sc) {
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

    public Character getOperator(Scanner sc) throws RuntimeException {
        System.out.print("사칙연산 기호('+', '-', '*', '/')를 입력해주세요:");
        char op = sc.nextLine().charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new RuntimeException("사칙연산 기호('+', '-', '*', '/')를 입력해주세요");
        }
        return op;
    }

    public int getResult(char op, int a, int b) throws RuntimeException{
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
