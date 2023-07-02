package home_work_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_4 {
    public static void main(String[] args) {
        Logger logger;
        try {
            logger = prepareLogger();
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
            return;
        }
        Scanner in = new Scanner(System.in);
        while (true){
            String expression = in.nextLine();
            if (expression.startsWith("q")) break;
            String[] pieces = expression.split(" ");
            try{
                int a = Integer.parseInt(pieces[0]);
                int b = Integer.parseInt(pieces[2]);
                String result = calculate(a, b, pieces[1]);
                System.out.println(result);
                logger.info(String.format("Solved: %s = %s", expression, result));
            }catch (Exception e){
                logger.warning(String.format("Error evaluating expression: \"%s\". Trace\n%s", expression, e.toString()));
            }
        }
        in.close();
    }

    private static String calculate(int a, int b, String operation)
    {
        switch (operation){
            case "+": return ((Integer)(a + b)).toString();
            case "-": return ((Integer)(a - b)).toString();
            case "*": return ((Integer)(a * b)).toString();
            case "/": return ((Double)((double) a / b)).toString();
            case "^": return ((Double)Math.pow(a, b)).toString();
            default: throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static Logger prepareLogger() throws SecurityException, IOException{
        FileHandler fh = new FileHandler("./home_work_2/calculator.log", true);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        Logger logger = Logger.getLogger("Calculator");  
        logger.addHandler(fh);
        return logger;
    }
}
