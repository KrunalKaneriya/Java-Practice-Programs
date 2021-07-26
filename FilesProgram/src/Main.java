import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Integer>filePointers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

//        Student student = new Student("Krunal");
//        Student student2 = new Student("Khyati");
//        Student student3 = new Student("Vishal");
//        Student student4 = new Student("Dhanraj");
//        Student student5 = new Student("Mitesh");
//        Student student6 = new Student("Vidhi");
//        Student student7 = new Student("Pruthvi");
//        Student student8 = new Student("Yaksh");
//        Student student9 = new Student("Meet");
//        Student student10 = new Student("Vicky");
//
//        studentList.add(student);
//        studentList.add(student2);
//        studentList.add(student3);
//        studentList.add(student4);
//        studentList.add(student5);
//        studentList.add(student6);
//        studentList.add(student7);
//        studentList.add(student8);
//        studentList.add(student9);
//        studentList.add(student10);
//
//        try (FileWriter fileWriter = new FileWriter("Students.txt")) {
//            for (Student studentlist : studentList) {
//                fileWriter.write(studentlist.getRollNo() + "," + studentlist.getStudentName() + "," + studentlist.getIdNumber() + "\n");
//                System.out.println("Name: " + studentlist.getStudentName());
//            }
//        }

//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Students.txt"))) {
//            for(Student studentlist : studentList) {
//                bufferedWriter.write(studentlist.getRollNo() + "," + studentlist.getStudentName() + "," + studentlist.getIdNumber()+"\n");
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Students.dat")))) {
            for(Student students:studentList) {
                dataOutputStream.writeInt(students.getRollNo());
                dataOutputStream.writeUTF(students.getStudentName());
                dataOutputStream.writeInt(students.getIdNumber());
                System.out.println("Written " + students + " in File");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Students.dat")))) {
//            for(Student students:studentList) {
//                objectOutputStream.writeObject(students);
////                System.out.println("Written " + students + " in File");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("Students_rand.txt","rwd")) {

            System.out.println("The Pointer is At " + randomAccessFile.getFilePointer());
            System.out.println("************************************************");
            for(Student students:studentList) {
                filePointers.add((int)randomAccessFile.getFilePointer());
                randomAccessFile.writeInt(students.getRollNo());
                randomAccessFile.writeUTF(students.getStudentName());
                randomAccessFile.writeInt(students.getIdNumber());
                System.out.println("The Current Object Size is " + calculateSize(students));
                System.out.println("The Files Are Written Now The File Pointer is at " + randomAccessFile.getFilePointer());

                System.out.println(filePointers.toString());
            }

            for(Integer value:filePointers) {
                System.out.println("The Address Of Element is " + value);
            }
        }

        //Function to add fileoffset in filePosition array in file
        try (DataOutputStream fileoffsetStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("FileOffset.dat")))) {
            System.out.println("The size of FilePointers is " + filePointers.size());
            for(Integer fileoffset : filePointers) {
                fileoffsetStream.writeInt(fileoffset);
            }
        }


        printStudents(studentList);


    }

    static {

//        try (Scanner scanner = new Scanner(new FileReader("Students.txt"))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                String studentInfo = scanner.nextLine();
//                String[] studentInfoArray = studentInfo.split(",");
//                int rollNo = Integer.parseInt(studentInfoArray[0]);
//                String name = studentInfoArray[1];
//                int id = Integer.parseInt(studentInfoArray[2]);
//                Student tempStudent = new Student(rollNo, name, id);
//                studentList.add(tempStudent);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try(RandomAccessFile randomAccessFile = new RandomAccessFile("Students_rand.txt","rwd")) {
//            System.out.println("The Size of FilePointers is " + filePointers.size());
//            for(int i=0;i< filePointers.size();i++) {
//                randomAccessFile.seek(filePointers.get(i));
//                int roll = randomAccessFile.readInt();
//                String name = randomAccessFile.readUTF();
//                int id = randomAccessFile.readInt();
//                Student newStudent = new Student(roll,name,id);
//                studentList.add(newStudent);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Students.txt"))) {
            String input;
            while((input = bufferedReader.readLine())!=null) {
                String[] studentInfoArray = input.split(",");
                int rollNo = Integer.parseInt(studentInfoArray[0]);
                String name = studentInfoArray[1];
                int id = Integer.parseInt(studentInfoArray[2]);
                Student tempStudent = new Student(rollNo, name, id);
                studentList.add(tempStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (RandomAccessFile rao = new RandomAccessFile("Students_rand.txt","rwd")) {
//            rao.seek(14);
//            System.out.println(rao.readInt());
//            rao.seek(16);
//            System.out.println(rao.readInt());
//        }catch (IOException e) {
//            e.printStackTrace();
//        }


//        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("Students.dat")))) {
//            boolean eof = false;
//            while(!eof) {
//                try {
//                    int rollNo = dataInputStream.readInt();
//                    String name = dataInputStream.readUTF();
//                    int id = dataInputStream.readInt();
//                    studentList.add(new Student(rollNo,name,id));
//                }catch (EOFException e) {
//                    eof = true;
////                    e.printStackTrace();
//                }
//            }
//        } catch (IOException io) {
//            io.printStackTrace();
//        }

        //Function to calculate the bytes or length of each line and add the size to the arrayList
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("lines.txt"))) {
//            String line;
//            ArrayList<Integer>byteOffSet = new ArrayList<>();
//            Integer l = 0; //Pointer of the current line
//            while ((line = bufferedReader.readLine())!=null) { //Reading lines
//                System.out.println(line);
//                Integer num_bytes = line.getBytes().length + 2; //Adding size 2 in the current line size because of \n character
//                System.out.println(num_bytes); //printing the current size of line
//                byteOffSet.add(l == 0 ? num_bytes : byteOffSet.get(l-1) + num_bytes); //If the line is at 0 then add first line size else get the previous arraylist value and add the current value
//                System.out.println("The Byte is " + byteOffSet.toString() + " And the Length is " + byteOffSet.size() + " and the previous value was " + byteOffSet.get(l));
//                l++; //Incrementing the line pointer by 1
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Students.dat")))) {
//           boolean eof = false;
//           try {
//               while(!eof) {
//                   Student tempStudent = (Student)objectInputStream.readObject();
//                    calculateSize(tempStudent);
////                   System.out.println("Imported Student "  + tempStudent + " From File.");
//                   studentList.add(tempStudent);
//               }
//           } catch(EOFException e) {
//               eof = true;
//           }
//        }
//        catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }


    }

    public static void printStudents(ArrayList<Student>studentList) {
        for(Student student:studentList) {
            System.out.println(student);
        }
    }

    public static int calculateSize(Student object) {
        System.out.println("The Size of the Name is " + object.getStudentName().length());
        System.out.println("The Size of the Roll No is " + Integer.BYTES);
        System.out.println("The Size of The ID is " + Integer.BYTES);
        int TotalSizeOfObject = object.getStudentName().length() + (Integer.BYTES*2);
        return TotalSizeOfObject;
//        System.out.println("The Total Size of Object is " + TotalSizeOfObject);
    }
}