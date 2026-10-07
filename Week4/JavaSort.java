import java.io.*;
import java.util.*;

class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa){
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCgpa(){
        return cgpa;
    }
}
public class JavaSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i<n; i++){
            int a = sc.nextInt();
            String b = sc.next();
            double c = sc.nextDouble();
            Student st = new Student(a,b,c);
            studentList.add(st);
        }
        Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0){
                    return Double.compare(s2.getCgpa() , s1.getCgpa());
                }
                if (! s1.getName().equals(s2.getName())){
                    return s1.getName().compareTo(s2.getName());
                }
                return Integer.compare(s1.getId(), s2.getId());
            }
        } );
        for (Student st : studentList) {
            System.out.println(st.getName());
        }
    }
}
