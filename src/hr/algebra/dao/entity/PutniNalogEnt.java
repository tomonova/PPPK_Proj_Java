/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.entity;

import hr.algebra.model.enums.PutniNalogStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TomoNova
 */
@Entity
@Table(name = "PUTNI_NALOZI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PutniNalogEnt.findAll", query = "SELECT p FROM PutniNalogEnt p")
    , @NamedQuery(name = "PutniNalogEnt.findByIDNalog", query = "SELECT p FROM PutniNalogEnt p WHERE p.iDNalog = :iDNalog")
    , @NamedQuery(name = "PutniNalogEnt.findByOtvaranje", query = "SELECT p FROM PutniNalogEnt p WHERE p.otvaranje = :otvaranje")
    , @NamedQuery(name = "PutniNalogEnt.findByZatvaranje", query = "SELECT p FROM PutniNalogEnt p WHERE p.zatvaranje = :zatvaranje")
    , @NamedQuery(name = "PutniNalogEnt.findByStatusNaloga", query = "SELECT p FROM PutniNalogEnt p WHERE p.statusNaloga = :statusNaloga")})
public class PutniNalogEnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDNalog")
    private Integer iDNalog;
    @Column(name = "Otvaranje")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otvaranje;
    @Column(name = "Zatvaranje")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zatvaranje;
    @Column(name = "StatusNaloga")
    private Integer statusNaloga;
    @JoinColumn(name = "MjestoStartID", referencedColumnName = "IDGrad")
    @ManyToOne
    private GradEnt mjestoStartID;
    @JoinColumn(name = "MjestoCiljID", referencedColumnName = "IDGrad")
    @ManyToOne
    private GradEnt mjestoCiljID;
    @JoinColumn(name = "VozacID", referencedColumnName = "IDVozac")
    @ManyToOne
    private VozacEnt vozacID;
    @JoinColumn(name = "VoziloID", referencedColumnName = "IDVozilo")
    @ManyToOne
    private VoziloEnt voziloID;

    public PutniNalogEnt() {
    }

    public PutniNalogEnt(Integer iDNalog) {
        this.iDNalog = iDNalog;
    }

    public Integer getIDNalog() {
        return iDNalog;
    }
    public Date getOtvaranje() {
        return otvaranje;
    }

    public void setOtvaranje(Date otvaranje) {
        this.otvaranje = otvaranje;
    }

    public Date getZatvaranje() {
        return zatvaranje;
    }

    public void setZatvaranje(Date zatvaranje) {
        this.zatvaranje = zatvaranje;
    }

    public Integer getStatusNaloga() {
        return statusNaloga;
    }

    public GradEnt getMjestoStartID() {
        return mjestoStartID;
    }

    public void setMjestoStartID(GradEnt mjestoStartID) {
        this.mjestoStartID = mjestoStartID;
    }

    public GradEnt getMjestoCiljID() {
        return mjestoCiljID;
    }

    public void setMjestoCiljID(GradEnt mjestoCiljID) {
        this.mjestoCiljID = mjestoCiljID;
    }

    public VozacEnt getVozacID() {
        return vozacID;
    }

    public void setVozacID(VozacEnt vozacID) {
        this.vozacID = vozacID;
    }

    public VoziloEnt getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(VoziloEnt voziloID) {
        this.voziloID = voziloID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDNalog != null ? iDNalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PutniNalogEnt)) {
            return false;
        }
        PutniNalogEnt other = (PutniNalogEnt) object;
        if ((this.iDNalog == null && other.iDNalog != null) || (this.iDNalog != null && !this.iDNalog.equals(other.iDNalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: "+iDNalog+
                " | STATUS: "+PutniNalogStatus.values()[(statusNaloga-1)] +
                " | Polazište: "+mjestoStartID+
                " | Odredište:"+mjestoCiljID+
                " | "+vozacID+
                " | "+voziloID;
    }
    
}
