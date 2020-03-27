package com.flouis.changgou.goods.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spu {

    private String id;
    private String sn;
    private String name;
    private String caption;
    private Long brandId;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;
    private Long templateId;
    private Long freightId;
    private String image;
    private String saleService;
    private String specItems;
    private String paramItems;
    private Integer commentNum;
    private Integer isEnableSpec;
    private Integer state;
    private String images;
    private String introduction;

}