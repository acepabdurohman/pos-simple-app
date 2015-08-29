package com.github.acepabdurohman.salesapp.ui.master;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Jenis;
import com.github.acepabdurohman.salesapp.ui.MainFrame;
import com.github.acepabdurohman.salesapp.ui.renderer.NumberFormatTableCellRender;
import com.github.acepabdurohman.salesapp.ui.renderer.CenterAlignmentTableCellRender;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
/*
    Panel barang (UI) user mengakses form barang.
*/
public class BarangPanel extends javax.swing.JInternalFrame {

    private Integer nomorHalaman = 1;
    private Integer jumlahBarisPerHalaman = 5;
    private Integer totalHalaman = 1;
    private Integer totalData = 0;
    private Barang barang = new Barang();
    private BarangTableModel barangTableModel;
    
    public BarangPanel() {
        initComponents();
        List<Jenis> listJenis = Main.getMasterService().getAllJenis();
        for(Jenis j : listJenis){
            cmbKodeJenis.addItem(j.getKodeJenis());
        }
        statusTxt(false); 
        statusSimpan();
        validate();
        
        cmbJumlahBaris.addItem("10");
        cmbJumlahBaris.addItem("20");
        cmbJumlahBaris.addItem("30");
        cmbJumlahBaris.addItemListener( new KodeJenisItemListener());
        initPagination();
        
        tblBarang.getSelectionModel().addListSelectionListener( new BarangSelectionListener());
    }
    
    @Override
    public void validate(){
        lblValidateKode.setVisible(false);
        lblValidateNama.setVisible(false);
        lblValidateKodeJenis.setVisible(false);
        lblValidateStok.setVisible(false);
        lblValidateHB.setVisible(false);
        lblValidateHJ.setVisible(false);
    }
    // mengrender data pada setiap kolom di jtable dengan memanggil objek yang mengatur render data tersebut
    public void rendererData(){
        tblBarang.getColumnModel().getColumn(3).setCellRenderer( new CenterAlignmentTableCellRender());
        tblBarang.getColumnModel().getColumn(4).setCellRenderer( new NumberFormatTableCellRender());
        tblBarang.getColumnModel().getColumn(5).setCellRenderer( new NumberFormatTableCellRender()); 
    }
    
    public void statusSimpan(){
        btnTambah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        btnKeluar.setEnabled(true);
    }
    
    public void statusTxt(boolean akses){
        txtKodeBarang.setEnabled(akses);
        txtNamaBarang.setEnabled(akses);
        cmbKodeJenis.setEnabled(akses);
        txtJenisBarang.setEnabled(akses);
        txtStok.setEnabled(akses);
        txtHargaBeli.setEnabled(akses);
        txtHargaJual.setEnabled(akses);
    }
    
    public void clearText(){
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        cmbKodeJenis.setSelectedIndex(0);
        txtStok.setText("0");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
    }
    
    private void initPagination(){
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
        barangTableModel = new BarangTableModel(Main.getMasterService().getBarangPaging(nomorHalaman, jumlahBarisPerHalaman));
        tblBarang.setModel(barangTableModel);
        
        lblHalaman.setText("Halaman " + nomorHalaman + " dari " + totalHalaman);
        lblTotalData.setText("Total Data : " + totalData);
        rendererData();
    }
    
