package com.ghx.domain;

import java.io.Serializable;
import java.util.List;
/**
*-------------------------------------------------
* @ClassName  : Pagination
* @Descprition : 分页
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:29
*--------------------------------------------------
*/
public class Pagination implements Serializable {
	
	private static final long serialVersionUID = 3902799900991457896L;
	/**状态吗，0 异常 1正常*/
	//private Integer statusNum = 1;
	//private String  statusMsg;
	
	/**
	 * 当前页码
	 */
	long pagenum = 1;
	/**
	 * 总记录数
	 */
	//int totalCount = 0;
	long total = 0;
	/**
	 * 每页展示的记录数
	 */
	int pageSize = 5;
	/**
	 * 总页数
	 */
	long totalPage = 1;
	
	/**
	 * 开始行号
	 */
	long startNum = 0;
	
	/**
	 * 结束行号
	 */
	long endNum = 0;
	
	List<?> rows;
	
	public Pagination(){}

	public Pagination(long pageNo, long totalCount, int pageSize) {
		super();
		this.pagenum = pageNo;
		this.total = totalCount;
		this.pageSize = pageSize;
	}

	public long getPagenum() {
		return pagenum;
	}

	public void setPagenum(long pagenum) {
		this.pagenum = pagenum;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long totalCount) {
		this.total = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获得总页数
	 * @return
	 */
	public long getTotalPage() {
		long pages = total /pageSize;
		if(total %pageSize != 0){
			pages++;
		}
		return pages;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获得开始行号
	 * @return
	 */
	public long getStartNum() {
		return pageSize *(pagenum -1);
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	/**
	 * 获得结束行号
	 * @return
	 */
	public long getEndNum() {
		return pageSize * pagenum  + 1;
	}

	public void setEndNum(long endNum) {
		this.endNum = endNum;
	}

	 
	
	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	/**
	 * 第一页
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 上一页
	 */
	public long getPreviousPageNo() {
		if (pagenum <= 1) {
			return 1;
		}
		return pagenum - 1;
	}

	/**
	 * 下一页
	 */
	public long getNextPageNo() {
		if (pagenum >= getTotalPage()) {
			return getTotalPage() == 0 ? 1 : getTotalPage();
		}
		return pagenum + 1;
	}

	/**
	 * 最后一页
	 */
	public long getBottomPageNo() {
		return getTotalPage() == 0 ? 1 : getTotalPage();
	}

	@Override
	public String toString() {
		return "Pagination [pagenum=" + pagenum + ", total=" + total + ", pageSize=" + pageSize + ", totalPage="
				+ totalPage + ", startNum=" + startNum + ", endNum=" + endNum + ", rows=" + rows + "]";
	}
	
}
