package com.example.sbmp.service.impl;

import com.example.sbmp.entity.BizUser;
import com.example.sbmp.mapper.BizUserMapper;
import com.example.sbmp.service.IBizUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BizUserServiceImpl extends ServiceImpl<BizUserMapper, BizUser> implements IBizUserService {
	@Transactional
	public List<BizUser> findUserAndScoreById() {
		List<BizUser> list = baseMapper.findUserAndScoreById();
		return list;
	}
}
