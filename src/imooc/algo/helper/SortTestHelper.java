package imooc.algo.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortTestHelper {
    private SortTestHelper() {

    }

    public static Integer[] generateRandoArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }

        return arr;
    }

    public static void showArr(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    // check if arr is sorted
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // Reflection get the class name
            Class sortClass = Class.forName(sortClassName);

            // Reflection get sorting method
            Method sortMethod = sortClass.getMethod("sortIt", Comparable[].class);

            // params
            Object[] params = new Object[]{arr};

            // invoke method
            long start_ts = System.currentTimeMillis();

            sortMethod.invoke(null, params);

            long end_ts = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " Performance of this sorting: " + (end_ts - start_ts) +  " ms");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
