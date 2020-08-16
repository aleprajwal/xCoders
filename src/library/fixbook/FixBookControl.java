package library.fixbook;
import library.entities.Book;
import library.entities.Library;

//Author: Sudhir Thapaliya
//Mediator: Prajwal Kumar ale
//Reviewer: Mukesh Kumar



//public class fIX_bOOK_cONTROL {
public class FixBookControl {// changed class name and renamed class file as well.
    
    //private FixBookUI Ui;
    private FixBookUI ui;// changed variable name
    //private enum CoNtRoL_StAtE { INITIALISED, READY, FIXING };
    private enum ControlState { INITIALISED, READY, FIXING };// changed Enums name
    //private CoNtRoL_StAtE StAtE;
    private ControlState state;// changed enum variable name and Enums Type
    
    //private Library LiBrArY;
    private Library library;// changed variable name
    //private Book CuRrEnT_BoOk;
    private Book currentBook;// changed variable name


    //public fIX_bOOK_cONTROL() {
    public FixBookControl() {// changed constructors name
        //this.LiBrArY = Library.GeTiNsTaNcE();
        this.library = Library.GeTiNsTaNcE();// changed variable name only as the function is in Library class which is not refractored
        //StAtE = CoNtRoL_StAtE.INITIALISED;
        state = ControlState.INITIALISED;// changed variable name and enums name
    }
    
    
    //public void SeT_Ui(FixBookUI ui) {
    public void setUI(FixBookUI ui) {// changed function name
        //if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED)) 
            //throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
        if (!state.equals(ControlState.INITIALISED)) {// changed variable names and added code block
            throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
        }
            
            
        //this.Ui = ui;
        this.ui = ui;// changed variable name
        //ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
        ui.setState(FixBookUI.UIState.READY);// changed function call name
        //StAtE = CoNtRoL_StAtE.READY;
        state = ControlState.READY;        // changed enums reference and variable name
    }


    //public void BoOk_ScAnNeD(int BoOkId) {
    public void bookScanned(int bookId) {// changed function and parameter name
        // if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
        //     throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
        if (!state.equals(ControlState.READY)) {// changed variable name and added code block
            throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
        }
            
            
        //CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
        currentBook = library.gEt_BoOk(BoOkId);// this function belongs to another class which is not refractored
        
        //if (CuRrEnT_BoOk == null) {
        if (currentBook == null) {// changed variable
            //Ui.dIsPlAy("Invalid bookId");
            ui.display("Invalid bookId");// changed function name and variable name
            return;
        }
        //if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
        if (!currentBook.isDamaged()) {// changed variable and function name
            //Ui.dIsPlAy("Book has not been damaged");
            ui.display("Book has not been damaged");// changed variable and function name
            return;
        }
        //Ui.dIsPlAy(CuRrEnT_BoOk.toString());
        ui.display(currentBook.toString());// changed variable and function name
        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
        ui.setState(FixBookUI.UIState.FIXING);// changed variable and function name
        //StAtE = CoNtRoL_StAtE.FIXING;
        state = ControlState.FIXING;    // changed variable and enum name        
    }


    //public void FiX_BoOk(boolean mUsT_FiX) {
    public void fixBook(boolean mustFix) {// change function and parametername
        // if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) 
        //     throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");

        if (!state.equals(ControlState.FIXING)) { // changed variables name and added code block
            throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
        }
            
            
        // if (mUsT_FiX) 
        //     LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
        if (mustFix) {// changed variable name and added code block
            library.RePaIr_BoOk(currentBook);//this function belongs to libray class
        }
            
        
        //CuRrEnT_BoOk = null;
        currentBook = null;// changed variable name
        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
        ui.setState(FixBookUI.UIState.READY);// changed variable name and function name
        //StAtE = CoNtRoL_StAtE.READY;
        state = ControlState.READY;    // changed variable name and enum reference    
    }

    
    //public void SCannING_COMplete() {
    public void scanningComplete() {// changed function name
        // if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
        //     throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
        if(!state.equals(ControlState.READY)) {// changed variable name and added code block
            throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
        }
            
        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);
        ui.setState(FixBookUI.UIState.COMPLETED);// changed variable and enum reference        
    }

}
