package com.github.acepabdurohman.salesapp.ui.master;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Jenis;
import com.github.acepabdurohman.salesapp.service.MasterService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/*
    Panel jenis barang (UI) user mengakses form jenis barang.
*/
public class JenisBarangPanel extends javax.swing.JInternalFrame {
    
    private Jenis jenis = new Jenis();
    private JenisTableModel jenisTableModel;
    
    public JenisBarangPanel() {
        initComponents();
        refreshTable();
        status(false);
        lblValidasiKode.setVisible(false);
        lblValidasiJenis.setVisible(false);
        tblJenisBarang.getSelectionModel().addListSelectionListener( new JenisBarangSelectionListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeJenis = new javax.swing.JTextField();
        txtJenis = new javax.swing.JTextField();
        lblValidasiKode = new javax.swing.JLabel();
        lblValidasiJenis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJenisBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Form Jenis Barang");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));

        jLabel1.setText("Kode Jenis Barang");

        jLabel2.setText("Jenis Barang");

        lblValidasiKode.setForeground(new java.awt.Color(255, 0, 0));
        lblValidasiKode.setText("Validasi Kode Jenis");

        lblValidasiJenis.setForeground(new java.awt.Color(255, 0, 0));
        lblValidasiJenis.setText("Validasi Jenis Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValidasiJenis))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValidasiKode)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidasiKode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidasiJenis))
                .addGap(38, 38, 38))
        );

        tblJenisBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblJenisBarang);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKeluar)
                        .addGap(42, 92, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnKeluar)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void validate(){
        lblValidasiKode.setVisible(false);
        lblValidasiJenis.setVisible(false);
    }
    
    private void status(boolean akses){
        txtKodeJenis.setEnabled(akses);
        txtJenis.setEnabled(akses);        
        btnSimpan.setEnabled(akses);
        btnUbah.setEnabled(akses);
        btnHapus.setEnabled(akses);
        btnBatal.setEnabled(akses);
    }
    
    private void refreshTable(){
        jenisTableModel = new JenisTableModel(Main.getMasterService().getAllJenis());
        tblJenisBarang.setModel(jenisTableModel);
    }
    
    private void clearText(){
        txtKodeJenis.setText("");
        txtJenis.setText("");        
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:        
        Main.getFrame().jenisBarangPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        txtKodeJenis.setEnabled(true);
        txtJenis.setEnabled(true);
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnBatal.setEnabled(true);
        clearText();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void validateSave(){
        if(txtKodeJenis.getText() != null && txtKodeJenis.getText().length() > 0){
            jenis.setKodeJenis(txtKodeJenis.getText());
            lblValidasiKode.setVisible(true);
            lblValidasiKode.setText("");
        }
        else{
            jenis.setKodeJenis(null);
            txtKodeJenis.requestFocus();
            lblValidasiKode.setVisible(true);
            lblValidasiKode.setText("Kode jenis harus diisi");
        }
        if(txtJenis.getText() != null && txtJenis.getText().length() > 0){
            jenis.setJenis(txtJenis.getText());
            lblValidasiJenis.setVisible(true);
            lblValidasiJenis.setText("");
        }
        else{
            jenis.setJenis(null);
            txtJenis.requestFocus();
            lblValidasiJenis.setVisible(true);
            lblValidasiJenis.setText("Jenis Barang harus diisi");
        }
        if(jenis.getKodeJenis() != null && jenis.getJenis() != null){
            Main.getMasterService().simpan(jenis);
            refreshTable();
            txtKodeJenis.setEnabled(false);
            txtJenis.setEnabled(false);
            btnTambah.setEnabled(true);
            btnSimpan.setEnabled(false);                
            btnBatal.setEnabled(false);
            clearText();
        }
    }
    
    private void validateUpdate(){
        if(txtKodeJenis.getText() != null && txtKodeJenis.getText().length() > 0){
            jenis.setKodeJenis(txtKodeJenis.getText());
            lblValidasiKode.setVisible(true);
            lblValidasiKode.setText("");
        }
        else{
            jenis.setKodeJenis(null);
            lblValidasiKode.setVisible(true);
            lblValidasiKode.setText("Kode jenis harus diisi");
        }
        if(txtJenis.getText() != null && txtJenis.getText().length() > 0){
            jenis.setJenis(txtJenis.getText());
            lblValidasiJenis.setVisible(true);
            lblValidasiJenis.setText("");
        }
        else{
            jenis.setJenis(null);
            lblValidasiJenis.setVisible(true);
            lblValidasiJenis.setText("Jenis Barang harus diisi");
        }
        if(jenis.getKodeJenis() != null && jenis.getJenis() != null){
            Main.getMasterService().ubah(jenis);
            refreshTable();
            clearText(); 
            status(false);
            btnTambah.setEnabled(true);
            btnUbah.setEnabled(false);
        }
    }
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:        
        validateSave();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:      
        validateUpdate();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        btnBatal.setEnabled(false);
        btnTambah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        tblJenisBarang.clearSelection();
        clearText();
        txtKodeJenis.setEnabled(false);
        txtJenis.setEnabled(false);
        validate();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(konfirmasi == 0){
                Main.getMasterService().hapus(jenis);    
                refreshTable();
                clearText();
                status(false);
                btnTambah.setEnabled(true);
            }
            validate();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().jenisBarangPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private class JenisTableModel extends AbstractTableModel{
        private final List<Jenis> listJenis;
        
        public JenisTableModel(List<Jenis> list){
            listJenis = list;
        }
        
        @Override
        public int getRowCount(){
            return listJenis.size();
        }
        
        @Override
        public int getColumnCount(){
            return 2;
        }
        
        @Override
        public Object getValueAt(int baris, int kolom){ // untuk mendapatkan nilai pada baris dan kolom sekian
            Jenis jenis = listJenis.get(baris);
            switch(kolom){
                case 0 :
                    return jenis.getKodeJenis();
                case 1 : 
                    return jenis.getJenis();
                default :
                    return "";
            }
        }
        
        @Override
        public String getColumnName(int kolom){
            switch(kolom){
                case 0 : 
                    return "Kode Jenis Barang";
                case 1 :
                    return "Jenis Barang";
                default :
                    return "";
            }
        }
    }
    
    private class JenisBarangSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e){
            // kalau row pada tabel jenis ada yang terseleksi
            if(tblJenisBarang.getSelectedRow() >= 0){
                // ambil row yang terseleksi
                jenis = Main.getMasterService().getAllJenis().get(tblJenisBarang.getSelectedRow());
                // ambil kolom kode dan assign ke object idJenis
                jenis = Main.getMasterService().getJenisByKodeSelection(jenis.getKodeJenis());
                txtKodeJenis.setText(jenis.getKodeJenis());
                txtJenis.setText(jenis.getJenis());
                txtJenis.setEnabled(true);
                btnTambah.setEnabled(false);
                btnUbah.setEnabled(true);
                btnHapus.setEnabled(true);
                btnBatal.setEnabled(true);
            }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValidasiJenis;
    private javax.swing.JLabel lblValidasiKode;
    private javax.swing.JTable tblJenisBarang;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKodeJenis;
    // End of variables declaration//GEN-END:variables
}
