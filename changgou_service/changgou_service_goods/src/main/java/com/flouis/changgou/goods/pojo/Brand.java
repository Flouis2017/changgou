package com.flouis.changgou.goods.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Brand implements Serializable {

	private Long id;
	private String name;
	private String image;
	private String letter;
	private Integer seq;

}
