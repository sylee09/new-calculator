import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    private LinkedList<Integer> list = new LinkedList<>();


    public LinkedList<Integer> getList() {
        return list;
    }

    public void setList(LinkedList<Integer> list) {
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
