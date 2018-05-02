package com.myschooljournal.workservice;

import java.time.LocalDate;

public class DateWorkService {
	
	public static boolean isDateInInterval(LocalDate from,LocalDate to,LocalDate date){
		if(from==null||to==null||date==null){
			return false;
		}
	if((date.equals(from)||date.isAfter(from))&&(date.equals(to)||date.isBefore(to))){
			return true;
		}
		return false;
		
	}

}
