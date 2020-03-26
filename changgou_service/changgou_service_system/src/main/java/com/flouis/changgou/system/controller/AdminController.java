package com.flouis.changgou.system.controller;

import com.flouis.changgou.common.entity.Result;
import com.flouis.changgou.common.entity.ResultCode;
import com.flouis.changgou.system.pojo.Admin;
import com.flouis.changgou.system.service.AdminService;
import com.flouis.changgou.system.util.JwtUtil;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@GetMapping
	public Result findAll(){
		try {
			List<Admin> all = this.adminService.findAll();
			return Result.success(all);
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}

	@PostMapping
	public Result add(@RequestBody Admin admin){
		try {
			this.adminService.add(admin);
			return Result.success();
		} catch (Exception e){
//			e.printStackTrace();
			logger.error(e.getMessage());
			System.out.println();
			return Result.fail(ResultCode.REACT_ERROR.getCode(), e.getMessage());
		}
	}

	@PostMapping("/login")
	public Result login(@RequestBody Admin admin){
		try {
			// 根据用户名查询记录
			Admin record = this.adminService.findOneByLoginName(admin.getLoginName());
			if (record == null){
				return Result.fail("用户不存在！");
			}
			if (record.getState() != 1){
				return Result.fail(ResultCode.STATE_ERROR.getCode(), ResultCode.STATE_ERROR.getDescription());
			}
			// 密码校验
			if (!BCrypt.checkpw(admin.getPassword(), record.getPassword())){
				return Result.fail(ResultCode.LOGIN_ERROR.getCode(), ResultCode.LOGIN_ERROR.getDescription());
			}
			// 用户登录成功 则 签发JWT，前端可缓存token
			Map<String, String> info = Maps.newHashMap();
			info.put("loginName", admin.getLoginName());
			String token = JwtUtil.createJWT(UUID.randomUUID().toString(), admin.getLoginName(), null);
			info.put("token", token);
			info.put("timeExpire", String.valueOf(JwtUtil.JWT_TTL/1000));
			return Result.success("登录成功", info);
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail();
		}
	}

}
