package library.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Library implements Serializable {
	
	//private static final String lIbRaRyFiLe = "library.obj";
	private static final String LIBRARY_FILE = "library.obj";//Name of the constant variable lIbRaRyFiLe changed to LIBRARY_FILE 
	//private static final int lOaNlImIt = 2;
	private static final int LOAN_LIMIT = 2;//Name of the constant variable lOaNlImIt changed to LOAN_LIMIT
	//private static final int loanPeriod = 2;
	private static final int LOAN_PERIOD = 2;//Name of the constant variable loanPeriod changed to LOAN_PERIOD
	//private static final double FiNe_PeR_DaY = 1.0;
	private static final double FINE_PER_DAY = 1.0;//Name of the constant variable FiNe_PeR_DaY changed to FINE_PER_DAY
	//private static final double maxFinesOwed = 1.0;
	private static final double MAX_FINES_OWED = 1.0;//Name of the constant variable maxFinesOwed changed to MAX_FINES_OWED
	//private static final double damageFee = 2.0;
	private static final double DAMAGE_FEE = 2.0;//Name of the constant variable damageFee changed to DAMAGE_FEE
	
	//private static Library SeLf;
	private static Library self;// variable name updated from SeLf to self
	//private int bOoK_Id;
	private int bookId;// variable name updated from bOoK_Id to bookId
	//private int mEmBeR_Id;
	private int memberID;//varibale name updated from mEmBeR_Id to memberID
	//private int lOaN_Id;
	private int loanID;//variable name updated from lOaN_Id to loanID
	//private Date lOaN_DaTe;
	private Date loanDATE;//variable name updated from lOaN_DaTe to loanDATE
	
	//private Map<Integer, Book> CaTaLoG;
	private Map<Integer, Book> catalog; //variable name updated from CaTaLoG to catalog
	//private Map<Integer, Member> MeMbErS;
	private Map<Integer, Member> members;//variable name updated from MeMbErS to members
	//private Map<Integer, Loan> LoAnS;
	private Map<Integer, Loan> loans;//Variable name updated from LoAnS to loans
	//private Map<Integer, Loan> CuRrEnT_LoAnS;
	private Map<Integer, Loan> currentLOANS;//variable name updated from CuRrEnT_LoAnS to currentLOANS
	//private Map<Integer, Book> DaMaGeD_BoOkS;
	private Map<Integer, Book> damagedBOOKS;//variable name updated from DaMaGeD_BoOkS to damagedBOOKS
	

	private Library() { //function name remains same as class name is Library and this is constructor so, if we change this we need to update class name as well
		//CaTaLoG = new HashMap<>();
		catalog = new HashMap<>();//variable name CaTaLoG changed to catalog
		//MeMbErS = new HashMap<>();
		members = new HashMap<>();//Variable name MeMbErs were updated to members
		//LoAnS = new HashMap<>();
		loans = new HashMap<>();//variable name LoAnS updated to loans
		//CuRrEnT_LoAnS = new HashMap<>();
		currentLOANS = new HashMap<>();//variable name CuRrEnT_LoAnS updated to currentLOANS
		//DaMaGeD_BoOkS = new HashMap<>();
		damagedBOOKS = new HashMap<>();//variable name DaMaGeD_BoOkS updated to damagedBOOKS
		//bOoK_Id = 1;
		bookID = 1;//variable name bOoK_Id changed to bookID
		//mEmBeR_Id = 1;	
		memberID = 1;//variable name mEmBeR_Id changed to memberID
		//lOaN_Id = 1;	
		loanID = 1;//variable name lOaN_Id changed to loanID
	}

	
	//public static synchronized Library GeTiNsTaNcE() {		
	public static synchronized Library isGetInstance() {	//Method name changed from GeTiNsTaNcE to isGetInstance
		//if (SeLf == null) {
		if (self == null) {	//SeLf changed to self
			//Path PATH = Paths.get(lIbRaRyFiLe);	
			Path path = Paths.get(LIBRARY_FILE);//variable PATH updated to path ,Also variable used as constant name were updated from lIbRaRyFiLe to LIBRARY_FILE
			//if (Files.exists(PATH)) {	
			if (Files.exists(path)) {//PATH changed to path	
				//try (ObjectInputStream LiBrArY_FiLe = new ObjectInputStream(new FileInputStream(lIbRaRyFiLe));) {
				try (ObjectInputStream libraryFILE = new ObjectInputStream(new FileInputStream(LIBRARY_FILE));) {//new variable, static final variable name were updated
	
			    
					//SeLf = (Library) LiBrArY_FiLe.readObject();
					self = (Library) libraryFILE.readObject();//SeLf and LiBrArY_FiLe changed to self and libraryFILE respectively
					//Calendar.gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe);
					Calendar.isGetInstance().set_Date(self.loanDATE);//gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe) changed to set_Date(self.loanDATE)
					//LiBrArY_FiLe.close();
					libraryFILE.close();// LiBrArY_FiLe changed to libraryFILE
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			//else SeLf = new Library();
			else self = new Library();//SeLf changed to self
		}
		//return SeLf;
		return self;//SeLf changed to self 
	}

	
	//public static synchronized void SaVe() {
	public static synchronized void isSave() {	//Method name updated from SaVe to isSave
		//if (SeLf != null) {
		if (self != null) {// SeLf changed to self	
			//SeLf.lOaN_DaTe = Calendar.gEtInStAnCe().gEt_DaTe();
			self.loanDATE = Calendar.isGetInstance().get_Date();//whole line changed which include variable name,method name.Also method name gEt_DaTe changed to get_Date(here verb is not used in front of method name)
			//try (ObjectOutputStream LiBrArY_fIlE = new ObjectOutputStream(new FileOutputStream(lIbRaRyFiLe));) {
			try (ObjectInputStream libraryFILE = new ObjectInputStream(new FileInputStream(LIBRARY_FILE));) {	////new variable, static final variable name were updated
				//LiBrArY_fIlE.writeObject(SeLf);
				libraryFILE.writeObject(self);//SeLf changed to self,LiBrArY_fIlE changed to libraryFILE
				//LiBrArY_fIlE.flush();
				libraryFILE.flush();//LiBrArY_fIlE changed to libraryFILE,Method name remains same as these are library functions and if we change it .it become meaningless
				//LiBrArY_fIlE.close();	
				LiBrArY_fIlE.close();	//LiBrArY_fIlE changed to libraryFILE
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	//public int gEt_BoOkId() {
	public int get_bookId() {	//Method name gEt_BoOkId changed to get_bookId(function name underscore were not changed because it will change the getter function and it wont work)
		//return bOoK_Id;
		return bookId;//bOoK_Id changed to bookId
	}
	
	
	public int gEt_MeMbEr_Id() {
	//public int get_memberID() { gEt_MeMbEr_Id changed to get_memberID
		//return mEmBeR_Id;
		return memberID;//mEmBeR_Id changed to memberID
	}
	
	
	//private int gEt_NeXt_BoOk_Id() {
	private int get_next_bookID() {//gEt_NeXt_BoOk_Id changed to get_next_bookID
		//return bOoK_Id++;
		return bookID++;//bOoK_Id++ changed to bookID
	}

	
	//private int gEt_NeXt_MeMbEr_Id() {
	private int get_next_memberID() {//gEt_NeXt_MeMbEr_Id changed to get_next_memberID
		//return MeMbEr_Id++;
		return memberID++;//MeMbEr_Id++ changed to memberID
	}

	
	
	//private int gEt_NeXt_LoAn_Id() {LoAn_Id
	private int get_next_loanID() {//gEt_NeXt_LoAn_Id changed to get_next_loanID
		//return LoAn_Id++;
		return loanID++;//LoAn_Id++ changed to loanID
	}

	
	//public List<Member> lIsT_MeMbErS() {	
	public List<Member> isListMembers() { //Methdd name changed from lIsT_MeMbErS to isListMembers	
		//return new ArrayList<Member>(MeMbErS.values()); 
		return new ArrayList<Member>(members.values()); //MeMbErS changed to members
	}


	//public List<Book> lIsT_BoOkS() {
	public List<Book> isListBooks() {	//lIsT_BoOkS changed to isListBooks
		//return new ArrayList<Book>(CaTaLoG.values()); 
		return new ArrayList<Book>(catalog.values()); //CaTaLoG changed to catalog because of variable name should remain same throughout the code
	}


	//public List<Loan> lISt_CuRrEnT_LoAnS() {
	public List<Loan> isListCurrentLoans() {//lISt_CuRrEnT_LoAnS changed to isListCurrentLoans	
		//return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
		return new ArrayList<Loan>(currentLoans.values());//CuRrEnT_LoAnS changed to currentLoans
	}


	//public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {
	public Member isAddMember(String lastName, String firstName, String email, int phoneNo) {	//aDd_MeMbEr changed to isAddMember
		//Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		Member member = new Member(lastName, firstName, email, phoneNo, get_next_memberID());//gEt_NeXt_MeMbEr_Id changed to  get_next_memberID
		//MeMbErS.put(member.GeT_ID(), member);
		members.put(member.get_ID(), member);	//	MeMbErS changed to members
		return member;
	}

	
	//public Book aDd_BoOk(String a, String t, String c) {
	public Book isAddBook(String a, String t, String c) {	//aDd_BoOk changed to isAddBook
		//Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		Book b = new Book(a, t, c, get_next_bookID());//gEt_NeXt_BoOk_Id changed to get_next_bookID 
		//CaTaLoG.put(b.gEtId(), b);
		catalog.put(b.get_ID(), b);//CaTaLoG,gEtId changed to catalog,get_ID respectively
		return b;
	}

	
	//public Member gEt_MeMbEr(int memberId) {
	public Member get_member(int memberId) {//gEt_MeMbEr changed to get_member	
		//if (MeMbErS.containsKey(memberId)) 
		if (members.containsKey(memberId))	{//MeMbErS changed to members
			//return MeMbErS.get(memberId);
			return members.get(memberId);}//indentation and member name if fixed
		return null;
	}

	
	//public Book gEt_BoOk(int bookId) {
	public Book get_book(int bookId) {	//gEt_BoOk changed to get_book
		//if (CaTaLoG.containsKey(bookId)) 
		if (catalog.containsKey(bookId)) {//CaTaLoG changed to catalog	
			//return CaTaLoG.get(bookId);
			return catalog.get(bookId);}//CaTaLoG changed to catalog
		return null;
	}

	
	//public int gEt_LoAn_LiMiT() {
	public int get_loanLimit() {	//gEt_LoAn_LiMiT changed to get_loanLimit
		//return lOaNlImIt;
		return LOAN_LIMIT//lOaNlImIt changed to LOAN_LIMIT
	}

	
	//public boolean cAn_MeMbEr_BoRrOw(Member member) {
	public boolean isCanMemberBorrow(Member member) {	//cAn_MeMbEr_BoRrOw changed to isCanMemberBorrow
		//if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) {
		if (member.get_numberOfCurrentLoans() == LOAN_LIMIT ) {	//gEt_nUmBeR_Of_CuRrEnT_LoAnS,lOaNlImIt changed to get_numberOfCurrentLoans,LOAN_LIMIT respectively
			return false;}
				
		//if (member.FiNeS_OwEd() >= maxFinesOwed) {
		if (member.FinesOwed() >= MAX_FINES_OWED) {	//FiNeS_OwEd,maxFinesOwed changed to FinesOwed,MAX_FINES_OWED respectively.
			return false;}
				
		//for (Loan loan : member.GeT_LoAnS()) {
		for (Loan loan : member.get_loans()) {//	GeT_LoAnS changed to get_loans
			//if (loan.Is_OvEr_DuE()) {
			if (loan.isOverDue()) {	//Is_OvEr_DuE changed to isOverDue
				return false;}
		}
		return true;
	}

	
	//public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) {
	public int get_NumberOfLoansRemainingForMember(Member member) {	//gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr,MeMbEr changed to get_NumberOfLoansRemainingForMember,member respectively
		//return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
		return LOAN_LIMIT - member.get_numberOfCurrentLoans();//lOaNlImIt changed to LOAN_LIMIT.Also MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS() changed to get_numberOfCurrentLoans
	}

	
	//public Loan iSsUe_LoAn(Book book, Member member) {
	public Loan isIssueLoan(Book book, Member member) {//	iSsUe_LoAn changed to isIssueLoan
		//Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Date dueDate = Calendar.isGetInstance().get_dueDate(LOAN_PERIOD);//gEtInStAnCe().gEt_DuE_DaTe(loanPeriod) changed to get_dueDate(LOAN_PERIOD)
		//Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		Loan loan = new Loan(get_nextLoanId(), book, member, dueDate);//gEt_NeXt_LoAn_Id changed to get_nextLoanId
		//member.TaKe_OuT_LoAn(loan);
		member.isTakeOutLoan(loan);//TaKe_OuT_LoAn changes to isTakeOutLoan
		//book.BoRrOw();
	        book.borrow();//BoRrOw changes to borrow
		//LoAnS.put(loan.GeT_Id(), loan);
		Loans.put(loan.get_Id(), loan);//LoAnS changes to Loans
		//CuRrEnT_LoAnS.put(book.gEtId(), loan);
		currentLoans.put(book.get_Id(), loan);//CuRrEnT_LoAnS,gEtId changes to currentLoans,Get_ID respectively.
		return loan;
	}
	
	
	//public Loan GeT_LoAn_By_BoOkId(int bookId) {
	public Loan get_LoanByBookId(int bookId) {	//GeT_LoAn_By_BoOkId changes to get_LoanByBookId
		//if (CuRrEnT_LoAnS.containsKey(bookId)) {
		if (isCurrentLoans.isContainsKey(bookID)) {	//whole line is changed
			//return CuRrEnT_LoAnS.get(bookId);}
		        return isCurrentLoans.get(bookID);}//WHole line changed and indentation were corrected.
		
		return null;
	}

	
	//public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
	public double isCalculateOverDueFine(Loan loan) {// CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn)  changed to  isCalculateOverDueFine(Loan loan)	
		//if (LoAn.Is_OvEr_DuE()) {
		if (LoAn.isOverDue()) {	//Is_OvEr_DuE changes to isOverDue
			//long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			long isDaysOverDue = Calendar.isGetInstance().get_DaysDifference(loan.get_DueDate());//every method name is changed to comply with the guidelines.except in get underscore remains throughout the whole program
			//double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			double fine = daysOverDue * FINE_PER_DAY;//variable name fInE changed to fine .also other variable names were changed including constant variables
			//return fInE;
			return fine;//fInE changes to fine
		}
		return 0.0;		
	}


	public void DiScHaRgE_LoAn(Loan cUrReNt_LoAn, boolean iS_dAmAgEd) {
		Member mEmBeR = cUrReNt_LoAn.GeT_MeMbEr();
		Book bOoK  = cUrReNt_LoAn.GeT_BoOk();
		
		double oVeR_DuE_FiNe = CaLcUlAtE_OvEr_DuE_FiNe(cUrReNt_LoAn);
		mEmBeR.AdD_FiNe(oVeR_DuE_FiNe);	
		
		mEmBeR.dIsChArGeLoAn(cUrReNt_LoAn);
		bOoK.ReTuRn(iS_dAmAgEd);
		if (iS_dAmAgEd) {
			mEmBeR.AdD_FiNe(damageFee);
			DaMaGeD_BoOkS.put(bOoK.gEtId(), bOoK);
		}
		cUrReNt_LoAn.DiScHaRgE();
		CuRrEnT_LoAnS.remove(bOoK.gEtId());
	}


	public void cHeCk_CuRrEnT_LoAnS() {
		for (Loan lOaN : CuRrEnT_LoAnS.values()) 
			lOaN.cHeCk_OvEr_DuE();
				
	}


	public void RePaIr_BoOk(Book cUrReNt_BoOk) {
		if (DaMaGeD_BoOkS.containsKey(cUrReNt_BoOk.gEtId())) {
			cUrReNt_BoOk.RePaIr();
			DaMaGeD_BoOkS.remove(cUrReNt_BoOk.gEtId());
		}
		else 
			throw new RuntimeException("Library: repairBook: book is not damaged");
		
		
	}
	
	
}
