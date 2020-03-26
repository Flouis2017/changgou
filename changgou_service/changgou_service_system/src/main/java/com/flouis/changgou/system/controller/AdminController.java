package com.flouis.changgou.system.controller;

import com.flouis.changgou.common.entity.Result;
import com.flouis.changgou.system.pojo.Admin;
import com.flouis.changgou.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

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
			e.printStackTrace();
			return Result.fail();
		}
	}

	@GetMapping("/login")
	public Result login(Admin admin){
		return Result.success();
	}

}
