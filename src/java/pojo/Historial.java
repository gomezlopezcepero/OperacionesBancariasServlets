/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paco
 */
@Entity
@Table(name = "historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h")
    , @NamedQuery(name = "Historial.findByIDHistorial", query = "SELECT h FROM Historial h WHERE h.iDHistorial = :iDHistorial")
    , @NamedQuery(name = "Historial.findByTipoEvento", query = "SELECT h FROM Historial h WHERE h.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "Historial.findByFechaHora", query = "SELECT h FROM Historial h WHERE h.fechaHora = :fechaHora")
    , @NamedQuery(name = "Historial.findByNumeroCuenta", query = "SELECT h FROM Historial h WHERE h.numeroCuenta = :numeroCuenta")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Historial")
    private Integer iDHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Tipo_Evento")
    private String tipoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Fecha_Hora")
    private String fechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Numero_Cuenta")
    private String numeroCuenta;

    public Historial() {
    }

    public Historial(Integer iDHistorial) {
        this.iDHistorial = iDHistorial;
    }

    public Historial(Integer iDHistorial, String tipoEvento, String fechaHora, String numeroCuenta) {
        this.iDHistorial = iDHistorial;
        this.tipoEvento = tipoEvento;
        this.fechaHora = fechaHora;
        this.numeroCuenta = numeroCuenta;
    }

    public Historial(String tipoEvento, String fechaHora, String numeroCuenta) {
        this.tipoEvento = tipoEvento;
        this.fechaHora = fechaHora;
        this.numeroCuenta = numeroCuenta;
    }

    
    
    public Integer getIDHistorial() {
        return iDHistorial;
    }

    public void setIDHistorial(Integer iDHistorial) {
        this.iDHistorial = iDHistorial;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDHistorial != null ? iDHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.iDHistorial == null && other.iDHistorial != null) || (this.iDHistorial != null && !this.iDHistorial.equals(other.iDHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Historial[ iDHistorial=" + iDHistorial + " ]";
    }
    
}
