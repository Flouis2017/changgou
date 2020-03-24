package com.flouis.changgou.goods.controller;

import com.flouis.changgou.entity.Result;
import com.flouis.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

	@Autowired
	private BrandService brandService;

	@GetMapping
	public Result findAll(){
		return Result.success(this.brandService.findAll());
	}

}
