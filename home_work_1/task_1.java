package home_work_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int triangle = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++){
            triangle += i;
            factorial *= i;
        }
		System.out.println(triangle);
        System.out.println(factorial);
		in.close();
    }
}
