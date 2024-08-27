package Packages.service_classes;
import java.util.*;

public class BinarySearch implements Searchable{
    ArrayList<Integer> A;

    public BinarySearch(ArrayList<Integer> A) {
        this.A=A;
        Collections.sort(this.A);
    }

    public int search(int target) {
        int n=A.size(), left=0, right=n-1, mid=0, pos=-1;
        while(left<=right) {
            mid=left+(right-left)/2;
            if(A.get(mid)==target) {
                pos=mid;
                right=mid-1;
            }
            else if(A.get(mid)>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return pos;
    }
}
