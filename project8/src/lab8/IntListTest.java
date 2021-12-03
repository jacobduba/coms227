package lab8;

import lab8.IntList;

public class IntListTest {

    public static void main(String[] args) {

        IntList list = new IntList();

        list.add(5);
        list.add(4);
        list.add(3);
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Min: " + list.getMinimum());
        System.out.println("Max: " + list.getMaximum());

        list = new IntListSorted();

        list.add(5);
        list.add(4);
        list.add(3);
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Min: " + list.getMinimum());
        System.out.println("Max: " + list.getMaximum());

        IntListSorted sortedList = new IntListSorted();

        sortedList.add(0);
        sortedList.add(1);
        sortedList.add(10);
        sortedList.add(3);
        System.out.println(sortedList);
        System.out.println("Median: " + sortedList.getMedian());
    }
}