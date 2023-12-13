/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.pomocna.Pretraga;
import java.util.ArrayList;
import modeli.TableModelPretragaIzdavanja;

/**
 *
 * @author Nikola
 */
public class FormaPretrazenaIzdavanjaPoKnjizi extends javax.swing.JDialog {

    ArrayList<Pretraga> listaPretraga;
    
    /**
     * Creates new form FormaPretrazenaIzdavanjaPoKnjizi
     */
    public FormaPretrazenaIzdavanjaPoKnjizi(java.awt.Frame parent, boolean modal,ArrayList<Pretraga> listaPretraga) {
        super(parent, modal);
        
        initComponents();
        setLocationRelativeTo(null);
        this.listaPretraga=listaPretraga;
        postaviNaslov();
        postaviModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIzdavanja = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("nesto");

        tblIzdavanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIzdavanja);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(lblNaslov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JTable tblIzdavanja;
    // End of variables declaration//GEN-END:variables

    private void postaviModel() {
        TableModelPretragaIzdavanja tmpi = new TableModelPretragaIzdavanja(listaPretraga);
        tblIzdavanja.setModel(tmpi);
    }

    private void postaviNaslov() {
       lblNaslov.setText("Pretraga izdavanja za knjigu: "+listaPretraga.get(0).getKnjiga());
    }
}