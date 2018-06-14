
import aplicacao.vendas.model.Produto;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Teste {
    public static void main(String[] args) {
        Produto produto = new Produto();
        List<Produto> listaProdutos = new ArrayList<>();
        produto.setCodigo(2);
        
        
        System.out.println(listaProdutos.get(listaProdutos.size()-1).getCodigo());
    }
}
