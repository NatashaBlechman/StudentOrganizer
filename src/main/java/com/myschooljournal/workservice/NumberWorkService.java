package com.myschooljournal.workservice;

import java.util.Collection;

public  class NumberWorkService {
	
	public static <T extends Number> Double averageNum(Collection<? extends T> collection){
		
		if(collection==null || collection.isEmpty()) return null;//проверить метод
		double sum=0L;
		for (T element:collection) {
			sum+=element.doubleValue();
		}
		return 1.0*sum/collection.size();
			
	}

}
