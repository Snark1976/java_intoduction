package home_work_3;

import java.util.Arrays;
import java.util.ArrayList;

class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        // Создаем ArrayList для хранения нечетных чисел
        ArrayList<Integer> result = new ArrayList<>();

        // Итерируемся по входному массиву и добавляем нечетные числа в результат
        for (Integer num : arr) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }

        // Выводим результат на экран
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class task2{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
        
      Answer.removeEvenNumbers(arr);
    }
}
