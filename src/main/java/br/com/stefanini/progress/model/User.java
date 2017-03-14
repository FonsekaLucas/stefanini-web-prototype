package br.com.stefanini.progress.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "tb_cad_login")
public class User implements Serializable {	

	private static final long serialVersionUID = -841261025172084734L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cd_id_login")
	private int idLogin;
	
	@Column(name = "fd_username")
	private String userName;

	@Column(name = "fd_nickname")
	private String nickname;
	
	@Column(name = "fd_email")
	private String email;

	@Length(min = 6, message = "*Sua senha deve conter, no mínimo, 6 caracteres!")
	@Column(name = "fd_password")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_asso_user_profile", joinColumns = @JoinColumn(name = "cd_id_login"), inverseJoinColumns = @JoinColumn(name = "fd_profile"))
	private Set<Profile> profiles;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
}