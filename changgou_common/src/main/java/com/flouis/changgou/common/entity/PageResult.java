package com.flouis.changgou.common.entity;


import lombok.*;

import java.util.List;

/**
 * @description 分页查询结果实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResult {

	private Long total;
	private List<Object> rows;
	private Object row;

}
