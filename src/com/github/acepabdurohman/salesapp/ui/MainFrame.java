package com.github.acepabdurohman.salesapp.ui;

import com.github.acepabdurohman.salesapp.Main;
import com.github.acepabdurohman.salesapp.ui.master.BarangPanel;
import com.github.acepabdurohman.salesapp.ui.master.DistributorPanel;
import com.github.acepabdurohman.salesapp.ui.master.JenisBarangPanel;
import com.github.acepabdurohman.salesapp.ui.reports.PembelianReportPanel;
import com.github.acepabdurohman.salesapp.ui.reports.PenjualanReportPanel;
import com.github.acepabdurohman.salesapp.ui.transaction.PembelianPanel;
import com.github.acepabdurohman.salesapp.ui.transaction.PenjualanPanel;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
    Merupakan frame utama yang memanggil setiap panel - panel (UI) yang akan digunakan user
*/
public class MainFrame extends javax.swing.JFrame {

    // Deklarasikan setiap panel - panel tersebut
    public JenisBarangPanel jenisBarangPanel;
    public BarangPanel barangPanel;
    public DistributorPanel distributorPanel;
    public PenjualanPanel penjualanPanel;
    public PembelianPanel pembelianPanel;
    public PenjualanReportPanel penjualanReportPanel;
    public PembelianReportPanel pembelianReportPanel;
    
