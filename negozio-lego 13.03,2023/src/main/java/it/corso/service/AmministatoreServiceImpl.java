package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.AmministratoreDao;
import it.corso.model.Amministratore;

import jakarta.servlet.http.HttpSession;

public class AmministatoreServiceImpl implements AmministratoreService {

	@Autowired
	private AmministratoreDao amministratoreDao;
	
	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) {
		
		Amministratore amministratore = amministratoreDao.findByUsernameAndPassword(username, password);

		//controllo login 
		if(amministratore != null)
		{
			session.setAttribute("amministratore", amministratore); 
			return true; 
		}
		
		return false;
	}	
}
