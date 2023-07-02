package home_work_2;

import java.util.Objects;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String json = in.nextLine();
        in.close();
        if (json.length() == 0)
            json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        Object obj;
        try {
            obj = new JSONParser().parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        JSONObject jo = (JSONObject) obj;
        StringBuilder query = new StringBuilder();
        int counter = 0;
        for (var key : jo.keySet()){
            if (Objects.equals(jo.get(key), "null")) continue;
            query.append(counter++ == 0 ? "select * from students where " : " and ");
            query.append(key);
            query.append(" = ");
            query.append(jo.get(key));
        }
        System.out.println(query.toString());
    }
}
