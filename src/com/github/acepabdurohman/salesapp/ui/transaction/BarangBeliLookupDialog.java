package com.github.acepabdurohman.salesapp.ui.transaction;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.ui.master.BarangPanel;
import com.github.acepabdurohman.salesapp.ui.renderer.NumberFormatTableCellRender;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
/*
    Panel lookup untuk setiap barang yang akan dibeli
*/
public class BarangBeliLookupDialog extends javax.swing.JDialog {
    
    private Integer nomorHalaman = 1;
    private Integer jumlahBarisPerHalaman = 0;
    private Integer totalHalaman = 0;
    private Integer totalData = 0;
    private BarangTableModel barangTableModel;
    private Barang barang;
    private List<Barang> barangs;
    
    public BarangBeliLookupDialog() {
        
        super(Main.getFrame(), true); // modal
        initComponents();
        setLocationRelativeTo(null);
        cmbJumlahBaris.addItem("10");
        cmbJumlahBaris.addItem("20");
        cmbJumlahBaris.addItemListener( new ComboBarisItemListener());
        loadData();
        tblBarang.getSelectionModel().addListSelectionListener( new BarangSelectionListener());
    }
    
    private void rendererData(){
        tblBarang.getColumnModel().getColumn(2).setCellRenderer( new NumberFormatTableCellRender());
    }
    // return barang
    // aksebilitas public
    // digunakan pada form penjualan
    public Barang getBarang(){
        setVisible(true);
        return barang;
    }
    
    private void loadData(){
        // paging data
        totalData = Main.getMasterService().countBarang();
        jumlahBarisPerHalaman = Integer.valueOf(cmbJumlahBaris.getSelectedItem().toString());
        Double totalHalamanD = Math.ceil(totalData.doubleValue() / jumlahBarisPerHalaman.doubleValue());
        totalHalaman = totalHalamanD.intValue();
        
        if(nomorHalaman.equals(1)){
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
        
        }
        else{
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
        }
        if(nomorHalaman.equals(totalHalaman)){
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
        
        }
        else{
            btnLast.setEnabled(true);
            btnNext.setEnabled(true);
        }
        if(nomorHalaman > totalHalaman){
            nomorHalaman = 1;
        }
        barangs = Main.getMasterService().getBarangPaging(nomorHalaman, jumlahBarisPerHalaman);
        barangTableModel = new BarangTableModel(barangs);
        tblBarang.setModel(barangTableModel);
        rendererData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cmbJumlahBaris = new javax.swing.JComboBox();
        btnPrevious = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.title")); // NOI18N

        txtCari.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.txtCari.text")); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.jLabel1.text")); // NOI18N

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        btnOk.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnOk.text")); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnBatal.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnLast.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnLast.text")); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnNext.text")); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnPrevious.text")); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnFirst.setText(org.openide.util.NbBundle.getMessage(BarangBeliLookupDialog.class, "BarangBeliLookupDialog.btnFirst.text")); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious)
                    .addComponent(btnFirst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(nomorHalaman < totalHalaman){
            nomorHalaman++;
            loadData();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        nomorHalaman = totalHalaman;
        loadData();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if(nomorHalaman > 1){
            nomorHalaman--;
            loadData();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        nomorHalaman = 1;
        loadData();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        if(txtCari.getText() != null && !txtCari.getText().isEmpty()){
            barangTableModel = new BarangTableModel(Main.getMasterService().getBarangByKode(txtCari.getText()));
            tblBarang.setModel(barangTableModel);
            rendererData();
        }
        else{
            loadData();
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if(barang != null){
            dispose();
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Pilih salah satu barang", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        barang = null;
        
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private class BarangSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e){
            if(tblBarang.getSelectedRow() >= 0){
                // return kode barang
                barang = barangs.get(tblBarang.getSelectedRow());
                String kode = barangTableModel.getValueAt(tblBarang.getSelectedRow(), 0).toString();
                barang.setKodeBarang(kode);
                String nama = barangTableModel.getValueAt(tblBarang.getSelectedRow(), 1).toString();
                barang.setNamaBarang(nama);
                BigDecimal harga = new BigDecimal(barangTableModel.getValueAt(tblBarang.getSelectedRow(), 2).toString());
                barang.setHargaBeli(harga);
                btnOk.requestFocus();
            }
        }
    }
    
    private class ComboBarisItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            loadData();
        }
    }
    
    private class BarangTableModel extends AbstractTableModel{
        
        private final List<Barang> barangs;
        
        public BarangTableModel(List<Barang> barangs){
            this.barangs = barangs;
        }
        
        @Override
        public int getRowCount(){
            return barangs.size();
        }
        
        @Override
        public int getColumnCount(){
            return 3;
        }
        
        @Override
        public Object getValueAt(int baris, int column){
            Barang barang = barangs.get(baris);
            switch(column){
                case 0 :
                    return barang.getKodeBarang();
                case 1 :
                    return barang.getNamaBarang();
                case 2 :
                    return barang.getHargaBeli();
                default :
                    return null;
            }
        }
        
        @Override
        public String getColumnName(int column){
            switch(column){
                case 0 :
                    return "Kode Barang";
                case 1 :
                    return "Nama Barang";
                case 2 :
                    return "Harga Beli";
                default :
                    return "";
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox cmbJumlahBaris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
