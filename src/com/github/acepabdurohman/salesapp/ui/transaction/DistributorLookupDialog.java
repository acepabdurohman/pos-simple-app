package com.github.acepabdurohman.salesapp.ui.transaction;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Distributor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
/*
    Panel lookup untuk setiap data distributor yang akan digunakan pada panel pembelian
*/
public class DistributorLookupDialog extends javax.swing.JDialog {

    private DistributorTableModel distTableModel;
    private Distributor distributor;
    private List<Distributor> listDistributor;
    
    public DistributorLookupDialog() {
        super(Main.getFrame(), true);
        initComponents();
        setLocationRelativeTo(this);
        loadData();
        tblDistributor.getSelectionModel().addListSelectionListener( new DistributorSelectionListener());
    }

    public void loadData(){
        listDistributor = Main.getMasterService().getAllDistributor();
        distTableModel = new DistributorTableModel(listDistributor);
        tblDistributor.setModel(distTableModel);
    }
    
    public Distributor getDistributor(){
        setVisible(true);
        return distributor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDistributor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearchDistributor = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(DistributorLookupDialog.class, "DistributorLookupDialog.title")); // NOI18N

        tblDistributor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDistributor);

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DistributorLookupDialog.class, "DistributorLookupDialog.jLabel1.text")); // NOI18N

        txtSearchDistributor.setText(org.openide.util.NbBundle.getMessage(DistributorLookupDialog.class, "DistributorLookupDialog.txtSearchDistributor.text")); // NOI18N
        txtSearchDistributor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDistributorKeyReleased(evt);
            }
        });

        btnOk.setText(org.openide.util.NbBundle.getMessage(DistributorLookupDialog.class, "DistributorLookupDialog.btnOk.text")); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnBatal.setText(org.openide.util.NbBundle.getMessage(DistributorLookupDialog.class, "DistributorLookupDialog.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if(distributor != null){
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Pilih distributor");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        distributor = null;
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtSearchDistributorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDistributorKeyReleased
        // TODO add your handling code here:
        String nama = txtSearchDistributor.getText();
        if(!txtSearchDistributor.getText().isEmpty()){
            distTableModel = new DistributorTableModel(Main.getMasterService().searchByNama(nama));
            tblDistributor.setModel(distTableModel);

        }
        else{
            loadData();
        }        
    }//GEN-LAST:event_txtSearchDistributorKeyReleased

    private class DistributorSelectionListener implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent evt){
            distributor = listDistributor.get(tblDistributor.getSelectedRow());
            if(tblDistributor.getSelectedRow() >= 0){
                Integer id = Integer.valueOf(distTableModel.getValueAt(tblDistributor.getSelectedRow(), 0).toString());
                distributor.setIdDistributor(id);
                String nama = distTableModel.getValueAt(tblDistributor.getSelectedRow(), 1).toString();
                distributor.setNamaDistributor(nama);
                String noTelp = distTableModel.getValueAt(tblDistributor.getSelectedRow(), 2).toString();
                distributor.setNoTelepon(noTelp);
            }
        }
    }
    
    private class DistributorTableModel extends AbstractTableModel{
    
        private final List<Distributor> DISTRIBUTORS;
        private final String[] KOLOM = {"ID", "Nama Distributor", "Nomor Telepon"};
        
        public DistributorTableModel(List<Distributor> distributors){
            this.DISTRIBUTORS = distributors;
        }
        
        @Override
        public int getRowCount(){
            return DISTRIBUTORS.size();
        }
        
        @Override
        public int getColumnCount(){
            return KOLOM.length;
        }
        
        @Override
        public Object getValueAt(int baris, int kolom){
            Distributor distributor = DISTRIBUTORS.get(baris);
            switch(kolom){
                case 0 : return distributor.getIdDistributor();
                case 1 : return distributor.getNamaDistributor();
                case 2 : return distributor.getNoTelepon();
                default : return null;
            }
        }
        
        @Override        
        public String getColumnName(int kolom){
            switch(kolom){
                case 0 : return KOLOM[0];
                case 1 : return KOLOM[1];
                case 2 : return KOLOM[2];
                default : return "";
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDistributor;
    private javax.swing.JTextField txtSearchDistributor;
    // End of variables declaration//GEN-END:variables
}
