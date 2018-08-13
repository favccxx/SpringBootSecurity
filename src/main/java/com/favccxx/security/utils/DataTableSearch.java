package com.favccxx.security.utils;

import java.util.HashMap;

public class DataTableSearch extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String VALUE = "value";

    private static final String REGEX = "regex";
    
    public DataTableSearch() {
        put(VALUE, "");
        put(REGEX, "");
    }
    

	public static String getValue() {
		return VALUE;
	}

	public static String getRegex() {
		return REGEX;
	}
    
    

}