    public void validateSave(){
        if(txtKodeBarang.getText() != null && txtKodeBarang.getText().length() > 0){
            barang.setKodeBarang(txtKodeBarang.getText());
            lblValidateKode.setVisible(true);
            lblValidateKode.setText("");
        }
        else{
            barang.setKodeBarang(null);
            lblValidateKode.setVisible(true);
            lblValidateKode.setText("Kode barang harus diisi");
            
        }
        if(txtNamaBarang.getText() != null && txtNamaBarang.getText().length() > 0){
            barang.setNamaBarang(txtNamaBarang.getText());   
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("");
        }
        else{
            barang.setNamaBarang(null);   
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("Nama barang harus diisi");
            
        }
        int selectedIndex = cmbKodeJenis.getSelectedIndex();
        Jenis jenis = new Jenis();
        if(selectedIndex != 0){
            jenis.setKodeJenis(cmbKodeJenis.getSelectedItem().toString());
            barang.setJenis(jenis);
            lblValidateKodeJenis.setVisible(true);
            lblValidateKodeJenis.setText("");
        }
        else{
            jenis.setKodeJenis(null);
            barang.setJenis(jenis);
            lblValidateKodeJenis.setVisible(true);
            lblValidateKodeJenis.setText("Pilih Kode Jenis Barang");
        }
        if(txtStok.getText() != null && txtStok.getText().length() > 0){
            barang.setStok( new Integer(txtStok.getText()));
            lblValidateStok.setVisible(true);
            lblValidateStok.setText("");
        }
        else{
            barang.setStok(null);
            lblValidateStok.setVisible(true);
            lblValidateStok.setText("Stok harus diisi");
            
        }
        if(!txtHargaBeli.getText().isEmpty()){
            barang.setHargaBeli( new BigDecimal(txtHargaBeli.getText()));
            lblValidateHB.setVisible(true);
            lblValidateHB.setText("");
        }
        else{
            barang.setHargaBeli(null);
            lblValidateHB.setVisible(true);
            lblValidateHB.setText("Harga beli harus diisi");
        }
        if(txtHargaJual.getText() != null && txtHargaJual.getText().length() > 0){
            barang.setHargaJual( new BigDecimal(txtHargaJual.getText()));
            lblValidateHJ.setVisible(true);
            lblValidateHJ.setText("");
        }
        else{
            barang.setHargaJual(null);
            lblValidateHJ.setVisible(true);
            lblValidateHJ.setText("Harga jual harus diisi");
           
        }
        if(barang.getKodeBarang() != null && barang.getNamaBarang()!= null && barang.getJenis().getKodeJenis() != null
                && barang.getStok() != null & barang.getHargaBeli() != null && barang.getHargaJual() != null){
            Main.getMasterService().simpan(barang);
            initPagination();
            statusTxt(false);
            statusSimpan();
            clearText();
        }
    }
    
