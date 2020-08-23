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
					Calendar.isGetInstance().setDate(self.loanDATE);//gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe) changed to setDate(self.loanDATE)
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
			self.loanDATE = Calendar.isGetInstance().getDate();//whole line changed which include variable name,method name.Also method name gEt_DaTe changed to getDate(here verb is not used in front of method name)
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

	
	public int gEt_BoOkId() {
		return bOoK_Id;
	}
	
	
	public int gEt_MeMbEr_Id() {
		return mEmBeR_Id;
	}
	
	
	private int gEt_NeXt_BoOk_Id() {
		return bOoK_Id++;
	}

	
	private int gEt_NeXt_MeMbEr_Id() {
		return mEmBeR_Id++;
	}

	
	private int gEt_NeXt_LoAn_Id() {
		return lOaN_Id++;
	}

	
	public List<Member> lIsT_MeMbErS() {		
		return new ArrayList<Member>(MeMbErS.values()); 
	}


	public List<Book> lIsT_BoOkS() {		
		return new ArrayList<Book>(CaTaLoG.values()); 
	}


	public List<Loan> lISt_CuRrEnT_LoAnS() {
		return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
	}


	public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {		
		Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		MeMbErS.put(member.GeT_ID(), member);		
		return member;
	}

	
	public Book aDd_BoOk(String a, String t, String c) {		
		Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		CaTaLoG.put(b.gEtId(), b);		
		return b;
	}

	
	public Member gEt_MeMbEr(int memberId) {
		if (MeMbErS.containsKey(memberId)) 
			return MeMbErS.get(memberId);
		return null;
	}

	
	public Book gEt_BoOk(int bookId) {
		if (CaTaLoG.containsKey(bookId)) 
			return CaTaLoG.get(bookId);		
		return null;
	}

	
	public int gEt_LoAn_LiMiT() {
		return lOaNlImIt;
	}

	
	public boolean cAn_MeMbEr_BoRrOw(Member member) {		
		if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) 
			return false;
				
		if (member.FiNeS_OwEd() >= maxFinesOwed) 
			return false;
				
		for (Loan loan : member.GeT_LoAnS()) 
			if (loan.Is_OvEr_DuE()) 
				return false;
			
		return true;
	}

	
	public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) {		
		return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
	}

	
	public Loan iSsUe_LoAn(Book book, Member member) {
		Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		member.TaKe_OuT_LoAn(loan);
		book.BoRrOw();
		LoAnS.put(loan.GeT_Id(), loan);
		CuRrEnT_LoAnS.put(book.gEtId(), loan);
		return loan;
	}
	
	
	public Loan GeT_LoAn_By_BoOkId(int bookId) {
		if (CuRrEnT_LoAnS.containsKey(bookId)) 
			return CuRrEnT_LoAnS.get(bookId);
		
		return null;
	}

	
	public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
		if (LoAn.Is_OvEr_DuE()) {
			long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			return fInE;
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
