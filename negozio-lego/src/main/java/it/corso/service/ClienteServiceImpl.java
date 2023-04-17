package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ClienteDao;
import it.corso.model.Cliente;
import jakarta.servlet.http.HttpSession;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public void registraCliente(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	public Cliente getClienteById(int id) {
		
		return clienteDao.findById(id).get();
	}

	@Override
	public List<Cliente> getClienti() {

		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void cancellaCliente(Cliente cliente) {
		clienteDao.delete(cliente);

	}
	
	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) {
		
		Cliente cliente = clienteDao.findByProfiloUsernameAndProfiloPassword(username, password);
		
		//controllo login 
		if(cliente != null) {
			session.setAttribute("cliente", cliente);
			return true;
		}
		
		return false;
		
	}
	
	@Override
    public boolean controlloCreazioneAccount(String username, HttpSession session) {

        Cliente cliente = clienteDao.findByProfiloUsername(username);

        //controllo se username già esistente
        if(cliente == null) {
        	clienteDao.save(cliente);
            session.setAttribute("cliente", cliente);
            return true;
        }

        return false;
    }

}
