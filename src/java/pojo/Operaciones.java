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
@Table(name = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findByIDOperacion", query = "SELECT o FROM Operaciones o WHERE o.iDOperacion = :iDOperacion")
    , @NamedQuery(name = "Operaciones.findByFechahora", query = "SELECT o FROM Operaciones o WHERE o.fechahora = :fechahora")
    , @NamedQuery(name = "Operaciones.findByNumCuenta", query = "SELECT o FROM Operaciones o WHERE o.numCuenta = :numCuenta")
    , @NamedQuery(name = "Operaciones.findByTipoOperacion", query = "SELECT o FROM Operaciones o WHERE o.tipoOperacion = :tipoOperacion")
    , @NamedQuery(name = "Operaciones.findByCantidad", query = "SELECT o FROM Operaciones o WHERE o.cantidad = :cantidad")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Operacion")
    private Integer iDOperacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Fecha_hora")
    private String fechahora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Num_Cuenta")
    private String numCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tipo_Operacion")
    private String tipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;

    public Operaciones() {
    }

    public Operaciones(Integer iDOperacion) {
        this.iDOperacion = iDOperacion;
    }

    public Operaciones(Integer iDOperacion, String fechahora, String numCuenta, String tipoOperacion, int cantidad) {
        this.iDOperacion = iDOperacion;
        this.fechahora = fechahora;
        this.numCuenta = numCuenta;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
    }

    public Operaciones(String fechahora, String numCuenta, String tipoOperacion, int cantidad) {
        this.fechahora = fechahora;
        this.numCuenta = numCuenta;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
    }
    
    

    public Integer getIDOperacion() {
        return iDOperacion;
    }

    public void setIDOperacion(Integer iDOperacion) {
        this.iDOperacion = iDOperacion;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOperacion != null ? iDOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.iDOperacion == null && other.iDOperacion != null) || (this.iDOperacion != null && !this.iDOperacion.equals(other.iDOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Operaciones[ iDOperacion=" + iDOperacion + " ]";
    }
    
}
