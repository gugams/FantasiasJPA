

package br.com.controller;

import br.com.model.negocio.Locacao;
import br.com.model.persistencia.LocacaoDAOImpl;
import br.com.model.persistencia.dao.LocacaoDAO;
import java.util.List;




/**
 *
 * @author gustavo_monteiro
 */
public class LocacaoController {
    
    
     public boolean salvar(Locacao locacao) {
        LocacaoDAO dao = new LocacaoDAOImpl();
        return dao.save(locacao);

    }



    public boolean excluir(int id) {
        LocacaoDAO dao = new LocacaoDAOImpl();
        return dao.remove(Locacao.class, id);

    }
    
    public List<Locacao> listarLocacao() {
        LocacaoDAO dao = new LocacaoDAOImpl();
        return dao.getAll(Locacao.class);
    }
    
    public Locacao listarLocacaoById (int id){
        LocacaoDAO dao = new LocacaoDAOImpl();
        return dao.getById(Locacao.class, id);
    }
    
   public List<Locacao> listarLocacaosByDescricao (String descricao){
        LocacaoDAO dao = new LocacaoDAOImpl();
        return dao.getByDescricao(descricao);
    }
     
   public Locacao listarLocacaoByDescricaoCodigo(String descricao,int codigo){
       LocacaoDAO dao = new LocacaoDAOImpl();
       return dao.getLocacaoByDescricaoCodigo(descricao, codigo);
   }
        

}
