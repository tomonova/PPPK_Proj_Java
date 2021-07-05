/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GRADOVI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradEnt.findAll", query = "SELECT g FROM GradEnt g")
    , @NamedQuery(name = "GradEnt.findByIDGrad", query = "SELECT g FROM GradEnt g WHERE g.iDGrad = :iDGrad")
    , @NamedQuery(name = "GradEnt.findByIme", query = "SELECT g FROM GradEnt g WHERE g.ime = :ime")
    , @NamedQuery(name = "GradEnt.findByLatitutde", query = "SELECT g FROM GradEnt g WHERE g.latitutde = :latitutde")
    , @NamedQuery(name = "GradEnt.findByLongitude", query = "SELECT g FROM GradEnt g WHERE g.longitude = :longitude")})
public class GradEnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDGrad")
    private Integer iDGrad;
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Latitutde")
    private BigDecimal latitutde;
    @Basic(optional = false)
    @Column(name = "Longitude")
    private BigDecimal longitude;
    @OneToMany(mappedBy = "mjestoStartID")
    private List<PutniNalogEnt> putniNalogEntList;
    @OneToMany(mappedBy = "mjestoCiljID")
    private List<PutniNalogEnt> putniNalogEntList1;
    @JoinColumn(name = "DrzavaID", referencedColumnName = "IDDrzava")
    @ManyToOne(optional = false)
    private DrzavEnt drzavaID;

    public GradEnt() {
    }

    public GradEnt(Integer iDGrad) {
        this.iDGrad = iDGrad;
    }

    public GradEnt(Integer iDGrad, String ime, BigDecimal latitutde, BigDecimal longitude) {
        this.iDGrad = iDGrad;
        this.ime = ime;
        this.latitutde = latitutde;
        this.longitude = longitude;
    }

    public Integer getIDGrad() {
        return iDGrad;
    }

    public void setIDGrad(Integer iDGrad) {
        this.iDGrad = iDGrad;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public BigDecimal getLatitutde() {
        return latitutde;
    }

    public void setLatitutde(BigDecimal latitutde) {
        this.latitutde = latitutde;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public List<PutniNalogEnt> getPutniNalogEntList() {
        return putniNalogEntList;
    }

    public void setPutniNalogEntList(List<PutniNalogEnt> putniNalogEntList) {
        this.putniNalogEntList = putniNalogEntList;
    }

    @XmlTransient
    public List<PutniNalogEnt> getPutniNalogEntList1() {
        return putniNalogEntList1;
    }

    public void setPutniNalogEntList1(List<PutniNalogEnt> putniNalogEntList1) {
        this.putniNalogEntList1 = putniNalogEntList1;
    }

    public DrzavEnt getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(DrzavEnt drzavaID) {
        this.drzavaID = drzavaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGrad != null ? iDGrad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradEnt)) {
            return false;
        }
        GradEnt other = (GradEnt) object;
        if ((this.iDGrad == null && other.iDGrad != null) || (this.iDGrad != null && !this.iDGrad.equals(other.iDGrad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime;
    }
    
}
