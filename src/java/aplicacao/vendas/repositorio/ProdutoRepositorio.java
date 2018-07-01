/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.repositorio;

import aplicacao.vendas.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author gustavo
 */
public class ProdutoRepositorio {
    public static void salvar(Produto produto) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(produto);
        t.commit();
    }

    public static void excluir(Produto produto) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Produto.class, produto.getCodigo()));
        t.commit();
    }

    public static Produto getProduto(Integer codigo) {
        EntityManager em = JPA.getEM();
        /*TypedQuery<Produto> query = em.createQuery("select x from Produto x where x.codigo = :cod", Produto.class);
        query.setParameter("cod", codigo);
        return query.getSingleResult();*/
        return em.find(Produto.class, codigo);
    }
    
    public static List<Produto> getProdutos() {
        EntityManager em = JPA.getEM();
        
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }
        
    public static Produto getProduto(String valor) {
        EntityManager em = JPA.getEM();
        TypedQuery<Produto> query = em.createQuery("select x from Produto x where x.descricao like :valor", Produto.class);
        query.setParameter("valor", "%" + valor + "%");
        
        return query.getResultList().get(0);
    }
    
    public static void debitarEstoque(Produto produto, int quantidade) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        em.merge(produto);
        
        
        t.commit();
    }
}
