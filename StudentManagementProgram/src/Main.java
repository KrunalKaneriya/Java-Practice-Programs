import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StudentList students = new StudentList();
        System.out.println("************************************************");
        students.addStudent("Krunal Kaneria");
        students.addStudent("Khyati Kaneria");
        students.addStudent("Dhanraj Parmar");
        students.addStudent("Vishal Prajapati");
        students.addStudent("Chirag Parmar");
        students.addStudent("Jay Raval");
        students.addStudent("Mona Kaneria");
        students.addStudent("Ahmad Salim");
        students.addStudent("Vidhi Panchal");
        students.addStudent("Pruthvi Dumaswala");
        students.addStudent("Aakifa Pocha");
        students.addStudent("Gaurav Kumar");
        students.addStudent("Khalid Iqbal Mondal");
        students.addStudent("Mitesh Raval");
        students.addStudent("Khushi Shah");
        students.addStudent("Shreya Soni");
        students.addStudent("Shreya Patel");
        students.addStudent("Mohit Mistry");
        students.addStudent("Sagar Myakam");
        students.addStudent("Neev Modi");
        students.addStudent("Anmol Yadav");
//        students.addStudent("Krunal Kaneria");
        System.out.println("************************************************");
//        System.out.println(students.findStudent("Parmar"));
//        students.addFees("Krunal",15000);
        students.sortStudents();
        students.printstudents();
        students.addFees("Krunal Kaneria",15000);
        students.addFees("Vidhi Panchal",15000);
        students.changeName("Jacob",5);
    }
}