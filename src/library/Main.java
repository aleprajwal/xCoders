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
	private static Scanner in;	//IN changed to in
	//private static Library LIB;
	private static Library lib;	//LIB changed to lib
	//private static String MENU;
	private static String menu;	//MENU changed to menu
	//private static Calendar CAL;
	private static Calendar cal;	//CAL changed to cal
	//private static SimpleDateFormat SDF;
	private static SimpleDateFormat sdf;	//SDF changed to sdf
	
	
	private static String getMenu() {
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
			in = new Scanner(System.in);
			lib = Library.GeTiNsTaNcE();
			cal = Calendar.gEtInStAnCe();
			sdf = new SimpleDateFormat("dd/MM/yyyy");
	
			for (Member m : lib.lIsT_MeMbErS()) {
				output(m);
			}
			output(" ");
			for (Book b : lib.lIsT_BoOkS()) {
				output(b);
			}
						
			menu = getMenu();
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + sdf.format(cal.gEt_DaTe()));
				String c = input(menu);
				
				switch (c.toUpperCase()) {
				
				case "M":
					addMember();
					break;
					
				case "LM": 
					listMembers();
					break;
					
				case "B": 
					addBook();
					break;
					
				case "LB": 
					listBooks();
					break;
					
				case "FB": 
					fixBooks();
					break;
					
				case "L": 
					borrowBook();
					break;
					
				case "R": 
					returnBook();
					break;
					
				case "LL": 
					listCurrentLoans();
					break;
					
				case "P":
					payFines();
					break;
					
				case "T": 
					incrementDate();
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

	
	private static void payFines() {
		new PayFineUI(new pAY_fINE_cONTROL()).RuN();		
	}


	private static void listCurrentLoans() {
		output("");
		for (Loan loan : lib.lISt_CuRrEnT_LoAnS()) {
			output(loan + "\n");
		}		
	}


	private static void listBooks() {
		output("");
		for (Book book : lib.lIsT_BoOkS()) {
			output(book + "\n");
		}		
	}


	private static void listMembers() {
		output("");
		for (Member member : lib.lIsT_MeMbErS()) {
			output(member + "\n");
		}		
	}


	private static void borrowBook() {
		new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();		
	}


	private static void returnBook() {
		new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();		
	}


	private static void fixBooks() {
		new FixBookUI(new fIX_BOOK_cONTROL()).RuN();		
	}


	private static void incrementDate() {
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			cal.incrementDate(days);
			lib.cHeCk_CuRrEnT_LoAnS();
			output(sdf.format(cal.gEt_DaTe()));
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void addBook() {
		
		String author = input("Enter author: ");
		String title  = input("Enter title: ");
		String callNumber = input("Enter call number: ");
		Book book = lib.aDd_BoOk(author, title, callNumber);
		output("\n" + book + "\n");
		
	}

	
	private static void addMember() {
		try {
			String lastName = input("Enter last name: ");
			String firstName  = input("Enter first name: ");
			String emailAddress = input("Enter email address: ");
			int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue();
			Member member = lib.aDd_MeMbEr(lastName, firstName, emailAddress, phoneNumber);
			output("\n" + member + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return in.nextLine();
	}


	private static void output(Object object) {
		System.out.println(object);
	}
}
