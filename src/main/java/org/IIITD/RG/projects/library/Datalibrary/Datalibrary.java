package org.IIITD.RG.projects.library.Datalibrary;
import org.IIITD.RG.projects.library.Student.Student;

import java.util.*;


public class Datalibrary {
    public static HashMap<Integer, String[]> Book_data = new HashMap<>();
    public static ArrayList<Student> student_object= new ArrayList<>();
    public static Student Student_login(){
        Scanner stud= new Scanner(System.in);
        System.out.println("Enter your name: ");
        String studname= stud.nextLine();
        System.out.println("Enter your phone number: ");
        String studno= stud.nextLine();
        for(int i=0; i<student_object.size(); i++){
            if(student_object.get(i).getStudent_name().equals(studname) && student_object.get(i).getStudent_phno().equals(studno)){
                return student_object.get(i);
            }
        }
        System.out.println("Invalid user credentials.");
        return null;
    }

}



