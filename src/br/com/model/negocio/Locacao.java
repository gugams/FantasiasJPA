/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.negocio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author gustavo_monteiro
 */
@Entity
public class Locacao implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    private int codigo;
    
    
      @ManyToOne()
    @JoinColumn(name = "idFantasia", referencedColumnName = "id")
    private Fantasias fantasia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

 

    public Fantasias getFantasia() {
        return fantasia;
    }

    public void setFantasia(Fantasias fantasia) {
        this.fantasia = fantasia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

  
    
      
      
}
