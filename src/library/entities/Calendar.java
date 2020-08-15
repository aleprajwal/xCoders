//Author: Mukesh
//Reviewer: Sudhir
//Mediator: Saujan
package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//private static Calendar sElF;
	private static calendar Self; //variable name changed from Calendar sElF to calendar Self 
	//private static java.util.Calendar cAlEnDaR;
	private static java.util.Calendar calendar;//variable name changed from cAlEnDaR to calendar
	
	
	//private Calendar() {
	private isCalendar() { //Calendar() changes to isCalendar()
		//cAlEnDaR = java.util.Calendar.getInstance();
		Calendar = java.util.Calendar.getInstance();//cAlEnDaR changes to Calendar
	}
	
	//public static Calendar gEtInStAnCe() {
	public static Calendar getInstance() {	//Calendar gEtInStAnCe() changes to Calendar getInstance()
		//if (sElF == null) {
		if (self == null) {  //sElF chsnges to self
			//sElF = new Calendar();
			self = new isCalendar();//Calendar() changes to isCalendar() and sElF changes to self
		}
		return self;
	}
	
	public void incrementDate(int days) {
		cAlEnDaR.add(java.util.Calendar.DATE, days);		
	}
	
	public synchronized void SeT_DaTe(Date DaTe) {
		try {
			cAlEnDaR.setTime(DaTe);
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date gEt_DaTe() {
		try {
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
		//Date nOw = gEt_DaTe();
		dateNow = getDate();//variable name  Date nOw changed to datenow,method name gEt_DaTe(); changed to getDate();
		cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		//Date dUeDaTe = cAlEnDaR.getTime();
		dateDueDate = calendar.getTime();//variable name Date dUeDaTe changed to dateDueDate,method name cAlEnDaR.getTime(); changed to calendar.getTime();
		cAlEnDaR.setTime(nOw);
		return dUeDaTe;
	}
	
	public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
		
		//long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
		long diffMillis = getDate().getTime() - targetDate.getTime();// variable name Diff_Millis  changed to diffMillis,method name gEt_DaTe() changed to getDate()
	    //long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    long diffDays = TimeUnit.DAYS.isConvert(diffMillis, timeUnit.MILLISECONDS);//variable name Diff_Days,Diff_Millis changed to diffDays,diffMillis also method name convert(Diff_Millis, TimeUnit.MILLISECONDS); changed to isConvert(diffMillis, timeUnit.MILLISECONDS);
	    //return Diff_Days;
	    return diffDays;//variable name Diff_Days changed to diffDays
	}

}
