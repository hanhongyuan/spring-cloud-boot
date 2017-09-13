package com.example.sbmp.service;

import com.example.sbmp.entity.BizUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface IBizUserService extends IService<BizUser> {
	List<BizUser> findUserAndScoreById();
}
