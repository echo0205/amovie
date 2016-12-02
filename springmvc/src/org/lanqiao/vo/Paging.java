package org.lanqiao.vo;

public class Paging {
	private int offset;
	private int limit;
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "Paging [offset=" + offset + ", limit=" + limit + "]";
	}
	
}
