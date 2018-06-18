package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    
    public Produto getProdutoByName(String name) {
        Produto produto = new Produto();
        
        for (Produto p : listaProdutos) {
            if (p.getDescricao().equals(name)) {
                produto = p;
            }
        }
        
        return produto;
    }
    
    public void debitarEstoque(int quantidade, int codigoProduto) {
        this.listaProdutos.stream()
                .filter(p -> p.getCodigo() == codigoProduto)
                .collect(Collectors.toList()).get(0).debitaEstoque(quantidade); 
    }
}
