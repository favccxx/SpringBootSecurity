package com.favccxx.security.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.favccxx.security.constants.SysConstants;

@Entity
public class SysRole implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;

	private String roleCode;

	private String roleName;
	
	/**
	 * 角色状态
	 */
	private int roleStatus = SysConstants.STATUS_NORMAL;
	
	private String createUsername;
	
	private Date createTime;
	
	private String updateUsername;
	
	private Date updateTime;

	@ManyToMany(targetEntity = SysResource.class, fetch = FetchType.EAGER)
	@JoinTable(name = "SysRoleResource", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
			@JoinColumn(name = "resourceId") })
	private Set<SysResource> resources = new HashSet<SysResource>();

	
//	@ManyToMany(targetEntity = SysUser.class, mappedBy = "roles")
//    private Set<SysUser> users = new HashSet<SysUser>();
 
    @ManyToMany(targetEntity = SysGroup.class, mappedBy = "roles")
    private Set<SysGroup> userGroups = new HashSet<SysGroup>();
	
	
//	@ManyToMany(mappedBy="roleList")
//	@JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
//			@JoinColumn(name = "uid") })
//	private List<SysUser> userList;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	public int getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(int roleStatus) {
		this.roleStatus = roleStatus;
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

	public Set<SysResource> getResources() {
		return resources;
	}

	public void setResources(Set<SysResource> resources) {
		this.resources = resources;
	}


	public Set<SysGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<SysGroup> userGroups) {
		this.userGroups = userGroups;
	}

	@Override
	public String getAuthority() {
		return roleCode;
	}

	

}
