package home_work_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_2 {
    public static void main(String[] args){
        int[] arr = getRandomArray(10, 100);
        System.out.println(Arrays.toString(arr));
        try {
            Logger logger = prepareLogger();
            logger.info(String.format("Before sort: %s", Arrays.toString(arr)));
            bubbleSort(arr, logger);
            logger.info(String.format("After sort: %s", Arrays.toString(arr)));
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] getRandomArray(int length, int maxValue) {
        Random rd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(maxValue);
        }
        return arr;
    }

    private static Logger prepareLogger() throws SecurityException, IOException{
        FileHandler fh = new FileHandler("./home_work_2/bubbleSort.log");
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        Logger logger = Logger.getLogger("BubbleSort");  
        logger.addHandler(fh);
        return logger;
    }

    private static void bubbleSort(int[] arr, Logger logger){ 
        int n = arr.length;  
        int temp = 0;
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1] > arr[j]){   
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;
                    logger.info(Arrays.toString(arr));
                }  
            } 
        }
    }  
}