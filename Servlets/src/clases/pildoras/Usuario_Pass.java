package clases.pildoras;
// Generated 25-jun-2018 17:11:21 by Hibernate Tools 5.2.10.Final

/**
 * Usuario_Pass generated by hbm2java
 */
public class Usuario_Pass implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4819431138723360627L;
	private Integer id;
	private String usuario;
	private String password;

	public Usuario_Pass() {
	}

	public Usuario_Pass(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
