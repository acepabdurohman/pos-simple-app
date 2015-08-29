package com.github.acepabdurohman.salesapp.ui.master;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Distributor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
/*
    Panel distributor (UI) user mengakses form distributor.
*/
public class DistributorPanel extends javax.swing.JInternalFrame {

    private final Distributor distributor = new Distributor();
    private DistributorTableModel distTableModel;
    
    public DistributorPanel() {
        initComponents();
        enable();
        refreshTable();
        validate();
    }
    
    @Override
    public void enable(){
        txtNama.setEnabled(false);
        txtAlamat.setEnabled(false);
        txtKota.setEnabled(false);
        txtEmail.setEnabled(false);
        txtNoTelp.setEnabled(false);
        btnTambah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
    }
    
    public void clearText(){
        txtNama.setText("");
        txtAlamat.setText("");
        txtKota.setText("");
        txtEmail.setText("");
        txtNoTelp.setText("");
    }

    public void refreshTable(){
        distTableModel = new DistributorTableModel(Main.getMasterService().getAllDistributor());
        tblDistributor.setModel(distTableModel);
    }
    
    public void validateSave(){
        if(txtNama.getText() != null && txtNama.getText().length() > 0){
            distributor.setNamaDistributor(txtNama.getText());
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("");
        }
        else{
            distributor.setNamaDistributor(null);
            txtNama.requestFocus();
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("Nama Distributor harus diisi");
            
        }
        if(txtAlamat.getText() != null && txtAlamat.getText().length() > 0){
            distributor.setAlamat(txtAlamat.getText());
            lblValidateAlamat.setVisible(true);
            lblValidateAlamat.setText("");
        }
        else{
            distributor.setAlamat(null);
            txtAlamat.requestFocus();
            lblValidateAlamat.setVisible(true);
            lblValidateAlamat.setText("Alamat harus diisi");
        }
        if(txtKota.getText() != null && txtKota.getText().length() > 0){
            distributor.setKotaAsal(txtKota.getText());
            lblValidateKota.setVisible(true);
            lblValidateKota.setText("");
        }
        else{
            distributor.setKotaAsal(null);
            txtKota.requestFocus();
            lblValidateKota.setVisible(true);
            lblValidateKota.setText("Kota asal harus diisi");
            
        }
        if(distributor.getNamaDistributor() != null && distributor.getAlamat() != null 
                && distributor.getKotaAsal() != null){
            distributor.setEmail(txtEmail.getText());
            distributor.setNoTelepon(txtNoTelp.getText());
            Main.getMasterService().simpan(distributor);
            refreshTable();
            enable();
            clearText();
        }
    }
    
    public void validateUpdate(){
        if(txtNama.getText() != null && txtNama.getText().length() > 0){
            distributor.setNamaDistributor(txtNama.getText());
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("");
        }
        else{
            distributor.setNamaDistributor(null);
            txtNama.requestFocus();
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("Isi Nama Distributor");
            
        }
        if(txtAlamat.getText() != null && txtAlamat.getText().length() > 0){
            distributor.setAlamat(txtAlamat.getText());
            lblValidateAlamat.setVisible(true);
            lblValidateAlamat.setText("");
        }
        else{
            distributor.setAlamat(null);
            txtAlamat.requestFocus();
            lblValidateAlamat.setVisible(true);
            lblValidateAlamat.setText("Isi Alamat");
        }
        if(txtKota.getText() != null && txtKota.getText().length() > 0){
            distributor.setKotaAsal(txtKota.getText());
            lblValidateKota.setVisible(true);
            lblValidateKota.setText("");
        }
        else{
            distributor.setKotaAsal(null);
            txtKota.requestFocus();
            lblValidateKota.setVisible(true);
            lblValidateKota.setText("Isi Kota Asal");
            
        }
        if(distributor.getNamaDistributor() != null && distributor.getAlamat() != null 
                && distributor.getKotaAsal() != null){
            int baris = tblDistributor.getSelectedRow();
            Integer id = (Integer) tblDistributor.getValueAt(baris, 0);
            distributor.setEmail(txtEmail.getText());
            distributor.setNoTelepon(txtNoTelp.getText());            
            distributor.setIdDistributor(id);
            Main.getMasterService().ubah(distributor);
            refreshTable();            
            enable();
            clearText();
        }
    }
    
