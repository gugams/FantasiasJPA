package br.com.model.persistencia;

import br.com.model.negocio.Locacao;
import br.com.model.persistencia.dao.LocacaoDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author gustavo_monteiro
 */
public class LocacaoDAOImpl extends DAOImpl<Locacao, Integer> implements LocacaoDAO {

     public List<Locacao> getByDescricao (String descricao){
        return getEntityManager().createQuery("select m from Locacao m where m.descricao like '%" + descricao + "%'").getResultList();
    }
     
      public Locacao getLocacaoByDescricaoCodigo(String descricao, int codigo) {
        Query q = getEntityManager().createQuery("select m from Locacao m where m.descricao like '" + descricao + ""
                + "select m from Locacao m where m.codigo like'" + codigo + "'", Locacao.class);
        List<Locacao> modelos = q.getResultList();
        for (Locacao m : modelos) {
            return m;
        }
        return null;

    }

  

   

 

   

    

 
   
}
