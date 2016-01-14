package io.hedwig.satasamples.cassandra;


import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Sample user class.
 * 
 * @author Oliver Gierke
 * @author Thomas Darimont
 */
@Table(value = "users")
public class User {

	@PrimaryKey("user_id") private Long id;

	@Column("uname") private String username;
	@Column("fname") private String firstname;
	@Column("lname") private String lastname;

	public User(Long id) {
		this.setId(id);
	}

	public User() {
		this.setId(id);
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
