package com.github.acepabdurohman.salesapp.ui.transaction;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Penjualan;
import com.github.acepabdurohman.salesapp.model.PenjualanDetail;
import com.github.acepabdurohman.salesapp.ui.renderer.NumberFormatTableCellRender;
import com.github.acepabdurohman.salesapp.ui.renderer.CenterAlignmentTableCellRender;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
/*
    Panel pembelian (UI) Untuk melakukan pencatatan data barang yang dijual
*/
public class PenjualanPanel extends javax.swing.JInternalFrame {

    private PenjualanDetailTableModel penjualanDetailTableModel;
    private List<PenjualanDetail> penjualanDetails = new ArrayList<>();
    private Penjualan penjualan = new Penjualan();
    
    public PenjualanPanel() {
        initComponents();
        loadData();
        enableForm();       
        tblPenjualanDetail.getSelectionModel().addListSelectionListener( new PenjualanSelectionListener());
    }
    
    public void enableForm(){
        txtKodeBarang.setEnabled(false);
        btnBarangLookup.setEnabled(false);
        btnTambah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        txtBayar.setEnabled(false);
    }
    
    public void clearForm(){
        lblTotal.setText("0,00");
        txtBayar.setText("");
        lblKembalian.setText("0,00");
        penjualan = new Penjualan();
        penjualanDetails = new ArrayList<>();
        penjualanDetailTableModel = new PenjualanDetailTableModel(penjualanDetails);
        tblPenjualanDetail.setModel(penjualanDetailTableModel);
    }
    
    public void rendererData(){
        tblPenjualanDetail.getColumnModel().getColumn(2).setCellRenderer( new NumberFormatTableCellRender());
        tblPenjualanDetail.getColumnModel().getColumn(3).setCellRenderer( new CenterAlignmentTableCellRender());
        tblPenjualanDetail.getColumnModel().getColumn(4).setCellRenderer( new NumberFormatTableCellRender());
    }
        
    public void loadData(){
        penjualanDetailTableModel = new PenjualanDetailTableModel(penjualanDetails);
        tblPenjualanDetail.setModel(penjualanDetailTableModel);
        rendererData();
    }

