/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "VOZACI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VozacEnt.findAll", query = "SELECT v FROM VozacEnt v")
    , @NamedQuery(name = "VozacEnt.findByIDVozac", query = "SELECT v FROM VozacEnt v WHERE v.iDVozac = :iDVozac")
    , @NamedQuery(name = "VozacEnt.findByIme", query = "SELECT v FROM VozacEnt v WHERE v.ime = :ime")
    , @NamedQuery(name = "VozacEnt.findByPrezime", query = "SELECT v FROM VozacEnt v WHERE v.prezime = :prezime")
    , @NamedQuery(name = "VozacEnt.findByMobitel", query = "SELECT v FROM VozacEnt v WHERE v.mobitel = :mobitel")
    , @NamedQuery(name = "VozacEnt.findByVozackaDozvola", query = "SELECT v FROM VozacEnt v WHERE v.vozackaDozvola = :vozackaDozvola")
    , @NamedQuery(name = "VozacEnt.findByVozacStatus", query = "SELECT v FROM VozacEnt v WHERE v.vozacStatus = :vozacStatus")})
public class VozacEnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVozac")
    private Integer iDVozac;
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "Prezime")
    private String prezime;
    @Column(name = "Mobitel")
    private String mobitel;
    @Basic(optional = false)
    @Column(name = "VozackaDozvola")
    private String vozackaDozvola;
    @Column(name = "VozacStatus")
    private Integer vozacStatus;
    @OneToMany(mappedBy = "vozacID")
    private List<PutniNalogEnt> putniNalogEntList;

    public VozacEnt() {
    }

    public VozacEnt(Integer iDVozac) {
        this.iDVozac = iDVozac;
    }

    public VozacEnt(Integer iDVozac, String ime, String prezime, String vozackaDozvola) {
        this.iDVozac = iDVozac;
        this.ime = ime;
        this.prezime = prezime;
        this.vozackaDozvola = vozackaDozvola;
    }

    public Integer getIDVozac() {
        return iDVozac;
    }

    public void setIDVozac(Integer iDVozac) {
        this.iDVozac = iDVozac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public String getVozackaDozvola() {
        return vozackaDozvola;
    }

    public void setVozackaDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
    }

    public Integer getVozacStatus() {
        return vozacStatus;
    }

    public void setVozacStatus(Integer vozacStatus) {
        this.vozacStatus = vozacStatus;
    }

    @XmlTransient
    public List<PutniNalogEnt> getPutniNalogEntList() {
        return putniNalogEntList;
    }

    public void setPutniNalogEntList(List<PutniNalogEnt> putniNalogEntList) {
        this.putniNalogEntList = putniNalogEntList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVozac != null ? iDVozac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VozacEnt)) {
            return false;
        }
        VozacEnt other = (VozacEnt) object;
        if ((this.iDVozac == null && other.iDVozac != null) || (this.iDVozac != null && !this.iDVozac.equals(other.iDVozac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vozac: "+ime+" "+prezime;
    }
    
}
