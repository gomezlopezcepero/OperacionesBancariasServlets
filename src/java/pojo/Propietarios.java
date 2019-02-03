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
@Table(name = "propietarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietarios.findAll", query = "SELECT p FROM Propietarios p")
    , @NamedQuery(name = "Propietarios.findByIDPropietario", query = "SELECT p FROM Propietarios p WHERE p.iDPropietario = :iDPropietario")
    , @NamedQuery(name = "Propietarios.findByDni", query = "SELECT p FROM Propietarios p WHERE p.dni = :dni")
    , @NamedQuery(name = "Propietarios.findByDniNumeroSecreto", query = "SELECT p FROM Propietarios p WHERE p.dni = :dni and p.numeroSecreto = :numeroSecreto")
    , @NamedQuery(name = "Propietarios.findByUsuario", query = "SELECT p FROM Propietarios p WHERE p.usuario = :usuario")    
    , @NamedQuery(name = "Propietarios.findByNombre", query = "SELECT p FROM Propietarios p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Propietarios.findByPrimerApellido", query = "SELECT p FROM Propietarios p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Propietarios.findBySegundoApellido", query = "SELECT p FROM Propietarios p WHERE p.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Propietarios.findByNumeroSecreto", query = "SELECT p FROM Propietarios p WHERE p.numeroSecreto = :numeroSecreto")})
public class Propietarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Propietario")
    private Integer iDPropietario;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Primer_Apellido")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Numero_Secreto")
    private String numeroSecreto;

    public Propietarios() {
    }

    public Propietarios(Integer iDPropietario) {
        this.iDPropietario = iDPropietario;
    }

    public Propietarios(Integer iDPropietario, String dni, String usuario, String nombre, String primerApellido, String segundoApellido, String numeroSecreto) {
        this.iDPropietario = iDPropietario;
        this.dni = dni;
        this.usuario = usuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroSecreto = numeroSecreto;
    }

    public Propietarios(String dni, String usuario, String nombre, String primerApellido, String segundoApellido, String numeroSecreto) {
        this.dni = dni;
        this.usuario = usuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroSecreto = numeroSecreto;
    }
    
    
    

    public Integer getIDPropietario() {
        return iDPropietario;
    }

    public void setIDPropietario(Integer iDPropietario) {
        this.iDPropietario = iDPropietario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroSecreto() {
        return numeroSecreto;
    }

    public void setNumeroSecreto(String numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPropietario != null ? iDPropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietarios)) {
            return false;
        }
        Propietarios other = (Propietarios) object;
        if ((this.iDPropietario == null && other.iDPropietario != null) || (this.iDPropietario != null && !this.iDPropietario.equals(other.iDPropietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Propietarios[ iDPropietario=" + iDPropietario + " ]";
    }
    
}
