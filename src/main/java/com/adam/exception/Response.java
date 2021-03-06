package com.adam.exception;

public class Response<T> {

		/**
		 * 状态码
		 */
		private Integer code;

		/**
		 * 请求成功时返回的对象
		 */
		private T data;

		/**
		 * 提示信息
		 */
		private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Response(Integer code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public Response() {
	}

	@Override
	public String toString() {
		return "Response{" +
				"code=" + code +
				", data=" + data +
				", msg='" + msg + '\'' +
				'}';
	}
}