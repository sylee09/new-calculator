import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Integer> list = new ArrayList<>();


    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public boolean continueFunction(Scanner sc) {
        System.out.print("중지하려면 exit를 입력해주세요:");
        String str = sc.nextLine();
        return str.toLowerCase().equals("exit");
    }

    public Integer getInteger(Scanner sc) throws RuntimeException{
        System.out.print("양의 정수을 입력해주세요:");
        int a;
        try {
            a = sc.nextInt();
            if (a < 0) {
                throw new RuntimeException("양의 정수를 입력해주세요");
            }
        } finally {
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

    public void calculate(char op, int a, int b) throws ArithmeticException{
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
        list.add(result);
    }
}
