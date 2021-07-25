import java.io.Serializable;

public class Student {
    private int rollNo;
    private String studentName;
    private int idNumber;
    private static int rollNoCounter = 0;
    private static int idCounter = 0;
//    private long serialVersionUID = 1;

    public Student(int rollNo,String name,int id) {
        this.idNumber = id;
        this.rollNo = rollNo;
        this.studentName = name;
    }
    public Student(String name) {
        this.studentName = name;
        this.rollNo = ++rollNoCounter;
        this.idNumber = ++idCounter;
        System.out.println("Created New Student with Name : " + this.studentName + " Roll No: " + this.rollNo + " And Id is : " + this.idNumber);
    }

    public Student createStudent(int rollNo,String name,int id) {
        Student newStudent = new Student(rollNo,name,id);
        return newStudent;
    }


    /**
     * @return int return the rollNo
     */
    public int getRollNo() {
        return rollNo;
    }

    /**
     * @param rollNo the rollNo to set
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * @return String return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return int return the idNumber
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return  "rollNo = " + rollNo +
                ", studentName = '" + studentName + '\'' +
                ", idNumber = " + idNumber;
    }
}
