package com.favccxx.security.utils.datatable;

public class DataTableColumn {

	private String data;

	private String name;

	private Boolean searchable;

	private Boolean orderable;

	private DataTableSearch search;
	
	public DataTableColumn(String data, String name, Boolean searchable, Boolean orderable, DataTableSearch search) {
		this.data = data;
		this.name = name;
		this.searchable = searchable;
		this.orderable = orderable;
		this.search = search;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public DataTableSearch getSearch() {
		return search;
	}

	public void setSearch(DataTableSearch search) {
		this.search = search;
	}

	public void setSearchValue(String searchValue) {
		this.search.setValue(searchValue);
	}
}
