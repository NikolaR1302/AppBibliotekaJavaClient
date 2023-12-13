/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaIzdavanja;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelStavkeIzdavanja extends AbstractTableModel{

    ArrayList<StavkaIzdavanja> lista;
    String[] kolone = {"Datum izdavanja", "Knjiga", "Član", "Izdao bibliotekar"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public TableModelStavkeIzdavanja() {
    }

    public TableModelStavkeIzdavanja(ArrayList<StavkaIzdavanja> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
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
        StavkaIzdavanja stavka = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return sdf.format(stavka.getIzdavanje().getDatum());
            case 1:
                return stavka.getKnjiga().getNaziv();
            case 2:
                String imePrezime= stavka.getIzdavanje().getClan().getIme() +" " +stavka.getIzdavanje().getClan().getPrezime();
                return imePrezime;
            case 3:
                String bibliotekar = stavka.getIzdavanje().getBibliotekar().getIme()+" "+stavka.getIzdavanje().getBibliotekar().getPrezime();
                return bibliotekar;
            default:
                return "greska";
        }
    }
    
}