    @Override
    public void validate(){
        lblValidateNama.setVisible(false);
        lblValidateAlamat.setVisible(false);
        lblValidateKota.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        lblValidateNama = new javax.swing.JLabel();
        lblValidateKota = new javax.swing.JLabel();
        lblValidateAlamat = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDistributor = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.title")); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jPanel1.border.title"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jLabel1.text")); // NOI18N

        txtNama.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.txtNama.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jLabel2.text")); // NOI18N

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jLabel3.text")); // NOI18N

        txtKota.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.txtKota.text")); // NOI18N

        txtEmail.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.txtEmail.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jLabel4.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.jLabel5.text")); // NOI18N

        txtNoTelp.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.txtNoTelp.text")); // NOI18N

        lblValidateNama.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateNama.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.lblValidateNama.text")); // NOI18N

        lblValidateKota.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateKota.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.lblValidateKota.text")); // NOI18N

        lblValidateAlamat.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateAlamat.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.lblValidateAlamat.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtKota))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValidateAlamat)
                            .addComponent(lblValidateNama)
                            .addComponent(lblValidateKota))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblValidateNama)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblValidateAlamat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblValidateKota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21))
        );

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnSimpan.text")); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tblDistributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDistributorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDistributor);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnUbah.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnUbah.text")); // NOI18N
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnHapus.text")); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnBatal.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnKeluar.text")); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnTambah.setText(org.openide.util.NbBundle.getMessage(DistributorPanel.class, "DistributorPanel.btnTambah.text")); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnKeluar)
                    .addComponent(btnTambah))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        validateSave();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        txtNama.setEnabled(true);
        txtAlamat.setEnabled(true);
        txtKota.setEnabled(true);
        txtEmail.setEnabled(true);
        txtNoTelp.setEnabled(true);
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnBatal.setEnabled(true);
        clearText();
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        enable();
        clearText();
        tblDistributor.clearSelection();
        lblValidateNama.setVisible(false);
        lblValidateAlamat.setVisible(false);
        lblValidateKota.setVisible(false);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblDistributorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDistributorMouseClicked
        // TODO add your handling code here:
        int baris = tblDistributor.getSelectedRow();
        String nama = (String) distTableModel.getValueAt(baris, 1);
        txtNama.setText(nama);
        String alamat = (String) distTableModel.getValueAt(baris, 2);
        txtAlamat.setText(alamat);
        String kota = (String) distTableModel.getValueAt(baris, 3);
        txtKota.setText(kota);
        String email = (String) distTableModel.getValueAt(baris, 4);
        txtEmail.setText(email);
        String noTelp = (String) distTableModel.getValueAt(baris, 5);
        txtNoTelp.setText(noTelp);
        txtNama.setEnabled(true);
        txtAlamat.setEnabled(true);
        txtKota.setEnabled(true);
        txtEmail.setEnabled(true);
        txtNoTelp.setEnabled(true);
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
        validate();
    }//GEN-LAST:event_tblDistributorMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        validateUpdate();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = tblDistributor.getSelectedRow();
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 0){
            Integer id = (Integer) distTableModel.getValueAt(baris, 0);
            distributor.setIdDistributor(id);
            Main.getMasterService().hapus(distributor);
            refreshTable();            
            enable();
            clearText();
            validate();
        }
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().distributorPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().distributorPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private class DistributorTableModel extends AbstractTableModel{
        private final List<Distributor> listDistributor;
        
        public DistributorTableModel(List<Distributor> list){
            this.listDistributor = list;
        }
        
        @Override
        public int getRowCount(){
            return listDistributor.size();
        }
        
        @Override
        public int getColumnCount(){
            return 6;
        }
        
         @Override
        public Object getValueAt(int baris, int kolom){ 
            Distributor dist = listDistributor.get(baris);
            switch(kolom){
                case 0 : 
                    return dist.getIdDistributor();
                case 1 :
                    return dist.getNamaDistributor();
                case 2 : 
                    return dist.getAlamat();
                case 3 :
                    return dist.getKotaAsal();
                case 4 :
                    return dist.getEmail();
                case 5 :
                    return dist.getNoTelepon();
                default :
                    return "";
            }
        }
        
        @Override
        public String getColumnName(int kolom){
            switch(kolom){
                case 0 : 
                    return "ID Distributor";
                case 1 :
                    return "Nama Distributor";
                case 2 :
                    return "Alamat";
                case 3 :
                    return "Kota Asal";
                case 4 :
                    return "Email";
                case 5 :
                    return "Nomor Telepon";
            }
            return "";
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblValidateAlamat;
    private javax.swing.JLabel lblValidateKota;
    private javax.swing.JLabel lblValidateNama;
    private javax.swing.JTable tblDistributor;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
