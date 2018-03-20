package com.comr.escxxi.utils;

public class Utils {

	public static boolean isNullOrEmpty(String v) {
		if(v == null || v.isEmpty() || v.length() <= 0) {
			return true;
		}else {
			return false;
		}				
	}
}
