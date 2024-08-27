package Packages.driver_classes;
import Packages.service_classes.*;
import java.util.*;


public class SortDriver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n, i;
        System.out.println("Enter array size :-");
        n=sc.nextInt();
        int[] A=new int[n];
        int[] sorted=null;
        Sortable sort_obj=null;
        System.out.println("Enter array elements :-");
        for(i=0;i<n;i++)
            A[i]=sc.nextInt();
        Random rand=new Random();
        int num=rand.nextInt();
        if(num>100) {
            System.out.println("Using merge sort");
            sort_obj=new MergeSort(A);
            sorted=sort_obj.sort();
            System.out.println(Arrays.toString(sorted));
        }
        else {
            System.out.println("Using Quick Sort");
            sort_obj=new QuickSort(A);
            sorted=sort_obj.sort();
            System.out.println(Arrays.toString(sorted));
        }
    }
}
