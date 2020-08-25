package library.returnBook;
import java.util.Scanner;


public class ReturnBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, INSPECTING, COMPLETED };
	public static enum UIState { INITIALISED, READY, INSPECTING, COMPLETED };	// Changed enum name uI_sTaTe to UIState
	//private rETURN_bOOK_cONTROL CoNtRoL;
	private ReturnBookControl control;	// changed rETURN_bOOK_cONTROL to ReturnBookControl and CoNtRol to control
	//private Scanner iNpUt;
	private Scanner input;	// changed iNpUt variable to input
	//private uI_sTaTe StATe;
	private UIState state;	// changed uI_sTaTe to UIState and StATe to state

	
	//public ReturnBookUI(rETURN_bOOK_cONTROL cOnTrOL) {
	public ReturnBookUI(ReturnBookControl control) {	// changed argument rETURN_bOOK_cONTROL to ReturnBookControl and cOnTrOL to control
		//this.CoNtRoL = cOnTrOL;
		this.control = control;	// changed this.CoNtRol to this.control and cOnTrOL to control
		//iNpUt = new Scanner(System.in);
		iNpUt = new Scanner(System.in);	// changed iNpUt to input
		//StATe = uI_sTaTe.INITIALISED;
		StATe = uI_sTaTe.INITIALISED;	// changed StATe to state and uI_sTaTe to UIState
		//cOnTrOL.sEt_uI(this);
		cOnTrOL.sEt_uI(this);	// changed cOnTrOL to control and sEt_UI to setUI
	}


	//public void RuN() {
	public void run() {	// changed function name from RuN to run
		//oUtPuT("Return Book Use Case UI\n");
		output("Return Book Use Case UI\n");	// changed oUtPuT to output
		
		while (true) {
			
			//switch (StATe) {
			switch (state) {	// changed StATe to state
			
				case INITIALISED:
					break;

				case READY:
					//String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
					String bookInputString = input("Scan Book (<enter> completes): ");	// changed BoOk_InPuT_StRiNg to bookInputString and iNpUt to input
					//if (BoOk_InPuT_StRiNg.length() == 0)
					if (bookInputString.length() == 0)	// changed BoOk_InPuT_StRiNg to bookInputString
						//CoNtRoL.sCaNnInG_cOmPlEtE();
						control.scanningComplete();	// changed CoNtRoL to control and sCaNnInG_cOmPlEtE() to scanningComplete()

					else {
						try {
							//int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
							int bookID = Integer.valueOf(bookInputString).intValue();	// changed Book_Id to bookID and BoOk_InPuT_StRiNg to bookInputString
							//CoNtRoL.bOoK_sCaNnEd(Book_Id);
							control.bookScanned(bookID);	// change CoNtRoL to control, bOoK_sCaNnEd to bookScanned and Book_Id to bookID
						}
						catch (NumberFormatException e) {
							//oUtPuT("Invalid bookId");
							output("Invalid bookId");	// changed oUtPuT to output
						}
					}
					break;

				case INSPECTING:
					//String AnS = iNpUt("Is book damaged? (Y/N): ");
					String ans = input("Is book damaged? (Y/N): ");	// changed AnS to ans and iNpUt to input
					//boolean Is_DAmAgEd = false;
					boolean isDamaged = false;	// changed Is_DAmAgEd to isDamaged
					//if (AnS.toUpperCase().equals("Y"))
					if (ans.toUpperCase().equals("Y"))	// changed Ans to ans
						//Is_DAmAgEd = true;
						isDamaged = true;	// changed Is_DAmAgEd to isDamaged

					CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);

				case COMPLETED:
					oUtPuT("Return processing complete");
					return;

				default:
					oUtPuT("Unhandled state");
					throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);
			}
		}
	}

	
	//private String iNpUt(String PrOmPt) {
	private String input(String prompt) {	// changed iNpUt to input and PrOmPt to prompt
		//System.out.print(PrOmPt);
		System.out.print(prompt);	// changed PrOmPt to prompt
		//return iNpUt.nextLine();
		return input.nextLine();	// changed iNpUt to input
	}	
		
		
	//private void oUtPuT(Object ObJeCt) {
	private void output(Object object) {	// changed function name from oUtPuT to output and argument namge from ObJeCt to object
		//System.out.println(ObJeCt);
		System.out.println(object);	// changed ObJeCt to object
	}
	
			
	public void DiSpLaY(Object object) {
		oUtPuT(object);
	}
	
	public void sEt_sTaTe(uI_sTaTe state) {
		this.StATe = state;
	}

	
}
