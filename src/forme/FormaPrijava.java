/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Bibliotekar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nikola
 */
public class FormaPrijava extends javax.swing.JFrame {

    /**
     * Creates new form FormaPrijava
     */
    public FormaPrijava() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();
        txtLozinka = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prijava na sistem");

        jLabel1.setText("Korisnicko ime:");

        jLabel2.setText("Lozinka: ");

        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrijava)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorisnickoIme)
                            .addComponent(txtLozinka, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPrijava)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        String korisnickoIme = txtKorisnickoIme.getText();
        String lozinka = String.valueOf(txtLozinka.getPassword());
        Bibliotekar b = new Bibliotekar();
        b.setKorisnickoIme(korisnickoIme);
        b.setLozinka(lozinka);
//        Bibliotekar bibliotekar = login(korisnickoIme,lozinka);
        Bibliotekar bibliotekar;
        try {
            bibliotekar = login(b);
            if (bibliotekar != null) {
            new GlavnaForma(bibliotekar).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "neuspesna prijava");
        }
        } catch (Exception ex) {
            
            Logger.getLogger(FormaPrijava.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (bibliotekar != null) {
//            new GlavnaForma(bibliotekar).setVisible(true);
//            this.dispose();
//        } else {
//            JOptionPane.showMessageDialog(this, "neuspesna prijava");
//        }
    }//GEN-LAST:event_btnPrijavaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables

//    private Bibliotekar login(String korisnickoIme, String lozinka) {
//        KlijentskiZahtev kz = new KlijentskiZahtev();
//        kz.setOperacija(Operacije.LOGIN);
//        String[] parametri = {korisnickoIme, lozinka};
//        kz.setParametar(parametri);
//        komunikacija.KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstance().primiOdgovor();
//        Bibliotekar bibliotekar = (Bibliotekar) so.getOdgovor();
//        return bibliotekar;
//    }
    
    private Bibliotekar login(Bibliotekar b) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.LOGIN);
        //String[] parametri = {korisnickoIme, lozinka};
        kz.setParametar(b);
        komunikacija.KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstance().primiOdgovor();
//        Bibliotekar bibliotekar = (Bibliotekar) so.getOdgovor();
//        return bibliotekar;
        if(so.getException()==null){
            return (Bibliotekar) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }
}
