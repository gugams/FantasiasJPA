/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.model.negocio.Locacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo_monteiro
 */
public class LocacaoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_DESCRICAO = 1;
    private static final int COL_CODIGO = 2;
   
    private List<Locacao> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Descriçao", "Codigo"};

    public LocacaoTableModel() {
        linhas = new ArrayList<Locacao>();
    }

    //Cria uma LocacaoTableModel contendo a lista recebida por parâmetro.
    public LocacaoTableModel(List<Locacao> modelos) {
        this.linhas = new ArrayList<Locacao>(modelos);
    }

    public int getRowCount() {
        return linhas.size();
    }

    /*
     * Retorna a quantidade de colunas
     * 2 colunas: uma para id e a outra para nome.
     */
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        //Qual a classe das nossas colunas? A coluna 1 é inteira, as outras string.  
        if (columnIndex == COL_ID) {
            return Integer.class;
        }else if (columnIndex == COL_DESCRICAO ){
            return String.class;
        }else if (columnIndex == COL_CODIGO){
            return int.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega a marca da linha
        Locacao m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_DESCRICAO) {
            return m.getDescricao();
        } else if (column == COL_CODIGO){
            return m.getCodigo();
        }
            
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Locacao u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_DESCRICAO) {
            u.setDescricao(aValue.toString());
        } else if (column == COL_CODIGO) {
            u.setCodigo((Integer) aValue);
        } 
    }

    // Retorna a marca referente a linha especificada
    public Locacao getLocacao(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


// Adiciona a marca especificada ao modelo
    public void addLocacao(Locacao marca) {
        // Adiciona o registro.
        linhas.add(marca);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        ordenarPorDescricao();

    }
    
        public void updateLocacao(int indiceLinha, Locacao marca) {
            linhas.set(indiceLinha, marca);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }
    
    //Remove o sócio da linha especificada.
    public void removeLocacao(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
    
    public void ordenarPorDescricao() {
        //ordena pelo nome
        Collections.sort(linhas, new Comparator<Locacao>() {

            public int compare(Locacao o1, Locacao o2) {
                return o1.getDescricao().compareTo(o2.getDescricao());
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
    
}
