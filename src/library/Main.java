package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import library.borrowbook.BorrowBookUI;
import library.borrowbook.bORROW_bOOK_cONTROL;
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUI;
import library.fixbook.fIX_bOOK_cONTROL;
import library.payfine.PayFineUI;
import library.payfine.pAY_fINE_cONTROL;
import library.returnBook.ReturnBookUI;
import library.returnBook.rETURN_bOOK_cONTROL;

// Author: Saujan Thapa
// Mediator: Mukesh Kumar
// Reviewer: Prajwal Kumar Ale

public class Main {
    
    //private static Scanner IN;
    private static Scanner in;    // IN changed to in
    //private static Library LIB;
    private static Library lib;    // LIB changed to lib
    //private static String MENU;
    private static String menu;    // MENU changed to menu
    //private static Calendar CAL;
    private static Calendar cal;    // CAL changed to cal
    //private static SimpleDateFormat SDF;
    private static SimpleDateFormat sdf;    // SDF changed to sdf
    
    //private static String Get_menu() {
    private static String getMenu() {    //    change function name Get_menu() t0 getMenu()
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nLibrary Main Menu\n\n")
          .append("  M  : add member\n")
          .append("  LM : list members\n")
          .append("\n")
          .append("  B  : add book\n")
          .append("  LB : list books\n")
          .append("  FB : fix books\n")
          .append("\n")
          .append("  L  : take out a loan\n")
          .append("  R  : return a loan\n")
          .append("  LL : list loans\n")
          .append("\n")
          .append("  P  : pay fine\n")
          .append("\n")
          .append("  T  : increment date\n")
          .append("  Q  : quit\n")
          .append("\n")
          .append("Choice : ");
          
        return sb.toString();
    }


    public static void main(String[] args) {        
        try {
            //IN = new Scanner(System.in);
            in = new Scanner(System.in);    // changed IN to in according to the main variable declared above
            //LIB = Library.GeTiNsTaNcE();
            lib = Library.GeTiNsTaNcE();    // only changed variable name LIB to lib, method inside Library class is not refactored so no change is made here
            //CAL = Calendar.gEtInStAnCe();
            cal = Calendar.gEtInStAnCe();    // only changed variable name CAL to cal, method inside Calendar class is not refactored so no change is made here
            //SDF = new SimpleDateFormat("dd/MM/yyyy");
            sdf = new SimpleDateFormat("dd/MM/yyyy");    // changed variable name SDF to sdf
    
            //for (Member m : LIB.lIsT_MeMbErS()) {
                //output(m);
            //}
            for (Member m : lib.lIsT_MeMbErS()) {    // only changed variable name LIB to lib, method inside Library class is not refactored so no change is made here
                output(m);
            }
            output(" ");

            //for (Book b : LIB.lIsT_BoOkS()) {
                //output(b);
            //}
            for (Book b : lib.lIsT_BoOkS()) {    // only changed variable name LIB to lib, method inside Library class is not refactored so no change is made here
                output(b);
            }

            //MENU = Get_menu();
            menu = getMenu();    // changed variable MENU to menu according to the main variable declared above and also the function name Get_menu() to getMenu()
            
            boolean e = false;
            
            while (!e) {

                //output("\n" + SDF.format(CAL.gEt_DaTe()));
                output("\n" + sdf.format(cal.gEt_DaTe()));    // changed variable SDF to sdf and CAL to cal. No change made on the method of Calendar class as it is not refactored
                //String c = input(MENU);
                String c = input(menu);    // changed variable MENU to menu
                
                switch (c.toUpperCase()) {
                
                case "M":
                    //ADD_MEMBER();
                    addMember();    // changed function ADD_MEMBER() to addMember()
                    break;
                    
                case "LM":
                    //LIST_MEMBERS();
                    listMembers();    // changed function LIST_MEMBERS() to listMembers()
                    break;
                    
                case "B":
                    //ADD_BOOK();
                    addBook();        // changed function ADD_BOOK() to addBook()
                    break;
                    
                case "LB":
                    //LIST_BOOKS();
                    listBooks();    // changed function LIST_BOOKS() to listBooks()
                    break;
                    
                case "FB":
                    //FIX_BOOKS();
                    fixBooks();        // changed function FIX_BOOKS() to fixBooks()
                    break;
                    
                case "L":
                    //BORROW_BOOK();
                    borrowBook();    // changed function BORROW_BOOK() to borrowBook()
                    break;
                    
                case "R":
                    //RETURN_BOOK();
                    returnBook();    // changed function RETURN_BOOK() to returnBook()
                    break;
                    
                case "LL":
                    //LIST_CURRENT_LOANS();
                    listCurrentLoans();    // changed function LIST_CURRENT_LOANS() to listCurrentLoans()
                    break;
                    
                case "P":
                    //PAY_FINES();
                    payFines();        // changed function PAY_FINES() to payFines()
                    break;
                    
                case "T":
                    //INCREMENT_DATE();
                    incrementDate();    // changed function INCREMENT_DATE() to incrementDate()
                    break;
                    
                case "Q": 
                    e = true;
                    break;
                    
                default: 
                    output("\nInvalid option\n");
                    break;
                }
                
                Library.SaVe();
            }            
        } catch (RuntimeException e) {
            output(e);
        }        
        output("\nEnded\n");
    }    


