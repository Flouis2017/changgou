package com.flouis.changgou.goods.pojo;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Sku {

    private String id;
    private String spuId;
    private String sn;
    private String name;
    private Integer price;
    private Integer num;
    private Integer alertNum;
    private String image;
    private Integer weight;
    private Date createTime;
    private Date updateTime;
    private Long categoryId;
    private String categoryName;
    private String spec;
    private String brandName;
    private Integer saleNum;
    private Integer commentNum;
    private Integer state;
    private String images;

}