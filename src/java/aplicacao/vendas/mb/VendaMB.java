package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import aplicacao.vendas.model.Venda;
import aplicacao.vendas.repositorio.ProdutoRepositorio;
import aplicacao.vendas.repositorio.VendaRepositorio;
import java.time.LocalDate;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VendaMB {
    private Venda venda;
    private List<Venda> listaVendas;
    private List<Produto> produtos;

    public VendaMB(){
        venda = new Venda();
        produtos = ProdutoRepositorio.getProdutos();
        atualizarLista();
    }
    
    public void atualizarLista() {
        listaVendas = listarVendas();
    }    
    
     public List<Venda> listarVendas (){
        return VendaRepositorio.getVendas();
    }
        
    
    public void salvarVenda() {
        this.venda.setData(LocalDate.now());
        VendaRepositorio.salvar(this.venda); 
        ProdutoRepositorio.debitarEstoque(this.venda.getProduto(), this.venda.getQuantidade());
        
        this.venda = new Venda();
    }
    
    public void removerVenda(Venda venda) {
        this.listaVendas.remove(venda);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