    //private static void PAY_FINES() {
    private static void payFines() {    // function name changed from PAY_FINES() to payFines()
        new PayFineUI(new pAY_fINE_cONTROL()).RuN();        
    }


    //private static void LIST_CURRENT_LOANS() {
    private static void listCurrentLoans() {    // function name changed from LIST_CURRENT_LOANS() to listCurrentLoans()
        output("");
        //for (Loan loan : LIB.lISt_CuRrEnT_LoAnS()) {
        for (Loan loan : lib.lISt_CuRrEnT_LoAnS()) {    // changed LIB variable to lib, No change made on the method of Library class as it is not refactored
            output(loan + "\n");
        }        
    }


    //private static void LIST_BOOKS() {
    private static void listBooks() {    // function name changed from LIST_BOOKS() to listBooks()
        output("");
        //for (Book book : LIB.lIsT_BoOkS()) {
        for (Book book : lib.lIsT_BoOkS()) {    // changed LIB variable to lib, No change made on the method of Library class as it is not refactored
            output(book + "\n");
        }        
    }


    //private static void LIST_MEMBERS() {
    private static void listMembers() {    // function name changed from LIST_MEMBERS() to listMembers()
        output("");
        //for (Member member : LIB.lIsT_MeMbErS()) {
        for (Member member : lib.lIsT_MeMbErS()) {    // changed LIB variable to lib, No change made on the method of Library class as it is not refactored
            output(member + "\n");
        }        
    }


    //private static void BORROW_BOOK() {
    private static void borrowBook() {    // function name changed from BORROW_BOOK() to borrowBook()
        new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();        
    }


    //private static void RETURN_BOOK() {
    private static void returnBook() {    // function name changed from RETURN_BOOK() to returnBook()
        new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();        
    }


    //private static void FIX_BOOKS() {
    private static void fixBooks() {    // function name changed from FIX_BOOKS() to fixBooks()
        new FixBookUI(new fIX_BOOK_cONTROL()).RuN();        
    }


    //private static void INCREMENT_DATE() {
    private static void incrementDate() {    // function name changed from INCREMENT_DATE() to incrementDate()
        try {
            int days = Integer.valueOf(input("Enter number of days: ")).intValue();
            //CAL.incrementDate(days);
            cal.incrementDate(days);    // changed variable name CAL to cal
            //LIB.cHeCk_CuRrEnT_LoAnS();
            lib.cHeCk_CuRrEnT_LoAnS();    // changed variable name LIB to lib
            //output(SDF.format(CAL.gEt_DaTe()));
            output(sdf.format(cal.gEt_DaTe()));        // changed variable name SDF to sdf and CAL to cal, no change made on the method of Calendar class as it is not refactored
            
        } catch (NumberFormatException e) {
             output("\nInvalid number of days\n");
        }
    }


    //private static void ADD_BOOK() {
    private static void addBook() {        // function name changed from ADD_BOOK() to addBook()

        //String AuThOr = input("Enter author: ");
        String author = input("Enter author: ");    // changed variable AuThOr to author
        //String TiTlE = input("Enter title: ");
        String title  = input("Enter title: ");        // changed variable TiTlE to title
        //String CaLl_NuMbEr = input("Enter call number: ");
        String callNumber = input("Enter call number: ");    // changed variable CaLl_NuMbEr to callNumber
        //Book BoOk = LIB.aDd_BoOk(AuThOr, TiTlE, CaLl_NuMbEr);
        Book book = lib.aDd_BoOk(author, title, callNumber);    // changed BoOk, AuThOr, TiTlE, CaLl_NuMbEr to book, author, title, callNumber respectively, no change made on the method of Library class as it is not refactored
        //output("\n" + BoOk + "\n");
        output("\n" + book + "\n");    // changed BoOk to book
        
    }


    //private static void ADD_MEMBER() {
    private static void addMember() {    // function name changed from ADD_MEMBER() to addMember()
        try {
            //String LaSt_NaMe = input("Enter last name: ");
            String lastName = input("Enter last name: ");    // changed variable LaSt_NaMe to lastName
            //String FiRsT_NaMe = input("Enter first name: ");
            String firstName  = input("Enter first name: ");    // changed variable FiRsT_NaMe to firstName
            //String EmAiL_AdDrEsS = input("Enter email address: ");
            String emailAddress = input("Enter email address: ");    // changed variable EmAiL_AdDrEsS to emailAddress
            //int PhOnE_NuMbEr = Integer.valueOf(input("Enter phone number: ")).intValue();
            int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue();    // changed variable PhOnE_NuMbEr to phoneNumber
            //Member MeMbEr = LIB.aDd_MeMbEr(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr);
            Member member = lib.aDd_MeMbEr(lastName, firstName, emailAddress, phoneNumber);    // changed variable MeMbEr to member,  no change made on the method of Library class as it is not refactored
            //output("\n" + MeMbEr + "\n");
            output("\n" + member + "\n");    // changed variable MeMbEr to member
            
        } catch (NumberFormatException e) {
             output("\nInvalid phone number\n");
        }
    }


    private static String input(String prompt) {
        System.out.print(prompt);
        //return IN.nextLine();
        return in.nextLine();    //changet variable IN to in
    }


    private static void output(Object object) {
        System.out.println(object);
    }


}
