/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import CSV.CSV;
import book.QandA;
import study.Study;

/**
 *
 * @author Toui Kodera
 */
public class menu extends javax.swing.JFrame {

    public static CSV csv = null;
    /**
     * Creates new form menu
     */
    public menu(CSV csv) {
        initComponents();
        this.csv = csv;
        this.std = new Study(csv);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kanri = new javax.swing.JButton();
        gakusyu = new javax.swing.JButton();
        modoru = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 45, 0, 0));

        kanri.setText("閲覧管理");
        kanri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanriActionPerformed(evt);
            }
        });

        gakusyu.setText("学習スタート");
        gakusyu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gakusyuActionPerformed(evt);
            }
        });

        modoru.setText("戻る");
        modoru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoruActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("BiauKaiTC", 0, 48)); // NOI18N
        jLabel1.setText("デジタル単語帳");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gettyimages-1321495582-612x612.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modoru)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kanri, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gakusyu, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(kanri, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(gakusyu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(modoru)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modoruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoruActionPerformed
        // TODO add your handling code here:
        //初期画面へ切り替え
        syoki sk = new syoki();
        sk.show();
        dispose();
        
    }//GEN-LAST:event_modoruActionPerformed

    private void gakusyuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gakusyuActionPerformed
        // TODO add your handling code here:
        //学習画面へ切り替え
        quiz qz  = new quiz(csv);
        qz.show();
        dispose();
        
        /*
        //quizタブの問題を表示（仮）
        quiz.question.setText("問題");
        
        //quizタブの最初の問題番号と正答率を表示(仮)
        quiz.num.setText("１");
        quiz.per.setText("１");
        */
        
        //問題リストを受け取る
        this.QA = std.setQA();
        
        
        //quizタブの最初の問題番号と正答率を表示
        //問題番号と正解率を受け取り、文字型に直す
        this.ID = std.getID();
        this.question = QA.getQuestion();
        this.rate = QA.getCorrectRate() * 100;
        String st_ID =  ID.toString();
        String st_rate =  String.valueOf(rate);
        //Studyクラスのオブジェクトを共有
        quiz.std = this.std; 
        
        //表示
        quiz.question.setText(this.question);
        quiz.num.setText(st_ID);
        quiz.per.setText(st_rate);
        
    }//GEN-LAST:event_gakusyuActionPerformed

    private void kanriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kanriActionPerformed
        // TODO add your handling code here:
        //閲覧管理画面への切り替え
        view vw = new view(csv);
        vw.show();
        dispose();
    }//GEN-LAST:event_kanriActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu(null).setVisible(true);
            }
        });
        
    }
    
    public static Integer ID;
    public static String question;
    public static float rate;
    public static Study std = null;
    public static QandA QA;
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton gakusyu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton kanri;
    private javax.swing.JButton modoru;
    // End of variables declaration//GEN-END:variables
}
