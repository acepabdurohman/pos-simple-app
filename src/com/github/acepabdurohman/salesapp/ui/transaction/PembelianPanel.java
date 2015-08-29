package com.github.acepabdurohman.salesapp.ui.transaction;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Distributor;
import com.github.acepabdurohman.salesapp.model.Pembelian;
import com.github.acepabdurohman.salesapp.model.PembelianDetail;
import com.github.acepabdurohman.salesapp.ui.renderer.NumberFormatTableCellRender;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
/*
    Panel pembelian (UI) Untuk melakukan pencatatan data barang yang dibeli
*/
public class PembelianPanel extends javax.swing.JInternalFrame {

    private PembelianTableModel pembelianTableModel; 
    private List<PembelianDetail> pembelianDetail = new ArrayList<>();
    private Pembelian pembelian = new Pembelian();
    private Distributor dist;
    
    public PembelianPanel() {
        initComponents();
        enableForm();
        loadData();
        tblPembelian.getSelectionModel().addListSelectionListener( new PembelianSelectionListener());
    }

    public void enableForm(){
        txtIdDistributor.setEnabled(false);
        txtNamaDistributor.setEnabled(false);
        txtKodeBarang.setEnabled(false);
        btnTambah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        btnCariDistributor.setEnabled(false);
        btnKodeBarang.setEnabled(false);
        
    }
    
    public void rendererData(){
        tblPembelian.getColumnModel().getColumn(3).setCellRenderer( new NumberFormatTableCellRender());
        tblPembelian.getColumnModel().getColumn(4).setCellRenderer( new NumberFormatTableCellRender());
    }
    
    public void loadData(){
        pembelianTableModel = new PembelianTableModel(pembelianDetail);
        tblPembelian.setModel(pembelianTableModel);
        rendererData();
    }
    
    public void clearForm(){
        txtIdDistributor.setText("");
        txtNamaDistributor.setText("");
        dist = null;
        lblTotal.setText("0");
        pembelianDetail = new ArrayList<>();
        pembelianTableModel = new PembelianTableModel(pembelianDetail);
        tblPembelian.setModel(pembelianTableModel);
    }
    
