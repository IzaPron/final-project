 import java.util.*;

    public class Main {
        public static void main(String[] args) {
            boolean isRunning = true; //deklaracja zmiennej i przypisanie wartości true

            while (isRunning) {

                Random random = new Random(); //obiekt klasy random
                System.out.println("Give n");
                Scanner input = new Scanner(System.in); // obiekt klasy scanner
                int n = input.nextInt(); // tworzenie zmiennej n, która jest ilością elementów tablicy
                int[] array = new int[n]; //  tworzenie pustej tablicy o wielkości n
            /*
            w pętli for wypełnienie tablicy arr randomowymi wartościami od 0 do 200
            po pętli wypełnienie tablicy posortowanymi wartościami
             */
                System.out.println("Choose bound of your array (advise: give max 1 000)");
                int bound = input.nextInt();

                System.out.println("Here is your array:");

                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(bound);
                    System.out.print(array[i] + " ");
                }
                System.out.println();

                System.out.println("Choose sorting method: ");
                System.out.println("0 = exit");
                System.out.println("1 = insertion sort");
                System.out.println("2 = selection sort");
                System.out.println("3 = bubble sort");
                System.out.println("4 = merge sort");


                int method = input.nextInt(); // tworzenie zmiennej  method dla rozpoznania metody
                if (method != 0) {
                    chooseMethod(method, array); // sortowanie tablicy metodą wybraną przez użytkownika

                    System.out.println("Here is your array sorted by chosen method: ");
                    printArray(array); // drukowanie posortowanej tablicy

                    System.out.println("Choose number to find in your array: ");
                    int chosen = input.nextInt();
                    int index = binarySearch(array, 0, array.length - 1, chosen);

                    if (index == -1) {
                        System.out.println("No given data in array");
                    } else {
                        System.out.println("Given data's index is: " + index);
                    }
                } else {
                    isRunning = false;
                }
            }
        }

        public static void chooseMethod(int method, int[] arr) {

            AlgorytmySortujace alg = new AlgorytmySortujace();

            if (method == 1) {
                alg.insertionSort(arr);
            }
            if (method == 2) {
                alg.selectionSort(arr);
            }
            if (method == 3) {
                alg.bubbleSort(arr);
            }
            if (method == 4) {
                alg.sort(arr, 0, arr.length - 1);

            }
        }

        public static void printArray(int[] arr) {

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public static int binarySearch(int array[], int l, int r, int x) {

            if (r >= l) {
                int middle = l + (r - l) / 2;

                if (array[middle] == x) {
                    return middle;
                }

                if (array[middle] > x) {
                    return binarySearch(array, l, middle - 1, x);
                }
                if (array[middle] < x) {
                    return binarySearch(array, middle + 1, r, x);
                }
            }

            return -1;
        }
    }
