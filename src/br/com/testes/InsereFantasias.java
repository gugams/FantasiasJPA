/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testes;

import br.com.model.negocio.Fantasias;
import br.com.model.persistencia.dao.FantasiasDAO;
import br.com.model.persistencia.FantasiasDAOImpl;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class InsereFantasias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        Fantasias m = new Fantasias();
        m.setNome("testssse");
        
        FantasiasDAO dao = new FantasiasDAOImpl();
        dao.save(m);
        
//        em.getTransaction().begin();
//        em.persist(m);
//        em.getTransaction().commit();
//        em.close();
        
    }
}
