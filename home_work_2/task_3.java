package home_work_2;

class Answer {
    public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {
        JSON = JSON.replace("[{", "").replace("}]", "");
        String[] elements = JSON.split("},{");        
        for (String element : elements) {
            String[] keyValuePairs = element.split(",");            
            String фамилия = "";
            String оценка = "";
            String предмет = "";            
            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                
                if ("фамилия".equals(key)) {
                    фамилия = value;
                } else if ("оценка".equals(key)) {
                    оценка = value;
                } else if ("предмет".equals(key)) {
                    предмет = value;
                }
            }
            
            StringBuilder result = new StringBuilder();
            result.append(ELEMENT1)
                  .append(фамилия)
                  .append(ELEMENT2)
                  .append(оценка)
                  .append(ELEMENT3)
                  .append(предмет);
            
            System.out.println(result.toString());
        }
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class task_3{ 
	public static void main(String[] args) { 
      String JSON = "";
      String ELEMENT1 = "";
      String ELEMENT2 = "";
      String ELEMENT3 = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
        	"{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
        	"{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
	    ELEMENT1 = "Студент ";
        ELEMENT2 = " получил ";
        ELEMENT3 = " по предмету ";
      }
      else{
        JSON = args[0];
	    ELEMENT1 = args[1];
        ELEMENT2 = args[2];
        ELEMENT3 = args[3];
      }     
      
      Answer ans = new Answer();      
      ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
	}
}
