package com.favccxx.security.utils.datatable;

public class DataTableSearch {
	
	

	private String value;

	private Boolean regex;
	
	public DataTableSearch(String value, Boolean regex) {
		this.value = value;
		this.regex = regex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getRegex() {
		return regex;
	}

	public void setRegex(Boolean regex) {
		this.regex = regex;
	}

	
}
