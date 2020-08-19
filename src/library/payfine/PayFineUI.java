package library.payfine;
import java.util.Scanner;
//Author: Sudhir Thapaliya
//Mediator: Prajwal Kumar ale
//Reviewer: Mukesh Kumar


public class PayFineUI {


	//public static enum uI_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	public static enum UIState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };// Change enum naming convention

	//private pAY_fINE_cONTROL CoNtRoL;
	private pAY_fINE_cONTROL control; // changed variable naming conventions
	private Scanner input;
	//private uI_sTaTe StAtE;
	private UIState state;// Changed variable naming convention and Enum reference.

	
	public PayFineUI(pAY_fINE_cONTROL control) {
		//this.CoNtRoL = control;
		this.control = control;// changed varible naming 

		input = new Scanner(System.in);
		//StAtE = uI_sTaTe.INITIALISED;
		state = UIState.INITIALISED;// changed variable naming
		control.SeT_uI(this);
	}
	
	
	//public void SeT_StAtE(uI_sTaTe state) {
	public void setState(UIState state) {//change methods name and parameters name
		//this.StAtE = state;
		this.state = state;
	}


	//public void RuN() {
	public void run() {// changed methods name
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			//switch (StAtE) {
			switch (state) {// changed private variable reference name
			case READY:
				//String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				String memStr = input("Swipe member card (press <enter> to cancel): ");// changed local variable name
				//if (Mem_Str.length() == 0) {
				if (memStr.length() == 0) {
					//CoNtRoL.CaNcEl();
					control.CaNcEl();
					break;
				}
				try {
					//int Member_ID = Integer.valueOf(Mem_Str).intValue();
					int memberId = Integer.valueOf(memStr).intValue();// changed local variable name
					//CoNtRoL.CaRd_sWiPeD(Member_ID);
					control.CaRd_sWiPeD(memberId);
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				//double AmouNT = 0;
				double amount = 0;// changed local variable name
				//String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				String amtStr = input("Enter amount (<Enter> cancels) : ");// changed local variable name
				//if (Amt_Str.length() == 0) {
				if (amtStr.length() == 0) {
					//CoNtRoL.CaNcEl();
					control.CaNcEl();
					break;
				}
				try {
					//AmouNT = Double.valueOf(Amt_Str).doubleValue();
					amount = Double.valueOf(amtStr).doubleValue();
				}
				catch (NumberFormatException e) {}
				//if (AmouNT <= 0) {
				if (amount <= 0) {
					output("Amount must be positive");
					break;
				}
				//CoNtRoL.PaY_FiNe(AmouNT);
				control.PaY_FiNe(amount);
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	//public void DiSplAY(Object object) {
	public void display(Object object) {
		output(object);
	}


}
