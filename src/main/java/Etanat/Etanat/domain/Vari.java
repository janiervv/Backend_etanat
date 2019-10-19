package Etanat.Etanat.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vari {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long variid;
	private String vari;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "variid")
	private List<Vari> varit;
	
	public Vari() {}
	
	public Vari(String vari) {
		super();
		this.vari = vari;
	}

	public Long getVariid() {
		return variid;
	}

	public void setVariid(Long variid) {
		this.variid = variid;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public List<Vari> getVarit() {
		return varit;
	}

	public void setVarit(List<Vari> varit) {
		this.varit = varit;
	}
	
}