    public void validateUpdate(){
        if(txtKodeBarang.getText() != null && txtKodeBarang.getText().length() > 0){
            barang.setKodeBarang(txtKodeBarang.getText());
            lblValidateKode.setVisible(true);
            lblValidateKode.setText("");
        }
        else{
            barang.setKodeBarang(null);
            lblValidateKode.setVisible(true);
            lblValidateKode.setText("Kode barang harus diisi");
            
        }
        if(txtNamaBarang.getText() != null && txtNamaBarang.getText().length() > 0){
            barang.setNamaBarang(txtNamaBarang.getText());   
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("");
        }
        else{
            barang.setNamaBarang(null);   
            lblValidateNama.setVisible(true);
            lblValidateNama.setText("Nama barang harus diisi");
            
        }
        int selectedIndex = cmbKodeJenis.getSelectedIndex();
        Jenis jenis = new Jenis();
        if(selectedIndex != 0){
            jenis.setKodeJenis(cmbKodeJenis.getSelectedItem().toString());
            barang.setJenis(jenis);
            lblValidateKodeJenis.setVisible(true);
            lblValidateKodeJenis.setText("");
        }
        else{
            jenis.setKodeJenis(null);
            barang.setJenis(jenis);
            lblValidateKodeJenis.setVisible(true);
            lblValidateKodeJenis.setText("Pilih Kode Jenis Barang");
        }
        if(txtStok.getText() != null && txtStok.getText().length() > 0){
            barang.setStok( new Integer(txtStok.getText()));
            lblValidateStok.setVisible(true);
            lblValidateStok.setText("");
        }
        else{
            barang.setStok( new Integer(txtStok.getText()));
            lblValidateStok.setVisible(true);
            lblValidateStok.setText("Stok harus diisi");
            
        }
        if(txtHargaBeli.getText() != null && txtHargaBeli.getText().length() > 0){
            barang.setHargaBeli( new BigDecimal(txtHargaBeli.getText()));
            lblValidateHB.setVisible(true);
            lblValidateHB.setText("");
        }
        else{
            barang.setHargaBeli(null);
            lblValidateHB.setVisible(true);
            lblValidateHB.setText("Harga beli harus diisi");
            
        }
        if(txtHargaJual.getText() != null && txtHargaJual.getText().length() > 0){
            barang.setHargaJual( new BigDecimal(txtHargaJual.getText()));
            lblValidateHJ.setVisible(true);
            lblValidateHJ.setText("");
        }
        else{
            barang.setHargaJual(null);
            lblValidateHJ.setVisible(true);
            lblValidateHJ.setText("Harga jual harus diisi");
            
        }
        if(barang.getKodeBarang() != null && barang.getNamaBarang() != null && barang.getJenis().getKodeJenis() != null
                && barang.getStok() != null & barang.getHargaBeli() != null && barang.getHargaJual() != null){
            Main.getMasterService().ubah(barang);
            initPagination();
            clearText();
            statusTxt(false);
            statusSimpan();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbKodeJenis = new javax.swing.JComboBox();
        txtJenisBarang = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        lblValidateKode = new javax.swing.JLabel();
        lblValidateNama = new javax.swing.JLabel();
        lblValidateStok = new javax.swing.JLabel();
        lblValidateHB = new javax.swing.JLabel();
        lblValidateHJ = new javax.swing.JLabel();
        lblValidateKodeJenis = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cmbJumlahBaris = new javax.swing.JComboBox();
        btnPrevious = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        lblHalaman = new javax.swing.JLabel();
        lblTotalData = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.title")); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jPanel1.border.title"))); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel2.text")); // NOI18N

        txtKodeBarang.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtKodeBarang.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel3.text")); // NOI18N

        txtNamaBarang.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtNamaBarang.text")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel1.text")); // NOI18N

        cmbKodeJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Kode Jenis-" }));
        cmbKodeJenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKodeJenisItemStateChanged(evt);
            }
        });
        cmbKodeJenis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbKodeJenisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txtJenisBarang.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtJenisBarang.text")); // NOI18N

        txtHargaBeli.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtHargaBeli.text")); // NOI18N
        txtHargaBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaBeliKeyTyped(evt);
            }
        });

        txtHargaJual.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtHargaJual.text")); // NOI18N
        txtHargaJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaJualKeyTyped(evt);
            }
        });

        txtStok.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStok.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtStok.text")); // NOI18N
        txtStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStokKeyTyped(evt);
            }
        });

        lblValidateKode.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateKode.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateKode.text")); // NOI18N

        lblValidateNama.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateNama.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateNama.text")); // NOI18N

        lblValidateStok.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateStok.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateStok.text")); // NOI18N

        lblValidateHB.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateHB.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateHB.text")); // NOI18N

        lblValidateHJ.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateHJ.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateHJ.text")); // NOI18N

        lblValidateKodeJenis.setForeground(new java.awt.Color(255, 0, 0));
        lblValidateKodeJenis.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblValidateKodeJenis.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel4.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel5.text")); // NOI18N

        jLabel6.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel6.text")); // NOI18N

        jLabel7.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel7.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValidateNama)
                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValidateKode)
                            .addComponent(lblValidateKodeJenis)
                            .addComponent(txtJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValidateStok)
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValidateHB)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValidateHJ))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateKode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateKodeJenis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateStok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateHB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidateHJ)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuNew.png"))); // NOI18N
        btnTambah.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnTambah.text")); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnSimpan.text")); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnUbah.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnUbah.text")); // NOI18N
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnHapus.text")); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuCancel.png"))); // NOI18N
        btnBatal.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnBatal.text")); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnKeluar.text")); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnLast.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnLast.text")); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnNext.text")); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnPrevious.text")); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnFirst.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.btnFirst.text")); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        lblHalaman.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblHalaman.text")); // NOI18N

        lblTotalData.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.lblTotalData.text")); // NOI18N

        jLabel8.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.jLabel8.text")); // NOI18N

        txtCari.setText(org.openide.util.NbBundle.getMessage(BarangPanel.class, "BarangPanel.txtCari.text")); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(btnKeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(lblTotalData))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHalaman)
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(cmbJumlahBaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(lblHalaman)
                    .addComponent(jLabel8)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnKeluar)
                    .addComponent(lblTotalData))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnBatal.setEnabled(true);
        txtKodeBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        cmbKodeJenis.setEnabled(true);
        txtStok.setEnabled(true);
        txtHargaBeli.setEnabled(true);
        txtHargaJual.setEnabled(true);
        clearText();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
       validateSave();
    }//GEN-LAST:event_btnSimpanActionPerformed

    
    private void cmbKodeJenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKodeJenisItemStateChanged
        // TODO add your handling code here:
        int selectedIndex = cmbKodeJenis.getSelectedIndex();
        if(selectedIndex == 0){
            txtJenisBarang.setText("");
        }
        else{
            List<Jenis> listJenis = Main.getMasterService().getJenisByKode(cmbKodeJenis.getSelectedItem().toString());
            for(Jenis j : listJenis){
                txtJenisBarang.setText(j.getJenis());
            }
        }
        
    }//GEN-LAST:event_cmbKodeJenisItemStateChanged

    private void cmbKodeJenisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbKodeJenisPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKodeJenisPopupMenuWillBecomeInvisible

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        validateUpdate();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txtStokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStokKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtStokKeyTyped

    private void txtHargaBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaBeliKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaBeliKeyTyped

    private void txtHargaJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaJualKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaJualKeyTyped

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        statusSimpan();
        tblBarang.clearSelection();
        statusTxt(false);
        clearText();
        validate();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 0){
            Main.getMasterService().hapus(barang);
            initPagination();
            clearText();
            statusTxt(false);
            statusSimpan(); 
        } 
       
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().barangPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().barangPanel = null;
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        nomorHalaman = 1;
        initPagination();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if(nomorHalaman > 1){
            nomorHalaman--;
            initPagination();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(nomorHalaman < totalHalaman){
            nomorHalaman++;
            initPagination();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        nomorHalaman = totalHalaman;
        initPagination();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        if(txtCari.getText() != null && !txtCari.getText().isEmpty()){
            barangTableModel = new BarangTableModel(Main.getMasterService().searchBarangByNama(txtCari.getText()));
            tblBarang.setModel(barangTableModel);
            rendererData();
        }
        else{
            initPagination();
        }
        
    }//GEN-LAST:event_txtCariKeyTyped

     private class KodeJenisItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            initPagination();
            statusTxt(false); 
            statusSimpan();
            validate();
            clearText();
        }
    }
     
    private class BarangTableModel extends AbstractTableModel{
        
        private final List<Barang> listBarang;
        
        public BarangTableModel(List<Barang> listBarang){
            this.listBarang = listBarang;
        }
        
        @Override
        public int getRowCount(){
            return listBarang.size();
        }
        
        @Override
        public int getColumnCount(){
            return 6;
        }        
        
        @Override
        public Object getValueAt(int baris, int kolom){
            Barang barang = listBarang.get(baris);
            switch(kolom){
                case 0 :
                    return barang.getKodeBarang();
                case 1 :
                    return barang.getNamaBarang();
                case 2 :
                    return barang.getJenis().getKodeJenis();     
                case 3 :
                    return barang.getStok();
                case 4 :
                    return barang.getHargaBeli();
                case 5 :
                    return barang.getHargaJual();
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
                    return "Kode Jenis";
                case 3 :
                    return "Stok";
                case 4 :
                    return "Harga Beli";
                case 5 :
                    return "Harga Jual";
                default :
                    return "";
            }
        }
    }
    
    private class BarangSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e){
            // kalau ada baris terseleksi
            if(tblBarang.getSelectedRow() >= 0){
                Jenis jenis = new Jenis();
                String kode = barangTableModel.getValueAt(tblBarang.getSelectedRow(), 0).toString();
                barang.setKodeBarang(kode);
                String nama = barangTableModel.getValueAt(tblBarang.getSelectedRow(), 1).toString();
                barang.setNamaBarang(nama);
                String kodeJenis = barangTableModel.getValueAt(tblBarang.getSelectedRow(), 2).toString();
                jenis.setKodeJenis(kodeJenis);
                barang.setJenis(jenis);
                Integer stok = Integer.valueOf(barangTableModel.getValueAt(tblBarang.getSelectedRow(), 3).toString());
                barang.setStok(stok);
                BigDecimal hargaBeli = new BigDecimal(barangTableModel.getValueAt(tblBarang.getSelectedRow(), 4).toString());
                barang.setHargaBeli(hargaBeli);
                BigDecimal hargaJual = new BigDecimal(barangTableModel.getValueAt(tblBarang.getSelectedRow(), 5).toString());
                barang.setHargaJual(hargaJual);
                txtKodeBarang.setText(barang.getKodeBarang());
                txtNamaBarang.setText(barang.getNamaBarang());
                cmbKodeJenis.setSelectedItem(barang.getJenis().getKodeJenis());
                txtStok.setText(barang.getStok().toString());
                txtHargaBeli.setText(barang.getHargaBeli().toString());
                txtHargaJual.setText(String.valueOf(barang.getHargaJual()));
                txtKodeBarang.setEnabled(false);
                txtNamaBarang.setEnabled(true);
                cmbKodeJenis.setEnabled(true);
                txtStok.setEnabled(true);
                txtHargaBeli.setEnabled(true);
                txtHargaJual.setEnabled(true);
                btnTambah.setEnabled(false);
                btnSimpan.setEnabled(false);
                btnUbah.setEnabled(true);
                btnHapus.setEnabled(true);
                btnBatal.setEnabled(true);
                
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cmbJumlahBaris;
    private javax.swing.JComboBox cmbKodeJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHalaman;
    private javax.swing.JLabel lblTotalData;
    private javax.swing.JLabel lblValidateHB;
    private javax.swing.JLabel lblValidateHJ;
    private javax.swing.JLabel lblValidateKode;
    private javax.swing.JLabel lblValidateKodeJenis;
    private javax.swing.JLabel lblValidateNama;
    private javax.swing.JLabel lblValidateStok;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtJenisBarang;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
