

package br.com.model.persistencia.dao;

import br.com.model.negocio.Fantasias;
import java.util.List;

/**
 *
 * @author gustavo_monteiro
 */
public interface FantasiasDAO extends DAO<Fantasias, Integer>{
      
    List<Fantasias> getByNome (String nome);
    Fantasias getFantasiasByNome(String nome);
    
    List<Fantasias> getByNomeTamanhoSexoValores (String nome, String Tamanho,
            String Sexo, double Valores);
    
    Fantasias getFantasiasByNomeTamanhoSexoValores(String nome, String Tamanho,
            String Sexo, double Valores);
}
