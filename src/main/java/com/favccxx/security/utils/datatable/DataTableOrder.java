package com.favccxx.security.utils.datatable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DataTableOrder {

	/**
	 * 排序的列索引
	 */
	@NotNull
	@Min(0)
	private Integer column;

	/**
	 * 排序方式（desc/asc）
	 */
	@NotNull
	@Pattern(regexp = "(desc|asc)")
	private String dir;

	public DataTableOrder(int column, String dir) {
		this.column = column;
		this.dir = dir;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

}
