package com.stylefeng.roses.core.page;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页结果集
 */
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = -4071521319254024213L;

	protected Integer page = 1;// 要查找第几页
	protected Integer pageSize = 20;// 每页显示多少条
	protected Integer totalPage = 0;// 总页数
	protected Integer totalRows = 0;// 总记录数
	protected List<T> rows;// 结果集

	protected Object obj;
	
	public PageResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageResult(Page<T> page) {
		this.setRows(page.getRecords());
		this.setTotalRows(page.getTotal());
		this.setPage(page.getCurrent());
		this.setPageSize(page.getSize());
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		if (this.getPageSize() != null) {
			return (this.getTotalRows() + this.getPageSize() - 1) / this.getPageSize();// 总页数的算法
		} else {
			return totalPage;
		}
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}