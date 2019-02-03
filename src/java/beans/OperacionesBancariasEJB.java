/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import pojo.CuentasBancarias;
import pojo.Historial;
import pojo.Operaciones;
import pojo.Propietarios;

/**
 *
 * @author Paco
 */
@Stateless
public class OperacionesBancariasEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    
    public List verOperaciones() {
        return emf.createEntityManager().createNamedQuery("Operaciones.findAll").getResultList();
    }
    
    public Operaciones verOperacion(int id) {
         Query q = emf.createEntityManager().createNamedQuery("Operaciones.findByIDOperacion");
    
        q.setParameter("iDOperacion", id);
        Operaciones op = (Operaciones) q.getSingleResult();
        
        return op;
    }
   // from Operaciones as opes where opes.fechaHora in (select histo.fechaHora from Historial as histo where histo.tipoEvento = 'R')
    public List operacionesNumerosRojos() {
        return emf.createEntityManager().createQuery("FROM Operaciones o WHERE o.fechahora in (select h.fechaHora from Historial h where h.tipoEvento = 'R') ").getResultList();
    }
    
    public List rankingNumRojos() {
        return emf.createEntityManager().createQuery("SELECT m FROM CuentasBancarias m WHERE m.saldo < 0 ORDER BY m.saldo").getResultList();
    }
    
    public Historial verFechaLogin(String fecha) {
        Query q = emf.createEntityManager().createNamedQuery("Historial.findByFechaHora");
        q.setParameter("fechaHora", fecha);
        Historial login = (Historial) q.getSingleResult();
        
        return login;
    }
    
    public List verMiRanking() {
        return emf.createEntityManager().createQuery("SELECT c FROM CuentasBancarias c ORDER BY c.saldo desc").getResultList();
    }
    
    public List verOperaciones(String dni) {
        Query q = emf.createEntityManager().createNamedQuery("CuentasBancarias.findByDni");
        q.setParameter("dni", dni);
        CuentasBancarias cuent = (CuentasBancarias) q.getSingleResult();
        
       Query q2 = emf.createEntityManager().createNamedQuery("Operaciones.findByNumCuenta");
            q2.setParameter("numCuenta", cuent.getNumeroCuenta());

            return q2.getResultList();
    }
    
        public boolean insertarCuenta(CuentasBancarias a, Propietarios b) {
 
            EntityManager em = emf.createEntityManager();
            em.persist(a);
            em.persist(b);
            em.flush(); 
            em.close();
            return true;     
        }
        
       public boolean verificarExistencia(String dni, String clave, String fecha) {
        
        try{   
            
        Query q = emf.createEntityManager().createNamedQuery("Propietarios.findByDniNumeroSecreto");
        q.setParameter("dni", dni);
        q.setParameter("numeroSecreto", clave);
         
        if((Propietarios) q.getSingleResult()==null){
             return false;
        }
        else{  
            
           Query q2 = emf.createEntityManager().createNamedQuery("CuentasBancarias.findByDni");
        q2.setParameter("dni", dni);
        CuentasBancarias cuent = (CuentasBancarias) q2.getSingleResult();
            
         EntityManager em = emf.createEntityManager();
        
            Historial h = new Historial("L",fecha,cuent.getNumeroCuenta());
            
            em.persist(h);
            em.flush();
            
             return true;
        }
        
       }catch(Exception ex){
         return false;
    }
       
    }
       
       
       public void updateCuenta(String dni,String nombre, String primerApellido, String segundoApellido) {
        try{
        EntityManager em = emf.createEntityManager();
        Propietarios aux = em.find(Propietarios.class, dni);
        
        aux.setNombre(nombre);
        aux.setPrimerApellido(primerApellido);
        aux.setSegundoApellido(segundoApellido);
        
        em.persist(aux);
        em.flush();
        em.close();
        }
        catch(Exception ex){
            
        }
        
    }
       
       
       
       public void updateClave(String dni,String clave) {
        try{
        EntityManager em = emf.createEntityManager();
        Propietarios aux = em.find(Propietarios.class, dni);
        
        aux.setNumeroSecreto(clave);

        em.persist(aux);
        em.flush();
        em.close();
        }
        catch(Exception ex){
            
        }
        
    }
       
       
       public void hacerOperacion(String dni,int cantidad, String operacion) {
        try{
            boolean bulean = false;
            int saldo=0;
            
            //saca el numeroCuenta
            
        Query q = emf.createEntityManager().createNamedQuery("CuentasBancarias.findByDni");
        q.setParameter("dni", dni);
        CuentasBancarias cuent = (CuentasBancarias) q.getSingleResult();
            
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now2 = LocalDateTime.now();
           String fecha=  dt.format(now2).toString();
        
           //crea la operacion y el historial
           
           Operaciones opera = new Operaciones(fecha, cuent.getNumeroCuenta(),operacion,cantidad);
           
            EntityManager em = emf.createEntityManager();
            em.persist(opera);
            em.flush(); 
           
            Historial h = new Historial(operacion.toUpperCase(),fecha, cuent.getNumeroCuenta());
            
            em.persist(h);
            em.flush();
            
            if(operacion.equals("e")){
                   saldo = cuent.getSaldo() - cantidad;
               }
               else{
                   saldo = cuent.getSaldo() + cantidad;                     
               }
            
            if(cuent.getSaldo()>0&&saldo<0){
           bulean =true;
       }
            
            if(bulean){
               Historial h2 = new Historial("R",fecha, cuent.getNumeroCuenta());
            
            em.persist(h2);
            em.flush(); 
            }
            
         //actualiza el saldo   
            
        CuentasBancarias aux = em.find(CuentasBancarias.class, dni);
        
        aux.setSaldo(saldo);

        em.persist(aux);
        em.flush();
        em.close();
                
        }catch(Exception ex){
            
        }
    }
       
       
        public String eliminarCuenta(String dni) {
           String mensaje="";
            try{
        EntityManager em = emf.createEntityManager();
        Propietarios aux = em.find(Propietarios.class, dni);
        if (aux != null) {
            em.remove(aux);
        }
        
        CuentasBancarias aux2 = em.find(CuentasBancarias.class, dni);
        if (aux2 != null) {
            em.remove(aux2);
            em.close();    
        }
        
        }
        catch(Exception ex){
                mensaje = ex.getMessage();
        }
        return mensaje;
    }
       
        
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
