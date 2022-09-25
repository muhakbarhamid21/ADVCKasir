
package formmanajer.laporan;

import db.koneksi;
import formmanajer.datauser.usergudangframe;
import formmanajer.datauser.userkasirframe;
import formmanajer.datauser.usermanajerframe;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class barangmasukframe extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsBarang=null;

    public barangmasukframe() {
        initComponents();
        waktu();
        tampilData();
        sb();
        hbb();
        hjb();
        blapbarmsk.setEnabled(false);
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
    
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Tanggal", "Nama Barang", "Kode Barang", "Satuan Barang", "Stok Barang", "Harga Beli Barang", "Harga Jual Barang"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tlaporan.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT DATE_FORMAT(waktumasuk_barang, '%d %M %Y'), nama_barang, kode_barang, satuan_barang, stok_barang, hargabeli_barang, hargajual_barang FROM barang");
            while(RsBarang.next()){
                Object[] data={
                    RsBarang.getString("DATE_FORMAT(waktumasuk_barang, '%d %M %Y')"),
                    RsBarang.getString("nama_barang"),
                    RsBarang.getString("kode_barang"),
                    RsBarang.getString("satuan_barang"),
                    RsBarang.getString("stok_barang"),
                    RsBarang.getString("hargabeli_barang"),
                    RsBarang.getString("hargajual_barang"),
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

    public void sb(){
        ltotal.setText("0");
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();

            RsBarang=stt.executeQuery("SELECT SUM(`stok_barang`) AS total FROM barang");
            
            while (RsBarang.next()) {
                ltotal.setText(RsBarang.getString(""+"total"));
            }
            RsBarang.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
    public void hbb(){
        lhpp.setText("0");
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();

            RsBarang=stt.executeQuery("SELECT SUM(`hargabeli_barang`) AS hpp FROM barang");
            
            while (RsBarang.next()) {
                lhpp.setText(RsBarang.getString(""+"hpp"));
            }
            RsBarang.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
    public void hjb(){
        llaba.setText("0");
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();

            RsBarang=stt.executeQuery("SELECT SUM(`hargajual_barang`) AS laba FROM barang");
            
            while (RsBarang.next()) {
                llaba.setText(RsBarang.getString(""+"laba"));
            }
            RsBarang.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
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
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ptotal = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();
        plaba = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lhpp = new javax.swing.JLabel();
        phpp = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        llaba = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlaporan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        blapjual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blapjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blapjualActionPerformed(evt);
            }
        });
        jPanel2.add(blapjual);
        blapjual.setBounds(80, 95, 210, 100);

        blapbarmsk.setText("<html>\n<center>\nLAPORAN BARANG MASUK\n</center>\n</html>"); // NOI18N
        jPanel2.add(blapbarmsk);
        blapbarmsk.setBounds(80, 210, 210, 100);

        bgudang.setText("Gudang");
        bgudang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bgudang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgudangActionPerformed(evt);
            }
        });
        jPanel2.add(bgudang);
        bgudang.setBounds(80, 375, 210, 60);

        bkasir.setText("Kasir");
        bkasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkasirActionPerformed(evt);
            }
        });
        jPanel2.add(bkasir);
        bkasir.setBounds(80, 450, 210, 60);

        bmanajer.setText("Manajer");
        bmanajer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bmanajer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmanajerActionPerformed(evt);
            }
        });
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
        jPanel2.add(jDateChooser2);
        jDateChooser2.setBounds(440, 90, 80, 26);

        jMonthChooser1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jMonthChooser1.setYearChooser(null);
        jPanel2.add(jMonthChooser1);
        jMonthChooser1.setBounds(580, 90, 130, 26);
        jPanel2.add(jYearChooser1);
        jYearChooser1.setBounds(780, 90, 59, 26);

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tahun");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(720, 90, 60, 30);

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("CARI BERDASARKAN");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(400, 60, 440, 30);

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Hari");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(400, 90, 80, 30);

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Bulan");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(530, 90, 60, 30);

        ptotal.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(207, 28, 45));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Stok Barang");
        ptotal.add(jLabel24);
        jLabel24.setBounds(4, 2, 170, 30);

        ltotal.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        ltotal.setForeground(new java.awt.Color(207, 28, 45));
        ltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ltotal.setText("0");
        ptotal.add(ltotal);
        ltotal.setBounds(77, 2, 330, 30);

        jPanel2.add(ptotal);
        ptotal.setBounds(800, 512, 410, 30);

        plaba.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 204, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Harga Beli Barang");
        plaba.add(jLabel31);
        jLabel31.setBounds(4, 2, 220, 30);

        lhpp.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        lhpp.setForeground(new java.awt.Color(0, 204, 0));
        lhpp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lhpp.setText("0");
        plaba.add(lhpp);
        lhpp.setBounds(77, 2, 330, 30);

        jPanel2.add(plaba);
        plaba.setBounds(800, 549, 410, 30);

        phpp.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Harga Jual Barang");
        phpp.add(jLabel32);
        jLabel32.setBounds(4, 2, 220, 30);

        llaba.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        llaba.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        llaba.setText("0");
        phpp.add(llaba);
        llaba.setBounds(77, 2, 330, 30);

        jPanel2.add(phpp);
        phpp.setBounds(800, 585, 410, 30);

        tlaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Faktur", "Nama Barang", "Kode Barang", "Total", "HPP", "Laba"
            }
        ));
        jScrollPane1.setViewportView(tlaporan);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(400, 120, 810, 380);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan Barang Masuk", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(370, 30, 870, 600);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 49, 1280, 672);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(barangmasukframe.MAXIMIZED_BOTH);
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
        userkasirframe ukf = new userkasirframe();
        ukf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bkasirActionPerformed

    private void blapjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blapjualActionPerformed
        penjualanframe pf = new penjualanframe();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_blapjualActionPerformed

    private void bmanajerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmanajerActionPerformed
        usermanajerframe umf = new usermanajerframe();
        umf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bmanajerActionPerformed


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
            java.util.logging.Logger.getLogger(barangmasukframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangmasukframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangmasukframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangmasukframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangmasukframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bgudang;
    private javax.swing.JButton bkasir;
    private javax.swing.JButton blapbarmsk;
    private javax.swing.JButton blapjual;
    private javax.swing.JButton bmanajer;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lhpp;
    private javax.swing.JLabel llaba;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel ltotal;
    private javax.swing.JLabel lwaktu;
    private javax.swing.JPanel phpp;
    private javax.swing.JPanel plaba;
    private javax.swing.JPanel ptotal;
    private javax.swing.JTable tlaporan;
    // End of variables declaration//GEN-END:variables
}
