class KLists {
    public static void printDoubleLists(double[][] arr) {
        System.out.println("Given Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Array[" + i + "]:\t");
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + "  \t");
            System.out.println();
        }
    }

    public static void printSingleLists(double[] arr) {
        System.out.print("Merged Array: " + "\t");
        if (arr.length == 0)
            System.out.println("{}");
        else
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + "  \t");
        System.out.println();
    }

    // gets the total mumber of a double array (including duplicates)
    public static int arrayCounter(double[][] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                counter++;
        return counter;
    }

    // merges double[][] arrays into one array[] and gets rid of duplicates
    public static double[] mergeKLists(double[][] outerArray) {
        double singleArr[] = {};
        // checks for empty
        if (arrayCounter(outerArray) < 2)
            return singleArr;
        singleArr = new double[arrayCounter(outerArray)];

        // merges into single array
        for (int counter = 0, i = 0; i < outerArray.length; i++)
            for (int j = 0; j < outerArray[i].length; j++)
                singleArr[counter++] = outerArray[i][j];

        // sorts single array
        for (int i = 0; i < singleArr.length; i++)
            for (int j = 0; j < singleArr.length; j++)
                if (singleArr[i] < singleArr[j]) {
                    double temp = singleArr[i];
                    singleArr[i] = singleArr[j];
                    singleArr[j] = temp;
                }

        // counts for duplicates inside array
        int duplicateCounter = 0;
        for (int i = 1; i < singleArr.length; i++)
            if (singleArr[i] == singleArr[i - 1])
                duplicateCounter++;

        // gets rid of duplicates inside array
        double sortedSingleArr[] = new double[singleArr.length - duplicateCounter];
        sortedSingleArr[0] = singleArr[0];
        for (int counter = 1, i = 1; i < singleArr.length; i++)
            if (singleArr[i] != singleArr[i - 1])
                sortedSingleArr[counter++] = singleArr[i];

        // returns sorted array[]
        return sortedSingleArr;
    }

    public static void main(String[] args) {
        double[][] outerArray;

        // TEST ONE:
        System.out.println("TEST ONE:");
        outerArray = new double[][] { { 1.1, 4.4, 5.5 }, { 1.1, 3.3, 4.4 }, { 2.2, 6.6 } };
        printDoubleLists(outerArray); // print OG array
        printSingleLists(mergeKLists(outerArray)); // prints single sorted array

        // TEST TWO:
        System.out.println("\n\nTEST TWO:");
        outerArray = new double[][] {};
        printDoubleLists(outerArray); // print OG array
        printSingleLists(mergeKLists(outerArray)); // prints single sorted array

        // TEST THREE:
        System.out.println("\n\nTEST THREE:");
        outerArray = new double[][] { {} };
        printDoubleLists(outerArray); // print OG array
        printSingleLists(mergeKLists(outerArray)); // prints single sorted array

        // TEST FOUR:
        System.out.println("\n\nTEST FOUR:");
        outerArray = new double[][] { { 9.7, 17.1 }, { 15.8 }, { 12.7, 18.5, 21.27 } };
        printDoubleLists(outerArray); // print OG array
        printSingleLists(mergeKLists(outerArray)); // prints single sorted array
    }
}