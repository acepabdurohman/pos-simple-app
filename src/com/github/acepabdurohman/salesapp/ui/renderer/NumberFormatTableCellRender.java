
package com.github.acepabdurohman.salesapp.ui.renderer;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/*
    Kelas untuk mengformat uang pada jtable dengan aturan pemisahan menggunakan koma
*/
public class NumberFormatTableCellRender extends DefaultTableCellRenderer{

    //private final NumberFormat rupiah;
    private DecimalFormat decFormat;
    
    public NumberFormatTableCellRender(){
        //rupiah = NumberFormat.getCurrencyInstance( new Locale("in", "ID"));
        decFormat = new DecimalFormat("#,###,###");
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        //label.setText(rupiah.format(value));
        label.setText(decFormat.format(value));
        return label;
    }        
}
