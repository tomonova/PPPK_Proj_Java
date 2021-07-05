/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TomoNova
 */
@Entity
@Table(name = "VOZILA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoziloEnt.findAll", query = "SELECT v FROM VoziloEnt v")
    , @NamedQuery(name = "VoziloEnt.findByIDVozilo", query = "SELECT v FROM VoziloEnt v WHERE v.iDVozilo = :iDVozilo")
    , @NamedQuery(name = "VoziloEnt.findByMarka", query = "SELECT v FROM VoziloEnt v WHERE v.marka = :marka")
    , @NamedQuery(name = "VoziloEnt.findByTip", query = "SELECT v FROM VoziloEnt v WHERE v.tip = :tip")
    , @NamedQuery(name = "VoziloEnt.findByGodinaProizvodnje", query = "SELECT v FROM VoziloEnt v WHERE v.godinaProizvodnje = :godinaProizvodnje")
    , @NamedQuery(name = "VoziloEnt.findByGodinaUnosa", query = "SELECT v FROM VoziloEnt v WHERE v.godinaUnosa = :godinaUnosa")
    , @NamedQuery(name = "VoziloEnt.findByInicijalniKM", query = "SELECT v FROM VoziloEnt v WHERE v.inicijalniKM = :inicijalniKM")})
public class VoziloEnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVozilo")
    private Integer iDVozilo;
    @Basic(optional = false)
    @Column(name = "Marka")
    private String marka;
    @Basic(optional = false)
    @Column(name = "Tip")
    private String tip;
    @Basic(optional = false)
    @Column(name = "GodinaProizvodnje")
    @Temporal(TemporalType.DATE)
    private Date godinaProizvodnje;
    @Basic(optional = false)
    @Column(name = "GodinaUnosa")
    @Temporal(TemporalType.DATE)
    private Date godinaUnosa;
    @Basic(optional = false)
    @Column(name = "InicijalniKM")
    private int inicijalniKM;
    @OneToMany(mappedBy = "voziloID")
    private List<PutniNalogEnt> putniNalogEntList;

    public VoziloEnt() {
    }

    public VoziloEnt(Integer iDVozilo) {
        this.iDVozilo = iDVozilo;
    }

    public VoziloEnt(Integer iDVozilo, String marka, String tip, Date godinaProizvodnje, Date godinaUnosa, int inicijalniKM) {
        this.iDVozilo = iDVozilo;
        this.marka = marka;
        this.tip = tip;
        this.godinaProizvodnje = godinaProizvodnje;
        this.godinaUnosa = godinaUnosa;
        this.inicijalniKM = inicijalniKM;
    }

    public Integer getIDVozilo() {
        return iDVozilo;
    }

    public void setIDVozilo(Integer iDVozilo) {
        this.iDVozilo = iDVozilo;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Date godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public Date getGodinaUnosa() {
        return godinaUnosa;
    }

    public void setGodinaUnosa(Date godinaUnosa) {
        this.godinaUnosa = godinaUnosa;
    }

    public int getInicijalniKM() {
        return inicijalniKM;
    }

    public void setInicijalniKM(int inicijalniKM) {
        this.inicijalniKM = inicijalniKM;
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
        hash += (iDVozilo != null ? iDVozilo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoziloEnt)) {
            return false;
        }
        VoziloEnt other = (VoziloEnt) object;
        if ((this.iDVozilo == null && other.iDVozilo != null) || (this.iDVozilo != null && !this.iDVozilo.equals(other.iDVozilo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vozilo: "+marka+" "+tip;
    }
    
}
