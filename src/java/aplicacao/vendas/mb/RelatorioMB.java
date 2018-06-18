/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao.vendas.mb;

import aplicacao.vendas.model.Venda;
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
    @ManagedProperty("#{vendaMB}")
    private VendaMB vendaMb; // +setter (no getter!)    
     
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
        LocalDate localDateIni = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dataIni) );
        LocalDate localDateFim = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dataFim) );
            
        vendasPeriodo = vendaMb.getListaVendas().stream()
                .filter(p -> p.getData().isAfter(localDateIni.minusDays(1)) 
                          && p.getData().isBefore(localDateFim.plusDays(1)))
                .collect(Collectors.toList()); 
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

    public void setVendaMb(VendaMB vendaMb) {
        this.vendaMb = vendaMb;
    }   
}
