/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TomoNova
 */
@Entity
@Table(name = "DRZAVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrzavEnt.findAll", query = "SELECT d FROM DrzavEnt d")
    , @NamedQuery(name = "DrzavEnt.findByIDDrzava", query = "SELECT d FROM DrzavEnt d WHERE d.iDDrzava = :iDDrzava")
    , @NamedQuery(name = "DrzavEnt.findByNaziv", query = "SELECT d FROM DrzavEnt d WHERE d.naziv = :naziv")})
public class DrzavEnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDDrzava")
    private Integer iDDrzava;
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drzavaID")
    private List<GradEnt> gradEntList;

    public DrzavEnt() {
    }

    public DrzavEnt(Integer iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    public Integer getIDDrzava() {
        return iDDrzava;
    }

    public void setIDDrzava(Integer iDDrzava) {
        this.iDDrzava = iDDrzava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<GradEnt> getGradEntList() {
        return gradEntList;
    }

    public void setGradEntList(List<GradEnt> gradEntList) {
        this.gradEntList = gradEntList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDrzava != null ? iDDrzava.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrzavEnt)) {
            return false;
        }
        DrzavEnt other = (DrzavEnt) object;
        if ((this.iDDrzava == null && other.iDDrzava != null) || (this.iDDrzava != null && !this.iDDrzava.equals(other.iDDrzava))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.algebra.dao.entity.DrzavEnt[ iDDrzava=" + iDDrzava + " ]";
    }
    
}
