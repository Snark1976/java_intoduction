package home_work_5;

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);
        for (int i = sortLength - 1; i >= 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;
            heapify(sortArray, i, 0);
        }
    }

     private static void heapify(int[] tree, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && tree[leftChild] > tree[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && tree[rightChild] > tree[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = tree[i];
            tree[i] = tree[largest];
            tree[largest] = swap;

            heapify(tree, n, largest);
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class task_3 {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
