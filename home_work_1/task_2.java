package home_work_1;

public class task_2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++){
            boolean flag = true;
            for (int j = 2; j*j <= (i); j ++){
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}
