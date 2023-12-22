package org.IIITD.RG.projects.library.Librarian;
import org.IIITD.RG.projects.library.Student.Student;

import java.util.*;

import static org.IIITD.RG.projects.library.Datalibrary.Datalibrary.Book_data;
import static org.IIITD.RG.projects.library.Datalibrary.Datalibrary.student_object;

public class Librarian {
    static int book_ID=1;
    static int auto_student_ID=99;
    //Function to add a new book
    public void addBook(){
        Scanner booktitle= new Scanner(System.in);
        System.out.println("Enter title of book: ");
        String book_Title=booktitle.nextLine();

        Scanner bookauthor= new Scanner(System.in);
        System.out.println("Enter author of book: ");
        String book_Author=booktitle.nextLine();

        Scanner cope= new Scanner(System.in);
        System.out.println("Enter number of copies to be added: ");
        int book_Copies=cope.nextInt();


        for(int i=0; i<book_Copies; i++){
            Book_data.put(book_ID, new String[]{book_Title, book_Author, "1"});
            book_ID++;
        }


        //Book_data.put(book_ID, new String[]{book_Title, book_Author, "1"});
        System.out.println("Book added successfully!");
    }

    //Function to delete an existing book
    public void delBook(){
        Scanner bookId= new Scanner(System.in);
        System.out.println("Enter ID of book to be deleted: ");
        Integer book_ID=bookId.nextInt();
        String[] remove = Book_data.get(book_ID);
        String rem = remove[2];
        if(Book_data.containsKey(book_ID)){
            if(rem.equals("1")){
                Book_data.remove(book_ID);
                System.out.println("Book deleted successfully!");
            }
            else if(rem.equals("0")){
                System.out.println("Book already issued. Try Later");
            }

        }
        else{
            System.out.println("No such book exists! Enter correct book ID.");
        }
    }

    //Function to register a new member
    public void regMember(){
        auto_student_ID++;
        Scanner memname= new Scanner(System.in);
        System.out.println("Enter name of student: ");
        String member_Name=memname.nextLine();

        Scanner memage= new Scanner(System.in);
        System.out.println("Enter age of student: ");
        Integer member_Age=memage.nextInt();

        Scanner phno= new Scanner(System.in);
        System.out.println("Enter phone number of student: ");
        String member_phno=phno.nextLine();
        for(int i = 0;i<student_object.size();i++){
            if(member_phno.equals(student_object.get(i).getStudent_phno())){
                System.out.println("Member with this phone number already exists! Registration unsuccessful!.");
                return;
            }}
        Student s1= new Student(member_Name, member_Age, member_phno,auto_student_ID);
        student_object.add(s1);
        System.out.println("Student registered successfully with member ID "+auto_student_ID);
    }

    //Function to remove an existing member
    public void delMember(){
        int flag_r=0;
        int flag_s=0;
        Scanner phno= new Scanner(System.in);
        System.out.println("Enter phone number of student: ");
        String member_phno=phno.nextLine();

        for(int i=0; i<student_object.size(); i++){
            if(member_phno.equals(student_object.get(i).getStudent_phno()) && student_object.get(i).getBooks_with_member()==0){
                student_object.remove(i);
                System.out.println("Student removed successfully!");
                flag_r=1;
                break;
            } else if (member_phno.equals(student_object.get(i).getStudent_phno()) && student_object.get(i).getBooks_with_member()!=0) {
                flag_s=1;
                System.out.println("Fine due with student, hence student cannot be removed. ");
                break;
            }

        }
        if(flag_r==0 && flag_s==0){
            System.out.println("Student not found.");
        }

    }
    //Function to view all books in the library
    public void viewBooks() {
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| Book ID |   Book Title             |   Book Author         |");
        System.out.println("+------------------------------------------------------------+");

        for (Map.Entry<Integer, String[]> entry : Book_data.entrySet()) {
            Integer bookID = entry.getKey();
            String[] values = entry.getValue();
            String bookTitle = values[0];
            String bookAuthor = values[1];

            String formattedOutput = String.format("| %-8d| %-25s| %-20s|", bookID, bookTitle, bookAuthor);
            System.out.println(formattedOutput);
        }

        System.out.println("+------------------------------------------------------------+");
    }
    //Function to view all registered members in the library
    public void viewRegMembers() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.printf("| %-20s | %-12s | %-12s | %-18s |\n", "Name", "Book 1", "Book 2", "Total Fine");
        System.out.println("+----------------------------------------------------------------------+");

        for (int i = 0; i < student_object.size(); i++) {
            String name = student_object.get(i).getStudent_name();
            int bookID1 = student_object.get(i).getBookID1();
            int bookID2 = student_object.get(i).getBookID2();
            int totalFine = student_object.get(i).calcFine_librarian();

            System.out.printf("| %-20s | %-12d | %-12d | %-18d |\n", name, bookID1, bookID2, totalFine);
        }

        System.out.println("+----------------------------------------------------------------------+");
    }}


