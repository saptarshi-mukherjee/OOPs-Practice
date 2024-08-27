package Packages.service_classes;

import java.util.*;

public class LinearSearch implements Searchable{
    ArrayList<Integer> A;

    public LinearSearch(ArrayList<Integer> A) {
        this.A=A;
    }

    @Override
    public int search(int target) {
        int position=-1, i, n=A.size();
        for(i=0;i<n;i++) {
            if(A.get(i)==target) {
                position=i;
                break;
            }
        }
        return position;
    }
}
