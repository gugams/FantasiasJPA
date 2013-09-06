

package br.com.controller;

import br.com.model.negocio.Fantasias;
import br.com.model.persistencia.FantasiasDAOImpl;
import br.com.model.persistencia.dao.FantasiasDAO;
import java.util.List;




/**
 *
 * @author Rosicléia Frasson
 */
public class FantasiasController {
    
    
     public boolean salvar(Fantasias fantasia) {
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.save(fantasia);

    }



    public boolean excluir(int id) {
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.remove(Fantasias.class, id);

    }
    
    public List<Fantasias> listarFantasias() {
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.getAll(Fantasias.class);
    }
    
    public Fantasias listarFantasiasById (int id){
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.getById(Fantasias.class, id);
    }
    
   public List<Fantasias> listarFantasiassByNome (String nome){
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.getByNome(nome);
    }
     
   public Fantasias listarFantasiasByNome (String nome){
       FantasiasDAO dao = new FantasiasDAOImpl();
       return dao.getFantasiasByNome(nome);
   }

     public List<Fantasias> listarFantasiassByNomeTamanhoSexoValores (String nome, String Tamanho,
           String Sexo, double Valores ){
        FantasiasDAO dao = new FantasiasDAOImpl();
        return dao.getByNomeTamanhoSexoValores (nome, Tamanho, Sexo, Valores);
    }      

}
