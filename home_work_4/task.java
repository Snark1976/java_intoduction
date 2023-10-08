package home_work_4;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Random;

public class task {
    public static void main(String[] args){
        ArrayDeque<Byte> n1 = getRandomNumber();
        ArrayDeque<Byte> n2 = getRandomNumber();
        System.out.println(sum(n1, n2));
    }

    private static ArrayDeque<Byte> getRandomNumber(){
        Random rd = new Random();        
        ArrayDeque<Byte> result = new ArrayDeque<>();
        result.addFirst((byte)(rd.nextInt(19) - 10));
        for (int i = 0; i < rd.nextInt(50); i++){
            result.addFirst((byte)rd.nextInt(10));
        }
        return result;
    }
    
    private static LinkedList<Character> sum (ArrayDeque<Byte> n1, ArrayDeque<Byte> n2){
        LinkedList<Character> result = new LinkedList<Character>();
        
        return result;
    }
}
