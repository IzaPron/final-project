import java.util.*;

import static java.lang.System.nanoTime;

public class Main {

    public static Random random = new Random();
    public static Scanner input = new Scanner(System.in);
    public static SortAlgorithms sortAlgorithms = new SortAlgorithms();
    public static BinarySearch binarySearch = new BinarySearch();

    public static void main(String[] args) {

        int[] thousand = new int[1000];
        int[] oneHundredThousand = new int[100000];
        int[] million = new int[1000000];

        int[] copyOfThousand = new int[1000];
        int[] copyOfOneHundredThousand = new int[100000];
        int[] copyOfMillion = new int[1000000];

        long[] sortTimeForThousand = new long[4];
        long[] sortTimeForOneHundredThousand = new long[4];
        long[] sortTimeForMillion = new long[4];

        long starTime, endTime, resultTime;

        fillTheArray(thousand);
        fillTheArray(oneHundredThousand);
        fillTheArray(million);

        int randomForThousand, randomForOneHundredThousand, randomForMillion;
        int  randomValueForThousand, randomValueForOneHundredThousand, randomValueForMillion;
        randomForThousand = random.nextInt(999);
        randomForOneHundredThousand = random.nextInt(99999);
        randomForMillion = random.nextInt(999999);

        randomValueForThousand = thousand[randomForThousand];
        randomValueForOneHundredThousand = oneHundredThousand[randomForOneHundredThousand];
        randomValueForMillion = million[randomForMillion];

        for (int i = 0; i < 4; i++) {
            copyOfThousand = thousand;

            starTime = nanoTime();
            sortByChoosenMethod(i, copyOfThousand);
            endTime = nanoTime();
            resultTime = starTime - endTime;
            sortTimeForThousand[i] = resultTime;

        }

        for (int i = 0; i < 4; i++) {
            copyOfOneHundredThousand = oneHundredThousand;

            starTime = nanoTime();
            sortByChoosenMethod(i, copyOfOneHundredThousand);
            endTime = nanoTime();
            resultTime = starTime - endTime;
            sortTimeForOneHundredThousand[i] = resultTime;

        }

        for (int i = 0; i < 4; i++) {
            copyOfMillion = copyOfMillion;

            starTime = nanoTime();
            sortByChoosenMethod(i, copyOfMillion);
            endTime = nanoTime();
            resultTime = starTime - endTime;
            sortTimeForMillion[i] = resultTime;
        }


    }

    public static int factoryOfNumbers() {

        int number = -1;
        String numberStr = "";
        String digitStr = "";
        String restOfNumberStr = "";

        int digit = random.nextInt(1, 9);
        int restOfNumber = random.nextInt(100000000, 999999999);

        digitStr = String.valueOf(digit);
        restOfNumberStr = String.valueOf(restOfNumber);
        numberStr = digitStr + numberStr;

        number = Integer.parseInt(numberStr);

        return number;
    }

    public static void fillTheArray(int[] array) {
        for (int i = 0; i < array.length; i++) {

            array[i] = factoryOfNumbers();
        }
    }

    public static void sortByChoosenMethod(int chosenMethod, int[] array) {


        if (chosenMethod == 1) {
            sortAlgorithms.insertionSort(array);
        }

        if (chosenMethod == 2) {
            sortAlgorithms.selectionSort(array);
        }

        if (chosenMethod == 3) {
            sortAlgorithms.bubbleSort(array);
        }

        if (chosenMethod == 4) {
            sortAlgorithms.sort(array, 0, array.length - 1);
        }
    }


}
