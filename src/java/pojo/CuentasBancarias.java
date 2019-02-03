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
@Table(name = "cuentas_bancarias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasBancarias.findAll", query = "SELECT c FROM CuentasBancarias c")
    , @NamedQuery(name = "CuentasBancarias.findByIDCuentaBancaria", query = "SELECT c FROM CuentasBancarias c WHERE c.iDCuentaBancaria = :iDCuentaBancaria")
    , @NamedQuery(name = "CuentasBancarias.findByNumeroCuenta", query = "SELECT c FROM CuentasBancarias c WHERE c.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "CuentasBancarias.findByPropietario", query = "SELECT c FROM CuentasBancarias c WHERE c.propietario = :propietario")
    , @NamedQuery(name = "CuentasBancarias.findBySaldo", query = "SELECT c FROM CuentasBancarias c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "CuentasBancarias.findByDni", query = "SELECT c FROM CuentasBancarias c WHERE c.dni = :dni")})
public class CuentasBancarias implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Cuenta_Bancaria")
    private Integer iDCuentaBancaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Numero_Cuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Propietario")
    private String propietario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldo")
    private int saldo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI")
    private String dni;

    public CuentasBancarias() {
    }

    public CuentasBancarias(Integer iDCuentaBancaria) {
        this.iDCuentaBancaria = iDCuentaBancaria;
    }

    public CuentasBancarias(Integer iDCuentaBancaria, String numeroCuenta, String propietario, int saldo, String dni) {
        this.iDCuentaBancaria = iDCuentaBancaria;
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldo;
        this.dni = dni;
    }

    public CuentasBancarias(String numeroCuenta, String propietario, int saldo, String dni) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldo;
        this.dni = dni;
    }
    
    

    public Integer getIDCuentaBancaria() {
        return iDCuentaBancaria;
    }

    public void setIDCuentaBancaria(Integer iDCuentaBancaria) {
        this.iDCuentaBancaria = iDCuentaBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCuentaBancaria != null ? iDCuentaBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasBancarias)) {
            return false;
        }
        CuentasBancarias other = (CuentasBancarias) object;
        if ((this.iDCuentaBancaria == null && other.iDCuentaBancaria != null) || (this.iDCuentaBancaria != null && !this.iDCuentaBancaria.equals(other.iDCuentaBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.CuentasBancarias[ iDCuentaBancaria=" + iDCuentaBancaria + " ]";
    }
    
}
