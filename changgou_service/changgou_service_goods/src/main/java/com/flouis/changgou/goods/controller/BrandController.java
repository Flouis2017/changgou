package com.flouis.changgou.goods.controller;

import com.flouis.changgou.entity.Result;
import com.flouis.changgou.goods.pojo.Brand;
import com.flouis.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

	@Autowired
	private BrandService brandService;

	/**
	 * @description 查询所有
	 */
	@GetMapping
	public Result findAll(){
		return Result.success(this.brandService.findAll());
	}

	/**
	 * @description 新增
	 */
	@PostMapping
	public Result add(@RequestBody Brand brand){
		try {
			this.brandService.add(brand);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}

	/**
	 * @description 更新
	 */
	@PutMapping
	public Result update(@RequestBody Brand brand){
		try {
			this.brandService.update(brand);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}

	/**
	 * @description 删除
	 */
	@DeleteMapping
	public Result delete(Long id){
		try {
			this.brandService.delete(id);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}

}
