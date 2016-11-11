package com.mindbody.source;

import java.util.List;

import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;
import com.mindbodyonline.clients.api._0_5.StatusCode;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;

public class BaseResponse {
	
	private List<?> rows;
	protected StatusCode status;
    protected int errorCode;
    protected String message;
    protected XMLDetailLevel xmlDetail;
    protected int resultCount;
    protected int currentPageIndex;
    protected int totalPageCount;
    
	public BaseResponse(SelectDataCSVResult selectDataCSVResult) {
		this.currentPageIndex = selectDataCSVResult.getCurrentPageIndex();
		this.errorCode = selectDataCSVResult.getErrorCode();
		this.message = selectDataCSVResult.getMessage();
		this.resultCount = selectDataCSVResult.getResultCount();
		this.totalPageCount = selectDataCSVResult.getTotalPageCount();
		this.status = selectDataCSVResult.getStatus();
		this.xmlDetail = selectDataCSVResult.getXMLDetail();
	}
	
	
	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	/**
	 * @return the status
	 */
	public StatusCode getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusCode status) {
		this.status = status;
	}
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the xmlDetail
	 */
	public XMLDetailLevel getXmlDetail() {
		return xmlDetail;
	}
	/**
	 * @param xmlDetail the xmlDetail to set
	 */
	public void setXmlDetail(XMLDetailLevel xmlDetail) {
		this.xmlDetail = xmlDetail;
	}
	/**
	 * @return the resultCount
	 */
	public int getResultCount() {
		return resultCount;
	}
	/**
	 * @param resultCount the resultCount to set
	 */
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	/**
	 * @return the currentPageIndex
	 */
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	/**
	 * @param currentPageIndex the currentPageIndex to set
	 */
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	/**
	 * @return the totalPageCount
	 */
	public int getTotalPageCount() {
		return totalPageCount;
	}
	/**
	 * @param totalPageCount the totalPageCount to set
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

}
