package library.entities;
import java.io.Serializable;

// Author: Prajwal Kumar Ale
// Mediator: Sudhir Thapaliya
// Reviewer: Saujan Thapa

@SuppressWarnings("serial")
public class Book implements Serializable {
	
// 	private String tItLe;
	private String title; // changed variable name tItLe to title
// 	private String AuThOr;
	private String author; // changed variable name AuThOr to author
// 	private String CALLNO;
	private String callNo; // changed variable name CALLNO to callNo
// 	private int iD;
	private int id; // changed variable name iD to id
	
// 	private enum sTaTe { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED }; // changed sTaTe to State
// 	private sTaTe StAtE;
	private State State; // changed sTaTe StAtE to State State
	
	
	public Book(String author, String title, String callNo, int id) {
// 		this.AuThOr = author;
		this.author = author;
// 		this.tItLe = title;
		this.title = title;
// 		this.CALLNO = callNo;
		this.callNo = callNo;
// 		this.iD = id;
		this.id = id;
// 		this.StAtE = sTaTe.AVAILABLE;
		this.State = State.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		/*sb.append("Book: ").append(iD).append("\n")
		  .append("  Title:  ").append(tItLe).append("\n")
		  .append("  Author: ").append(AuThOr).append("\n")
		  .append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  State:  ").append(StAtE);*/
		
		sb.append("Book: ").append(id).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  .append("  CallNo: ").append(callNo).append("\n")
		  .append("  State:  ").append(State);
		return sb.toString();
	}

	public Integer gEtId() {
// 		return iD;
		return id;
	}

	public String gEtTiTlE() {
// 		return tItLe;
		return title;
	}


	
	public boolean iS_AvAiLaBlE() {
// 		return StAtE == sTaTe.AVAILABLE;
		return State == State.AVAILABLE;
	}

	
	public boolean iS_On_LoAn() {
// 		return StAtE == sTaTe.ON_LOAN;
		return State == State.ON_LOAN;
	}

	
	public boolean iS_DaMaGeD() {
// 		return StAtE == sTaTe.DAMAGED;
		return State == State.DAMAGED;
	}

	
	public void BoRrOw() {
// 		if (StAtE.equals(sTaTe.AVAILABLE))
		if (State.equals(State.AVAILABLE))
// 			StAtE = sTaTe.ON_LOAN;
			State = State.ON_LOAN;
		
		else 
// 			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));
		
		
	}


	public void ReTuRn(boolean DaMaGeD) {
// 		if (StAtE.equals(sTaTe.ON_LOAN))
		if (State.equals(State.ON_LOAN))
			if (DaMaGeD) 
// 				StAtE = sTaTe.DAMAGED;
				State = State.DAMAGED;
			
			else 
// 				StAtE = sTaTe.AVAILABLE;
				State = State.AVAILABLE;
			
		
		else 
// 			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
				
	}

	
	public void RePaIr() {
// 		if (StAtE.equals(sTaTe.DAMAGED))
		if (State.equals(State.DAMAGED))
// 			StAtE = sTaTe.AVAILABLE;
			State = State.AVAILABLE;
		
		else 
// 			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));
		
	}


}
