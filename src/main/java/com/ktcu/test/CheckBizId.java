package com.ktcu.test;

/**
 * Created by LG on 2017-07-25.
 */

public class CheckBizId {

	String biz = "612-81-49445";
	String biz2 = "129-86-63877";

	public static boolean checkCompNumber(String comp1, String comp2, String comp3) {

		String compNumber = comp1 + comp2 + comp3;

		int hap = 0;
		int temp = 0;
		int check[] = {1,3,7,1,3,7,1,3,5};  //????? ??? ?? ??? ?

		if(compNumber.length() != 10)    //?????? ??? ???? ????.
			return false;

		for(int i=0; i < 9; i++){
			if(compNumber.charAt(i) < '0' || compNumber.charAt(i) > '9')  //??? ?? ?? ?????? ????.
				return false;

			hap = hap + (Character.getNumericValue(compNumber.charAt(i)) * check[temp]); //??? ??
			temp++;
		}

		hap += (Character.getNumericValue(compNumber.charAt(8))*5)/10;

		if ((10 - (hap%10))%10 == Character.getNumericValue(compNumber.charAt(9))) //??? ????? ???? ?? ?? ??
			return true;
		else
			return false;
	}

	public static boolean checkCompNumber(String comp) {

		if(comp.length() != 10) return false;
		return checkCompNumber(comp.substring(0,3), comp.substring(3,5), comp.substring(5,10));

	}
}
