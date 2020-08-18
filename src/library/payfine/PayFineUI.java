package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	//public static enum uI_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	public static enum UIState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	//private pAY_fINE_cONTROL CoNtRoL;
	private pAY_fINE_cONTROL control;
	private Scanner input;
	//private uI_sTaTe StAtE;
	private UIState state;

	
	public PayFineUI(pAY_fINE_cONTROL control) {
		//this.CoNtRoL = control;
		this.control = control;

		input = new Scanner(System.in);
		//StAtE = uI_sTaTe.INITIALISED;
		state = UIState.INITIALISED;
		control.SeT_uI(this);
	}
	
	
	//public void SeT_StAtE(uI_sTaTe state) {
	public void SeT_StAtE(UIState state) {
		//this.StAtE = state;
		this.state = state;
	}


	public void RuN() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (StAtE) {
			
			case READY:
				//String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				String memStr = input("Swipe member card (press <enter> to cancel): ");
				//if (Mem_Str.length() == 0) {
				if (memStr.length() == 0) {
					//CoNtRoL.CaNcEl();
					control.CaNcEl();
					break;
				}
				try {
					//int Member_ID = Integer.valueOf(Mem_Str).intValue();
					int memberId = Integer.valueOf(memStr).intValue();
					//CoNtRoL.CaRd_sWiPeD(Member_ID);
					control.CaRd_sWiPeD(memberId);
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				//double AmouNT = 0;
				double amount = 0;
				String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				if (Amt_Str.length() == 0) {
					//CoNtRoL.CaNcEl();
					control.CaNcEl();
					break;
				}
				try {
					//AmouNT = Double.valueOf(Amt_Str).doubleValue();
					amount = Double.valueOf(Amt_Str).doubleValue();
				}
				catch (NumberFormatException e) {}
				//if (AmouNT <= 0) {
				if (amount <= 0) {
					output("Amount must be positive");
					break;
				}
				//CoNtRoL.PaY_FiNe(AmouNT);
				CoNtRoL.PaY_FiNe(amount);
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
			

	public void DiSplAY(Object object) {
		output(object);
	}


}
