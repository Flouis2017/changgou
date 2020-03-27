package com.flouis.changgou.common.entity;

import lombok.*;

/**
 * @description 结果实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {

	private Boolean flag; // 请求是否成功
	private Integer code; // 响应码
	private String message; // 消息
	private Object data; // 结果集

	public static Result success(){
		return new Result(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDescription(), null);
	}

	public static Result success(Object data){
		return new Result(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDescription(), data);
	}

	public static Result success(String message){
		return new Result(true, ResultCode.SUCCESS.getCode(), message, null);
	}

	public static Result success(String message, Object data){
		return new Result(true, ResultCode.SUCCESS.getCode(), message, data);
	}

	public static Result success(Integer code, String message, Object data){
		return new Result(true, code, message, data);
	}

	public static Result fail(){
		return new Result(false, ResultCode.FAIL.getCode(), ResultCode.FAIL.getDescription(), null);
	}

	public static Result fail(String message){
		return new Result(false, ResultCode.FAIL.getCode(), message, null);
	}

	public static Result fail(Integer code, String message){
		return new Result(false, code, message, null);
	}

}
