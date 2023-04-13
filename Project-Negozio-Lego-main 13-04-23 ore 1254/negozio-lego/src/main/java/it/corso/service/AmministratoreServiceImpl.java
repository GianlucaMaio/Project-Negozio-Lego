package it.corso.service;

import it.corso.model.Amministratore;
import jakarta.servlet.http.HttpSession;

public class AmministratoreServiceImpl implements AmministratoreService {

    /*final String USERNAME_REGISTRATO = "admin";
    final String PASSWORD_REGISTRATO = "admin";*/
	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) {
		  /*final String USERNAME_REGISTRATO = "admin";
        final String PASSWORD_REGISTRATO = "admin";*/
        //controllo login 
        if(username.equalsIgnoreCase(username) && password.contentEquals(password))
        {
            Amministratore amministratore = new Amministratore();
            amministratore.setUsername(username);
            amministratore.setPassword(password);
            session.setAttribute("amministratore", amministratore); 
            return true; 
        }
    return false;
	}

}
