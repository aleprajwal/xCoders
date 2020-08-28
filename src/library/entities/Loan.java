package library.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

// Author: Prajwal Kumar Ale
// Mediator: Sudhir Thapaliya
// Reviewer: Saujan Thapa

@SuppressWarnings("serial")
public class Loan implements Serializable {
    
//     public static enum lOaN_sTaTe { CURRENT, OVER_DUE, DISCHARGED };
    public static enum LoanState { CURRENT, OVER_DUE, DISCHARGED }; // changed name from lOaN_sTaTe to LoanState
    
//    private int LoAn_Id;
    private int loanID; // changed variable name LoAn_Id to loanID
//    private Book BoOk;
    private Book book; // changed variable name BoOk to book
//    private Member MeMbEr;
    private Member member; // changed variable name MeMbEr to member
//    private Date DaTe;
    private Date date; // changed variable name DaTe to date
//    private lOaN_sTaTe StAtE;
    private LoanState state; // changed variable name StAtE to state

    
//    public Loan(int loanId, Book bOoK, Member mEmBeR, Date DuE_dAtE) {
    public Loan(int loanId, Book book, Member member, Date dueDate) { // changed parameters name
//        this.LoAn_Id = loanId;
        this.loanID = loanId;
//        this.BoOk = bOoK;
        this.book = book;
//        this.MeMbEr = mEmBeR;
        this.member = member;
//        this.DaTe = DuE_dAtE;
        this.date = dueDate;
//        this.StAtE = lOaN_sTaTe.CURRENT;
        this.state = LoanState.CURRENT;
    }

    
//    public void cHeCk_OvEr_DuE() {
    public void checkOverDue() { // changed method name cHeCk_OvEr_DuE to checkOverDue
//        if (StAtE == lOaN_sTaTe.CURRENT &&
//            Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe))
        if (state == LoanState.CURRENT &&
                Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe)) {
//            this.StAtE = lOaN_sTaTe.OVER_DUE;
            this.state = LoanState.OVER_DUE;
        }
    }

    
//    public boolean Is_OvEr_DuE() {
    public boolean isOverDue() { // changed method name Is_OvEr_DuE to isOverDue
//        return StAtE == lOaN_sTaTe.OVER_DUE;
        return state == LoanState.OVER_DUE;
    }

    
//    public Integer GeT_Id() {
    public Integer getID() { // changed method name GeT_Id to getID
//        return LoAn_Id;
        return loanID;
    }


//    public Date GeT_DuE_DaTe() {
     public Date getDueDate() { // changed method name GeT_DuE_DaTe to getDueDate
//        return DaTe;
         return date;
    }
    
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();
//        sb.append("Loan:  ").append(LoAn_Id).append("\n")
//          .append("  Borrower ").append(MeMbEr.GeT_ID()).append(" : ")
//          .append(MeMbEr.GeT_LaSt_NaMe()).append(", ").append(MeMbEr.GeT_FiRsT_NaMe()).append("\n")
//          .append("  Book ").append(BoOk.gEtId()).append(" : " )
//          .append(BoOk.gEtTiTlE()).append("\n")
//          .append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
//          .append("  State: ").append(StAtE);

        sb.append("Loan:  ").append(loanID).append("\n")
                .append("  Borrower ").append(member.GeT_ID()).append(" : ")
                .append(member.GeT_LaSt_NaMe()).append(", ").append(member.GeT_FiRsT_NaMe()).append("\n")
                .append("  Book ").append(book.gEtId()).append(" : " )
                .append(book.gEtTiTlE()).append("\n")
                .append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
                .append("  State: ").append(state);

        return sb.toString();
    }


//    public Member GeT_MeMbEr() {
    public Member getMember() { // changed method name GeT_MeMbEr to getMember
//        return MeMbEr;
        return member;
    }


//    public Book GeT_BoOk() {
    public Book getBook() { // changed method name GeT_BoOk to getBook
//        return BoOk;
        return book;
    }


//    public void DiScHaRgE() {
    public void discharge() { // changed method name DiScHaRgE to discharge
//        StAtE = lOaN_sTaTe.DISCHARGED;
        state = LoanState.DISCHARGED;
    }
}
