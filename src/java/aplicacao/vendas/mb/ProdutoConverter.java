/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.mb;


import aplicacao.vendas.model.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@SessionScoped
public class ProdutoConverter implements Converter {
    @ManagedProperty("#{produtoMB}")
    private ProdutoMB produtoMb;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value == null) {
            return null;
        }
                    
        return produtoMb.getProdutoByName(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null) {
            return "";
        }
        if(o instanceof String) {
            return (String) o;
        }
        
        Produto produto = (Produto) o;
        return produto.getDescricao();
    }

    public void setProdutoMb(ProdutoMB produtoMb) {
        this.produtoMb = produtoMb;
    }
    
}