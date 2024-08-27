package Packages.driver_classes;
import Packages.service_classes.BinarySearch;
import Packages.service_classes.LinearSearch;
import Packages.service_classes.Searchable;

import java.util.*;


public class SearchDriver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0, i=0, pos=-1, target=0;
        Searchable find=null;
        ArrayList<Integer> A=new ArrayList<>();
        String choice=null, cont=null;
        do {
            System.out.println("Enter choice :-");
            choice=sc.nextLine();
            switch(choice) {
                case "create array":
                    System.out.println("Enter array size :-");
                    n=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter array elements :-");
                    for(i=0;i<n;i++) {
                        A.add(sc.nextInt());
                        sc.nextLine();
                    }
                    break;
                case "linear search":
                    System.out.println("Enter target :-");
                    target=sc.nextInt();
                    sc.nextLine();
                    find=new LinearSearch(A);
                    pos=find.search(target);
                    System.out.println("Index = "+pos);
                    break;
                case "binary search":
                    System.out.println("Enter target :-");
                    target=sc.nextInt();
                    sc.nextLine();
                    find=new BinarySearch(A);
                    pos=find.search(target);
                    System.out.println("Index = "+pos);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Continue?");
            cont=sc.nextLine();
        } while(cont.equals("yes"));
        System.out.println("\nSystem terminated.");
    }
}
