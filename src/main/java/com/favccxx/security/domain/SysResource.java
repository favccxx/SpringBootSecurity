package com.favccxx.security.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SysResource implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long resourceId;
	
	/**
	 * 资源代码
	 */
	private String resourceCode;
	
	/**
	 * 资源名称，默认同代码
	 */
	private String resourceName;
	
	/**
	 * 父类资源Id
	 */
	private long parentId;
	
	/**
	 * 资源类型：菜单/按钮
	 */
	private String resourceType;
	
	/**
	 * 资源样式表
	 */
	private String resourceCss;
	
	/**
	 * 状态：是否禁用
	 */
	private boolean disabled = false;
	
	
	/**
	 * 显示顺序
	 */
	private int resourceOrder;
	
	/**
	 * 访问地址
	 */
	private String url;
	
	/**
	 * 备注
	 */
	private String description;
	
	
	private String createUsername;
	
	private Date createTime;
	
	private String updateUsername;
	
	private Date updateTime;
	
	
//	@ManyToMany
//	@JoinTable(name = "SysRoleResource", joinColumns = { @JoinColumn(name = "resourceId") }, inverseJoinColumns = {
//			@JoinColumn(name = "roleId") })
	
	@ManyToMany(mappedBy="resources")
	private List<SysRole> roles;

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceCss() {
		return resourceCss;
	}

	public void setResourceCss(String resourceCss) {
		this.resourceCss = resourceCss;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(int resourceOrder) {
		this.resourceOrder = resourceOrder;
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

	
	
}