    public void hitungTotal(){
        BigDecimal total = BigDecimal.ZERO;
        
        for(PembelianDetail detail : pembelianDetail){
            total = total.add(detail.getSubtotal());
        }
        DecimalFormat decFormat = new DecimalFormat("#,###,###");
        lblTotal.setText(decFormat.format(total));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdDistributor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCariDistributor = new javax.swing.JButton();
        txtKodeBarang = new javax.swing.JTextField();
        btnKodeBarang = new javax.swing.JButton();
        txtNamaDistributor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPembelian = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.title")); // NOI18N
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

        txtIdDistributor.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.txtIdDistributor.text")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.jLabel1.text")); // NOI18N

        btnCariDistributor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuFind.png"))); // NOI18N
        btnCariDistributor.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnCariDistributor.text")); // NOI18N
        btnCariDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDistributorActionPerformed(evt);
            }
        });

        txtKodeBarang.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.txtKodeBarang.text")); // NOI18N
        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        btnKodeBarang.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnKodeBarang.text")); // NOI18N
        btnKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKodeBarangActionPerformed(evt);
            }
        });

        txtNamaDistributor.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.txtNamaDistributor.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.jLabel3.text")); // NOI18N

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.lblTotal.text")); // NOI18N

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnTambah.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnTambah.text")); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnSimpan.text")); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.jLabel2.text")); // NOI18N

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnHapus.text")); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnBatal.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.btnKeluar.text")); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tblPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPembelian);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText(org.openide.util.NbBundle.getMessage(PembelianPanel.class, "PembelianPanel.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNamaDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(txtKodeBarang)
                                    .addComponent(txtIdDistributor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCariDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnKodeBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCariDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(jLabel4)))
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKodeBarangActionPerformed
        // TODO add your handling code here:
        BarangBeliLookupDialog lookup = new BarangBeliLookupDialog();
        Barang barang = lookup.getBarang();
        
        boolean ada = false;
        if(barang != null){
            for(PembelianDetail detail : pembelianDetail){
                if(barang.getKodeBarang().equals(detail.getBarang().getKodeBarang())){
                
                    detail.setJumlah(detail.getJumlah() + 1);
                    BigDecimal subtotal = detail.getHarga().multiply( new BigDecimal(detail.getJumlah()));
                    detail.setSubtotal(subtotal);
                    ada = true;
                    break;
                }
            }
            if(ada){
                loadData();
                hitungTotal();
            }
            else{
                tambahPembelianDetail(barang);
            }
        }
        
        
    }//GEN-LAST:event_btnKodeBarangActionPerformed

    private void btnCariDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDistributorActionPerformed
        // TODO add your handling code here:
        DistributorLookupDialog lookup = new DistributorLookupDialog();
        dist = lookup.getDistributor();
        
        if(dist != null){
            txtIdDistributor.setText(dist.getIdDistributor().toString());
            txtNamaDistributor.setText(dist.getNamaDistributor().toString());
        }
        else{
            txtIdDistributor.setText("");
            txtNamaDistributor.setText("");
        }

    }//GEN-LAST:event_btnCariDistributorActionPerformed

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
        String kode = txtKodeBarang.getText();
        boolean ada = false;
        try{
            for(PembelianDetail detail : pembelianDetail){
                if(kode.equalsIgnoreCase(detail.getBarang().getKodeBarang())){

                    detail.setJumlah(detail.getJumlah() + 1);
                    detail.setSubtotal( detail.getHarga().multiply( new BigDecimal(detail.getJumlah())));
                    ada = true;
                    System.out.println("Sama");
                    break;
                }
            }
            if(ada){
                loadData();
                hitungTotal();
            }
            else{
                Barang barang = Main.getMasterService().getByKode(kode);
                if(barang != null && !kode.isEmpty()){
                    tambahPembelianDetail(barang);
                }
                
            }
            txtKodeBarang.setText("");
        } catch(Exception exe){
            exe.printStackTrace();
            System.out.println("Error");
        }
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(!pembelianDetail.isEmpty() && dist != null){
            BigDecimal total = BigDecimal.ZERO;
            for(PembelianDetail d : pembelianDetail){
                total = total.add(d.getSubtotal());
            }
            
            pembelian.setDistributor(dist);
            pembelian.setTotal(total);
            Main.getTransactionService().simpan(pembelian);
            for(PembelianDetail det : pembelianDetail){
                det.setPembelian(pembelian);
                Main.getTransactionService().simpan(det);
            }
            loadData();
            hitungTotal();
            clearForm();
            enableForm();
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Isi barang dan distributor", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        btnCariDistributor.setEnabled(true);
        btnKodeBarang.setEnabled(true);
        txtKodeBarang.setEnabled(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int rowIndex = tblPembelian.getSelectedRow();
        pembelianDetail.remove(rowIndex);
        loadData();
        hitungTotal();
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        enableForm();
        clearForm();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().pembelianPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().pembelianPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed
    
    private void tambahPembelianDetail(Barang barang){
    
        if(barang != null){
            PembelianDetail detail = new PembelianDetail();
            detail.setBarang(barang);
            detail.setJumlah(1);
            detail.setHarga(barang.getHargaBeli());
            if(detail.getSubtotal() == null){
                detail.setSubtotal(detail.getHarga());
            }
            else{
                detail.setSubtotal(detail.getSubtotal().add(detail.getHarga()));
            }
            pembelianDetail.add(detail);
            loadData();
            hitungTotal();
        }
        
    }
    
    public class PembelianSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent evt){
            if(tblPembelian.getSelectedRow() >= 0){
                btnHapus.setEnabled(true);
            }
            else{
                btnHapus.setEnabled(false);
            }
            
        }
    }
    
    private class PembelianTableModel extends AbstractTableModel{
        private List<PembelianDetail> pembelianDetails;
        private String[] column = {"Kode Barang", "Nama Barang", "Jumlah", "Harga Beli", "Subtotal"};
        public PembelianTableModel(List<PembelianDetail> details){
            this.pembelianDetails = details;
        }
        
        @Override
        public int getRowCount(){
            return pembelianDetails.size();
        }
        
        @Override
        public int getColumnCount(){
            return column.length;
        }
        
        @Override
        public Object getValueAt(int baris, int kolom){
            PembelianDetail details = pembelianDetails.get(baris);
            switch(kolom){
                case 0 : return details.getBarang().getKodeBarang();
                case 1 : return details.getBarang().getNamaBarang();
                case 2 : return details.getJumlah();
                case 3 : return details.getHarga();
                case 4 : return details.getSubtotal();
                default : return null;
            }
        }
        
        @Override
        public String getColumnName(int kolom){
            switch(kolom){
                case 0 : return column[0];
                case 1 : return column[1];
                case 2 : return column[2];
                case 3 : return column[3];
                case 4 : return column[4];
                default : return "";
            }
        }
        
        @Override
        public Class<?> getColumnClass(int kolom){
            if(kolom == 3 && kolom == 4){
                return BigDecimal.class;
            }
            else if(kolom == 2){
                return Integer.class;
            }
            else{
                return String.class;
            }
        }
        
        @Override
        public boolean isCellEditable(int baris, int kolom){
            if(kolom == 2){
                return true;
            }
            else{
                return false;
            }
        }
        
        @Override
        public void setValueAt(Object aValue, int baris, int kolom){
            PembelianDetail detail = pembelianDetail.get(baris);
            if(kolom == 2){
                detail.setJumlah( (Integer) aValue); // aValue = nilai baru
                BigDecimal subtotal = detail.getHarga().multiply( new BigDecimal(detail.getJumlah()));
                detail.setSubtotal(subtotal);
                hitungTotal();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariDistributor;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKodeBarang;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblPembelian;
    private javax.swing.JTextField txtIdDistributor;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaDistributor;
    // End of variables declaration//GEN-END:variables
}
