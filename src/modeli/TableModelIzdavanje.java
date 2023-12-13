/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzdavanja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelIzdavanje extends AbstractTableModel{
    
    ArrayList<StavkaIzdavanja> listaStavki;
    String[] kolone = {"redni broj","Knjiga"};

    public TableModelIzdavanje() {
        listaStavki = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaIzdavanja stavka = listaStavki.get(rowIndex);
        switch(columnIndex){
            case 0:
                return stavka.getRedniBroj();
            case 1:
                return stavka.getKnjiga();
            default:
                return "greska";
        }
    }
    
    public void dodajStavku(StavkaIzdavanja stavka){
        listaStavki.add(stavka);
        fireTableDataChanged();
    }
    
    public void obrisiStavku(int red){
        listaStavki.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<StavkaIzdavanja> getListaStavki() {
        return listaStavki;
    }
    
    public void ocistiTabelu(){
        listaStavki = new ArrayList<>();
        fireTableDataChanged();
    }
    
    public void poredjajRedneBrojeve(){
        int brojac = 1;
        for (StavkaIzdavanja stavkaIzdavanja : listaStavki) {
            stavkaIzdavanja.setRedniBroj(brojac++);
        }
    }
    
}
