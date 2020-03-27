package com.flouis.changgou.goods.controller;

import com.flouis.changgou.common.entity.Result;
import com.flouis.changgou.goods.pojo.Goods;
import com.flouis.changgou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@PostMapping
	public Result add(@RequestBody Goods goods){
		try {
			String spuId = this.goodsService.add(goods);
			return Result.success("操作成功", spuId);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
	}

	@GetMapping("/{spuId}")
	public Result findBySpuId(@PathVariable String spuId){
		try {
			Goods goods = this.goodsService.findBySpuId(spuId);
			return Result.success(goods);
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}


}
