package com.flouis.changgou.system.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Admin implements Serializable {

    private Long id;
    private String loginName;
    private String password;
    private Integer state;

}