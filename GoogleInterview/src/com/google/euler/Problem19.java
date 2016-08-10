package com.google.euler;

public class Problem19 {

	public static void main(String[] args) {
		int indexLeap = 366%7;
		int indexNormal = 365%7;
		//0 = monday 1= tuesday 2=wednesday 3=thursday 4 = friday 5 = saturday 6 = sunday
		System.out.println("1900 mod 4 : " + 1900%4);
		System.out.println("1900 mod 400 : " + 1900%400);
		System.out.println("365 mod 7 : " + indexNormal);
		System.out.println("366 mod 7 : " + indexLeap);
		//=>jan 1 1901 is a thursday
		//int years[] = new int[];
		int numSundays = 0;
		int day = 2;
		int month = 0;
		int daysInYear = 365;
		int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int i = 1901; i <=2000; i++){
			if((i%4 == 0 && i%100 !=0) || (i%400 == 0)){
				daysInMonth[1] =29;
				daysInYear = 366;
				//System.out.println("Year : " + i +" is a leap year!");
				/*day += daysInYear;
				numSundays += day/7;
				day %= 366;*/
			}else{
				daysInMonth[1] = 28;
				daysInYear = 365;
				/*day += daysInYear;
				numSundays += day/7;
				day %= 365;*/
			}
			for(int k =0; k < 12; k++){
				for(int j = 0; j < daysInMonth[month]; j++){
					day %= 7;
					if(day == 0 && j==0){
						numSundays++;
						System.out.println("Day " + day + " Month " + month +" Day of month "+j+ " Year " + i);
						//System.out.println("Day " + day + " Month " + month +" Day of month "+j+ " Year " + i);
					}
					day++;
					
				}
				
				month++;
				
			}
			month %= 12;
			
		}
		System.out.println("number of sundays : " + numSundays);
	}

}
