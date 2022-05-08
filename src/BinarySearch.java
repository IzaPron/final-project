public class BinarySearch {

    /*
        Funkcja binarySearch zwraca index szukanej wartości w posortowanej tablicy, jeśli nie ma tej wartości zwraca -1
     */

    public int binarySearch(int arr[], int left, int right, int indexOfSearchingVal) {

        if (right >= left) {
            int mid = left + (right - left) / 2;

            // Jeśli wartość jest w środku
            if (arr[mid] == indexOfSearchingVal)
            {
                return mid;
            }

            /*
                Jeśli wartość jest mniejsza nież wartość w środku wtedy może być tylko w lewej podtablicy.
                Przeszukaj w takim wypadkutylko lewą pod tablicę
             */

            if (arr[mid] > indexOfSearchingVal)
            {
                return binarySearch(arr, left, mid - 1, indexOfSearchingVal);
            }

            /*
                W przeciwnym wypadku wartość jest w prawej pod tablicy
             */

            return binarySearch(arr, mid + 1, right, indexOfSearchingVal);
        }

        /*
        Nie ma takiej wartości w tablicy zwracamy -1
         */

        return -1;
    }

}




