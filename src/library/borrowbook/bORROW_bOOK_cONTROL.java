package library.borrowbook;
import java.util.ArrayList;
import java.util.List;

import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;

// Author: Prajwal Kumar Ale
// Mediator: Sudhir Thapaliya
// Reviewer: Saujan Thapa

// public class bORROW_bOOK_cONTROL {
public class BorrowBookControl { //changed class name bORROW_bOOK_cONTROL to BorrowBookControl

	
//	private BorrowBookUI uI;
	private BorrowBookUI ui; // changed variable name uI to ui
	
//	private Library lIbRaRy;
	private Library library; // changed variable name lIbRaRy to library
//	private Member mEmBeR;
	private Member member; // changed variable name mEmBeR to member
//	private enum CONTROL_STATE { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	private enum ControlState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED }; // changed variable name CONTROL_STATE to ControlState
//	private CONTROL_STATE sTaTe;
	private CONTROL_STATE state; // changed variable name sTaTe to state
//	private List<Book> pEnDiNg_LiSt;
	private List<Book> pendingList; // changed variable name pEnDiNg_LiSt to pendingList
//	private List<Loan> cOmPlEtEd_LiSt;
	private List<Loan> completedList; // changed variable name cOmPlEtEd_LiSt to completedList
	//	private Book bOoK;
	private Book book; // changed variable name bOoK to book
	
	
	// public bORROW_bOOK_cONTROL() {
	public BorrowBookControl() { // changed bORROW_bOOK_cONTROL() to BorrowBookControl()
//		this.lIbRaRy = Library.GeTiNsTaNcE();
		this.library = Library.GeTiNsTaNcE();
		// sTaTe = CONTROL_STATE.INITIALISED;
		state = ControlState.INITIALISED; // changed variable name sTaTe to state and CONTROL_STATE to ControlState
	}
	

	// public void SeT_Ui(BorrowBookUI Ui) {
		public void setUI(BorrowBookUI ui) { // changed method name SeT_Ui to setUI and parameter Ui to ui
		// if (!sTaTe.equals(CONTROL_STATE.INITIALISED))
		if (!state.equals(CONTROL_STATE.INITIALISED)) { //changed sTaTe to state and added {} to if statement  
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");
	    }	
		// this.uI = Ui;
		this.ui = ui; //changed variabe uI to ui and Ui to ui 
//		Ui.SeT_StAtE(BorrowBookUI.uI_STaTe.READY);
	    ui.setState(BorrowBookUI.UIState.READY); // changed variable Ui to ui; SeT_StAtE to setState and uI_STaTe to UIState[BorrowBookUI.java]
		// sTaTe = CONTROL_STATE.READY;
		state = CONTROL_STATE.READY; // changed sTaTe to state		
	}

		
//	public void SwIpEd(int mEmBeR_Id) {
    public void swiped(int memberID) { // changed method name SwIpEd to swiped and variable name mEmBeR_Id to memberID
		// if (!sTaTe.equals(CONTROL_STATE.READY))
		if (!state.equals(CONTROL_STATE.READY)) { // changed sTaTe to state and added {} to if statement
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");
		}
//		mEmBeR = lIbRaRy.gEt_MeMbEr(mEmBeR_Id);
		member = library.gEt_MeMbEr(memberID); //changed variable mEmBeR to member, lIbRaRy to library and mEmBeR_Id to memberID
//		if (mEmBeR == null) {
		if (member == null) { // changed mEmBeR to member
			// uI.DiSpLaY("Invalid memberId");
			ui.display("Invalid memberId"); // changed uI to ui; DiSpLaY to display[BorrowBookUI.java]
			return;
		}
//		if (lIbRaRy.cAn_MeMbEr_BoRrOw(mEmBeR)) {
		if (library.cAn_MeMbEr_BoRrOw(member)) { // changed lIbRaRy to library and mEmBeR to member
//			pEnDiNg_LiSt = new ArrayList<>();
			pendingList = new ArrayList<>(); // changed array name pEnDiNg_LiSt to pendingList
			// uI.SeT_StAtE(BorrowBookUI.uI_STaTe.SCANNING);
			ui.setState(BorrowBookUI.UIState.SCANNING); // method SeT_StAtE to setState and enum uI_STaTe to UIState [BorrowBookUI.java]
			// sTaTe = CONTROL_STATE.SCANNING;
			state = ControlState.SCANNING; //changed sTaTe to state and CONTROL_STATE to ControlState
		}
		else {
			// uI.DiSpLaY("Member cannot borrow at this time");
			ui.display("Member cannot borrow at this time"); // method DiSpLaY to display[BorrowBookUI.java]
			// uI.SeT_StAtE(BorrowBookUI.uI_STaTe.RESTRICTED);
			ui.setState(BorrowBookUI.UIState.RESTRICTED); // changed method SeT_StAtE to setState and enum variable uI_STaTe to UIState[BorrowBookUI.java]
		}
	}
	
	
	public void ScAnNeD(int bOoKiD) {
		bOoK = null;
		if (!sTaTe.equals(CONTROL_STATE.SCANNING)) 
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
			
		bOoK = lIbRaRy.gEt_BoOk(bOoKiD);
		if (bOoK == null) {
			uI.DiSpLaY("Invalid bookId");
			return;
		}
		if (!bOoK.iS_AvAiLaBlE()) {
			uI.DiSpLaY("Book cannot be borrowed");
			return;
		}
		pEnDiNg_LiSt.add(bOoK);
		for (Book B : pEnDiNg_LiSt) 
			uI.DiSpLaY(B.toString());
		
		if (lIbRaRy.gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(mEmBeR) - pEnDiNg_LiSt.size() == 0) {
			uI.DiSpLaY("Loan limit reached");
			CoMpLeTe();
		}
	}
	
	
	public void CoMpLeTe() {
		if (pEnDiNg_LiSt.size() == 0) 
			CaNcEl();
		
		else {
			uI.DiSpLaY("\nFinal Borrowing List");
			for (Book bOoK : pEnDiNg_LiSt) 
				uI.DiSpLaY(bOoK.toString());
			
			// cOmPlEtEd_LiSt = new ArrayList<Loan>();
			completedList = new ArrayList<Loan>(); //changed variable name to completedList
			uI.SeT_StAtE(BorrowBookUI.uI_STaTe.FINALISING);
			sTaTe = CONTROL_STATE.FINALISING;
		}
	}


	public void CoMmIt_LoAnS() {
		if (!sTaTe.equals(CONTROL_STATE.FINALISING)) 
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
			
		for (Book B : pEnDiNg_LiSt) {
			Loan lOaN = lIbRaRy.iSsUe_LoAn(B, mEmBeR);
			cOmPlEtEd_LiSt.add(lOaN);			
		}
		uI.DiSpLaY("Completed Loan Slip");
		for (Loan LOAN : cOmPlEtEd_LiSt) 
			uI.DiSpLaY(LOAN.toString());
		
		uI.SeT_StAtE(BorrowBookUI.uI_STaTe.COMPLETED);
		sTaTe = CONTROL_STATE.COMPLETED;
	}

	
	public void CaNcEl() {
		uI.SeT_StAtE(BorrowBookUI.uI_STaTe.CANCELLED);
		sTaTe = CONTROL_STATE.CANCELLED;
	}
	
	
}
