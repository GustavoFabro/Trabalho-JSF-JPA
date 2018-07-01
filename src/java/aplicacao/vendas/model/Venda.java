package aplicacao.vendas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Venda")
@Table(name = "venda")
public class Venda implements Serializable{
    @Id
    private Integer codigo;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto")
    private Produto produto;
    private Integer quantidade;
    private LocalDate data;
     
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        if(!(obj instanceof Venda)) {
            return false;
        }
        Venda venda = (Venda) obj;
        return Objects.equals(getCodigo(), venda.getCodigo());
    }
    
}
