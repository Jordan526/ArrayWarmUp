//@author Jordan Wood
//08.28.22

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\CST-201\\Array0WarmUp\\src\\text.txt");
        Scanner scanFile = new Scanner(file);
        String[] totalCapacity = new String[10000];
        int counter = 0;
        while (scanFile.hasNext()) {
            String current = scanFile.next();
            totalCapacity[counter] = current;
            counter++;
        }
        int valueCounter = 0;
        for (int i = 0; i < totalCapacity.length; i++) {
            if (totalCapacity[i] != null) {
                valueCounter++;
            }
        }
        String[] newCapacity = new String[valueCounter];
        for (int i = 0; i < newCapacity.length; i++) {
            newCapacity[i] = totalCapacity[i];
        }
        System.out.println("Before sorting:");
        printArray(newCapacity);
        System.out.println();
        System.out.println("After sorting:");
        selectionSort(newCapacity);
        printArray(newCapacity);

        System.out.print("Enter words to search for (enter 0 to quit): ");
        Scanner input = new Scanner(System.in);
        String currentWord = input.next();
        while (!currentWord.equals("0")) {
            boolean isInArray = false;
            for(int i = 0; i < newCapacity.length; i++) {
                if(currentWord.equals(newCapacity[i])) {
                    isInArray = true;
                }
            }
            if(isInArray) {
                System.out.println(currentWord + " is in the list at index " + binarySearch(newCapacity, currentWord));
                currentWord = input.next();
            }
            if(isInArray == false) {
                System.out.println(currentWord + " is not in the list");
                currentWord = input.next();
            }
        }
        if(currentWord.equals("0")) {
            System.exit(0);
        }
    }

    public static void printArray(String[]array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;
            String minimumString = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(minimumString) < 0) {
                    minimumString = array[j];
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                String temp = array[minimumIndex];
                array[minimumIndex] = array[i];
                array[i] = temp;
            }
        }
    }
    public static int binarySearch(String[] array, String targetWord) {
        int start = 0;
        int arrayLength = array.length - 1;
        while (start <= arrayLength) {
            int middle = start + (arrayLength - start) / 2;

            int result = targetWord.compareTo(array[middle]);

            if (result == 0) {
                return middle;
            }
            else if (result > 0) {
                start = middle + 1;
            }
            else {
                arrayLength = middle - 1;
            }
        }
        return -1;
    }
}