    public MainFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBarSales = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        menuJenisBarang = new javax.swing.JMenuItem();
        menuBarang = new javax.swing.JMenuItem();
        menuDistributor = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        menuPembelian = new javax.swing.JMenuItem();
        menuPenjualan = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuReportPenjualan = new javax.swing.JMenuItem();
        menuReportPembelian = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Point of Sales");
        setResizable(false);

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        menuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aplikasi.png"))); // NOI18N
        menuFile.setText("File");

        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/keluar.png"))); // NOI18N
        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuLogout);

        menuClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuclose.png"))); // NOI18N
        menuClose.setText("Exit");
        menuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseActionPerformed(evt);
            }
        });
        menuFile.add(menuClose);

        menuBarSales.add(menuFile);

        menuMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/master-data.png"))); // NOI18N
        menuMaster.setText("Master");

        menuJenisBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kategori.png"))); // NOI18N
        menuJenisBarang.setText("Jenis Barang");
        menuJenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJenisBarangActionPerformed(evt);
            }
        });
        menuMaster.add(menuJenisBarang);

        menuBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barang.png"))); // NOI18N
        menuBarang.setText("Barang");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        menuMaster.add(menuBarang);

        menuDistributor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pemasok.png"))); // NOI18N
        menuDistributor.setText("Distributor");
        menuDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDistributorActionPerformed(evt);
            }
        });
        menuMaster.add(menuDistributor);

        menuBarSales.add(menuMaster);

        menuTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transaksi.png"))); // NOI18N
        menuTransaksi.setText("Transaksi");

        menuPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pembelian.png"))); // NOI18N
        menuPembelian.setText("Pembelian");
        menuPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPembelianActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuPembelian);

        menuPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/penjualan.png"))); // NOI18N
        menuPenjualan.setText("Penjualan");
        menuPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenjualanActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuPenjualan);

        menuBarSales.add(menuTransaksi);

        menuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/laporan.png"))); // NOI18N
        menuReport.setText("Report");

        menuReportPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        menuReportPenjualan.setText("Report Penjualan");
        menuReportPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportPenjualanActionPerformed(evt);
            }
        });
        menuReport.add(menuReportPenjualan);

        menuReportPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        menuReportPembelian.setText("Report Pembelian");
        menuReportPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportPembelianActionPerformed(evt);
            }
        });
        menuReport.add(menuReportPembelian);

        menuBarSales.add(menuReport);

        setJMenuBar(menuBarSales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ketika user mengklik setiap menu item
    private void menuJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJenisBarangActionPerformed
        // TODO add your handling code here:
        try{
            if(jenisBarangPanel == null){ // Ketika dipanggil dan masih null
                jenisBarangPanel = new JenisBarangPanel(); // create object
                desktopPane.add(jenisBarangPanel); // tambahkan ke desktoppane
            }
            else{
                jenisBarangPanel.toFront(); // jika tidak null tampilkan panel yang di klik di posisi paling depan
            }
            // tricky code to display an internal frame's location to the middle of frame :)
            Dimension x = desktopPane.getSize();
            Dimension y = jenisBarangPanel.getSize();
            jenisBarangPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            jenisBarangPanel.setVisible(true);
            jenisBarangPanel.setSelected(true);
        } catch(PropertyVetoException ex){
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Gagal menampilkan panel jenis barang", "Informasi", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_menuJenisBarangActionPerformed

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        // TODO add your handling code here:
        try{
            if(barangPanel == null){
                barangPanel = new BarangPanel();
                desktopPane.add(barangPanel);
            }
            else{
                barangPanel.toFront();
            }
            Dimension x = desktopPane.getSize();
            Dimension y = barangPanel.getSize();
            barangPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            barangPanel.setVisible(true);
            barangPanel.setSelected(true);
        } catch(PropertyVetoException exe){
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, exe);
            JOptionPane.showMessageDialog(this, "Gagal menampilkan panel barang", "Informasi", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_menuBarangActionPerformed

    private void menuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuCloseActionPerformed

    private void menuDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDistributorActionPerformed
        // TODO add your handling code here:
        try{
            if(distributorPanel == null){
                distributorPanel = new DistributorPanel();
                desktopPane.add(distributorPanel);
            }
            else{
                distributorPanel.toFront();
            }
            Dimension x = desktopPane.getSize();
            Dimension y = distributorPanel.getSize();
            distributorPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            distributorPanel.setVisible(true);
            distributorPanel.setSelected(true);
        } catch(PropertyVetoException ex){
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menuDistributorActionPerformed

    private void menuPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenjualanActionPerformed
        // TODO add your handling code here:
        if(penjualanPanel == null){
            penjualanPanel = new PenjualanPanel();
            desktopPane.add(penjualanPanel);
        }
        else{
            penjualanPanel.toFront();
        }
        Dimension d = desktopPane.getSize();
        Dimension p = penjualanPanel.getSize();
        penjualanPanel.setLocation((d.width - p.width) / 2, (d.height - p.height) / 2);
        penjualanPanel.setVisible(true);
    }//GEN-LAST:event_menuPenjualanActionPerformed

    private void menuPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPembelianActionPerformed
        // TODO add your handling code here:
        if(pembelianPanel == null){
            // create object
            pembelianPanel = new PembelianPanel();
            desktopPane.add(pembelianPanel);
        }
        else{
            // tampilkan paling depan
            pembelianPanel.toFront();
        }
        Dimension d = desktopPane.getSize();
        Dimension b = pembelianPanel.getSize();
        // lebar x tinggi
        pembelianPanel.setLocation((d.width - b.width) / 2, (d.height - b.height) / 2);
        pembelianPanel.setVisible(true);
    }//GEN-LAST:event_menuPembelianActionPerformed

    private void menuReportPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportPenjualanActionPerformed
        // TODO add your handling code here:
        if(penjualanReportPanel == null){
            penjualanReportPanel = new PenjualanReportPanel();
            desktopPane.add(penjualanReportPanel);
        }
        else{
            penjualanReportPanel.toFront();
        }
        Dimension x = desktopPane.getSize();
        Dimension y = penjualanReportPanel.getSize();
        penjualanReportPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
        penjualanReportPanel.setVisible(true);
    }//GEN-LAST:event_menuReportPenjualanActionPerformed

    private void menuReportPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportPembelianActionPerformed
        // TODO add your handling code here:
        if(pembelianReportPanel == null){
            pembelianReportPanel = new PembelianReportPanel();
            desktopPane.add(pembelianReportPanel);
        }
        else{
            pembelianReportPanel.toFront();
        }
        Dimension x = desktopPane.getSize();
        Dimension y = pembelianReportPanel.getSize();
        pembelianReportPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
        pembelianReportPanel.setVisible(true);
    }//GEN-LAST:event_menuReportPembelianActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        dispose();
        Main.getLoginFrame().setVisible(true);
        
    }//GEN-LAST:event_menuLogoutActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBarSales;
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenuItem menuClose;
    private javax.swing.JMenuItem menuDistributor;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuJenisBarang;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenuItem menuPembelian;
    private javax.swing.JMenuItem menuPenjualan;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenuItem menuReportPembelian;
    private javax.swing.JMenuItem menuReportPenjualan;
    private javax.swing.JMenu menuTransaksi;
    // End of variables declaration//GEN-END:variables
}
