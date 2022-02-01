package com.rodrigopereira.arraylistvslinkedlist;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArrayListVsLinkedList {

    public static final int NUMBER_OF_ELEMENTS = 10000;
    public static final int INDEX_TO_GET = 5000;
    public static final int INDEX_TO_REMOVE = 5000;

    public static void main(String[] args) {

        var arrayList = new ArrayList<Integer>();
        var linkedList = new LinkedList<Integer>();

        measureAddingManyElementsOneByOne(arrayList);
        measureAddingManyElementsOneByOne(linkedList);

        measureGettingOneElementInTheMiddle(arrayList);
        measureGettingOneElementInTheMiddle(linkedList);

        measureRemovingOneElementInTheMiddle(arrayList);
        measureRemovingOneElementInTheMiddle(linkedList);

        measureRemovingFirstElement(arrayList);
        measureRemovingFirstElement(linkedList);

    }

    private static void measureAddingManyElementsOneByOne(List<Integer> list) {
        final long startTime = System.nanoTime();
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.add(i);
        }
        final long endTime = System.nanoTime();
        long total = endTime - startTime;
        printResults("adding elements", list.getClass().getName(), total);
    }

    private static void measureGettingOneElementInTheMiddle(List<Integer> list) {
        final long startTime = System.nanoTime();
        list.get(INDEX_TO_GET);
        final long endTime = System.nanoTime();

        long total = endTime - startTime;
        printResults("getting one element", list.getClass().getName(), total);
    }

    private static void measureRemovingOneElementInTheMiddle(List<Integer> list) {
        final long startTime = System.nanoTime();
        list.remove(INDEX_TO_REMOVE);
        final long endTime = System.nanoTime();

        long total = endTime - startTime;
        printResults("removing one element", list.getClass().getName(), total);
    }

    private static void measureRemovingFirstElement(List<Integer> list) {
        final long startTime = System.nanoTime();
        list.remove(0);
        final long endTime = System.nanoTime();

        long total = endTime - startTime;
        printResults("removing first element", list.getClass().getName(), total);
    }

    private static void printResults(String action, String listClass, long total) {
        long totalSeconds = TimeUnit.MILLISECONDS.convert(Duration.ofNanos(total));
        System.out.printf("Time to %s in %s: (nanoseconds) %s (milliseconds) %s%n", action, listClass, total, totalSeconds);

    }
}
