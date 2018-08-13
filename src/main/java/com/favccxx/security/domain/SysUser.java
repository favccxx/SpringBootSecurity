package com.favccxx.security.domain;


import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.favccxx.security.constants.SysConstants;

@Entity
public class SysUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long userId;
	
	private String username;
	
	private String password;
	
	private String nickName;
		
	private int userStatus = SysConstants.STATUS_NORMAL;

	private Date birthday;


	private String userMail;


	private String userTel;


	private String salt;


	private String description;

	private String createUsername;
	
	private Date createTime;
	
	private String updateUsername;
	
	private Date updateTime;
	
//	@ManyToMany(targetEntity = SysUserGroup.class, mappedBy = "users")
	
	@ManyToMany(cascade= {CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinTable(name = "SysGroupUser", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "groupId") })
    private Set<SysGroup> groups = new HashSet<SysGroup>();
	
//	@ManyToMany(cascade= {CascadeType.REFRESH}, fetch=FetchType.EAGER)
//	@JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
//	private Set<SysRole> roles = new HashSet<SysRole>();
	
	@Transient
    private Set<SysRole> authorities = new HashSet<SysRole>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SysGroup> grps = this.getGroups();
		for(SysGroup group : grps) {
			Set<SysRole> roles = group.getRoles();
			authorities.addAll(roles);
			return authorities;
		}
		
		return null;
		
		
//		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
//		Set<SysRole> roleList = this.getRoles();
//		if(roleList!=null && roleList.size()>0) {
//			for(SysRole role : roleList) {
//				auths.add(new SimpleGrantedAuthority(role.getRoleName()));
//				
//			}
//		}
//		return auths;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	



	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUsername() {
		return updateUsername;
	}

	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Set<SysGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<SysGroup> groups) {
		this.groups = groups;
	}

	public void setAuthorities(Set<SysRole> authorities) {
		this.authorities = authorities;
	}
	
	
	

}
