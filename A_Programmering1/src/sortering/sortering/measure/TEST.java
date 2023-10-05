package sortering.sortering.measure;

import java.util.ArrayList;

public class TEST {

    public static void main(String[] args) {
        int testSize = 25000;

        ArrayList<String> list = new ArrayList<>();
        list = ListGenerator.generateString(10000, 100);
        String[] array = list.toArray(new String[0]);


        Measurer.start();
        SortMethods.bubbleSort(array);
        Measurer.stop();
        System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(array);
        Measurer.stop();
        System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(array);
        Measurer.stop();
        System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));


    }

}
