public class AlgorytmySortujace {

    public void insertionSort (int[] array) {
        int x, j;

        for (int i = 1; i < array.length; i++) {
            x = array[i];
            j = i -1;
            while (j >= 0 && array[j] > x) {
                array[j +1] = array[j];
                j--;
            }
            array[j + 1] = x;

        }
    }

    public void selectionSort(int array[]) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx])
                    min_idx = j;
            }

            int swap = array[min_idx];
            array[min_idx] = array[i];
            array[i] = swap;
        }
    }

    public void bubbleSort(int[] array) {

        int save;

        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    save = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = save;
                }
            }
        }
    }

    public void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(int arr[], int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}

