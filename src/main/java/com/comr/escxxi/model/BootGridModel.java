package com.comr.escxxi.model;

import java.util.List;

public class BootGridModel {
	private int current;
	private int rowCount;
	private long total;
	private List<?> rows;
	
	public BootGridModel() {
		super();
		this.current = 1;
		this.rowCount = 10;
	}
	
	public BootGridModel(int current, int rowCount) {
		super();
		this.current = current;
		this.rowCount = rowCount;		
	}	
	
	public BootGridModel(int current, int rowCount, long total, List<?> rows) {
		super();
		this.current = current;
		this.rowCount = rowCount;
		this.total = total;
		this.rows = rows;
	}	

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
	
}
