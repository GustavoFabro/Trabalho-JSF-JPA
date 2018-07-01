/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Produto")
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    private Integer codigo;
    private String descricao;
    private String cor;
    private String tamanho;
    private Integer quantidade;
    private String publico;
    private float valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getCodigo());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) obj;
        return Objects.equals(getCodigo(), produto.getCodigo());
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }
    
    public void debitaEstoque(int quantidade) {
        this.quantidade -= quantidade;
    }
}