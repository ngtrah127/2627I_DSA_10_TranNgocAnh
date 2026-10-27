import java.io.*;
import java.util.*;
class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name , double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCGPA(){
        return cgpa;
    }
}
public class Solution {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(Comparator.comparing(Student :: getCGPA).reversed()
                .thenComparing(Student :: getName)
                .thenComparing(Student :: getID));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i<n; i++){
            String s = sc.next();
            if (s.equals("ENTER")){
                String name = sc.next();
                double cgpa = sc.nextDouble();
                int id = sc.nextInt();
                Student st = new Student(id, name, cgpa);
                pq.add(st);
            }
            else if (s.equals("SERVED")) {
                if (!pq.isEmpty()){
                    pq.poll();
                }
            }
        }
        if(!pq.isEmpty()){
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().getName());
            }
        }else{
            System.out.println("EMPTY");
        }
    }
}
