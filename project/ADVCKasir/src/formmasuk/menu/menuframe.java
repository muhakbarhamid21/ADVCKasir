
package formmasuk.menu;

import formmasuk.masuk.masuk_gudangframe;
import formmasuk.masuk.masuk_kasirframe;
import formmasuk.masuk.masuk_manajerframe;
import javax.swing.ImageIcon;

public class menuframe extends javax.swing.JFrame {

    public menuframe() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(748, 334));
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-gudang1.png"))); // NOI18N
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
        jLabel4.setBounds(23, 200, 219, 93);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-kasir1.png"))); // NOI18N
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
        jLabel5.setBounds(265, 200, 219, 93);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-manajer1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(507, 200, 219, 93);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/menu/images/menu.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 748, 334);

        setSize(new java.awt.Dimension(748, 334));
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
        this.setState(menuframe.ICONIFIED);
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
    
    // TOMBOL GUDANG
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        masuk_gudangframe m_gf = new masuk_gudangframe();
        m_gf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-gudang2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseEntered
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-gudang1.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseExited
    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-gudang2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MousePressed
    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-gudang2.png"));
        jLabel4.setIcon(C);
    }//GEN-LAST:event_jLabel4MouseReleased
    // END TOMBOL GUDANG
    
    // TOMBOL KASIR
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        masuk_kasirframe m_kf = new masuk_kasirframe();
        m_kf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked
    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-kasir2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseEntered
    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-kasir1.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseExited
    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-kasir2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MousePressed
    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-kasir2.png"));
        jLabel5.setIcon(C);
    }//GEN-LAST:event_jLabel5MouseReleased
    // END TOMBOL KASIR
    
    // TOMBOL MANAJER
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        masuk_manajerframe m_mf = new masuk_manajerframe();
        m_mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked
    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-manajer2.png"));
        jLabel6.setIcon(C);
    }//GEN-LAST:event_jLabel6MouseEntered
    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-manajer1.png"));
        jLabel6.setIcon(C);
    }//GEN-LAST:event_jLabel6MouseExited
    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-manajer2.png"));
        jLabel6.setIcon(C);
    }//GEN-LAST:event_jLabel6MousePressed
    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
        ImageIcon C = new ImageIcon(getClass().getResource("/formmasuk/menu/images/tombol-manajer2.png"));
        jLabel6.setIcon(C);
    }//GEN-LAST:event_jLabel6MouseReleased
    // END TOMBOL MANAJER

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuframe().setVisible(true);
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
    // End of variables declaration//GEN-END:variables
}
