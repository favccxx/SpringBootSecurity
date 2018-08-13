package com.favccxx.security.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.favccxx.security.constants.SysConstants;

@Entity
public class SysGroup implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long groupId;
	
	
	private String groupCode;
	
	
	private String groupName;
	
	
	private int groupStatus = SysConstants.STATUS_NORMAL;
	
	
	private String description;
	
	
	private String createUsername;
	
	private Date createTime;
	
	private String updateUsername;
	
	private Date updateTime;
	
	
//	@ManyToMany
//	@JoinTable(name = "SysGroupUser", joinColumns = { @JoinColumn(name = "groupId") }, inverseJoinColumns ={@JoinColumn(name = "userId") })
	
	
	@ManyToMany(targetEntity = SysUser.class, mappedBy = "groups")
	private Set<SysUser> users = new HashSet<SysUser>();
	
	@ManyToMany
	@JoinTable(name = "SysRoleGroup", joinColumns = { @JoinColumn(name = "groupId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
	private Set<SysRole> roles = new HashSet<SysRole>();

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	

	public int getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(int groupStatus) {
		this.groupStatus = groupStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SysUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
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

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	
	
	

}
