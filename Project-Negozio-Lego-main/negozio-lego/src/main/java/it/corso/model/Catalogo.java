package it.corso.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="catalogo")
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="id_categoria")
	private int id_categoria;
	@Column(name="immagine")
	private String immagine; 
	@Column(name="prezzo")
	private double prezzo;
	
	 @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) 
	    @JoinTable //cosi ci troviamo dentro la tabella 
	    (
	            name = "ordini_prodotti",
	            joinColumns = @JoinColumn(name="id_prodotto", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "id_ordine", referencedColumnName = "id")
	    )
	    private List<Ordine> ordini = new ArrayList<>();
	 
	 //collegare catalogo a categoria
	
	//getters e setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getCategoria() {
		return id_categoria;
	}
	public void setCategoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
