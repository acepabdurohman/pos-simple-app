package com.github.acepabdurohman.salesapp;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.service.MasterService;
import com.github.acepabdurohman.salesapp.service.SecurityService;
import com.github.acepabdurohman.salesapp.service.TransactionService;
import com.github.acepabdurohman.salesapp.service.impl.MasterServiceImpl;
import com.github.acepabdurohman.salesapp.service.impl.SecurityServiceImpl;
import com.github.acepabdurohman.salesapp.service.impl.TransactionServiceImpl;
import com.github.acepabdurohman.salesapp.ui.LoginFrame;
import com.github.acepabdurohman.salesapp.ui.MainFrame;

/*
    Kelas main sebagai kelas utama
    Ketika di run pertama kali akan memanggil form login
    Untuk memudahkan pemanggilan, setiap kelas yang dibutuhkan dideklarasikan dan diinisialisasi

*/
public class Main {
   
    private static MainFrame frame;
    private static MasterService masterService;
    private static TransactionService transactionService;
    private static SecurityService securityService;
    private static LoginFrame loginFrame;
    
    public static MainFrame getFrame(){
        return frame;
    }
    public static MasterService getMasterService(){
        return masterService;
    }
    public static TransactionService getTransactionService(){
        return transactionService;
    }
    public static SecurityService getSecurityService(){
        return securityService;
    }
    public static LoginFrame getLoginFrame(){
        return loginFrame;
    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater( new Runnable() {
            
            @Override
            public void run() {      
                loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                frame = new MainFrame();
                KoneksiDatabase koneksiDB = new KoneksiDatabase();
                // polimorpism
                masterService = new MasterServiceImpl(koneksiDB);
                transactionService = new TransactionServiceImpl(koneksiDB);
                securityService = new SecurityServiceImpl(koneksiDB);
            }
        });
    }
}
