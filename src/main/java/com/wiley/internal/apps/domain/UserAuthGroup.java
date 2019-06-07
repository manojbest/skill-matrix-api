package com.wiley.internal.apps.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="AUTH_USER_GROUP")
public class UserAuthGroup {
	
	@Id
    @Column(name="AUTH_USER_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="AUTH_GROUP")
    private String authGroup;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
    
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
    
    @Override
	public String toString() {
		return "UserAuthGroup [id=" + id + ", username=" + username + ", authGroup=" + authGroup + "]";
	}
    
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
