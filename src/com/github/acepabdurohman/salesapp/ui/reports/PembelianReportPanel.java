package com.github.acepabdurohman.salesapp.ui.reports;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
    Panel report (UI) untuk user agar dapat menampilkan report per periode
*/
public class PembelianReportPanel extends javax.swing.JInternalFrame {

    private KoneksiDatabase koneksiDB = new KoneksiDatabase();
    public PembelianReportPanel() {
        initComponents();
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupReport = new javax.swing.ButtonGroup();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        btnDisplay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.title")); // NOI18N

        dateChooserFrom.setDateFormatString(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.dateChooserFrom.dateFormatString")); // NOI18N

        btnDisplay.setText(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.btnDisplay.text")); // NOI18N
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.jLabel1.text_1")); // NOI18N

        dateChooserTo.setDateFormatString(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.dateChooserTo.dateFormatString")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(PembelianReportPanel.class, "PembelianReportPanel.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateChooserTo, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(dateChooserFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplay)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        // TODO add your handling code here:
        Connection koneksi = koneksiDB.connect();
        Map<String, Object> parameter = new HashMap<>();
        try{
            InputStream is = PembelianReportPanel.class.getResourceAsStream("/reports/ReportPembelian.jrxml");
            JasperDesign design = JRXmlLoader.load(is);
            parameter.put("PRM_TANGGAL_FROM", dateChooserFrom.getDate());
            parameter.put("PRM_TANGGAL_TO", dateChooserTo.getDate());
            JasperReport report = JasperCompileManager.compileReport(design);
            JasperPrint print = JasperFillManager.fillReport(report, parameter, koneksi);
            JasperViewer.viewReport(print, false);
        }
        catch(JRException exe){
            exe.printStackTrace();
        }
    }//GEN-LAST:event_btnDisplayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplay;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.ButtonGroup radioGroupReport;
    // End of variables declaration//GEN-END:variables
}
