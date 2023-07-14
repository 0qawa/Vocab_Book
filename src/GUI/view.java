/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author ogawa
 */
import CSV.CSV;
import book.QandA;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableCellRenderer;

public class view extends javax.swing.JFrame{

    static String[] columnNames = {"問題", "答え", "正答率"};
    static String[] s = {"", "", ""};
    /**
     * Creates new form gui
     */
    static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    static CSV csv = null;
    static String name = null;
    
    public view(CSV csv, String filename) {
        initComponents();
        this.csv = csv;
        String[][] tabledata = this.csv.DataArray();
        this.name = filename;

        for(int i = 0 ; i < tabledata.length ; i++){
            tableModel.addRow(tabledata[i]);
        }
        /*
        String[] s = {"", "", ""};
        tableModel.addRow(s);
        */
    }
    
    public static void add(QandA qa){
        String[] td = qa.ToArray();
        tableModel.addRow(td);
    }
    
    /*
    public void tableChanged(TableModelEvent e) {
        SysMes.setText("a");
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getLastRow();
            String q = tableModel.getValueAt(row, 0).toString();
            String a = tableModel.getValueAt(row, 0).toString();
            String r = tableModel.getValueAt(row, 0).toString();  //正答率の変更はできないようにする
            if (q.equals("")){
                if (r.equals("")){  //問題も答えも入力されていなかったら
                    tableModel.removeRow(row+1);
                }
                else{  //答えのみ入力されていたら
                    
                }
            }else if(r.equals("")){  //問題のみ入力されていたら
                
            }else{  //どちらも入力されていたら
                tableModel.setValueAt("0.0", row, 2);
                tableModel.addRow(s);
            }
        } 
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(tableModel);
        enter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Qtext = new javax.swing.JTextArea();
        Atext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        SysMes = new javax.swing.JLabel();
        modoru = new javax.swing.JButton();
        Hensyu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable1);
        jTable1.setModel(tableModel);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        DefaultTableColumnModel columnModel = (DefaultTableColumnModel)jTable1.getColumnModel();

        TableColumn column = null;

        column = columnModel.getColumn(0);
        column.setPreferredWidth(370);
        column = columnModel.getColumn(1);
        column.setPreferredWidth(130);
        column = columnModel.getColumn(2);
        column.setPreferredWidth(91);

        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        TableColumn col = jTable1.getColumnModel().getColumn(1);
        col.setCellRenderer(tableCellRenderer);

        DefaultTableCellRenderer tableCellRenderer1 = new DefaultTableCellRenderer();
        tableCellRenderer1.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        TableColumn col1 = jTable1.getColumnModel().getColumn(2);
        col1.setCellRenderer(tableCellRenderer);

        enter.setText("入力");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });

        Qtext.setColumns(20);
        Qtext.setRows(5);
        jScrollPane1.setViewportView(Qtext);

        Atext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("問題の登録");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("問題の答え");

        Delete.setText("削除");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jToggleButton1.setText("保存");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        SysMes.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        SysMes.setForeground(new java.awt.Color(255, 0, 0));

        modoru.setText("戻る");
        modoru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoruActionPerformed(evt);
            }
        });

        Hensyu.setText("編集");
        Hensyu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HensyuActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(modoru))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Hensyu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Atext, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SysMes, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Atext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SysMes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(jToggleButton1)
                    .addComponent(enter)
                    .addComponent(Hensyu))
                .addGap(12, 12, 12)
                .addComponent(modoru)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //入力ボタンを押したとき
    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        // TODO add your handling code here:
        csv.Input(Qtext.getText(),Atext.getText());
        add(csv.OutputLast());
        SysMes.setText(" ");
    }//GEN-LAST:event_enterActionPerformed

    private void AtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtextActionPerformed

    //削除ボタンを押したとき
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int number[] = jTable1.getSelectedRows();  //選択された行のインデックス配列
        for(int i = 0 ; i < number.length ; i++){
            tableModel.removeRow(number[i]-i);
            csv.Delete(number[i]-i);
        }
        SysMes.setText(" ");
    }//GEN-LAST:event_DeleteActionPerformed

    //保存ボタンを押したとき
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:        
        /*
        String q = null, a = null;
        float r = 0;
        csv.AllClear();
        for(int i = 0;i<tableModel.getRowCount();i++){
            q = tableModel.getValueAt(i, 0).toString();
            a = tableModel.getValueAt(i, 1).toString();
            r = Float.parseFloat(tableModel.getValueAt(i, 0).toString());
            csv.Input(q,a,r);
        }
        */
        csv.MakeCSV(name);
        SysMes.setText("保存しました");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    //戻るボタンを押したとき
    private void modoruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoruActionPerformed
        // TODO add your handling code here:
        //メニュー画面に戻る
        menu mn = new menu(csv, name);
        mn.show();
        tableModel = new DefaultTableModel(columnNames, 0);
        dispose();
    }//GEN-LAST:event_modoruActionPerformed

    //編集ボタンを押したとき
    private void HensyuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HensyuActionPerformed
        // TODO add your handling code here:
        int number[] = jTable1.getSelectedRows();  //選択された行のインデックス配列
        if (number.length > 1){
            SysMes.setText("a");
            javax.swing.JLabel label = new javax.swing.JLabel("1つだけ選択してください");
            label.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, label);
        }
        else{
            for(int i = 0 ; i < number.length ; i++){
                tableModel.removeRow(number[i]-i);
                csv.Delete(number[i]-i);
            }
        }    
        SysMes.setText(" ");
    }//GEN-LAST:event_HensyuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Atext;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Hensyu;
    private javax.swing.JTextArea Qtext;
    private javax.swing.JLabel SysMes;
    private javax.swing.JButton enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton modoru;
    // End of variables declaration//GEN-END:variables
}
