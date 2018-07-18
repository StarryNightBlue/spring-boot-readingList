/**
 * @author StarryNight
 * @date 2018年5月2日 
 */
package com.think.springbootreadingList.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author StarryNight
 * @data 2018年5月2日 上午9:44:28
 */
@Entity
public class Reader implements UserDetails {

	private static final long serialVersionUID = -7547593991988260801L;

	@Id
	private String username;
	private String fullname;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {// 授予READER 权限
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}

	@Override
	public boolean isAccountNonExpired() {//不过期
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {//不加锁
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {//不禁用
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
