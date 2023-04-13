package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.ClienteDao;
import it.corso.model.Cliente;

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public void registraCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);

	}

	@Override
	public Cliente getClienteById(int id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).get();
	}

	@Override
	public List<Cliente> getClienti() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void cancellaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.delete(cliente);

	}

}
