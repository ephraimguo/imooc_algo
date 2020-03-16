package imooc.algo.selectionsort;

import imooc.algo.helper.SortTestHelper;

public class SelectionSortComparable {

    public static void sortIt(Comparable[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if ( arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            Comparable<Student> tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

    }

    public static void main(String[] args) {
        /*// Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        sortIt(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        sortIt(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // Object
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        sortIt(d);
        for( int i = 0 ; i < d.length ; i ++ )
            System.out.println(d[i]);*/

        Integer[] ax = SortTestHelper.generateRandoArray(10000, 0, 1000);
        // SortTestHelper.showArr(ax);
        SortTestHelper.testSort("imooc.algo.selectionsort.SelectionSortComparable", ax);
        SortTestHelper.showArr(ax);

    }
}
