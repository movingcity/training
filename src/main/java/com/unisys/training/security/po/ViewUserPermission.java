/**
 * 
 */
package com.unisys.training.security.po;

import java.io.Serializable;

/**
 * @author LiuJ2
 *
 */
public class ViewUserPermission implements Serializable {
	/**
	 * default UID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String username;
    private Boolean locked;
    private String permission;
    private Boolean available;
    private String description;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ViewUserPermission [id=" + id + ", username=" + username + ", locked=" + locked + ", permission="
				+ permission + ", available=" + available + ", description=" + description + "]";
	}
	
	public ViewUserPermission(Long id, String username, Boolean locked, String permission, Boolean available,
			String description) {
		super();
		this.id = id;
		this.username = username;
		this.locked = locked;
		this.permission = permission;
		this.available = available;
		this.description = description;
	}
}
