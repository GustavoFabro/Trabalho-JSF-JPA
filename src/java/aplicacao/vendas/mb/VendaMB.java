package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import aplicacao.vendas.model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class VendaMB {
    private Venda venda;
    private List<Venda> listaVendas;
    private Produto produto;
    
    public VendaMB(){
        venda = new Venda();
        listaVendas = new ArrayList<>();
        produto = new Produto();
    }
        
    public void salvarVenda() {
        if(!this.listaVendas
                .contains(this.venda)) {
     
            this.venda.setCodigo(listaVendas.size() > 0? listaVendas.get(listaVendas.size()-1).getCodigo() + 1 : 1);
            this.listaVendas.add(this.venda);
        }
        
        this.venda = new Venda();
    }
    
    
    
    public void removerVenda(Venda venda) {
        this.listaVendas.remove(venda);
    }

    public Venda getVenda() {
        return venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
}
