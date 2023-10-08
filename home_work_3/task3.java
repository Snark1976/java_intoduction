package home_work_3;

import java.util.Arrays;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        // Сортируем массив по возрастанию
        Arrays.sort(arr);

        // Выводим отсортированный массив
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        // Выводим результат на экран
        System.out.println(sb.toString());

        // Находим минимальное и максимальное значение
        int min = arr[0];
        int max = arr[arr.length - 1];

        // Находим сумму всех чисел для вычисления среднего
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Вычисляем среднее арифметическое
        int average = sum / arr.length;

        // Выводим результаты
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);
        System.out.println("Average is = " + average);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class task3{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
      
   
      Answer.analyzeNumbers(arr);
    }
}