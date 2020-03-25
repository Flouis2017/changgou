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

	public List<Brand> findAll() {
		return this.brandMapper.findAll();
	}

	public void add(Brand brand) {
		this.brandMapper.insertSelective(brand);
	}

	public void update(Brand brand) {
		this.brandMapper.updateByPrimaryKeySelective(brand);
	}

	public void delete(Long id) {
		this.brandMapper.deleteByPrimaryKey(id);
	}

}
