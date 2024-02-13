package com.seproject.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "custom_user_table2")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // Other UserDetails fields and methods...

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Define user roles/authorities here if needed
        return Collections.emptyList();
    }



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







	@Override
    public boolean isAccountNonExpired() {
        return true; // Assuming accounts do not expire
    }

    public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
    public boolean isAccountNonLocked() {
        return true; // Assuming accounts are not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials do not expire
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming accounts are enabled
    }

    // Implement other UserDetails methods...
}
