/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RotasMB {
    public String openVenda() {
        return "lista_vendas.xhtml?faces-redirect=true";
    }
    
    public String openEstoque() {
        return "lista_produtos.xhtml?faces-redirect=true";
    }
    
    public String openReport() {
        return "relatorio.xhtml?faces-redirect=true";
    }
    
    public String openCadastroProduto() {
        return "cadastro_produto.xhtml?faces-redirect=true";
    }
    
    public String openCadastroVendas() {
        return "cadastro_venda.xhtml?faces-redirect=true";
    }
    
    public String openHome() {
        return "index.xhtml?faces-redirect=true";
    }
}
