package org.IIITD.RG.projects.library.Student;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import java.time.LocalTime;
import java.util.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import static org.IIITD.RG.projects.library.Datalibrary.Datalibrary.Book_data;
import static org.IIITD.RG.projects.library.Datalibrary.Datalibrary.student_object;

    public class Student {
        //    librarian- hashmap -1
//    student - hashmap +1 , flag =1 , timer->start
        private String Student_name;

        public String getStudent_name() {
            return Student_name;
        }
        public void setStudent_name(String Student_name) {
            this.Student_name=Student_name;
        }


        private int Student_age;

        public int getStudent_age() {
            return Student_age;
        }

        public void setStudent_age(int student_age) {
            this.Student_age = student_age;
        }

        private String Student_phno;

        public String getStudent_phno() {
            return Student_phno;
        }

        public void setStudent_phno(String student_phno) {
            this.Student_phno = student_phno;
        }

        public int studentID;
        private int fine1;

        public int getFine1() {
            return fine1;
        }

        public void setFine1(int fine1) {
            this.fine1 = fine1;
        }

        private int fine2;

        public int getFine2() {
            return fine2;
        }

        public void setFine2(int fine2) {
            this.fine2 = fine2;
        }

        private int bookID1;

        public int getBookID1() {
            return bookID1;
        }

        public void setBookID1(int bookID1) {
            this.bookID1 = bookID1;
        }

        private int bookID2;
        public int getBookID2() {
            return bookID2;
        }

        public void setBookID2(int bookID2) {
            this.bookID2 = bookID2;
        }
        private int time_issue1;

        public int getTime_issue1() {
            return time_issue1;
        }

        public void setTime_issue1(int time_issue1) {
            this.time_issue1 = time_issue1;
        }

        private int time_issue2;

        public int getTime_issue2() {
            return time_issue2;
        }

        public void setTime_issue2(int time_issue2) {
            this.time_issue2 = time_issue2;
        }

        private int books_with_member;
        public int getBooks_with_member(){
            return books_with_member;
        }
        public void setBooks_with_member(int books_with_member) {
            this.books_with_member = books_with_member;
        }
        //creating object for student
        public Student(String Student_name, int Student_age, String Student_phno, int studentID){
            this.setStudent_name(Student_name);
            this.setStudent_age(Student_age);
            this.setStudent_phno(Student_phno); //unique identifier for every student--> mention in README
            this.studentID=studentID;
            this.setFine1(0);
            this.setFine2(0);
            this.setBookID1(0);
            this.setBookID2(0);
            this.setBooks_with_member(0);
        }
        public void viewAvailableBooks(){
            System.out.println("+------------------------------------------------------------+");
            System.out.println("| Book ID |   Book Title             |   Book Author         |");
            System.out.println("+------------------------------------------------------------+");
            for (Map.Entry<Integer, String[]> entry : Book_data.entrySet()) {
                Integer bookID = entry.getKey();
                String[] values = entry.getValue();
                String bookTitle = values[0];
                String bookAuthor = values[1];
                String bookCopies = values[2];
                String formattedOutput_AVbooks;
                if (bookCopies.equals("1")) {
                    formattedOutput_AVbooks = String.format("| %-8d| %-25s| %-20s|", bookID, bookTitle, bookAuthor);
                } else {
                    continue;
                }
                System.out.println(formattedOutput_AVbooks);
                System.out.println("+------------------------------------------------------------+");
            }
        }
        public void viewMyBooks(){
            if(bookID1!=0){
                System.out.println("BOOK ID1: "+ bookID1);
            }
            if(bookID2!=0){
                System.out.println("BOOK ID2: "+ bookID2);
            }
        }

        public int getCurrentTime(){
            ZoneId istZone = ZoneId.of("Asia/Kolkata");

            // Get the current time in IST
            LocalTime currentTimeIST = LocalTime.now(istZone);

            // Create a DateTimeFormatter for formatting the time with commas
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH, mm, ss");

            // Format the current time in IST
            String formattedTimeIST = currentTimeIST.format(formatter);

            // Parse the formatted time and convert to integers
            String[] timeComponents = formattedTimeIST.split(", ");
            int hours = Integer.parseInt(timeComponents[0]);
            int minutes = Integer.parseInt(timeComponents[1]);
            int seconds = Integer.parseInt(timeComponents[2]);

            int concatenatedTime = hours * 10000 + minutes * 100 + seconds;
            return concatenatedTime;
        }

        public int calculateTimeDifferenceInSeconds(int startTime, int endTime) {
            // Convert the integer start time to a LocalTime
            int startHours = startTime / 10000;
            int startMinutes = (startTime % 10000) / 100;
            int startSeconds = startTime % 100;
            LocalTime startLocalTime = LocalTime.of(startHours, startMinutes, startSeconds);

            int endHours = endTime / 10000;
            int endMinutes = (endTime % 10000) / 100;
            int endSeconds = endTime % 100;
            LocalTime endLocalTime = LocalTime.of(endHours, endMinutes, endSeconds);

            // Calculate the duration between the two times
            Duration duration = Duration.between(startLocalTime, endLocalTime);

            // Get the time difference in seconds as an integer
            int seconds = (int) duration.getSeconds();

            return seconds;
        }
        public int calcFine_librarian(){
            int time_ret=getCurrentTime();
            if(books_with_member==1){
                int startTime = time_issue1; // First time
                int endTime = time_ret; // Second time
                int timediff= calculateTimeDifferenceInSeconds(startTime, endTime);
                int fine;
                // Calculate the time difference in seconds
                if(timediff>10){
                    fine= (timediff-10)*3;
                }
                else{
                    fine=0;
                }
                return fine;
            }

            else if(books_with_member==2){
                int lfine1=0;
                int startTime = time_issue1; // First time
                int endTime = time_ret; // Second time
                int timediff= calculateTimeDifferenceInSeconds(startTime, endTime);
                // Calculate the time difference in seconds
                if(timediff>10){
                    lfine1= (timediff-10)*3;
                }
                else{
                    lfine1=0;
                }

                int lfine2=0;
                int startTime2 = time_issue2; // First time
                int endTime2 = time_ret; // Second time
                int timediff2= calculateTimeDifferenceInSeconds(startTime2, endTime2);
                // Calculate the time difference in seconds
                if(timediff2>10){
                    lfine2= (timediff2-10)*3;
                }
                else{
                    lfine2=0;
                }
                return lfine1+lfine2;
            }
            return 0;
        }

        public int calcFine_student(int bookid){
            int time_ret= getCurrentTime();
            int fine=0;
            if(bookid==bookID1){
                int startTime = time_issue1; // First time
                int endTime = time_ret; // Second time
                int timediff= calculateTimeDifferenceInSeconds(startTime, endTime);
                // Calculate the time difference in seconds
                if(timediff>10){
                    fine= (timediff-10)*3;
                }
                else{
                    fine=0;
                }
            }
            else if(bookid==bookID2){
                int startTime = time_issue2; // First time
                int endTime = time_ret; // Second time
                int timediff= calculateTimeDifferenceInSeconds(startTime, endTime);
                // Calculate the time difference in seconds
                if(timediff>10){
                    fine= (timediff-10)*3;
                }
                else{
                    fine=0;
                }
            }
            else{
                System.out.println("Invalid book ID! ");
                return 0;
            }
            return fine;
        }

        public void issueBook(){
            System.out.println("List of available books: \n");
            viewAvailableBooks();
            Scanner in=new Scanner(System.in);
            System.out.println("Enter ID of book to be issued: ");
            Integer book_id= in.nextInt();
            //Assuming the user always inputs correct book ID-> as list is being displayed already
            if(bookID1==0){
                //first issue of student
                bookID1=book_id;
                System.out.println(bookID1);
                time_issue1= getCurrentTime();
                String[] retrievedArray = Book_data.get(book_id);
                retrievedArray[2] = "0";
                Book_data.put(book_id, retrievedArray);
                books_with_member++;
            }
            else if(bookID2 == 0){
                fine1=calcFine_student(bookID1);
                if(fine1==0){
                    bookID2=book_id;
                    time_issue2= getCurrentTime();
                    String[] retrievedArray = Book_data.get(book_id);
                    retrievedArray[2] = "0";
                    Book_data.put(book_id, retrievedArray);
                    books_with_member++;
                }}
            else {
                System.out.println("Book cannot be issued as fine for first book is yet to be paid.");
            }
        }

        public void returnBook(){
            Scanner b1= new Scanner(System.in);
            System.out.println("Enter ID of the book to be returned: ");
            Integer bookid= b1.nextInt();
            if(books_with_member==0){
                System.out.println("No books to return.");
            }
            else{
                if(bookid==bookID1){
                    int fine= calcFine_student(bookid);
                    System.out.println("Fine due for book is: Rs. "+ fine+"for a delay of "+(fine/3)+" days");

                    if(fine==0){
                        System.out.println("No fine to be paid. ");
                        bookID1=0;
                        String[] retrievedArray = Book_data.get(bookid);
                        retrievedArray[2] = "1";
                        Book_data.put(bookid, retrievedArray);
                        books_with_member--;
                        System.out.println("Book returned successfully! ");

                    }
                    else{
                        while(true){
                            Scanner sc= new Scanner(System.in);
                            System.out.println("Enter amount you are paying: ");
                            int finepaid= sc.nextInt();
                            if(finepaid==fine){
                                bookID1=0;
                                String[] retrievedArray = Book_data.get(bookid);
                                retrievedArray[2] = "1";
                                Book_data.put(bookid, retrievedArray);
                                books_with_member--;
                                System.out.println("Fine paid successfully and book returned successfully! ");
                                break;
                            }
                            else{
                                System.out.println("Pay correct amount.");
                            }

                        }
                    }

                }
                else if(bookid==bookID2){
                    int fine= calcFine_student(bookid);
                    System.out.println("Fine due for book is: "+fine);
                    if(fine==0){
                        System.out.println("No fine to be paid. ");
                        bookID1=0;
                        String[] retrievedArray = Book_data.get(bookid);
                        retrievedArray[2] = "1";
                        Book_data.put(bookid, retrievedArray);
                        books_with_member--;
                        System.out.println("Book returned successfully! ");

                    }
                    else{
                        while(true) {
                            Scanner sc = new Scanner(System.in);
                            System.out.println("Enter amount you are paying: ");
                            int finepaid = sc.nextInt();
                            if (finepaid == fine) {
                                bookID2 = 0;
                                String[] retrievedArray = Book_data.get(bookid);
                                retrievedArray[2] = "1";
                                Book_data.put(bookid, retrievedArray);
                                books_with_member--;
                                System.out.println("Fine paid successfully and book returned successfully! ");
                                break;
                            } else {
                                System.out.println("Pay correct amount.");
                            }}
                    }
                }
                else{
                    System.out.println("Invalid book ID");
                }

            }
        }

    }




