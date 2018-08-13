package com.favccxx.security.utils.datatable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

public class DataTableRequest {

	/**
	 * 第 x 次请求
	 */
	private Integer draw = 1;

	/**
	 * 从第 x 条开始取数
	 */
	private Integer start = 0;

	/**
	 * 每页显示条目
	 */
	private Integer length = 10;
	
	private List<DataTableColumnSpecs> columns;
	
	/** The order. */
	private DataTableColumnSpecs order;
	
	private int maxParamsToCheck = 0;

	/**
	 * DataTable的搜索
	 */
	private DataTableSearch search = new DataTableSearch("", false);

	private boolean isGlobalSearch;
	
	
	
	/**
	 * 排序
	 */
//	private List<DataTableOrder> order = new ArrayList<>();

	/**
	 * 显示列
	 */
	// private List<DataTableColumn> columns = new ArrayList<>();

	public DataTableRequest(HttpServletRequest request) {
		prepareDataTableRequest(request);
	}

	private void prepareDataTableRequest(HttpServletRequest request) {

		Enumeration<String> parameterNames = request.getParameterNames();

		if (parameterNames.hasMoreElements()) {

			this.setStart(Integer.parseInt(request.getParameter("start")));
			this.setLength(Integer.parseInt(request.getParameter("length")));
//			this.setUniqueId(request.getParameter("_"));
			this.setDraw(Integer.parseInt(request.getParameter("draw")));

			String searchValue = (request.getParameter("search[value]"));
			boolean regex = (Boolean.valueOf(request.getParameter("search[regex]")));
			this.setSearch(new DataTableSearch(searchValue, regex));
			
			int sortableCol = Integer.parseInt(request.getParameter("order[0][column]"));

			List<DataTableColumnSpecs> cols = new ArrayList<DataTableColumnSpecs>();

//			if (!AppUtil.isObjectEmpty(this.getSearch())) {
//				this.setGlobalSearch(true);
//			}

			maxParamsToCheck = getNumberOfColumns(request);

			for(int i=0; i < maxParamsToCheck; i++) {
    			if(null != request.getParameter("columns["+ i +"][data]") 
    					&& !"null".equalsIgnoreCase(request.getParameter("columns["+ i +"][data]"))  
    					&& !StringUtils.isBlank(request.getParameter("columns["+ i +"][data]"))) {
    				DataTableColumnSpecs colSpec = new DataTableColumnSpecs(request, i);
    				if(i == sortableCol) {
    					this.setOrder(colSpec);
    					
    				}
    				cols.add(colSpec);
    				
    				if(!StringUtils.isBlank(colSpec.getSearch())) {
    					this.setGlobalSearch(false);
    				}
    			} 
    		}
    		
    		if(cols!=null && cols.size()>0) {
    			this.setColumns(cols);
    		}
		}
	}

	private int getNumberOfColumns(HttpServletRequest request) {
		Pattern p = Pattern.compile("columns\\[[0-9]+\\]\\[data\\]");
		@SuppressWarnings("rawtypes")
		Enumeration params = request.getParameterNames();
		List<String> lstOfParams = new ArrayList<String>();
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			Matcher m = p.matcher(paramName);
			if (m.matches()) {
				lstOfParams.add(paramName);
			}
		}
		return lstOfParams.size();
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<DataTableColumnSpecs> getColumns() {
		return columns;
	}

	public void setColumns(List<DataTableColumnSpecs> columns) {
		this.columns = columns;
	}

	public DataTableColumnSpecs getOrder() {
		return order;
	}

	public void setOrder(DataTableColumnSpecs order) {
		this.order = order;
	}

	public DataTableSearch getSearch() {
		return search;
	}

	public void setSearch(DataTableSearch search) {
		this.search = search;
	}

	public boolean isGlobalSearch() {
		return isGlobalSearch;
	}

	public void setGlobalSearch(boolean isGlobalSearch) {
		this.isGlobalSearch = isGlobalSearch;
	}

	

	

	// public List<DataTableColumn> getColumns() {
	// return columns;
	// }
	//
	// public void setColumns(List<DataTableColumn> columns) {
	// this.columns = columns;
	// }
	//
	// public Map<String, DataTableColumn> getColumnsAsMap() {
	// Map<String, DataTableColumn> map = new HashMap<>();
	// for (DataTableColumn column : columns) {
	// map.put(column.getData(), column);
	// }
	// return map;
	// }

	/**
	 * 根据表格列的名称获取表格列详细信息
	 * 
	 * @param columnName
	 * @return
	 */
	// public DataTableColumn getColumn(String columnName) {
	// if (columnName == null) {
	// return null;
	// }
	// for (DataTableColumn column : columns) {
	// if (columnName.equals(column.getData())) {
	// return column;
	// }
	// }
	// return null;
	// }

	/**
	 * 向列集合中添加列
	 * 
	 * @param columnName
	 * @param searchable
	 * @param orderable
	 * @param searchValue
	 */
	// public void addColumn(String columnName, boolean searchable, boolean
	// orderable, String searchValue) {
	// this.columns.add(new DataTableColumn(columnName, "", searchable, orderable,
	// new DataTableSearch(searchValue, false)));
	// }

	/**
	 * Add an order on the given column
	 *
	 * @param columnName
	 *            the name of the column
	 * @param ascending
	 *            whether the sorting is ascending or descending
	 */
	// public void addOrder(String columnName, boolean ascending) {
	// if (columnName == null) {
	// return;
	// }
	// for (int i = 0; i < columns.size(); i++) {
	// if (!columnName.equals(columns.get(i).getData())) {
	// continue;
	// }
	// order.add(new DataTableOrder(i, ascending ? "asc" : "desc"));
	// }
	// }
}
