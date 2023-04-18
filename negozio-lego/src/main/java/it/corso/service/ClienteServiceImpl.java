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
	public void registraCliente(String nome, String cognome, String indirizzo, String cap, String localita, String provincia, String telefono_cellulare, String codice_fiscale, String email) {
		
		//Si possono migliore con controlli per l'inserimento
		Cliente cliente = new Cliente();
		if (nome.length() <101) cliente.setNome(nome);
		if (cognome.length() <101)  cliente.setCognome(cognome);
		if (indirizzo.length() <101) cliente.setIndirizzo(indirizzo);
		if (cap.length() < 6) cliente.setCap(cap);
		if (localita.length() < 51) cliente.setLocalita(localita);
		if (provincia.length() <3) cliente.setProvincia(provincia);
		if (telefono_cellulare.length() < 31) cliente.setTelefono_cellulare(telefono_cellulare);
		if (codice_fiscale.length() < 17) cliente.setCodice_fiscale(codice_fiscale);
		if (email.length() < 51) cliente.setEmail(email);
		
		
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
