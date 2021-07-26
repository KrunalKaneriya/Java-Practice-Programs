import java.util.ArrayList;

public class Main {
    private static ArrayList<Student>studentList = new ArrayList<>();
    public static void main(String []args) {
        Student student = new Student("Krunal");
        Student student2 = new Student("Khyati");
        Student student3 = new Student("Vishal");
        Student student4 = new Student("Dhanraj");
        Student student5 = new Student("Mitesh");
        Student student6 = new Student("Vidhi");
        Student student7 = new Student("Pruthvi");
        Student student8 = new Student("Yaksh");
        Student student9 = new Student("Meet");
        Student student10 = new Student("Vicky");

        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);

        for(Student studentlist : studentList) {
            System.out.println("The Student Name is: " +studentlist.getStudentName());
            
        }
        
    }
}