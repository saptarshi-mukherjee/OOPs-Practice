package Packages.service_classes;

public class MergeSort implements Sortable{
    int[] A;

    public MergeSort(int[] A) {
        this.A=A;
    }

    public int[] sort() {
        int n=A.length, left=0, right=n-1;
        mergeSort(A,left,right);
        return A;
    }

    public void mergeSort(int[] A, int left, int right) {
        if(left>=right)
            return;
        int mid=left+(right-left)/2;
        mergeSort(A,left,mid);
        mergeSort(A,mid+1,right);
        merge(A,left,mid,right);
    }

    public void merge(int[] A, int left, int mid, int right) {
        int[] left_sub=new int[mid-left+1];
        int[] right_sub=new int[right-mid];
        int i=0, j=0, n=0, m=0, index=0;
        for(i=left;i<=mid;i++)
            left_sub[index++]=A[i];
        index=0;
        for(i=mid+1;i<=right;i++)
            right_sub[index++]=A[i];
        index=left;
        i=0;
        n=left_sub.length;
        m=right_sub.length;
        while(i<n && j<m) {
            if(left_sub[i]<=right_sub[j]) {
                A[index++]=left_sub[i];
                i++;
            }
            else {
                A[index++]=right_sub[j];
                j++;
            }
        }
        while(i<n) {
            A[index++]=left_sub[i];
            i++;
        }
        while(j<m) {
            A[index++]=right_sub[j];
            j++;
        }
    }
}
