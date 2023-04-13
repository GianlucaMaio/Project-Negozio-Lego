package it.corso.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import it.corso.dao.OrdineDao;
import it.corso.model.Catalogo;
import it.corso.model.Cliente;
import it.corso.model.Ordine;

public class OrdineServiceImp implements OrdineService {

	@Autowired
	private OrdineDao ordineDao;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CatalogoService catalogoService;
	   
	
	@Override
	public void registraOrdine(Ordine ordine, String data, int idCliente, int[] idProdotti) {
		// TODO Auto-generated method stub
		  try {
	            LocalDate dataOrdine = LocalDate.parse(data);
	            ordine.setData(dataOrdine);
	        } catch (Exception e) {
	            ordine.setData(LocalDate.now()); 
	        }
	        
	        Cliente cliente = clienteService.getClienteById(idCliente);
	        ordine.setCliente(cliente);
	        
	        
	        ordine.getCatalogo().clear();
	        for(int idProdotto : idProdotti) {
	            Catalogo catalogo = catalogoService.getProdottoById(idProdotto);
	            ordine.getCatalogo().add(catalogo);
	        }
	        
	        double importo = 0;
	        for (Catalogo c: ordine.getCatalogo())
	            importo += c.getPrezzo();
	        ordine.setImporto(importo);
	        //registrazione ordine
	        ordineDao.save(ordine);    
		

	}

	@Override
	public Ordine getOrdineById(int id) {
		// TODO Auto-generated method stub
		return ordineDao.findById(id).get();
	}

	@Override
	public List<Ordine> geOrdine() {
		// TODO Auto-generated method stub
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public void cancellaOrdine(Ordine ordine) {
		// TODO Auto-generated method stub
        //rimozione dell'ordine da cancellare dalla lista ordini dal cliente collegato (gli altri oridini restano)
        ordine.getCliente().getOrdini().remove(ordine);
        
        //pulizia lista prodotti dell'ordine da cancellare
        ordine.getCatalogo().clear();
        
        //cancellazione ordine 
        ordineDao.delete(ordine);

	}

}
