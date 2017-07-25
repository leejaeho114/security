package com.ktcu.member.model;

import com.ktcu.login.domain.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by LG on 2017-07-24.
 */
public class UserVo {

	public static UserVo getUserVo() {
		LoginUser user = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUserVo();
	}

	public UserVo() {}

	public UserVo(String id, String password, int loginFailCnt, boolean isTobeUser) {
		this.id = id;
		this.password = password;
		this.loginFailCnt = loginFailCnt;
		this.isTobeUser = isTobeUser;
	}

	public UserVo getTobeUserVo(){
		return new UserVo("leejaeho114", "1234", 0, true);
	}

	public UserVo getTobeUserFailCountVo(){
		return new UserVo("leejaeho114", "1234", 5, true);
	}

	public UserVo getAsisUserVo(){
		return new UserVo("leejaeho114", "1234", 0, false);
	}

	public UserVo getAsisUserFailCountVo(){
		return new UserVo("leejaeho114", "1234", 5, false);
	}

	private String id;
	private String password;
	private String name = "jaeho";
	private String phone = "010-1111-2222";
	private String birth = "1988-11-11";
	private int age = 30;
	private int loginFailCnt;
	private boolean isTobeUser;
	private String asisId;
	private String chaptcha;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLoginFailCnt() {
		return loginFailCnt;
	}

	public void setLoginFailCnt(int loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}

	public String getAsisId() {
		return asisId;
	}

	public void setAsisId(String asisId) {
		this.asisId = asisId;
	}

	public boolean isTobeUser() {
		return isTobeUser;
	}

	public void setTobeUser(boolean tobeUser) {
		isTobeUser = tobeUser;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getChaptcha() {
		return chaptcha;
	}

	public void setChaptcha(String chaptcha) {
		this.chaptcha = chaptcha;
	}
}
