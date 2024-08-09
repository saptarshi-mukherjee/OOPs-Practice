import java.util.*;

class Student {
    private String name;
    private int attendance;
    private float psp;

    public Student(String n, int a, float p) {
        name=n;
        attendance=a;
        psp=p;
    }

    public String getName() {
        return name;
    }

    public int getAttendance() {
        return attendance;
    }

    public float getPSP() {
        return psp;
    }

    public boolean isGood() {
        if(attendance>=90 && psp >=85)
            return true;
        else
            return false;
    }
}



/**
 * CreatingObjects
 */
public class CreatingObjects {

    public static void main(String[] args) {
        String name;
        int attendance;
        float psp;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name :-");
        name=sc.nextLine();
        System.out.println("Enter attendance and PSP respectively :-");
        attendance=sc.nextInt();
        sc.nextLine();
        psp=sc.nextFloat();
        sc.nextLine();
        Student student=new Student(name,attendance,psp);
        System.out.println("Your name : "+student.getName());
        System.out.println("Your attendance : "+student.getAttendance());
        System.out.println("Your PSP : "+student.getPSP());
        if(student.isGood())
            System.out.println("Good Work! Keep it up");
        else
            System.out.println("Put in a bit more effort to achieve your goals");
    }
}