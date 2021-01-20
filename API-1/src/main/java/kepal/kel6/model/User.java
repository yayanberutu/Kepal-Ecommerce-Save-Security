package kepal.kel6.model;
import java.util.*;

import javax.persistence.*;

import lombok.*;


@Entity
@Setter @Getter @NoArgsConstructor
@Table(name = "t_user", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
public class User {
    	private static final long OTP_VALID_DURATION = 1 * 60 * 1000;   // 1 menit
    
	 @Id
	 @Column(name = "user_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 
	 private String username;
	 
	 private String password;
	 
	 private String salt;
	 
	 private String email;
	 
	 private String one_time_password;
	 
	 private Date otp_requested_time;
	 
	 private boolean enabled;
	     
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(
			 name = "users_roles",
			 joinColumns = @JoinColumn(name = "user_id"),
			 inverseJoinColumns = @JoinColumn(name = "role_id")
			 )
	 private Set<Role> roles = new HashSet<>();

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getOne_time_password() {
		return one_time_password;
	}

	public void setOne_time_password(String one_time_password) {
		this.one_time_password = one_time_password;
	}

	public Date getOtp_requested_time() {
		return otp_requested_time;
	}

	public void setOtp_requested_time(Date otp_requested_time) {
		this.otp_requested_time = otp_requested_time;
	}

	public boolean isOTPRequired() {
		if (this.getOne_time_password() == null) {
			return false;
		}
		
		long currentTimeInMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = this.otp_requested_time.getTime();
	         
		if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
			return false;
		}
	         
	        return true;
	}
	
	
	
}
