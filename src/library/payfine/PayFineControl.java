package library.payfine;
import library.entities.Library;
import library.entities.Member;
//Author: Sudhir Thapaliya
//Mediator: Prajwal Kumar ale
//Reviewer: Mukesh Kumar

//public class pAY_fINE_cONTROL {
public class PayFineControl {
    
    //private PayFineUI Ui;
    private PayFineUI ui;
    //private enum cOnTrOl_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
    private enum ControlState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };//changed enum name
    //private cOnTrOl_sTaTe StAtE;
    private ControlState state;// changed variable name and enum reference
    
    //private Library LiBrArY;
    private Library library;// changed variable name
    //private Member MeMbEr;
    private Member member;//changed variable name


    //public pAY_fINE_cONTROL() {
    public PayFineControl() {
        //this.LiBrArY = Library.GeTiNsTaNcE();
        this.library = Library.getInstance();// changed referene of library
        //StAtE = cOnTrOl_sTaTe.INITIALISED;
        state = ControlState.INITIALISED;// changed Enum Referene
    }
    
    
    //public void SeT_uI(PayFineUI uI) {
    public void setUI(PayFineUI ui) {//changed function name
        //if (!StAtE.equals(cOnTrOl_sTaTe.INITIALISED)) {
        if (!state.equals(ControlState.INITIALISED)) {// changed enums reference and variable name
            throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
        }    
        //this.Ui = uI;
        this.ui = ui;
        //ui.SeT_StAtE(PayFineUI.uI_sTaTe.READY);
        ui.setState(PayFineUI.UIState.READY);// change method name as it is changed to payfineui
        //StAtE = cOnTrOl_sTaTe.READY;
        state = ControlState.READY;     // changed variable and enum reference   
    }


    //public void CaRd_sWiPeD(int MeMbEr_Id) {
    public void cardSwiped(int memberId) {// changed function and parameter name
        //if (!StAtE.equals(cOnTrOl_sTaTe.READY)) 
        if (!state.equals(ControlState.READY)) {// added codeblock and changed enums referene
            throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
        }
           
            
        //MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id);
        member = Library.getMember(memberId);// changed function name
        
        //if (MeMbEr == null) {
        if (member == null) {
            //Ui.DiSplAY("Invalid Member Id");
            ui.display("Invalid Member Id");// change reference of display function from PayFineUI.java
            return;
        }
        //Ui.DiSplAY(MeMbEr.toString());
        ui.display(member.toString());// change function referene and variable reference name
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
    public double payFine(double amount) {// changed parameter and function name
        //if (!StAtE.equals(cOnTrOl_sTaTe.PAYING)) 
        if (!state.equals(ControlState.PAYING)) 
            throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
            
        //double ChAnGe = MeMbEr.PaY_FiNe(AmOuNt);
        double change = member.payFine(amount);// changed variable name
        //if (ChAnGe > 0) 
        if (change > 0) {// added code block
            //Ui.DiSplAY(String.format("Change: $%.2f", ChAnGe));
            ui.disply(String.format("Change: $%.2f", change));
        }
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
