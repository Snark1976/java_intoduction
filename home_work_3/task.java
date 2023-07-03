package home_work_3;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args){
        ArrayList<Integer> lst = getRandomList(20, 100);
        String str = lst.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(String.format("Список случайных чисел: %s", str));
        str = lst.stream().filter(x -> x % 2 != 0).map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(String.format("Он же без четных чисел: %s", str));
        int max = lst.stream().max(Integer::compare).get();
        System.out.println(String.format("Максимум: %d", max));
        int min = lst.stream().min(Integer::compare).get();
        System.out.println(String.format("Минимум: %d", min));
        double average = lst.stream().reduce((x, y) -> x + y).get() / (double) lst.size();
        System.out.println(String.format("Среднее: %f", average));
    }

    private static ArrayList<Integer> getRandomList(int length, int maxValue){
        Random rd = new Random();
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            lst.add(rd.nextInt(maxValue));
        }
        return lst;
    } 
}
