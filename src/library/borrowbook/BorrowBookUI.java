package library.borrowbook;
import java.util.Scanner;

// Author: Prajwal Kumar Ale
// Mediator: Sudhir Thapaliya
// Reviewer: Saujan Thapa

public class BorrowBookUI {
    
//     public static enum uI_STaTe { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
    public static enum UIState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED }; //changed uI_STaTe to UIState

//     private bORROW_bOOK_cONTROL CoNtRoL;
    private bORROW_bOOK_cONTROL control; // changed variable CoNtRoL to control
    
//     private Scanner InPuT;
    private Scanner input; //changed InPuT to input
    
//     private uI_STaTe StaTe;
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

    
//    private String iNpUT(String PrOmPt) {
    private String input(String prompt) { // changed method name iNpUT to input and parameter name PromPt to prompt
        // System.out.print(PrOmPt);
        System.out.print(prompt); 
        // return InPuT.nextLine();
        return input.nextLine();
    }    
        
        
    // private void OuTpUt(Object ObJeCt) {
    private void output(Object object) { // changed method name OuTpUt to output and parameter name ObJeCt to object
        // System.out.println(ObJeCt);
        System.out.println(object);
    }
    
            
    // public void SeT_StAtE(uI_STaTe StAtE) {
    public void setState(UIState state) { // changed method name SeT_StAtE to setState and parameter uI_STaTe StAtE to UIState state
        // this.StaTe = StAtE;
        // this.state = StAtE;
        this.state = state;
    }

    
    // public void RuN() {
    public void run() { //changed method name RuN to run
        // OuTpUt("Borrow Book Use Case UI\n");
        output("Borrow Book Use Case UI\n");
        
        while (true) {
            
            // switch (StaTe) {
            switch (state) {            
            
            case CANCELLED:
                // OuTpUt("Borrowing Cancelled");
                output("Borrowing Cancelled");
                return;

                
            case READY:
                // String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
                String memStr = input("Swipe member card (press <enter> to cancel): "); //changed variable MEM_STR to memStr
                // if (MEM_STR.length() == 0) {
                if (memStr.length() == 0) {
                    // CoNtRoL.CaNcEl();
                    control.CaNcEl();
                    break;
                }
                try {
                    // int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
                    int memberID = Integer.valueOf(memStr).intValue(); // changed variable name MeMbEr_Id to memberID
                    // CoNtRoL.SwIpEd(MeMbEr_Id);
                    // control.SwIpEd(MeMbEr_Id);
                    control.SwIpEd(memberID);
                }
                catch (NumberFormatException e) {
                    // OuTpUt("Invalid Member Id");
                    output("Invalid Member Id");
                }
                break;

                
            case RESTRICTED:
                // iNpUT("Press <any key> to cancel");
                input("Press <any key> to cancel");
                // CoNtRoL.CaNcEl();
                control.CaNcEl();
                break;
            
                
            case SCANNING:
                // String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
                String bookStringInput = input("Scan Book (<enter> completes): "); // changed variable name BoOk_StRiNg_InPuT to bookStringInput
                // if (BoOk_StRiNg_InPuT.length() == 0) {
                if (bookStringInput.length() == 0) {
                    // CoNtRoL.CoMpLeTe();
                    control.CoMpLeTe();
                    break;
                }
                try {
                    // int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
                    int bookID = Integer.valueOf(bookStringInput).intValue(); // changed variable name BiD to bookID
                    // CoNtRoL.ScAnNeD(BiD);
                    // control.ScAnNeD(BiD);
                    control.ScAnNeD(bookID);
                    
                } catch (NumberFormatException e) {
                    // OuTpUt("Invalid Book Id");
                    output("Invalid Book Id");
                } 
                break;
                    
                
            case FINALISING:
                // String AnS = iNpUT("Commit loans? (Y/N): ");
                String answer = input("Commit loans? (Y/N): "); // changed variable name AnS to answer
                // if (AnS.toUpperCase().equals("N")) {
                if (answer.toUpperCase().equals("N")) {
                    // CoNtRoL.CaNcEl();
                    control.CaNcEl();
                    
                } else {
                    // CoNtRoL.CoMmIt_LoAnS();
                    control.CoMmIt_LoAnS();
                    // iNpUT("Press <any key> to complete ");
                    input("Press <any key> to complete ");
                }
                break;
                
                
            case COMPLETED:
                // OuTpUt("Borrowing Completed");
                output("Borrowing Completed");
                return;
    
                
            default:
                // OuTpUt("Unhandled state");
                output("Unhandled state");
                // throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);
                throw new RuntimeException("BorrowBookUI : unhandled state :" + state;            
            }
        }        
    }


    // public void DiSpLaY(Object object) {
    public void display(Object object) { // changed method name DiSpLaY to display
        // OuTpUt(object);
        output(object);        
    }
}
