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
        int randomValueForThousand, randomValueForOneHundredThousand, randomValueForMillion;
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
            copyOfMillion = million;

            starTime = nanoTime();
            sortByChoosenMethod(i, copyOfMillion);
            endTime = nanoTime();
            resultTime = starTime - endTime;
            sortTimeForMillion[i] = resultTime;
        }

        long[] timeOfBinarySearch = new long[3];
        long fastestSortForThousand = minFromArray(sortTimeForThousand);
        long fastestSortForOneHundred = minFromArray(sortTimeForOneHundredThousand);
        long fastestSortForMillion = minFromArray(sortTimeForMillion);

        starTime = nanoTime();
        int indexOfSearchValueForThousand = binarySearch.binarySearch(thousand, 0, thousand.length - 1, randomValueForThousand);
        endTime = nanoTime();

        timeOfBinarySearch[0] = (starTime - endTime) + fastestSortForThousand;

        starTime = nanoTime();
        int indexOfSearchValueForOneHundredThousand = binarySearch.binarySearch(thousand, 0, thousand.length - 1, randomForOneHundredThousand);
        endTime = nanoTime();

        timeOfBinarySearch[1] = (starTime - endTime) + fastestSortForOneHundred;

        starTime = nanoTime();
        int indexOfSearchValueForMillion = binarySearch.binarySearch(thousand, 0, thousand.length - 1, randomForMillion);
        endTime = nanoTime();

        timeOfBinarySearch[2] = (starTime - endTime) + fastestSortForMillion;

        long[] timeOfLinearSearch = new long[3];
        int[] linearSearch = new int[3];

        starTime = nanoTime();
        linearSearch[0] = linearSearch(thousand, randomValueForThousand);
        endTime = nanoTime();

        timeOfLinearSearch[0] = starTime - endTime;

        starTime = nanoTime();
        linearSearch[1] = linearSearch(oneHundredThousand, randomForOneHundredThousand);
        endTime = nanoTime();

        timeOfLinearSearch[1] = starTime - endTime;


        starTime = nanoTime();
        linearSearch[2] = linearSearch(million, randomForMillion);
        endTime = nanoTime();

        timeOfLinearSearch[2] = starTime - endTime;
        String[] algorithmName = {"Insertion sort ", "Selection sort ", "Bubblesor t"," Mergesort "};


        System.out.println("For array with 1000 elemments");
        for (int i = 0; i < 4; i++) {
            System.out.println("Time of sort" + algorithmName[i] + sortTimeForThousand[i] + " nano second." );
        }
        System.out.println("Binary search find random value in time " + timeOfBinarySearch[0]);
        System.out.println("Linear search find random value in time " + timeOfLinearSearch[0]);


        System.out.println("For array with 100  000 elemments");
        for (int i = 0; i < 4; i++) {
            System.out.println("Time of sort" + algorithmName[i] + sortTimeForOneHundredThousand[i] + " nano second." );
        }
        System.out.println("Binary search find random value in time " + timeOfBinarySearch[1]);
        System.out.println("Linear search find random value in time " + timeOfLinearSearch[1]);

        
        System.out.println("For array with 1 000 000 elemments");
        for (int i = 0; i < 4; i++) {
            System.out.println("Time of sort" + algorithmName[i] + sortTimeForMillion[i] + " nano second." );
        }
        System.out.println("Binary search find random value in time " + timeOfBinarySearch[2]);
        System.out.println("Linear search find random value in time " + timeOfLinearSearch[2]);

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

    public static long minFromArray(long[] array){
        long min = array[0];

        for (int i = 1; i < array.length; i++) {
            if( array[i] < min){
                min = array[i];
            }
        }

        return  min;
    }

    public static int linearSearch(int[] array, int valueToFind){

        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToFind){
                return i;
            }
        }

        return -1;

    }
}
