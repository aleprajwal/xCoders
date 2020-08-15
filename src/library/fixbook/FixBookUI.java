package library.fixbook;
import java.util.Scanner;

//Author: Sudhir Thapaliya
//Mediator: Prajwal Kumar ale
//Reviewer: Mukesh Kumar

public class FixBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, FIXING, COMPLETED };
	public static enum UIState { INITIALISED, READY, FIXING, COMPLETED };//change enum naming convention
	//private fIX_bOOK_cONTROL CoNtRoL;
	private FixBookControl control;//changed reference of Class as the class name is change i fix book control
	//private Scanner InPuT;
	private Scanner input;// fixed variable naming convention
	//private uI_sTaTe StAtE;
	private UIState state;// fixed variable naming convention

	
	//public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) {
	public FixBookUI(FixBookControl control) {// fixed Parameter Class name and argument naming convention
		//this.CoNtRoL = CoNtRoL;
		this.control = control;// variable naming convention fix
		//InPuT = new Scanner(System.in);
		input = new Scanner(System.in);// variable naming convention fix
		//StAtE = uI_sTaTe.INITIALISED;
		state = UIState.INITIALISED;// Enum/variable naming convention fix
		//CoNtRoL.SeT_Ui(this);
		control.setUI(this);// changed the varianble and function name as he function is changed in fixbookcontrol.java
	}


	//public void SeT_StAtE(uI_sTaTe state) {
	public void setState(UIState state) {//fixed method and argument naming convention
		//this.StAtE = state;
		this.state = state;// fixed variables naming convention
	}

	//public void RuN() {
	public void run() {//change methods naming convvention
		//OuTpUt("Fix Book Use Case UI\n");
		output("Fix Book Use Case UI\n");// changed functions name which is inside this class
		
		while (true) {
			
			//switch (StAtE) {
			switch (state) {// changed variable name

			case READY:
				//String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookEntryString = input("Scan Book (<enter> completes): ");// changed variable name
				//if (BoOk_EnTrY_StRiNg.length() == 0) 
				if(bookEntryString.length() == 0) {// added code block and changed variable naming conventions
					//CoNtRoL.SCannING_COMplete();
					control.scanningComplete();
				}
				
				else {
					try {
						//int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						int bookId = Integer.valueOf(bookEntryString).intValue();// changed variable naming conventions
						//CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
						control.bookScanned(bookId);// changed function and variable name. Function name has been changed in Fixbookcontrol.java as well.
					}
					catch (NumberFormatException e) {
						//OuTpUt("Invalid bookId");
						output("Invalid bookId");// changed function name
					}
				}
				break;	
				
			case FIXING:
				//String AnS = iNpUt("Fix Book? (Y/N) : ");
				String answer = input("Fix Book? (Y/N) : ");// changed variable /function name
				//boolean FiX = false;
				boolean fix = false;// changed variable name
				//if (AnS.toUpperCase().equals("Y"))
				    //FiX = true;
				if (answer.toUpperCase().equals("Y")) {//changed variable name and also added code block
                    fix = true;
				}
					
				
				//CoNtRoL.FiX_BoOk(FiX);
				control.fixbook(fix);// changed variable name and function name. Function name is changed in it definition as well.
				break;
								
			case COMPLETED:
				//OuTpUt("Fixing process complete");
				output("Fixing process complete");// changed function name
				return;
			
			default:
				//OuTpUt("Unhandled state");
				output("Unhandled state");// changed function name
				throw new RuntimeException("FixBookUI : unhandled state :" + state);			
			
			}		
		}
		
	}

	
	//private String iNpUt(String prompt) {
	private String input(String prompt) {// changed function name
		System.out.print(prompt);
		//return InPuT.nextLine();
		return input.nextLine();// change variable name
	}	
		
		
	//private void OuTpUt(Object object) {
	private void output(Object object) {// changed function name
		System.out.println(object);
	}
	

	//public void dIsPlAy(Object object) {
	public void display(Object object) {// changed function name
		//OuTpUt(object);
		output(object);// changed function name
	}
	
	
}
