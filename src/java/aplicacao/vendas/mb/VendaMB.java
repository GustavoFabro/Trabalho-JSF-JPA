package aplicacao.vendas.mb;

import aplicacao.vendas.model.Produto;
import aplicacao.vendas.model.Venda;
import java.time.LocalDate;
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
    
    public VendaMB(){
        venda = new Venda();
        listaVendas = new ArrayList<>();
    }
        
    public void salvarVenda() {
        this.venda.setData(LocalDate.now());
        this.venda.setProduto(new Produto());
        
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
