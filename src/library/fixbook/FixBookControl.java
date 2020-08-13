package library.fixbook;
import library.entities.Book;
import library.entities.Library;

public class FixBookControl {
	
	private FixBookUI ui;
	private enum ControlState { INITIALISED, READY, FIXING };
	private ConrolState state;
	
	private Library library;
	private Book currentBook;


	public FixBookControl() {
		this.library = Library.GeTiNsTaNcE();
		state = ControlState.INITIALISED;
	}
	
	
	public void setUI(FixBookUI ui) {
		if (!state.equals(ControlState.INITIALISED)) 
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		this.ui = ui;
		ui.setState(FixBookUI.UIState.READY);
		this.state = ControlState.READY;		
	}


	public void bookScanned(int bookId) {
		if (!state.equals(ControlState.READY)) 
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		currentBook = library.gEt_BoOk(booki);
		
		if (currentBook == null) {
			ui.display("Invalid bookId");
			return;
		}
		if (!currentBook.iS_DaMaGeD()) {
			Ui.display("Book has not been damaged");
			return;
		}
		ui.display(currentBook.toString());
		ui.setState(FixBookUI.UIState.FIXING);
		state = ControlState.FIXING;		
	}


	public void fixBook(boolean mustFix) {
		if (!state.equals(ControlState.FIXING)) 
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			
		if (mustFix) 
			library.RePaIr_BoOk(currentBook);
		
		currentBook = null;
		ui.setState(FixBookUI.uI_sTaTe.READY);
		state = ControlState.READY;		
	}

	
	public void scanningComplete() {
		if (!state.equals(ControlState.READY)) 
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		ui.setState(FixBookUI.uI_sTaTe.COMPLETED);		
	}

}
