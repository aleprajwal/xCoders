package library.fixbook;
import library.entities.Book;
import library.entities.Library;

public class fIX_bOOK_cONTROL {
	
	private FixBookUI ui;
	private enum ControlState { INITIALISED, READY, FIXING };
	private CoNtRoL_StAtE state;
	
	private Library library;
	private Book currentBook;


	public fIX_bOOK_cONTROL() {
		this.library = Library.GeTiNsTaNcE();
		state = ControlState.INITIALISED;
	}
	
	
	public void SeT_Ui(FixBookUI ui) {
		if (!state.equals(ControlState.INITIALISED)) 
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		this.ui = ui;
		ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		state = ControlState.READY;		
	}


	public void BoOk_ScAnNeD(int bookId) {
		if (!state.equals(ControlState.READY)) 
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		currentBook = library.gEt_BoOk(booki);
		
		if (currentBook == null) {
			ui.dIsPlAy("Invalid bookId");
			return;
		}
		if (!currentBook.iS_DaMaGeD()) {
			Ui.dIsPlAy("Book has not been damaged");
			return;
		}
		ui.dIsPlAy(currentBook.toString());
		ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
		state = ControlState.FIXING;		
	}


	public void FiX_BoOk(boolean mustFix) {
		if (!state.equals(ControlState.FIXING)) 
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			
		if (mustFix) 
			library.RePaIr_BoOk(currentBook);
		
		currentBook = null;
		ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		state = ControlState.READY;		
	}

	
	public void SCannING_COMplete() {
		if (!state.equals(ControlState.READY)) 
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);		
	}

}
