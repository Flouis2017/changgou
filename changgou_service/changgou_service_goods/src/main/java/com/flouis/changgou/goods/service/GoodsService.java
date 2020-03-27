package com.flouis.changgou.goods.service;

import com.alibaba.fastjson.JSON;
import com.flouis.changgou.common.util.IdWorker;
import com.flouis.changgou.goods.dao.BrandMapper;
import com.flouis.changgou.goods.dao.SkuMapper;
import com.flouis.changgou.goods.dao.SpuMapper;
import com.flouis.changgou.goods.pojo.Brand;
import com.flouis.changgou.goods.pojo.Goods;
import com.flouis.changgou.goods.pojo.Sku;
import com.flouis.changgou.goods.pojo.Spu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

	@Resource
	private IdWorker idWorker;

	@Resource
	private SpuMapper spuMapper;

	@Resource
	private SkuMapper skuMapper;

	@Resource
	private BrandMapper brandMapper;

	@Transactional
	public String add(Goods goods) {
		// 保存SPU
		Spu spu = goods.getSpu();
		Long spuId = this.idWorker.nextId();
		spu.setId(String.valueOf(spuId));
		this.spuMapper.insertSelective(spu);

		// 保存SKU集合
		List<Sku> skuList = goods.getSkuList();
		if (skuList == null || skuList.size() == 0){
			return String.valueOf(spuId);
		}
		for (Sku sku : skuList){
			sku.setId(String.valueOf(this.idWorker.nextId()));
			if (StringUtils.isBlank(sku.getSpec())){
				sku.setSpec("{}");
			}

			// sku名称 = 商品名称 + 规格
			String name = spu.getName();
			Map<String, String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
			if (specMap != null && specMap.size() > 0){
				for (String value : specMap.values()){
					name += " " + value;
				}
			}
			sku.setName(name);
			sku.setSpuId(String.valueOf(spuId));
			sku.setCategoryId(spu.getCategory3Id());
			// 填充类目名称，这里暂时使用空字符串填充 todo
			sku.setCategoryName("");
			Brand brand = this.brandMapper.selectByPrimaryKey(spu.getBrandId());
			sku.setBrandName(brand == null ? "" : brand.getName());
			this.skuMapper.insertSelective(sku);
		}
		return String.valueOf(spuId);
	}

	public Goods findBySpuId(String spuId) {
		Goods goods = new Goods();
		Spu spu = this.spuMapper.selectByPrimaryKey(spuId);
		List<Sku> skuList = this.skuMapper.queryListBySpuId(spuId);
		goods.setSpu(spu);
		goods.setSkuList(skuList);
		return goods;
	}

}
