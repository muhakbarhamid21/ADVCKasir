
package formmanajer;

import formmanajer.datauser.usergudangframe;
import formmanajer.laporan.barangmasukframe;
import formmanajer.laporan.penjualanframe;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class manajerframe extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsBarang=null;

    public manajerframe() {
        initComponents();
        waktu();
    }
    
    // waktu
    private void waktu(){
        new Thread(){
            int waktumulai;
            @Override
            public void run(){
                while(true){
                    Calendar kal = new GregorianCalendar();
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int bulan = kal.get(Calendar.MONTH)+1;
                    int tahun = kal.get(Calendar.YEAR);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String waktu= jam+" : "+menit+" : "+detik;
                    String tanggal = hari+" - "+bulan+" - "+tahun;
                    lwaktu.setText(waktu);
                    ltanggal.setText(tanggal);
                }
            }
        }.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lwaktu = new javax.swing.JLabel();
        ltanggal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        blapjual = new javax.swing.JButton();
        blapbarmsk = new javax.swing.JButton();
        bgudang = new javax.swing.JButton();
        bkasir = new javax.swing.JButton();
        bmanajer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(156, 0, 25));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1236, 5, 39, 39);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADVCKasir (manajer)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(5, 0, 300, 50);

        lwaktu.setForeground(new java.awt.Color(255, 255, 255));
        lwaktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lwaktu.setText("waktu");
        jPanel1.add(lwaktu);
        lwaktu.setBounds(520, 5, 240, 20);

        ltanggal.setForeground(new java.awt.Color(255, 255, 255));
        ltanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltanggal.setText("tanggal");
        jPanel1.add(ltanggal);
        ltanggal.setBounds(520, 25, 240, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 49);

        jPanel2.setBackground(new java.awt.Color(207, 28, 45));
        jPanel2.setLayout(null);

        blapjual.setText("LAPORAN PENJUALAN");
        blapjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blapjualActionPerformed(evt);
            }
        });
        jPanel2.add(blapjual);
        blapjual.setBounds(80, 95, 210, 100);

        blapbarmsk.setText("<html>\n<center>\nLAPORAN BARANG MASUK\n</center>\n</html>"); // NOI18N
        blapbarmsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blapbarmskActionPerformed(evt);
            }
        });
        jPanel2.add(blapbarmsk);
        blapbarmsk.setBounds(80, 210, 210, 100);

        bgudang.setText("Gudang");
        bgudang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgudangActionPerformed(evt);
            }
        });
        jPanel2.add(bgudang);
        bgudang.setBounds(80, 375, 210, 60);

        bkasir.setText("Kasir");
        bkasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkasirActionPerformed(evt);
            }
        });
        jPanel2.add(bkasir);
        bkasir.setBounds(80, 450, 210, 60);

        bmanajer.setText("Manajer");
        jPanel2.add(bmanajer);
        bmanajer.setBounds(80, 529, 210, 60);

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data User", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(60, 340, 250, 270);

        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(60, 60, 250, 270);

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 30, 290, 600);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(372, 44, 866, 584);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 49, 1280, 672);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(manajerframe.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar2.png"));
        jLabel1.setIcon(A);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar1.png"));
        jLabel1.setIcon(A);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar2.png"));
        jLabel1.setIcon(A);
    }//GEN-LAST:event_jLabel1MousePressed

    private void bgudangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgudangActionPerformed
        usergudangframe ugf = new usergudangframe();
        ugf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bgudangActionPerformed

    private void bkasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bkasirActionPerformed

    private void blapjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blapjualActionPerformed
        penjualanframe pf = new penjualanframe();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_blapjualActionPerformed

    private void blapbarmskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blapbarmskActionPerformed
        barangmasukframe bmf = new barangmasukframe();
        bmf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_blapbarmskActionPerformed


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
            java.util.logging.Logger.getLogger(manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manajerframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgudang;
    private javax.swing.JButton bkasir;
    private javax.swing.JButton blapbarmsk;
    private javax.swing.JButton blapjual;
    private javax.swing.JButton bmanajer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel lwaktu;
    // End of variables declaration//GEN-END:variables
}
