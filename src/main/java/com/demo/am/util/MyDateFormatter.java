package com.demo.am.util;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MyDateFormatter {

	private static String pattern = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	

	public MyDateFormatter() {

		super();
	}

	public static String formatDate(Date date) {
		if(date != null && !date.equals("")) {
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
		return simpleDateFormat.format(date);
		}
		else 
			return null;
	}
	
	public static Timestamp dateToTimeStample(Date date) {
		if(date != null && !date.equals("")) {
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;
		}
		else 
			return null;
	}

	public static Date parseDate(String dateString) {

		try {
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			return simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String timeStampIntoDate(Timestamp date) {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
		formater.setTimeZone(pakistan);
		String formatedDate = formater.format(date);
		try {
			return formatedDate;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Timestamp stringToTimeStamp(String timestamp) {
		Timestamp tempTimestamp = null;
		
		if (timestamp != null && !timestamp.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(timestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
	}

	public static Timestamp stringToTimeStampWithTime(String strTime) {

		Timestamp tempTimestamp = null;
		if (strTime != null && !strTime.equals(""))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"dd-MMM-yy hh:mm:ss");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());

		}
		return tempTimestamp;
	}

	public static String timeStampToString(Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");
		
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
		return timeStampToStr;
	}

	public static String timeStampToStringWithTime(Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
			
		return timeStampToStr;
	}

	public static String timeStampToStringForBuildings(Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
			
		return timeStampToStr;
	}

	public static String timeStampToStringFourDigitYear(Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
			
		return timeStampToStr;
	}

	public static String timeStampToStringMonth(Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
			
		return timeStampToStr;
	}

	public static String timeStampToYear(Timestamp timeStamp) {

		String startYear = null;
		if (timeStamp != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(timeStamp.getTime()));
			startYear = String.valueOf(cal.get(Calendar.YEAR));
		}
		return startYear;
	}

	//Method to convert date to String without time
	public static String dateToString(Date date) {

		String dateToStr = null;
		if (date != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			dateToStr = simpleDateFormat.format(date);
		}
			
		return dateToStr;
	}
	
	public static String dateToStringYearMonthDay(Date date) {

		String dateToStr = null;
		if (date != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			dateToStr = simpleDateFormat.format(date);
		}
		
		return dateToStr;
	}
	
	public static String dateToStringYearMonthDayForMob(Date date) {

		String dateToStr = null;
		if (date != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd//MM/yyyy");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			dateToStr = simpleDateFormat.format(date);
		}
			
		return dateToStr;
	}
	public static String dateToStringYearMonthDayForMob2(Date date) {

		String dateToStr = null;
		if (date != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			
			dateToStr = simpleDateFormat.format(date);
		}
			//dateToStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		//	dateToStr = new SimpleDateFormat("dd/MM/yyyy").format(date);
		return dateToStr;
	}
	public static Timestamp stringToTimeStampNewFormat(String strTime) {

		Timestamp tempTimestamp = null;
		
		if (strTime != null && !strTime.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
	}
	public static Timestamp stringToTimeStampForMobApp(String strTime) {

		Timestamp tempTimestamp = null;
		
		if (strTime != null && !strTime.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
	}
	
	public static String timeStampIntoTimeAndDate(Timestamp date) {
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	
	    TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
	    formater.setTimeZone(pakistan);
	    String formatedDate = formater.format(date);
		try {
			return formatedDate;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String timeStampIntoDateForSummaryReport(Timestamp date) {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
		formater.setTimeZone(pakistan);
		String formatedDate = formater.format(date);
		try {
			return formatedDate;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Timestamp stringToTimeStampMobile(String strTime) {
		Timestamp tempTimestamp = null;
		
		if (strTime != null && !strTime.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
	}
	
	
	public static String timeStampToStringWithTimeMobile (Timestamp timeStamp) {

		String timeStampToStr = null;
		if (timeStamp != null){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			simpleDateFormat.setTimeZone(pakistan);
			timeStampToStr = simpleDateFormat.format(timeStamp);
		}
			
		return timeStampToStr;
	}
	
	
	public static Timestamp stringToTimeStampWithTimeMobileApp (String strTime) {

		Timestamp tempTimestamp = null;
		
		if (strTime != null && !strTime.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
			dateFormat.setTimeZone(pakistan);
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
	}
}
