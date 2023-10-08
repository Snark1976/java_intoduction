package home_work_2;

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        // Напишите свое решение ниже
        StringBuilder res = new StringBuilder(QUERY);
        String task = PARAMS;
        String[] parts = task.split(",");

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("null")) parts[i] = "0:0";
            parts[i] = parts[i].replace("\"", "");
            parts[i] = parts[i].replace("{", "");
            parts[i] = parts[i].replace("}", "");
            parts[i] = parts[i].replace(" ", "");
        }

        String arr [][] = new String[parts.length][2];

        for (int j = 0; j < arr.length; j++) {
            int flag = 0;
            String [] temp = parts[j].split(":");
            for (int k = 0; k < 2; k++) {
                arr [j][k] = temp[k];
                if (!arr[j][k].equals("0")) {
                    if (k == 0) res.append(arr[j][k] + "='");
                    else res.append(arr[j][k]);
                }
                else flag = 1;
            }
            if (j < arr.length -1) res.append("' and ");
            if (flag == 1) res.setLength(res.length() - 5);
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class task_1{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
}