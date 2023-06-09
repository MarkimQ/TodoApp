/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author TI
 */
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable  table, Object value,
            boolean isSelect, boolean hasFocus, int row, int col){
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, 
                isSelect, hasFocus, row, col);
        
        label.setHorizontalAlignment(CENTER);
        
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        
        if (task.getPrazo().after(new Date())){
            label.setBackground(Color.green);
        } else{
            label.setBackground(Color.red);
        }
        
        
        return label;
    }
    
    
    
    
    
    
    
    
    
    
    
}
