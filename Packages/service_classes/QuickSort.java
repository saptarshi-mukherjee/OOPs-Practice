package Packages.service_classes;

import java.util.Random;

public class QuickSort implements Sortable{
    int[] A;

    public QuickSort(int[] A) {
        this.A=A;
    }

    public int[] sort() {
        int n=A.length, left=0, right=n-1;
        quickSort(A,left,right);
        return A;
    }

    public void quickSort(int[] A, int left, int right) {
        if(left>=right)
            return;
        int pivot=partition(A, left, right);
        quickSort(A,left,pivot-1);
        quickSort(A,pivot+1,right);
    }

    public int partition(int[] A, int left, int right) {
        Random rand=new Random();
        int index=rand.nextInt(left,right+1);
        swap(A,index,right);
        int pivot=A[right], i=left-1, j=0;
        for(j=left;j<=right-1;j++) {
            if(A[j]<pivot) {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,right);
        return (i+1);
    }

    public void swap(int[] A, int index1, int index2) {
        int temp=A[index1];
        A[index1]=A[index2];
        A[index2]=temp;
    }
}
