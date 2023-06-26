package home_work_1;

import java.util.Objects;
import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] expression = in.nextLine().split(" ");
        int a = Integer.parseInt(expression[0]);
        int b = Integer.parseInt(expression[2]);
        if (Objects.equals(expression[1], "+")){
            System.out.println(a + b);
        }
        else if (Objects.equals(expression[1], "-")){
            System.out.println(a - b);
        }
        else if (Objects.equals(expression[1], "*")){
            System.out.println(a * b);
        }
        else if (Objects.equals(expression[1], "/")){
            System.out.println(a / (float)b);
        }
        in.close();
    }
}
