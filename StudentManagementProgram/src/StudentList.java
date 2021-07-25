import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StudentList{
    private static int startingrollnoCounter = 0;
    private static int sortedrollnoCounter = 0;
    private ArrayList<Student>studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();

    }
    public ArrayList<Student> getStudentArrayList() {
        return new ArrayList<>(studentArrayList);
    }

    public void addStudent(String name) {
        if(findStudent(name)!=null) {
            System.out.println("Student Already Added Named " + name);
        }
        else {
            Student newStudent = new Student(name);
            studentArrayList.add(newStudent);
            System.out.println("Student Added " + name + " and Assigned Roll no: "+newStudent.getRollno());
        }

    }


    private Student findStudent(Student student) {
        for(Student tempStudent : studentArrayList) {
            if(tempStudent.equals(student)) {
                return student;
            }
        }
        return null;
    }

    public Student findStudent(String name) {
        for(Student tempStudent:studentArrayList) {
            if(tempStudent.getName().contains(name)) {
                return tempStudent;
            }
        }
        return null;
    }

    public Student findStudent(int rollnumber) {
        for(Student tempStudent : studentArrayList) {
            if(tempStudent.rollno == rollnumber){
                return tempStudent;
            }
        }
        return null;
    }

    public int findrollNumber(int number) {
        for(Student tempStudent:studentArrayList) {
            if(tempStudent.getRollno() == number) {
                System.out.println("Student Founded " + tempStudent.getName() + " Roll No : " + tempStudent.getRollno());
                return tempStudent.getRollno();
            }
        }
        System.out.println("Student of Roll No Not Found...");
        return 0;
    }

    public boolean addFees(String name,double amount) {
        Student tempStudent = findStudent(name);
        if(tempStudent==null) {
            System.out.println("Student Not Found Named " + name);
        } else if(amount>0){
            tempStudent.paidFees += amount;
            System.out.println("Student " + name + " has paid " + amount);
            return true;
        }
        return false;
    }

    public void printstudents() {
        for(Student student:studentArrayList) {
            System.out.println(student);
        }
    }

    public void sortStudents() {
        Collections.sort(studentArrayList,studentNameComparator);
        int rollnoCounter = 0;
        for(Student student : studentArrayList) {
            sortedrollnoCounter+=1;
            student.setRollno(sortedrollnoCounter);
        }

    }

    public void changeName(String name,int rollNo) {
        Student requestedStudent = findStudent(rollNo);
        if(requestedStudent!=null && (!requestedStudent.name.equals(name))) {
            requestedStudent.name = name;
            System.out.println("Changed The Name to " + name);
        }
        else {
            System.out.println("Error Changing Student.. Check The Roll Number..");
        }

    }

    Comparator<Student>studentNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.getName().compareToIgnoreCase(obj2.getName());
        }
    };

    public class Student implements Comparable<Student>{

        private String name;
        private int rollno;
        private double paidFees;

        public Student(String name) {
            this.name = name;
            this.rollno = startingrollnoCounter+=1;
            this.paidFees = 0.0;
        }

        public Student(String name,double fees) {
            this.name = name;
            this.paidFees = fees;
            this.rollno = startingrollnoCounter+1;
        }
        @Override
        public int compareTo(Student o) {
            return this.getName().compareToIgnoreCase(o.getName());
        }

        public String getName() {
            return name;
        }

        public int getRollno() {
            return rollno;
        }


        public double getPaidFees() {
            return paidFees;
        }

        @Override
        public String toString() {
            return "Name : " + this.getName() + " || Roll No : " + this.getRollno() + " || Paid Fees : " + this.getPaidFees();
        }

        public void setRollno(int rollno) {
            this.rollno = rollno;
        }

        
    }
}
