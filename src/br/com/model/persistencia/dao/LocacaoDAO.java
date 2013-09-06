

package br.com.model.persistencia.dao;

import br.com.model.negocio.Locacao;
import java.util.List;

/**
 *
 * @author Rosicléia Frasson
 */
public interface LocacaoDAO extends DAO<Locacao, Integer>{
      
    List<Locacao> getByDescricao (String descricao);
    Locacao getLocacaoByDescricaoCodigo(String descricao, int codigo);

    
}
