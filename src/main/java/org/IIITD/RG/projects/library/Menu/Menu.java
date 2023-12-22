package org.IIITD.RG.projects.library.Menu;
import org.IIITD.RG.projects.library.Datalibrary.Datalibrary;
import org.IIITD.RG.projects.library.Librarian.Librarian;
import org.IIITD.RG.projects.library.Student.Student;

import java.util.*;

public class Menu {
    public static void LibAppHelp() {
        Librarian l1= new Librarian();
        Student s1= new Student("name", 0, "123", 0);
        while(true){
            System.out.println("+---------------------------+");
            System.out.println("1. Enter as a Librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            int check=0;
            Scanner en= new Scanner(System.in);
            System.out.println("Who do you want to enter as?");
            Integer inp= en.nextInt();
            switch(inp){
                case 1:
                    Scanner p= new Scanner(System.in);
                    System.out.println("Enter password: ");
                    String pass= p.nextLine();
                    if(pass.equals("User_librarian")){ //password for librarian is: User_librarian
                        System.out.println("Logged in successfully!\n");
                    }
                    else{
                        System.out.println("Enter correct password! ");
                        check=1;
                    }
                    break;
                case 2:
                    System.out.println("Entering as student\n");
                    s1= Datalibrary.Student_login();
                    break;
                case 3:
                    System.out.println("Thanks for visiting!");
                    break;
            }
            if(inp==3){
                break;
            }
            if((inp == 1 && check == 0 )){
                while(true){
                    System.out.println("1. Register a member");
                    System.out.println("2. Remove a member");
                    System.out.println("3. Add a book");
                    System.out.println("4. Remove a book");
                    System.out.println("5. View all members along with their books and fines to be paid");
                    System.out.println("6. View all books");
                    System.out.println("7. Back");
                    Scanner i= new Scanner(System.in);
                    System.out.println("Enter choice:");
                    int input= i.nextInt();
                    switch(input){
                        case 1:
                            l1.regMember();
                            break;
                        case 2:
                            l1.delMember();
                            break;
                        case 3:
                            l1.addBook();
                            break;
                        case 4:
                            l1.delBook();
                            break;
                        case 5:
                            l1.viewRegMembers();
                            break;
                        case 6:
                            l1.viewBooks();
                            break;
                        case 7:
                            break;
                    }
                    if(input==7){
                        break;
                    }
                }
            }
            else if(inp==2 && s1!=null){
                while(true){
                    System.out.println("1. List Available books");
                    System.out.println("2. Issue book");
                    System.out.println("3. View My Books");
                    System.out.println("4. Return book");
                    System.out.println("5. Back");
                    Scanner i= new Scanner(System.in);
                    System.out.println("Enter choice:");
                    int input= i.nextInt();
                    switch(input){
                        case 1:
                            s1.viewAvailableBooks();
                            break;
                        case 2:
                            s1.issueBook();
                            break;
                        case 3:
                            s1.viewMyBooks();
                            break;
                        case 4:
                            s1.returnBook();
                            break;
                        case 5:
                            break;
                    }
                    if(input==5){
                        break;
                    }
                }

            }
        }

    }
}
