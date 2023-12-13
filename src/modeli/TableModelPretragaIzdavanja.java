/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.pomocna.Pretraga;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelPretragaIzdavanja extends AbstractTableModel {

    ArrayList<Pretraga> lista;
    String[] kolone = {"Datum izdavanja", "Knjiga", "Član", "Izdao bibliotekar"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public TableModelPretragaIzdavanja(ArrayList<Pretraga> lista) {
        this.lista = lista;
    }

    public TableModelPretragaIzdavanja() {
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
        Pretraga p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sdf.format(p.getDatum());
            case 1:
                return p.getKnjiga();
            case 2:
                return p.getClan();
            case 3:
                return p.getBibliotekar();
            default:
                return "greska";
        }
    }

}
