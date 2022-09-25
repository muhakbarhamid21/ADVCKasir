/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formmasuk.masuk;

import db.koneksi;
import formgudang.gudangframe;
import formmanajer.manajerframe;
import formmasuk.menu.menuframe;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class masuk_manajerframe extends javax.swing.JFrame {

    /**
     * Creates new form masuk_manajerframe
     */
    public masuk_manajerframe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txuser = new javax.swing.JTextField();
        txpass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(748, 736));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar1.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(703, 5, 39, 39);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/topbutton/images/perkecil1.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(658, 5, 39, 39);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/masuk/images/kembali1.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(6, 5, 39, 39);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/masuk/images/tombol-masuk1.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(237, 539, 276, 93);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lupa Kata Sandi ? Hubungi Admin (Klik Disini)");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 670, 460, 30);

        txuser.setBackground(new java.awt.Color(225, 225, 225));
        txuser.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txuser.setBorder(null);
        getContentPane().add(txuser);
        txuser.setBounds(110, 284, 600, 86);

        txpass.setBackground(new java.awt.Color(225, 225, 225));
        txpass.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txpass.setBorder(null);
        getContentPane().add(txpass);
        txpass.setBounds(110, 388, 600, 86);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/masuk/images/masuk-manajer.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 748, 736);

        setSize(new java.awt.Dimension(748, 736));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // TOMBOL TUTUP
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked
    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar2.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MouseEntered
    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar1.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MouseExited
    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar2.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MousePressed
    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        ImageIcon A = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/keluar2.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MouseReleased
    // END TOMBOL TUTUP
    
    // TOMBOL PERKECIL
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(masuk_gudangframe.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked
    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        ImageIcon B = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/perkecil2.png"));
        jLabel3.setIcon(B);
    }//GEN-LAST:event_jLabel3MouseEntered
    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        ImageIcon B = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/perkecil1.png"));
        jLabel3.setIcon(B);
    }//GEN-LAST:event_jLabel3MouseExited
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        ImageIcon B = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/perkecil2.png"));
        jLabel3.setIcon(B);
    }//GEN-LAST:event_jLabel3MousePressed
    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        ImageIcon B = new ImageIcon(getClass().getResource("/formmasuk/topbutton/images/perkecil2.png"));
        jLabel3.setIcon(B);
    }//GEN-LAST:event_jLabel3MouseReleased
    // END TOMBOL PERKECIL
    
    // TOMBOL KEMBALI
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        menuframe mf = new menuframe();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/kembali2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseEntered
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/kembali1.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseExited
    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/kembali2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MousePressed
    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/kembali2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseReleased
    // END TOMBOL KEMBALI
    
    // TOMBOL MASUK
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet result=statement.executeQuery("select * from user_manajer where " + "username='" + txuser.getText() + "'");
            if (result.next()) {
                if (txpass.getText().equals(result.getString("password"))) {
                            menuframe mef = new menuframe();
                            mef.setVisible(true);
                            manajerframe mf = new manajerframe();
                            mf.setVisible(true);
                            this.dispose();

                } else {
                    popup1 pu1 = new popup1();
                    pu1.setVisible(true);
                    txpass.setText("");
                    txuser.requestFocus();
                }
            } else {
                popup2 pu2 = new popup2();
                pu2.setVisible(true);
                txuser.setText("");
                txpass.setText("");
                txuser.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "GAGAL TERKONEKSI DENGAN DATABASE GAN !!!");
        }    
    }//GEN-LAST:event_jLabel5MouseClicked
    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/tombol-masuk2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseEntered
    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/tombol-masuk1.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseExited
    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/tombol-masuk2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MousePressed
    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/masuk/images/tombol-masuk2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseReleased
    // END TOMBOL MASUK
    
    // HYPERLINK EMAIL
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            Desktop desktop = Desktop.getDesktop();
            URI url = new URI("mailto:m_akbarhamid@student.unud.ac.id");
            if (Desktop.isDesktopSupported()) {
                try {
                    desktop.browse(url);
                } 
                catch (IOException ex) {
                    Logger.getLogger(masuk_manajerframe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        catch (URISyntaxException ex) {
            Logger.getLogger(masuk_manajerframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked
    // END HYPERLINK HTML
    
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
            java.util.logging.Logger.getLogger(masuk_manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masuk_manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masuk_manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masuk_manajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masuk_manajerframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txpass;
    private javax.swing.JTextField txuser;
    // End of variables declaration//GEN-END:variables
}
