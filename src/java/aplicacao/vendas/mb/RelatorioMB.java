/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.mb;

import aplicacao.vendas.model.Venda;
import aplicacao.vendas.repositorio.VendaRepositorio;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RelatorioMB {  
    private List<Venda> vendasPeriodo;   
    private Date dataIni;
    private Date dataFim; 
    
    public RelatorioMB () {
        vendasPeriodo = new ArrayList<>();    
        dataIni = new Date();
        dataFim = new Date();
    }

    public List<Venda> getVendasPeriodo() {
        return vendasPeriodo;
    }

    public void setVendasPeriodo(List<Venda> vendasPeriodo) {
        this.vendasPeriodo = vendasPeriodo;
    }
    
    public void emitirRelatorio() {       
        LocalDate dateIni = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dataIni) );
        LocalDate dateFim = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dataFim) );
            
        vendasPeriodo = VendaRepositorio.getVendas(dateIni, dateFim);
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    } 
}
