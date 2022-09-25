
package formmasuk.loading;

import javax.swing.ImageIcon;

public class loadingframe extends javax.swing.JFrame {

    public loadingframe() {
        
        initComponents();
        loadingbar.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
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

        loadingbar.setBackground(new java.awt.Color(255, 255, 255));
        loadingbar.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        loadingbar.setForeground(new java.awt.Color(156, 0, 25));
        loadingbar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loadingbar.setStringPainted(true);
        getContentPane().add(loadingbar);
        loadingbar.setBounds(43, 219, 662, 57);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formmasuk/loading/images/loading.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 748, 334);

        setSize(new java.awt.Dimension(748, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // tombol keluar
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
    // end tombol end
    
    // tombol perkecil
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(loadingframe.ICONIFIED);
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
    // end tombol perkecil
    
    public static void main(String args[]) {
    
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
            java.util.logging.Logger.getLogger(loadingframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loadingframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loadingframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loadingframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loadingframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JProgressBar loadingbar;
    // End of variables declaration//GEN-END:variables
}
