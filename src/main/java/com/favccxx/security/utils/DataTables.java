package com.favccxx.security.utils;

import java.util.List;

public class DataTables<T> {

	/**
	 * 数据集
	 */
	private List<T> data;

	/**
	 * 总条数
	 */
	private long recordsTotal;

	private long recordsFiltered;	
	
	// 请求次数
	private long draw;
	

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public long getDraw() {
		return draw;
	}

	public void setDraw(long draw) {
		this.draw = draw;
	}
	
	

}
