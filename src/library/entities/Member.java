package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	//private String LaSt_NaMe;
	private String lastName;//Variable name changed from LaSt_NaMe to lastName
	//private String FiRsT_NaMe;
	private String firstName;//Variable name changed from FiRsT_NaMe to firstName
	//private String EmAiL_AdDrEsS;
	private String emailAddress;//variable name changed from EmAiL_AdDrEsS to emailAddress
	//private int PhOnE_NuMbEr;
	private int phoneNumber;//Variable name changed from PhOnE_NuMbEr to phoneNumber
	//private int MeMbEr_Id;
	private int memberId;//Variable name changed from MeMbEr_Id to memberId
	//private double FiNeS_OwInG;
	private double finesOwing;//variable name changed from FiNeS_OwInG to finesOwing
	
	//private Map<Integer, Loan> cUrReNt_lOaNs;
	private Map<Integer, Loan> currentLoans;//Variable name changed from cUrReNt_lOaNs to currentLoans

	
	//public Member(String lAsT_nAmE, String fIrSt_nAmE, String eMaIl_aDdReSs, int pHoNe_nUmBeR, int mEmBeR_iD) {
	public Member(String lastName, String firstName, String emailAddress, int phoneNumber, int memberId) {	//variable name corrected above were replaced here 
		//Method name remains same as it is same as class name which is constructor,if we change method name we need to update class name as well
		//we can update class name and method name both but that will create lot of confusions as both rules are contradicting to one other.
		//this.LaSt_NaMe = lAsT_nAmE;
		this.lastName = lastName;// LaSt_NaMe changed to lastName (Variable Name),this is used for the compiler to understand variable on left hand side is different than the right hand side variable
		//this.FiRsT_NaMe = fIrSt_nAmE;
		this.firstName = firstName;//FiRsT_NaMe changed to firstName
		//this.EmAiL_AdDrEsS = eMaIl_aDdReSs;
		this.emailAddress = emailAddress;//eMaIl_aDdReSs changed to emailAddress
		//this.PhOnE_NuMbEr = pHoNe_nUmBeR;
		this.phoneNumber = phoneNumber;//pHoNe_nUmBeR changed to phoneNumber
		//this.MeMbEr_Id = mEmBeR_iD;
		this.memberId = memberId;//mEmBeR_iD changed to memberId
		
		//this.cUrReNt_lOaNs = new HashMap<>();
		this.currentLoans = new HashMap<>();//cUrReNt_lOaNs changed to currentLoans
	}

	
	public String toString() {//method name remains same to avoid conflicts
		StringBuilder sb = new StringBuilder();
		//sb.append("Member:  ").append(MeMbEr_Id).append("\n")
		sb.append("Member:  ").append(memberID).append("\n")	//MeMbEr_Id changed to memberID
		  //.append("  Name:  ").append(LaSt_NaMe).append(", ").append(FiRsT_NaMe).append("\n")
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")	//firstName and Lastname were updated to replace the previous ones
		  //.append("  Email: ").append(EmAiL_AdDrEsS).append("\n")
		  .append("  Email: ").append(emailAddress).append("\n")	//EmAiL_AdDrEsS changed to emailAddress
		  //.append("  Phone: ").append(PhOnE_NuMbEr)
		  .append("  Phone: ").append(phoneNumber)	//PhOnE_NuMbEr changed to phoneNumber
		  .append("\n")
		  //.append(String.format("  Fines Owed :  $%.2f", FiNeS_OwInG))
		  .append(String.format("  Fines Owed :  $%.2f", finesOwing))	//FiNeS_OwInG changed to finesOwing
		  .append("\n");
		
		//for (Loan LoAn : cUrReNt_lOaNs.values()) {
		for (Loan loan : currentLoans.values()) {//	LoAn changed to loans,Also cUrReNt_lOaNs changed to currentLoans
			//sb.append(LoAn).append("\n");
			sb.append(loan).append("\n");//LoAn changed to loan
		}		  
		return sb.toString();
	}

	
	//public int GeT_ID() {
	public int isGetId() {	//Method name GeT_ID changed to isGetId
		//return MeMbEr_Id;
		return memberId;//MeMbEr_Id changed to memberID
	}

	
	//public List<Loan> GeT_LoAnS() {
	public List<Loan> isGetLoans() {//method name changed from GeT_LoAnS to isGetLoans
		//return new ArrayList<Loan>(cUrReNt_lOaNs.values());
		return new ArrayList<Loan>(currentLoans.values());//cUrReNt_lOaNs changed to currentLoans
	}

	
	//public int gEt_nUmBeR_Of_CuRrEnT_LoAnS() {
	public int isGetNumberOfCurrentLoans() {	//Method name changegd from gEt_nUmBeR_Of_CuRrEnT_LoAnS to isGetNumberOfCurrentLoans
		//return cUrReNt_lOaNs.size();
		return currentLoans.size();//cUrReNt_lOaNs changed to currentLoans
	}

	
	public double FiNeS_OwEd() {
		return FiNeS_OwInG;
	}

	
	public void TaKe_OuT_LoAn(Loan lOaN) {
		if (!cUrReNt_lOaNs.containsKey(lOaN.GeT_Id())) 
			cUrReNt_lOaNs.put(lOaN.GeT_Id(), lOaN);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String GeT_LaSt_NaMe() {
		return LaSt_NaMe;
	}

	
	public String GeT_FiRsT_NaMe() {
		return FiRsT_NaMe;
	}


	public void AdD_FiNe(double fine) {
		FiNeS_OwInG += fine;
	}
	
	public double PaY_FiNe(double AmOuNt) {
		if (AmOuNt < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (AmOuNt > FiNeS_OwInG) {
			change = AmOuNt - FiNeS_OwInG;
			FiNeS_OwInG = 0;
		}
		else 
			FiNeS_OwInG -= AmOuNt;
		
		return change;
	}


	public void dIsChArGeLoAn(Loan LoAn) {
		if (cUrReNt_lOaNs.containsKey(LoAn.GeT_Id())) 
			cUrReNt_lOaNs.remove(LoAn.GeT_Id());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
