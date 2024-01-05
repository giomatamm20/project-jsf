/**
 * 
 */
package com.giomata.projectjsf.controllers;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author giomata
 * clase que permite el funcionamiento con la pantalla login
 */
@ManagedBean
public class Logincrontroler {
	private String usuario;
	
	private String password;
	
	public void ingresar()
	{
		System.out.println("Usuario: " + usuario);
		if(usuario.equals("giomata") && password.equals("1234")) {
			try {
				this.redireccion("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_FATAL,"La pagina no existe","")  );
				e.printStackTrace();
			}
		}
		else {
			FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario y/o Contraseña incorrecta","")  );
		}
	
		}
	private void redireccion(String pagina) throws IOException  {
	
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
