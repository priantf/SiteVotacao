package model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "municipio")
public class Municipio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipio")
    private Integer idMunicipio;
	
    @Column(name = "nome")
    private String nome;
    
    @JoinColumn(name = "uf", referencedColumnName = "id_uf")
    @ManyToOne
    private UF uf;
    
    @OneToMany(mappedBy = "municipio")
    private List<Eleitor> eleitorList;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @XmlTransient
    public List<Eleitor> getEleitorList() {
        return eleitorList;
    }

    public void setEleitorList(List<Eleitor> eleitorList) {
        this.eleitorList = eleitorList;
    }
}
