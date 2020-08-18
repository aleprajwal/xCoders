package library.returnBook;
import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;

// Author: Saujan Thapa
// Mediator: Mukesh Kumar
// Reviewer: Prajwal Kumar Ale

//public class rETURN_bOOK_cONTROL {
public class ReturnBookControl {	// changed class name rETURN_bOOK_cONTROL to ReturnBookControl

	//private ReturnBookUI Ui;
	private ReturnBookUI ui;	// changed variable name Ui to ui
	//private enum cOnTrOl_sTaTe { INITIALISED, READY, INSPECTING }
	private enum ControlState { INITIALISED, READY, INSPECTING };	// changed Enums cOnTrOl_sTaTe to ControlState
	//private cOnTrOl_sTaTe sTaTe;
	private ControlState state;	// changed enum variable name and type
	
	//private Library lIbRaRy;
	private Library library;	// changed variable name lIbRaRy to library
	//private Loan CurrENT_loan;
	private Loan currentLoan;	// changed variable name CurrENT_loan to currentLoan
	

	public rETURN_bOOK_cONTROL() {
		this.lIbRaRy = Library.GeTiNsTaNcE();
		//sTaTe = cOnTrOl_sTaTe.INITIALISED;
		sTaTe = ControlState.INITIALISED;	//changed variable sTaTe to state and cOnTrOl_sTaTe to
	}
	
	
	//public void sEt_uI(ReturnBookUI uI) {
	public void setUI(ReturnBookUI ui) {	// changed function name and parameter variable name
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INITIALISED))
		if (!state.equals(ControlState.INITIALISED))	// changed variable sTaTe to state and enum cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
		
		//this.Ui = uI;
		this.ui = ui;	// change variable Ui to ui and parameter variable uI to ui
		//uI.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);	// changed uI to ui
		//sTaTe = cOnTrOl_sTaTe.READY;
		state = ControlState.READY;	// changed sTaTe to state and cOnTrOl_sTaTe to ControlState
	}


	//public void bOoK_sCaNnEd(int bOoK_iD) {
	public void bookScanned(int bookID) {		// changed function name bOoK_sCaNnEd to bookScanned and parameter variable bOoK_iD to bookID
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY))
		if (!state.equals(ControlState.READY))		// changed sTaTe to state and enum cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
		
		//Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD);
		Book currentBook = library.gEt_BoOk(bookID);	// changed variable cUrReNt_bOoK to currentBook and lIbRaRy to library, bOoK_iD to bookID
		
		/*if (cUrReNt_bOoK == null) {
			Ui.DiSpLaY("Invalid Book Id");
			return;
		}*/
		if (currentBook == null) {	// changed cUrReNt_bOoK to currentBook
			ui.DiSpLaY("Invalid Book Id");	// changed Ui to ui
			return;
		}

		/*if (!cUrReNt_bOoK.iS_On_LoAn()) {
			Ui.DiSpLaY("Book has not been borrowed");
			return;
		}*/
		if (!currentBook.iS_On_LoAn()) {	// changed variable name cUrReNt_bOoK to currentBook but its method is not changed because Book class has not been refactored yet
			ui.DiSpLaY("Book has not been borrowed");	// changed Ui to ui
			return;
		}

		//CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD);
		currentLoan = library.GeT_LoAn_By_BoOkId(bookID);	// changed variable CurrENT_loan to currentLoan, lIbRaRy to library and parameter variable bOoK_iD to bookID
		//double Over_Due_Fine = 0.0;
		double overDueFine = 0.0;		// changed variable name Over_Due_Fine to overDueFine
		/*if (CurrENT_loan.Is_OvEr_DuE())
			Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan);*/
		if (currentLoan.Is_OvEr_DuE())	// changed CurrENT_loan to currentLoan
			overDueFine = library.CaLcUlAtE_OvEr_DuE_FiNe(currentLoan);	// changed Over_Due_Fine to overDueFine and lIbRaRy to library and also argument CurrENT_loan to currentLoan
		
		/*Ui.DiSpLaY("Inspecting");
		Ui.DiSpLaY(cUrReNt_bOoK.toString());
		Ui.DiSpLaY(CurrENT_loan.toString());*/
		ui.DiSpLaY("Inspecting");	// changed variable Ui to ui
		ui.DiSpLaY(currentBook.toString());	// changed Ui to ui and cUrReNt_bOoK to currentBook
		ui.DiSpLaY(currentLoan.toString());	// changed Ui to ui and CurrENT_loan to currentLoan
		
		/*if (CurrENT_loan.Is_OvEr_DuE())
			Ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));*/
		if (currentLoan.Is_OvEr_DuE())	// changed CurrENT_loan to currentLoan
			ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", overDueFine));	// changed variable Ui to ui and Over_Due_Fine to overDueFine
		
		/*Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);
		sTaTe = cOnTrOl_sTaTe.INSPECTING;*/
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);		// changed Ui to ui
		state = ControlState.INSPECTING;	// changed sTaTe to state and enum cOnTrOl_sTaTe to ControlState
	}


	/*public void sCaNnInG_cOmPlEtE() {
		if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
			
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);		
	}*/
	public void scanningComplete() {	// changed function name sCaNnInG_cOmPlEtE to scanningComplete
		if (!state.equals(ControlState.READY))		// cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");

		ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);	// changed Ui to ui
	}


	public void dIsChArGe_lOaN(boolean iS_dAmAgEd) {
		if (!sTaTe.equals(cOnTrOl_sTaTe.INSPECTING)) 
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		
		lIbRaRy.DiScHaRgE_LoAn(CurrENT_loan, iS_dAmAgEd);
		CurrENT_loan = null;
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		sTaTe = cOnTrOl_sTaTe.READY;				
	}


}
