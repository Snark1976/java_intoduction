package class_work_1;

import java.util.Arrays;   
import java.util.Scanner;

public class task_1
{    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] nums = {in.nextInt(), in.nextInt(), in.nextInt()};
		Arrays.sort(nums);
		System.out.println(nums[0]);
		System.out.println(nums[2]);
		in.close();
    }
}