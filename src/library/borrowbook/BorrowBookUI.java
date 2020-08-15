package library.borrowbook;
import java.util.Scanner;

// Author: Prajwal Kumar Ale
// Mediator: Sudhir Thapaliya
// Reviewer: Saujan Thapa

public class BorrowBookUI {
	
// 	public static enum uI_STaTe { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	public static enum UIState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED }; //changed uI_STaTe to UIState

// 	private bORROW_bOOK_cONTROL CoNtRoL;
	private bORROW_bOOK_cONTROL control; // changed variable CoNtRoL to control
	
// 	private Scanner InPuT;
	private Scanner input; //changed InPuT to input
	
// 	private uI_STaTe StaTe;
	private UIState state; //changed uI_STaTe StaTe to UIState state

	
	public BorrowBookUI(bORROW_bOOK_cONTROL control) {
		// this.CoNtRoL = control;
	    this.control = control;
		// InPuT = new Scanner(System.in);
		input = new Scanner(System.in);
		// StaTe = uI_STaTe.INITIALISED;
		state = UIState.INITIALISED;
		control.SeT_Ui(this);
	}

	
	private String iNpUT(String PrOmPt) {
		System.out.print(PrOmPt);
		// return InPuT.nextLine();
		return input.nextLine();
	}	
		
		
	private void OuTpUt(Object ObJeCt) {
		System.out.println(ObJeCt);
	}
	
			
	public void SeT_StAtE(uI_STaTe StAtE) {
		// this.StaTe = StAtE;
		this.state = StAtE;
	}

	
	public void RuN() {
		OuTpUt("Borrow Book Use Case UI\n");
		
		while (true) {
			
			// switch (StaTe) {
			switch (state) {			
			
			case CANCELLED:
				OuTpUt("Borrowing Cancelled");
				return;

				
			case READY:
				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				if (MEM_STR.length() == 0) {
					// CoNtRoL.CaNcEl();
					control.CaNcEl();
					break;
				}
				try {
					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					// CoNtRoL.SwIpEd(MeMbEr_Id);
					control.SwIpEd(MeMbEr_Id);
				}
				catch (NumberFormatException e) {
					OuTpUt("Invalid Member Id");
				}
				break;

				
			case RESTRICTED:
				iNpUT("Press <any key> to cancel");
				// CoNtRoL.CaNcEl();
				control.CaNcEl();
				break;
			
				
			case SCANNING:
				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				if (BoOk_StRiNg_InPuT.length() == 0) {
					// CoNtRoL.CoMpLeTe();
					control.CoMpLeTe();
					break;
				}
				try {
					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					// CoNtRoL.ScAnNeD(BiD);
					control.ScAnNeD(BiD);
					
				} catch (NumberFormatException e) {
					OuTpUt("Invalid Book Id");
				} 
				break;
					
				
			case FINALISING:
				String AnS = iNpUT("Commit loans? (Y/N): ");
				if (AnS.toUpperCase().equals("N")) {
					// CoNtRoL.CaNcEl();
					control.CaNcEl();
					
				} else {
					// CoNtRoL.CoMmIt_LoAnS();
					control.CoMmIt_LoAnS();
					iNpUT("Press <any key> to complete ");
				}
				break;
				
				
			case COMPLETED:
				OuTpUt("Borrowing Completed");
				return;
	
				
			default:
				OuTpUt("Unhandled state");
				// throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);
				throw new RuntimeException("BorrowBookUI : unhandled state :" + state;			
			}
		}		
	}


	public void DiSpLaY(Object object) {
		OuTpUt(object);		
	}


}
