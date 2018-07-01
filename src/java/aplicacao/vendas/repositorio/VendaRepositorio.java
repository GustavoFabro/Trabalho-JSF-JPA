/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.repositorio;

import aplicacao.vendas.model.Venda;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author gustavo
 */
public class VendaRepositorio {
    public static void salvar(Venda venda) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(venda);
        t.commit();
    }

    public static void excluir(Venda venda) {
        EntityManager em = JPA.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Venda.class, venda.getCodigo()));
        t.commit();
    }

    public static Venda getVenda(Integer codigo) {
        EntityManager em = JPA.getEM();
        /*TypedQuery<Venda> query = em.createQuery("select x from Venda x where x.codigo = :cod", Venda.class);
        query.setParameter("cod", codigo);
        return query.getSingleResult();*/
        return em.find(Venda.class, codigo);
    }
    
    public static List<Venda> getVendas() {
        EntityManager em = JPA.getEM();
        
        return em.createQuery("select v from Venda v", Venda.class).getResultList();
    }
    
    public static List<Venda> getVendas(LocalDate dateIni, LocalDate dateFim) {
        EntityManager em = JPA.getEM();
        TypedQuery<Venda> query = em.createQuery("select x from Venda x where x.data between :dataIni and :dataFim", Venda.class);
       
        query.setParameter("dataIni", dateIni);
        query.setParameter("dataFim", dateFim);
        
        return query.getResultList();
    }
        
    public static List<Venda> getVendas(String valor) {
        EntityManager em = JPA.getEM();
        TypedQuery<Venda> query = em.createQuery("select x from Venda x where x.descricao like :valor", Venda.class);
        query.setParameter("valor", "%" + valor + "%");
        return query.getResultList();
    }
}
