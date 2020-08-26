package library.payfine;
import library.entities.Library;
import library.entities.Member;

//public class pAY_fINE_cONTROL {
public class PayFineControl {
	
	//private PayFineUI Ui;
	private PayFineUI ui;
	//private enum cOnTrOl_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	private enum ControlState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };//changed enum name
	//private cOnTrOl_sTaTe StAtE;
	private ControlState state;
	
	//private Library LiBrArY;
	private Library library;
	//private Member MeMbEr;
	private Member member;


	//public pAY_fINE_cONTROL() {
	public PayFineControl() {
		//this.LiBrArY = Library.GeTiNsTaNcE();
		this.library = Library.GeTiNsTaNcE();
		//StAtE = cOnTrOl_sTaTe.INITIALISED;
		state = ControlState.INITIALISED;
	}
	
	
	//public void SeT_uI(PayFineUI uI) {
	public void setUI(PayFineUI ui) {
		//if (!StAtE.equals(cOnTrOl_sTaTe.INITIALISED)) {
		if (!state.equals(ControlState.INITIALISED)) {
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		//this.Ui = uI;
		this.ui = ui;
		//ui.SeT_StAtE(PayFineUI.uI_sTaTe.READY);
		ui.setState(PayFineUI.UIState.READY);
		//StAtE = cOnTrOl_sTaTe.READY;
		state = ControlState.READY;		
	}


	//public void CaRd_sWiPeD(int MeMbEr_Id) {
	public void cardSwiped(int memberId) {
		//if (!StAtE.equals(cOnTrOl_sTaTe.READY)) 
		if (!state.equals(ControlState.READY)) 
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
			
		//MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id);
		member = Library.getMember(memberId);
		
		//if (MeMbEr == null) {
		if (member == null) {
			//Ui.DiSplAY("Invalid Member Id");
			ui.display("Invalid Member Id");
			return;
		}
		//Ui.DiSplAY(MeMbEr.toString());
		ui.display(member.toString());
		//Ui.SeT_StAtE(PayFineUI.uI_sTaTe.PAYING);
		ui.setState(PayFineUI.UIState.PAYING);
		//StAtE = cOnTrOl_sTaTe.PAYING;
		state = ControlState.PAYING;
	}
	
	
	//public void CaNcEl() {
	public void cancel() {
		//Ui.SeT_StAtE(PayFineUI.uI_sTaTe.CANCELLED);
		ui.setState(PayFineUI.UIState.CANCELLED);
		//StAtE = cOnTrOl_sTaTe.CANCELLED;
		state = ControlState.CANCELLED;
	}


	//public double PaY_FiNe(double AmOuNt) {
	public double payFine(double amount) {
		//if (!StAtE.equals(cOnTrOl_sTaTe.PAYING)) 
		if (!state.equals(ControlState.PAYING)) 
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
			
		//double ChAnGe = MeMbEr.PaY_FiNe(AmOuNt);
		double change = member.payFine(amount);
		//if (ChAnGe > 0) 
		if (change > 0) 
			//Ui.DiSplAY(String.format("Change: $%.2f", ChAnGe));
			ui.disply(String.format("Change: $%.2f", change));
		
		//Ui.DiSplAY(MeMbEr.toString());
		ui.display(member.toString());
		//Ui.SeT_StAtE(PayFineUI.uI_sTaTe.COMPLETED);
		ui.setState(PayFineUI.UIState.COMPLETED);
		//StAtE = cOnTrOl_sTaTe.COMPLETED;
		state = ControlState.COMPLETED;
		//return ChAnGe;
		return change;
	}
	


}
