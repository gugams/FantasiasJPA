/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.negocio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author gustavo_monteiro
 */
@Entity
public class Fantasias implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String Tamanho;
    private String Sexo;
    private double Valores;
    private String Nome;
    
    public Fantasias(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public double getValores() {
        return Valores;
    }

    public void setValores(double Valores) {
        this.Valores = Valores;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

   
    
    
    
    
    
}
