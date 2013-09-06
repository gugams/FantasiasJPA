package br.com.model.persistencia;

import br.com.model.negocio.Fantasias;
import br.com.model.persistencia.dao.FantasiasDAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gustavo_monteiro
 */
public class FantasiasDAOImpl extends DAOImpl<Fantasias, Integer> implements FantasiasDAO {

     public List<Fantasias> getByNome (String nome){
        return getEntityManager().createQuery("select m from Fantasias m where m.Nome like '%" + nome + "%'").getResultList();
    }
     
      public Fantasias getFantasiasByNome(String nome) {
        Query q = getEntityManager().createQuery("select m from Fantasias m where m.Nome like '%" + nome + "%'", Fantasias.class);
        List<Fantasias> fantasias = q.getResultList();
        Fantasias ma = new Fantasias();
        for (Fantasias m : fantasias) {
            ma = m;
        }
        return ma;

    }

    @Override
    public List<Fantasias> getByNomeTamanhoSexoValores(String nome, String Tamanho, String Sexo, double Valores) {
        return getEntityManager().createQuery("select a from Fantasias m where m.nome like"
                + " '%" + nome + "%' or m.Tamanho like '%" + Tamanho + "%'or m.Sexo like'%" + Sexo + "%'or m.valores like'%" + Valores +"%'").getResultList();
    }

    @Override
    public Fantasias getFantasiasByNomeTamanhoSexoValores(String nome, String Tamanho, String Sexo, double Valores) {
         Query q = getEntityManager().createQuery("select m from Fantasias m where m.nome like '" + nome + "'and m.Tamanho like'" + Tamanho +
                 "'and m.Sexo like'" + Sexo + "'and m.Valores like" + Valores +"'", Fantasias.class);
        List<Fantasias> fantasias = q.getResultList();
        Fantasias ma = new Fantasias();
        for (Fantasias m : fantasias) {
            ma = m;
        }
        return ma;
    }

}

 