package com.flouis.changgou.entity;


import lombok.*;

import java.util.List;

/**
 * @description 读结果实体类
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
