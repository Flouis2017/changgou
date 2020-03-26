package com.flouis.changgou.system.service;

import com.flouis.changgou.system.dao.AdminMapper;
import com.flouis.changgou.system.pojo.Admin;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

	@Resource
	private AdminMapper adminMapper;

	public List<Admin> findAll() {
		return this.adminMapper.findAll();
	}

	public void add(Admin admin) throws Exception {
		// 用户名唯一校验：
		Admin record = this.adminMapper.findOneByLoginName(admin.getLoginName());
		if (record != null){
			throw new Exception("用户名不可重复！");
		}
		String password = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
		admin.setPassword(password);
		this.adminMapper.insertSelective(admin);
	}

	public Admin findOneByLoginName(String loginName){
		return this.adminMapper.findOneByLoginName(loginName);
	}

}
