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

	public void add(Admin admin) {
		String password = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
		admin.setPassword(password);
		this.adminMapper.insertSelective(admin);
	}
}
