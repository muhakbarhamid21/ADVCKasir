
package formgudang;

import db.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class gudangframe extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsBarang=null;

    public gudangframe() {
        initComponents();
        waktu();
        tampilData();
        SetEditOff();
        find();
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
                    String waktu= jam+":"+menit+":"+detik;
                    String tanggal = hari+"-"+bulan+"-"+tahun;
                    lwaktu.setText(waktu);
                    ltanggal.setText(tanggal);
                }
            }
        }.start();
    }
    
    //fungsi untuk menampilkan data produk ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Nama", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Jual", "Waktu Masuk/Update"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tbarang.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT nama_barang, kode_barang, satuan_barang, stok_barang, hargabeli_barang, hargajual_barang, DATE_FORMAT(waktumasuk_barang, '%d %M %Y') from barang ORDER BY nama_barang ASC");
            while(RsBarang.next()){
                Object[] data={
                    RsBarang.getString("nama_barang"),
                    RsBarang.getString("kode_barang"),
                    RsBarang.getString("satuan_barang"),
                    RsBarang.getString("stok_barang"),
                    RsBarang.getString("hargabeli_barang"),
                    RsBarang.getString("hargajual_barang"),
                    RsBarang.getString("DATE_FORMAT(waktumasuk_barang, '%d %M %Y')")
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
    
    //menampilkan data ke form saat data pada tabel di klik 
   void tblKeForm(){
        tfnama.setText(tabModel.getValueAt(tbarang.getSelectedRow(),0)+"");
        tfkode.setText(tabModel.getValueAt(tbarang.getSelectedRow(),1)+"");
        cbsatuan.setSelectedItem(tabModel.getValueAt(tbarang.getSelectedRow(),2)+"");
        tfstok.setText(tabModel.getValueAt(tbarang.getSelectedRow(),3)+"");
        tfhargabeli.setText(tabModel.getValueAt(tbarang.getSelectedRow(),4)+"");
        tfhargajual.setText(tabModel.getValueAt(tbarang.getSelectedRow(),5)+"");
        
        bperbarui.setEnabled(true);
        bhapus.setEnabled(true);
        bbatal.setEnabled(true);
        bsimpan.setEnabled(false);
    }
   
   //membersihkan form
   private void BersihData(){
        tfnama.setText("");
        tfkode.setText("");
        cbsatuan.setSelectedIndex(0);
        tfstok.setText(""); 
        tfhargabeli.setText("");
        tfhargajual.setText("");
    }
   
   //disable form
   private void SetEditOff(){
        tfnama.setEnabled(false);
        tfkode.setEnabled(false);
        cbsatuan.setEnabled(false);
        tfstok.setEnabled(false);
        tfhargabeli.setEnabled(false);
        tfhargajual.setEnabled(false);
   }
      
   private void seteditOn(){
        tfnama.setEnabled(true);
        tfkode.setEnabled(true);
        cbsatuan.setEnabled(true);
        tfstok.setEnabled(true);
        tfhargabeli.setEnabled(true);
        tfhargajual.setEnabled(true);
   }
    
   private void find(){
           try{
            Object[] judul_kolom = {"Nama", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Jual", "Waktu Masuk/Update"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            RsBarang=stt.executeQuery("SELECT nama_barang, kode_barang, satuan_barang, stok_barang, hargabeli_barang, hargajual_barang, DATE_FORMAT(waktumasuk_barang, '%d %M %Y') from barang WHERE nama_barang like '%"+tfcari.getText()+"%' OR kode_barang LIKE '%" +tfcari.getText()+"%'");
           
            while (RsBarang.next()){
                String nb = RsBarang.getString("nama_barang");
                String kb = RsBarang.getString("kode_barang");
                String sab = RsBarang.getString("satuan_barang");
                String stb = RsBarang.getString("stok_barang");
                String hbb = RsBarang.getString("hargabeli_barang");
                String hjb = RsBarang.getString("hargajual_barang");
                String wbm = RsBarang.getString("DATE_FORMAT(waktumasuk_barang, '%d %M %Y')");
                String[] row = {nb, kb, sab, stb, hbb, hjb, wbm};
                tabModel.addRow(row);
            }
            tbarang.setModel(tabModel);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbarang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tfcari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lnamapgw = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfnama = new javax.swing.JTextField();
        tfkode = new javax.swing.JTextField();
        cbsatuan = new javax.swing.JComboBox<>();
        tfstok = new javax.swing.JTextField();
        tfhargabeli = new javax.swing.JTextField();
        tfhargajual = new javax.swing.JTextField();
        btambahkanbaru = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bperbarui = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();

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
        jLabel2.setText("ADVCKasir (gudang)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(5, 0, 280, 50);

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

        tbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Jual", "Waktu Masuk/Update"
            }
        ));
        tbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbarang);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(640, 110, 600, 470);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cari Barang");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(640, 590, 120, 20);

        tfcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfcariKeyReleased(evt);
            }
        });
        jPanel2.add(tfcari);
        tfcari.setBounds(640, 610, 600, 27);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 160, 160, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 110, 110, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Satuan");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 210, 140, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stok");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 260, 110, 29);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga Beli");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(40, 310, 150, 29);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Harga Jual");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 360, 150, 29);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nama Pegawai");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(40, 20, 0, 0);

        lnamapgw.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lnamapgw.setForeground(new java.awt.Color(255, 255, 255));
        lnamapgw.setText("Nama Pegawai");
        jPanel2.add(lnamapgw);
        lnamapgw.setBounds(40, 54, 0, 0);

        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel12);
        jLabel12.setBounds(30, 30, 0, 0);

        tfnama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfnama.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfnama);
        tfnama.setBounds(200, 110, 400, 35);

        tfkode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfkode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfkode);
        tfkode.setBounds(200, 160, 400, 35);

        cbsatuan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbsatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PCs", "Slop", "Botol", "Kaleng", "Lusin", "Kodi", "Gross", "Rim", "Slop", "kg", "L" }));
        jPanel2.add(cbsatuan);
        cbsatuan.setBounds(200, 210, 200, 35);

        tfstok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfstok.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfstok);
        tfstok.setBounds(200, 260, 400, 35);

        tfhargabeli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfhargabeli.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfhargabeli);
        tfhargabeli.setBounds(200, 310, 400, 35);

        tfhargajual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfhargajual.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfhargajual);
        tfhargajual.setBounds(200, 360, 400, 35);

        btambahkanbaru.setText("TAMBAHKAN BARU");
        btambahkanbaru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btambahkanbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahkanbaruActionPerformed(evt);
            }
        });
        jPanel2.add(btambahkanbaru);
        btambahkanbaru.setBounds(130, 420, 210, 50);

        bsimpan.setText("SIMPAN");
        bsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(130, 480, 110, 50);

        bperbarui.setText("PERBARUI");
        bperbarui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bperbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bperbaruiActionPerformed(evt);
            }
        });
        jPanel2.add(bperbarui);
        bperbarui.setBounds(250, 480, 110, 50);

        bhapus.setText("HAPUS");
        bhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel2.add(bhapus);
        bhapus.setBounds(370, 480, 110, 50);

        bbatal.setText("BATAL");
        bbatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel2.add(bbatal);
        bbatal.setBounds(490, 480, 110, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 49, 1280, 672);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(gudangframe.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    //<editor-fold defaultstate="collapsed" desc="TOMBOL TUTUP">
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
    //</editor-fold>
     
    
    private void btambahkanbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahkanbaruActionPerformed
        BersihData();
        tfnama.requestFocus();
        bsimpan.setEnabled(true);
        bperbarui.setEnabled(false);
        bhapus.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_btambahkanbaruActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String nama_barang=tfnama.getText();
        String kode_barang=tfkode.getText();
        String satuan_barang=cbsatuan.getSelectedItem().toString();
        String stok_barang=tfstok.getText();
        String hargabeli_barang=tfhargabeli.getText();
        String hargajual_barang=tfhargajual.getText();

        if (nama_barang.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama barang tidak boleh kosong");
            tfnama.requestFocus();
        }else if (kode_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Kode barang tidak boleh kosong");
            tfkode.requestFocus();
        }else if (satuan_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Satuan barang tidak boleh kosong");
            cbsatuan.requestFocus();
        }else if (stok_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok barang tidak boleh kosong");
            tfstok.requestFocus();
        }else if (hargabeli_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Beli barang tidak boleh kosong");
            tfhargabeli.requestFocus();
        }else if (hargajual_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Jual barang tidak boleh kosong");
            tfhargajual.requestFocus();
        }
        else if (!(new Scanner(stok_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok barang harus angka");
            tfstok.requestFocus();
        }else if (!(new Scanner(hargabeli_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga beli barang harus angka");
            tfhargabeli.requestFocus();
        }else if (!(new Scanner(hargajual_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga jual barang angka");
            tfhargajual.requestFocus();
        }
        else{
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                System.out.println(date); 
                String tgl = date.toString();
                stt.executeUpdate("insert into barang(nama_barang,kode_barang,satuan_barang,stok_barang,hargabeli_barang,hargajual_barang,waktumasuk_barang)"+
                    "VALUES('"+nama_barang+"','"+kode_barang+"','"+satuan_barang+"','"+stok_barang+"','"+hargabeli_barang+"','"+hargajual_barang+"','"+tgl+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bperbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bperbaruiActionPerformed
        String kode_barang=tfkode.getText();
        String nama_barang=tfnama.getText();
        String satuan_barang=cbsatuan.getSelectedItem().toString();
        String stok_barang=tfstok.getText();
        String hargabeli_barang=tfhargabeli.getText();
        String hargajual_barang=tfhargajual.getText();

        if (nama_barang.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama barang tidak boleh kosong");
            tfnama.requestFocus();
        }else if (kode_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Kode barang tidak boleh kosong");
            tfkode.requestFocus();
        }else if (satuan_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Satuan barang tidak boleh kosong");
            cbsatuan.requestFocus();
        }else if (stok_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok barang tidak boleh kosong");
            tfstok.requestFocus();
        }else if (hargabeli_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Beli barang tidak boleh kosong");
            tfhargabeli.requestFocus();
        }else if (hargajual_barang.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Jual barang tidak boleh kosong");
            tfhargajual.requestFocus();
        }
        else if (!(new Scanner(stok_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok barang harus angka");
            tfstok.requestFocus();
        }else if (!(new Scanner(hargabeli_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga beli barang harus angka");
            tfhargabeli.requestFocus();
        }else if (!(new Scanner(hargajual_barang).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga jual barang angka");
            tfhargajual.requestFocus();
        }
        else{
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                System.out.println(date); 
                String tgl = date.toString();
                stt.executeUpdate("UPDATE barang SET kode_barang='"+kode_barang+"', satuan_barang='"+satuan_barang+"', stok_barang='"+stok_barang+"', hargabeli_barang='"+hargabeli_barang+"', hargajual_barang='"+hargajual_barang+"', waktumasuk_barang='"+tgl+"' WHERE nama_barang='"+nama_barang+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bperbaruiActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        String nama_barang=tfnama.getText();

        if (nama_barang.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama barang tidak boleh kosong");
            tfnama.requestFocus();
        }
        else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?","Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            try{
                Connection conn=(Connection)koneksi.GetConnection();
                Statement stt=conn.createStatement();
                stt.executeUpdate("DELETE FROM barang WHERE nama_barang='"+nama_barang+"'");
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

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        BersihData();
        bsimpan.setEnabled(false);
        bperbarui.setEnabled(false);
        bhapus.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_bbatalActionPerformed

    private void tbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbarangMouseClicked
        seteditOn();
        tblKeForm();
    }//GEN-LAST:event_tbarangMouseClicked

    private void tfcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcariKeyReleased
        find();
    }//GEN-LAST:event_tfcariKeyReleased
    
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
            java.util.logging.Logger.getLogger(gudangframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gudangframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gudangframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gudangframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gudangframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bperbarui;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambahkanbaru;
    private javax.swing.JComboBox<String> cbsatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lnamapgw;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel lwaktu;
    private javax.swing.JTable tbarang;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tfhargabeli;
    private javax.swing.JTextField tfhargajual;
    private javax.swing.JTextField tfkode;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfstok;
    // End of variables declaration//GEN-END:variables
}
