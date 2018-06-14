package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoMB {
    private Produto produto;
    private List<Produto> listaProdutos;

    public ProdutoMB(){
        produto = new Produto();
        listaProdutos = new ArrayList<>();
    }
        
    public void salvarProduto() {
        if(!this.listaProdutos
                .contains(this.produto)) {
     
            this.produto.setCodigo(listaProdutos.size() > 0? listaProdutos.get(listaProdutos.size()-1).getCodigo() + 1 : 1);
            this.listaProdutos.add(this.produto);
        }
        
        this.produto = new Produto();
    }
    
    public void removerProduto(Produto produto) {
        this.listaProdutos.remove(produto);
    }
    
    public String editarItem(Produto produto) {
        this.produto = produto;
                
        return "cadastro_produto.xhtml?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