    public void totalLabel(){
        // label total tergantung pada penjualanDetails
        BigDecimal total = BigDecimal.ZERO;
        if(penjualanDetails != null){
            // foreach untuk load semua data pada penjualandetails
            for(PenjualanDetail d : penjualanDetails){
                total = total.add(d.getSubtotal());
            }
            DecimalFormat decFormat = new DecimalFormat("#,###,###");
            lblTotal.setText(decFormat.format(total));
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKodeBarang = new javax.swing.JTextField();
        btnBarangLookup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPenjualanDetail = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtBayar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblKembalian = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.title")); // NOI18N

        txtKodeBarang.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.txtKodeBarang.text")); // NOI18N
        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        btnBarangLookup.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnBarangLookup.text")); // NOI18N
        btnBarangLookup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangLookupActionPerformed(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.jLabel1.text")); // NOI18N

        tblPenjualanDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPenjualanDetail);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnTambah.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnTambah.text")); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnSimpan.text")); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.lblTotal.text")); // NOI18N

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnHapus.text")); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnBatal.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.btnKeluar.text")); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        txtBayar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtBayar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBayar.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.txtBayar.text")); // NOI18N
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.jLabel2.text")); // NOI18N

        lblKembalian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKembalian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKembalian.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.lblKembalian.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.jLabel4.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText(org.openide.util.NbBundle.getMessage(PenjualanPanel.class, "PenjualanPanel.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBayar)
                                    .addComponent(lblKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBarangLookup, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBarangLookup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblKembalian)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTotal))
                        .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBarangLookupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangLookupActionPerformed
        // TODO add your handling code here:
        BarangJualLookupDialog lookup = new BarangJualLookupDialog();
        // return barang dari lookup diaolog barang
        Barang b = lookup.getBarang();
        boolean ada = false;
        try{
            if(b != null){
                // pengecekan apakah data sudah ada di penjualanDetails
                for(PenjualanDetail detail : penjualanDetails){

                    // kalau kode barang pada tabel barang sama dengan kode barang yang ada di penjualandetails
                    if(b.getKodeBarang().equals(detail.getBarang().getKodeBarang())){
                        // tambahkan jumlahnya satu
                        detail.setJumlah(detail.getJumlah() + 1);
                        BigDecimal subtotal = detail.getHarga().multiply( new BigDecimal(detail.getJumlah().toString()));
                        detail.setSubtotal(subtotal);
                        ada = true;
                        break;
                    }
                }

                if(ada){
                    loadData();
                    totalLabel();
                }
                // kalau tidak ada pada penjualanDetails
                else{
                    // tambahkan berdasarkan kode barang yang sudah di return pada barang lookup
                    tambahPenjualanDetail(b);
                }
            }
        } catch(Exception exe){
            exe.printStackTrace();
        }      
    }//GEN-LAST:event_btnBarangLookupActionPerformed

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
        String kode = txtKodeBarang.getText();
        boolean ada = false;
        try{
            // kondisi kalau data di penjualandetails sudah ada
            for(PenjualanDetail d : penjualanDetails){
                // equalsignorecase untuk menghilangkan case sensitive dalam perbandingan
                if(kode.equalsIgnoreCase(d.getBarang().getKodeBarang())){ 
                    d.setJumlah(d.getJumlah() + 1);
                    d.setSubtotal(d.getHarga().multiply( new BigDecimal(d.getJumlah().toString())));
                    // ada di true kan karna ternyata kode barang sudah ada di penjualanDetails
                    ada = true;
                    // hentikan looping
                    break;
                }
            }
            // kalau ada maka load data agar menampilkan data terbaru pada penjualanDetails
            // load total harga juga
            if(ada){
                loadData();
                totalLabel();
            }
            // kondisi saat data di penjualandetails kosong
            else{
                // ambil data dari database berdasarkan kode barang yang diinput / discan
                Barang b = Main.getMasterService().getByKode(kode);
                if(b != null && !kode.isEmpty()){
                    tambahPenjualanDetail(b);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Isi kode barang", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        if(!penjualanDetails.isEmpty()){
            BigDecimal total = BigDecimal.ZERO;
            for(PenjualanDetail detail : penjualanDetails){
                total = total.add(detail.getSubtotal());

            }
            penjualan.setTotal(total);
            if(!txtBayar.getText().isEmpty()){
                Main.getTransactionService().simpan(penjualan);
                for(PenjualanDetail detail : penjualanDetails){
                    detail.setPenjualan(penjualan);
                    Main.getTransactionService().simpan(detail);
                }
                loadData();
                totalLabel();
                // reset ke keadaan awal
                enableForm();
                clearForm();
            }
            else{
                JOptionPane.showMessageDialog(this, "Belum bayar", "Peringatan", JOptionPane.WARNING_MESSAGE);
                txtBayar.requestFocus();
            }            
        }
        else{
            JOptionPane.showMessageDialog(this, "Silahkan isi barang", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        txtKodeBarang.setEnabled(true);
        btnBarangLookup.setEnabled(true);
        txtBayar.setEnabled(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
        try{
            BigDecimal bayar = new BigDecimal(txtBayar.getText());
            BigDecimal kembalian = BigDecimal.ZERO;
            BigDecimal total = BigDecimal.ZERO;
            for(PenjualanDetail detail : penjualanDetails){
                total = total.add(detail.getSubtotal());
            }
            kembalian = bayar.subtract(total);
            DecimalFormat decFormat = new DecimalFormat();
            lblKembalian.setText(decFormat.format(kembalian));
            txtBayar.setText(decFormat.format(bayar));
        } catch(NumberFormatException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Inputan harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtBayarActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        enableForm();
        clearForm();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().penjualanPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = tblPenjualanDetail.getSelectedRow();
        penjualanDetails.remove(baris);
        loadData();
        totalLabel();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tambahPenjualanDetail(Barang b){
        if(b != null){
            List<Barang> barangs = Main.getMasterService().getBarangByKode(b.getKodeBarang());
            for(Barang brg : barangs){
                if(brg.getStok() == 0){
                    JOptionPane.showMessageDialog(this, "Stok barang 0", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    PenjualanDetail penjualanDetail = new PenjualanDetail();
                    penjualanDetail.setBarang(b);
                    penjualanDetail.setHarga(b.getHargaJual());
                    penjualanDetail.setJumlah(1);
                    if(penjualanDetail.getSubtotal() == null){
                        penjualanDetail.setSubtotal(penjualanDetail.getHarga());
                    }
                    else{
                        penjualanDetail.setSubtotal(penjualanDetail.getSubtotal().add(penjualanDetail.getHarga()));
                    }

                    penjualanDetails.add(penjualanDetail);
                    loadData();
                    totalLabel();  
                }
            }
        }
    }
        
    private class PenjualanSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent evt){
            if(tblPenjualanDetail.getSelectedRow() >= 0){
                btnHapus.setEnabled(true);
            }
            else{
                btnHapus.setEnabled(false);
            }
            
        }
    }
    
    private class PenjualanDetailTableModel extends AbstractTableModel{
        private final List<PenjualanDetail> penjualanDetails;
        
        public PenjualanDetailTableModel(List<PenjualanDetail> penjualanDetails){
            this.penjualanDetails = penjualanDetails;
        }
        
        @Override
        public int getRowCount(){
            return penjualanDetails.size();
        }
        
        @Override
        public int getColumnCount(){
            return 5;
        }
        
        @Override
        public Object getValueAt(int baris, int kolom){
            PenjualanDetail detail = penjualanDetails.get(baris);
            switch(kolom){
                case 0 :
                    return detail.getBarang().getKodeBarang();
                case 1 :
                    return detail.getBarang().getNamaBarang();
                case 2 :
                    return detail.getHarga();
                case 3 :
                    return detail.getJumlah();
                case 4 :
                    return detail.getSubtotal();
                default :
                    return null;
            }
        }
        
        @Override
        public String getColumnName(int kolom){
            switch(kolom){
                case 0 :
                    return "Kode Barang";
                case 1 :
                    return "Nama Barang";
                case 2 :
                    return "Harga";
                case 3 :
                    return "Jumlah";
                case 4 :
                    return "Subtotal";
                default :
                    return "";
            }
        }
        
        @Override
        public Class<?> getColumnClass(int column){
            if(column == 2 || column == 4){
                return BigDecimal.class;
            }
            else if(column == 3){
                return Integer.class;
            }
            else{
                return String.class;
            }
        }
        
        @Override
        public boolean isCellEditable(int baris, int kolom){
            if(kolom == 3){
                return true;
            }
            else{
                return false;
            }
        }
        
        @Override
        public void setValueAt(Object aValue, int baris, int kolom){
            PenjualanDetail detail = penjualanDetails.get(baris);
            if(kolom == 3){
                detail.setJumlah( (Integer) aValue);
                BigDecimal subtotal = detail.getHarga().multiply( new BigDecimal(detail.getJumlah().toString()));
                detail.setSubtotal(subtotal);
                totalLabel();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarangLookup;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblPenjualanDetail;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtKodeBarang;
    // End of variables declaration//GEN-END:variables
}
