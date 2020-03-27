package com.flouis.changgou.goods.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Goods {

	private Spu spu;
	private List<Sku> skuList;

}
