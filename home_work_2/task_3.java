package home_work_2;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task_3 {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        JSONArray jArray;
        try {
            jArray = (JSONArray) parser.parse(new FileReader("./home_work_2/task_3.json", StandardCharsets.UTF_8));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return;
        }
        for (Object o : jArray){
            System.out.println(GetString(o));
        }
    }
    
    private static String GetString(Object o){
        JSONObject jObject = (JSONObject) o;
        StringBuilder str = new StringBuilder();
        str.append("Студент ");
        str.append(jObject.get("фамилия"));
        str.append(" получил ");
        str.append(jObject.get("оценка"));
        str.append(" по предмету ");
        str.append(jObject.get("предмет")); 
        return str.toString();       
    }
}
