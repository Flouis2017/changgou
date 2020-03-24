package com.flouis.changgou.goods.service;

import com.flouis.changgou.goods.dao.BrandMapper;
import com.flouis.changgou.goods.pojo.Brand;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService {

	@Resource
	private BrandMapper brandMapper;

	/**
	 * @description 查询所有品牌
	 */
	public List<Brand> findAll(){
		return this.brandMapper.findAll();
	}

}
