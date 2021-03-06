package com.example.sbmp.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.List;

@TableName("biz_user")
public class BizUser extends Model<BizUser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField(value = "username")
	private String username;
	@TableField(value = "password")
	private String password;
	@TableField(exist = false)
	private List<BizScore> scoreList;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BizScore> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<BizScore> scoreList) {
		this.scoreList = scoreList;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "BizUser{" +
			"id=" + id +
			", username=" + username +
			", password=" + password +
			"}";
	}
}
