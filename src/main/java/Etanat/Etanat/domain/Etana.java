package Etanat.Etanat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Etana {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@NotNull
	private long id;


	@Size(min=2, message = "Liian lyhyt")
	@Size (max=30, message = "Liian pitkä")
    private String laji;
    
	@Size(min=2, message = "Liian lyhyt")
	@Size (max=30, message = "Liian pitkä")
    private String latina;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;
    
	private double pituus;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "variid")
    private Vari vari;

	public Etana () {}
	
	public Etana(String laji, String latina, double pituus, Vari vari) {
		super();
		this.laji = laji;
		this.latina = latina;
		this.pituus = pituus;
		this.vari = vari;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLaji() {
		return laji;
	}
	public void setLaji(String laji) {
		this.laji = laji;
	}
	public String getLatina() {
		return latina;
	}
	public void setLatina(String latina) {
		this.latina = latina;
	}
	public double getPituus() {
		return pituus;
	}
	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public Vari getVari() {
		return vari;
	}

	public void setVari(Vari vari) {
		this.vari = vari;
	}


}
