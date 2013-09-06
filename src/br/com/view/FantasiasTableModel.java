package br.com.view;

import br.com.model.negocio.Fantasias;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo_monteiro
 */
public class FantasiasTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_SEXO = 2;
    private static final int COL_TAMANHO = 3;
    private static final int COL_VALORES = 4;
    private List<Fantasias> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Id", "Nome", "Tamanho","Sexo", "Valores"};

    //Cria uma FantasiasTableModel sem nenhuma linha
    public FantasiasTableModel() {
        linhas = new ArrayList<Fantasias>();
    }

    //Cria uma FantasiasTableModel contendo a lista recebida por parâmetro.
    public FantasiasTableModel(List<Fantasias> marcas) {
        this.linhas = new ArrayList<Fantasias>(marcas);
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
        }
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega a marca da linha
        Fantasias m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        }else if (column == COL_SEXO) {
            return m.getSexo();
        }else if (column == COL_TAMANHO) {
            return m.getTamanho();
        }else if (column == COL_VALORES) {
            return m.getValores();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Fantasias u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            u.setNome(aValue.toString());
        } else if (column == COL_SEXO) {
            u.setSexo(aValue.toString());
        } else if (column == COL_TAMANHO) {
            u.setTamanho(aValue.toString());
        } else if (column == COL_VALORES) {
            u.setValores((Integer) aValue);
        }

    }

    // Retorna a marca referente a linha especificada
    public Fantasias getFantasias(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


// Adiciona a marca especificada ao modelo
    public void addFantasias(Fantasias fantasia) {
        // Adiciona o registro.
        linhas.add(fantasia);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        ordenarPorNome();

    }
    
        public void updateFantasias(int indiceLinha, Fantasias fantasia) {
            linhas.set(indiceLinha, fantasia);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorNome();
    }
    
    //Remove o sócio da linha especificada.
    public void removeFantasias(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        ordenarPorNome();
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
    
    public void ordenarPorNome() {
        //ordena pelo nome
        Collections.sort(linhas, new Comparator<Fantasias>() {

            public int compare(Fantasias o1, Fantasias o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}
