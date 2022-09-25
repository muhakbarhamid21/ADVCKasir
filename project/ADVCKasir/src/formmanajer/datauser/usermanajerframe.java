
package formmanajer.datauser;

import formmanajer.laporan.*;
import db.koneksi;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class usermanajerframe extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsBarang=null;

    public usermanajerframe() {
        initComponents();
        waktu();
        tampilData();
        SetEditOff();
        bmanajer.setEnabled(false);
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
            Object[] judul_kolom = {"Nama", "Username", "Password", "HP", "Email", "Alamat"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tuser.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT * from user_manajer ORDER BY nama ASC");
            while(RsBarang.next()){
                Object[] data={
                    RsBarang.getString("nama"),
                    RsBarang.getString("username"),
                    RsBarang.getString("password"),
                    RsBarang.getString("hp"),
                    RsBarang.getString("email"),
                    RsBarang.getString("alamat") 
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }

        // disable button
        bsimpan.setEnabled(false);
        bperbarui.setEnabled(false);
        bhapus.setEnabled(false);
        bbatal.setEnabled(false);
    }
    
    void tblKeForm(){
        tfnama.setText(tabModel.getValueAt(tuser.getSelectedRow(),0)+"");
        tfusername.setText(tabModel.getValueAt(tuser.getSelectedRow(),1)+"");
        tfpassword.setText(tabModel.getValueAt(tuser.getSelectedRow(),2)+"");
        tfhp.setText(tabModel.getValueAt(tuser.getSelectedRow(),3)+"");
        tfemail.setText(tabModel.getValueAt(tuser.getSelectedRow(),4)+"");
        tfalamat.setText(tabModel.getValueAt(tuser.getSelectedRow(),5)+"");
        
        bperbarui.setEnabled(true);
        bhapus.setEnabled(true);
        bbatal.setEnabled(true);
        bsimpan.setEnabled(false);
    }
    
    //membersihkan form
   private void BersihData(){
        tfnama.setText("");
        tfusername.setText("");
        tfpassword.setText("");
        tfhp.setText(""); 
        tfemail.setText("");
        tfalamat.setText("");
    }
   
   //disable form
   private void SetEditOff(){
        tfnama.setEnabled(false);
        tfusername.setEnabled(false);
        tfpassword.setEnabled(false);
        tfhp.setEnabled(false);
        tfemail.setEnabled(false);
        tfalamat.setEnabled(false);
   }
      
   private void seteditOn(){
        tfnama.setEnabled(true);
        tfusername.setEnabled(true);
        tfpassword.setEnabled(true);
        tfhp.setEnabled(true);
        tfemail.setEnabled(true);
        tfalamat.setEnabled(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tuser = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfhp = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfusername = new javax.swing.JTextField();
        tfpassword = new javax.swing.JTextField();
        tfemail = new javax.swing.JTextField();
        tfalamat = new javax.swing.JTextField();
        btambahkanbaru = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bperbarui = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        blapbarmsk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blapbarmsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blapbarmskActionPerformed(evt);
            }
        });
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

        tuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Username", "Password", "HP", "Email", "Alamat"
            }
        ));
        tuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tuserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tuser);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(820, 100, 380, 490);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("(+62)");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 0, 50, 30);

        tfhp.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel3.add(tfhp);
        tfhp.setBounds(60, 0, 210, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(530, 280, 270, 30);

        tfnama.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel2.add(tfnama);
        tfnama.setBounds(530, 100, 270, 30);

        tfusername.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel2.add(tfusername);
        tfusername.setBounds(530, 160, 270, 30);

        tfpassword.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel2.add(tfpassword);
        tfpassword.setBounds(530, 220, 270, 30);

        tfemail.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel2.add(tfemail);
        tfemail.setBounds(530, 340, 270, 30);

        tfalamat.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel2.add(tfalamat);
        tfalamat.setBounds(530, 410, 270, 30);

        btambahkanbaru.setText("ADD NEW");
        btambahkanbaru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btambahkanbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahkanbaruActionPerformed(evt);
            }
        });
        jPanel2.add(btambahkanbaru);
        btambahkanbaru.setBounds(400, 480, 200, 50);

        bbatal.setText("CANCEL");
        bbatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel2.add(bbatal);
        bbatal.setBounds(700, 530, 100, 50);

        bhapus.setText("DELETE");
        bhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel2.add(bhapus);
        bhapus.setBounds(600, 530, 100, 50);

        bperbarui.setText("UPDATE");
        bperbarui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bperbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bperbaruiActionPerformed(evt);
            }
        });
        jPanel2.add(bperbarui);
        bperbarui.setBounds(500, 530, 100, 50);

        bsimpan.setText("SAVE");
        bsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(400, 530, 100, 50);

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Alamat");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(400, 410, 80, 30);

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Email");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(400, 340, 80, 30);

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("HP");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(400, 280, 130, 30);

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Password");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(400, 220, 130, 30);

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Username");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(400, 160, 130, 30);

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Nama");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(400, 100, 130, 30);

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data User", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(60, 340, 250, 270);

        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(60, 60, 250, 270);

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 30, 290, 600);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data User Manajer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(370, 30, 870, 600);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 49, 1280, 672);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(usermanajerframe.MAXIMIZED_BOTH);
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

    private void btambahkanbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahkanbaruActionPerformed
        BersihData();
        tfnama.requestFocus();
        bsimpan.setEnabled(true);
        bperbarui.setEnabled(false);
        bhapus.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_btambahkanbaruActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        BersihData();
        bsimpan.setEnabled(false);
        bperbarui.setEnabled(false);
        bhapus.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        String nama=tfnama.getText();

        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            tfnama.requestFocus();
        }
        else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?","Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                stt.executeUpdate("DELETE FROM user_manajer WHERE nama='"+nama+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bperbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bperbaruiActionPerformed
        String nama=tfnama.getText();
        String user=tfusername.getText();
        String pass=tfpassword.getText();
        String hp=tfhp.getText();
        String email=tfemail.getText();
        String alamat=tfalamat.getText();

        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            tfnama.requestFocus();
        }else if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            tfusername.requestFocus();
        }else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
            tfpassword.requestFocus();
        }else if (hp.isEmpty()) {
            JOptionPane.showMessageDialog(null,"HP tidak boleh kosong");
            tfhp.requestFocus();
        }else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Email tidak boleh kosong");
            tfemail.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong");
            tfalamat.requestFocus();
        }
        else if (!(new Scanner(hp).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Nomor HP harus angka");
            tfhp.requestFocus();
        }
        else{
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                
                stt.executeUpdate("UPDATE user_manajer SET username='"+user+"', password='"+pass+"', hp='"+hp+"', email='"+email+"', alamat='"+alamat+"' WHERE nama='"+nama+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bperbaruiActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String nama=tfnama.getText();
        String user=tfusername.getText();
        String pass=tfpassword.getText();
        String hp=tfhp.getText();
        String email=tfemail.getText();
        String alamat=tfalamat.getText();

        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            tfnama.requestFocus();
        }else if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            tfusername.requestFocus();
        }else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
            tfpassword.requestFocus();
        }else if (hp.isEmpty()) {
            JOptionPane.showMessageDialog(null,"HP tidak boleh kosong");
            tfhp.requestFocus();
        }else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Email tidak boleh kosong");
            tfemail.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong");
            tfalamat.requestFocus();
        }
        else if (!(new Scanner(hp).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Nomor HP harus angka");
            tfhp.requestFocus();
        }
        else{
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into user_manajer(nama,username,password,hp,email,alamat)"+
                    "VALUES('"+nama+"','"+user+"','"+pass+"','"+hp+"','"+email+"','"+alamat+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tuserMouseClicked
        seteditOn();
        tblKeForm();
        tfnama.setEnabled(false);
    }//GEN-LAST:event_tuserMouseClicked

    private void bmanajerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmanajerActionPerformed
        usermanajerframe umf = new usermanajerframe();
        umf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bmanajerActionPerformed

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
            java.util.logging.Logger.getLogger(usermanajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usermanajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usermanajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usermanajerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usermanajerframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bgudang;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkasir;
    private javax.swing.JButton blapbarmsk;
    private javax.swing.JButton blapjual;
    private javax.swing.JButton bmanajer;
    private javax.swing.JButton bperbarui;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambahkanbaru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel lwaktu;
    private javax.swing.JTextField tfalamat;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfhp;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfpassword;
    private javax.swing.JTextField tfusername;
    private javax.swing.JTable tuser;
    // End of variables declaration//GEN-END:variables
}
