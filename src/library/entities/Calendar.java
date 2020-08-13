//Author: Mukesh
//Reviewer: Sudhir
//Mediator: Saujan
package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//private static Calendar sElF;
	private static calendarSelf; //variable name changed from Calendar sElF to calendarSelf 
	//private static java.util.Calendar cAlEnDaR;
	private static java.util.Calendar calendar;//variable name changed from cAlEnDaR to calendar
	
	
	private Calendar() {
		cAlEnDaR = java.util.Calendar.getInstance();
	}
	
	public static Calendar gEtInStAnCe() {
		if (sElF == null) {
			sElF = new Calendar();
		}
		return sElF;
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
		Date dUeDaTe = cAlEnDaR.getTime();
		cAlEnDaR.setTime(nOw);
		return dUeDaTe;
	}
	
	public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
		
		long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
