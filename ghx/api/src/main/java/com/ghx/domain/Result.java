package com.ghx.domain;
/**
*-------------------------------------------------
* @ClassName  : Result
* @Descprition : 页面返回对象
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:29
*--------------------------------------------------
*/
public class Result {
	public static Integer RETCODE_SUCCESS=1;
	public static Integer RETCODE_ERROR=0;
	/**
	 * 错误信息
	 */
	private String errMsg;
	/**
	 * 状态码
	 */
	private Integer retCode;
	/**
	 * 实体数据
	 */
	private Object data;
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	/**
	 * 通用 成功 结果
	 * @param data
	 * @return
	 */
	public static Result success(Object data){
		Result result = new Result();
		result.setRetCode(RETCODE_SUCCESS);
		result.setData(data);
		return result;
	}
	/**
	 * 通用 失败结果
	 * @param errMsg
	 * @return
	 */
	public static Result fail(String errMsg){
		Result result = new Result();
		result.setRetCode(RETCODE_ERROR);
		result.setErrMsg(errMsg);
		return result;
	}
	@Override
	public String toString() {
		return "Result [errMsg=" + errMsg + ", retCode=" + retCode + ", data=" + data + "]";
	}
	
	
}
