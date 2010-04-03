package bookshelf.model.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends BaseModelImpl{

	private static final long serialVersionUID = -8909977119953563629L;

	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToOne(targetEntity = Role.class, optional = false)
	private Role role;

	public User(){
		
	}
	
	public User(String login, String password){
		
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
