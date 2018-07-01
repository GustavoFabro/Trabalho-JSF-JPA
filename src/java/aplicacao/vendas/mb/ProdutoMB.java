package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import aplicacao.vendas.repositorio.ProdutoRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProdutoMB {
    private Produto produto;
    private List<Produto> listaProdutos;
    
    public ProdutoMB(){
        produto = new Produto();
        atualizarLista();
    }
    
    public void atualizarLista() {
        listaProdutos = listarProdutos();
    }
    
    public List<Produto> listarProdutos (){
        return ProdutoRepositorio.getProdutos();
    }
        
    public void salvarProduto() {
        ProdutoRepositorio.salvar(this.produto); 

        this.produto = new Produto();
    }
    
    public void removerProduto(Produto produto) {               
        ProdutoRepositorio.excluir(produto);
        atualizarLista();
    }
    
    public String editarItem(Produto produto) {
        this.produto = produto;
                
        return "cadastro_produto.xhtml";
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
