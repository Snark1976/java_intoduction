package home_work_1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int[] q = getPossibleNumbers(in.nextLine());
            int[] w = getPossibleNumbers(in.nextLine());
            int[] e = getPossibleNumbers(in.nextLine());
            for (int i: q){
                for (int j: w){
                    for (int k: e){
                        if (i + j == k){
                            System.out.format("%d + %d = %d", i, j, k);
                            return;
                        }
                    }
                }
            }            
        } 
        System.out.print("Решения нет");       
    }

    static int[] getPossibleNumbers(String str)
    {
        var pos = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '?'){
                pos.add(i);
            }
        }
        var positions = pos.toArray();
        char[] chars = str.toCharArray();
        String pattern = "0".repeat(pos.size());
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        int size = (int) Math.pow(10, pos.size());
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            String substitution = myFormatter.format(i);
            char[] digits = chars.clone();
            for (int j = 0; j < pos.size(); j++) {
                digits[(int) positions[j]] = substitution.charAt(j);
            }
            result[i] = Integer.parseInt(new String(digits));
        }
        return result;
    }
}
