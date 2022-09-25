
package formkasir;

import db.koneksi;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class kasirframe extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    DefaultTableModel tabModel2;
    ResultSet RsBarang=null;
    public long total;
    public long bayar;
    public long kembali;
    
    public kasirframe() {
        initComponents();
        waktu();
        tampilData();
        nofaktur();
        loadData();
        jumlahbarang();
        total();
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
                    String tanggal2 = tahun+"-"+bulan+"-"+hari;
                    lwaktu.setText(waktu);
                    ltanggal.setText(tanggal);
                    tftanggal2.setText(tanggal2);
                }
            }
        }.start();
    }
    
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Nama", "Kode", "Satuan", "Stok", "Harga Beli", "Harga Jual"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tlistbarang.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT * from barang ORDER BY nama_barang ASC");
            while(RsBarang.next()){
                Object[] data={
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
        tfbarang.setEnabled(false);
        tfkode.setEnabled(false);
    }
    
    private void find(){
           try{
            Object[] judul_kolom = {"Nama", "Kode", "Satuan", "Stok", "Harga Beli", "Harga"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            RsBarang=stt.executeQuery("SELECT * from barang WHERE kode_barang like '%"+tfcari.getText()+"%' OR nama_barang LIKE '%" +tfcari.getText() + "%'");
            while (RsBarang.next()){
                String nb = RsBarang.getString("nama_barang");
                String kb = RsBarang.getString("kode_barang");
                String sab = RsBarang.getString("satuan_barang");
                String stb = RsBarang.getString("stok_barang");
                String hbb = RsBarang.getString("hargabeli_barang");
                String hjb = RsBarang.getString("hargajual_barang");
                String[] row = {nb, kb, sab, stb, hbb, hjb};
                tabModel.addRow(row);
            }
            tlistbarang.setModel(tabModel);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //menampilkan data ke form saat data pada tabel di klik 
    void tblKeForm(){
        tfbarang.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),0)+"");
        tfkode.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),1)+"");
        tfsatuan.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),2)+"");
        tfstok.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),3)+"");
        tfhargabeli.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),4)+"");
        tfhargajual.setText(tabModel.getValueAt(tlistbarang.getSelectedRow(),5)+"");
    }
   
    //membersihkan history inputan barang dan kode
    private void BersihData(){
        tfbarang.setText("");
        tfkode.setText("");
    }
        
    // MENGHITUNG TOTAL YANG HARUS DIBAYAR
    public void total(){
        ltotal1.setText("0");
        ltotal2.setText("0");
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();

            RsBarang=stt.executeQuery("SELECT SUM(`subtotal_barang`) AS total FROM daftar_belanja");
            
            while (RsBarang.next()) {
                ltotal1.setText(RsBarang.getString(""+"total"));
                ltotal2.setText(RsBarang.getString(""+"total"));
            }
            RsBarang.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
       
    //menampilkan nomor faktur yang berurutan
    private void nofaktur() {
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            RsBarang=stt.executeQuery("SELECT * from faktur ORDER BY no_faktur DESC");

            if (RsBarang.next()) {
                String nofak = RsBarang.getString("no_faktur").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                lfaktur.setText("F" + Nol + AN);
            } else {
                lfaktur.setText("F0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    
    // MENGHITUNG BANYAKNYA JUMLAH BARANG PADA FAKTUR
    public void jumlahbarang(){
        ljumlahbarang.setText("0");
        try {
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();

            RsBarang=stt.executeQuery("SELECT SUM(`jumlah_barang`) AS jumlahbarang FROM daftar_belanja");
            
            while (RsBarang.next()) {
                ljumlahbarang.setText(RsBarang.getString(""+"jumlahbarang"));    
            }
            RsBarang.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
    // MENYIMPAN DATA BELANJA DI TABLE SEMENTARA
    public final void loadData() {
        try{
            Object[] judul_kolom = {"No", "Nama", "Kode", "Satuan", "Harga", "QTY", "Sub Total"};
            tabModel2=new DefaultTableModel(null,judul_kolom);
            tlistbelanja.setModel(tabModel2);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            tabModel2.getDataVector().removeAllElements();
            
            RsBarang=stt.executeQuery("SELECT * from daftar_belanja");
            while(RsBarang.next()){
                Object[] data={
                    RsBarang.getString("id_daftarbelanja"),
                    RsBarang.getString("nama_barang"),
                    RsBarang.getString("kode_barang"),
                    RsBarang.getString("satuan_barang"),
                    RsBarang.getString("hargasatuan_barang"),
                    RsBarang.getString("jumlah_barang"),
                    RsBarang.getString("subtotal_barang"),
                };
               tabModel2.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
   }
    
    // MENCARI HARGA SUBTOTAL DENGAN QTY DARI STOK BARANG
    private void hitungjumlah(){
        if(lfaktur.getText().equals("") || tfbarang.getText().equals("") || tfkode.getText().equals("") || tfsatuan.getText().equals("") || tfhargajual.getText().equals("") || tfqty.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Barang atau Jumlah Barang (Qty) Belum Dimasukkan!", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String a = tfqty.getText();
            int aa = Integer.parseInt(a);
        
            String b = tfstok.getText();
            int bb = Integer.parseInt(b);
            
            if(aa > bb){
                JOptionPane.showMessageDialog(null, "Jumlah Barang yang Dimasukkan Melibihi Stok!", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
                tfqty.setText("");
            }
            else{
                if(tfqty.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Isi jumlah yang akan Dibeli!");
                }
                else{
                    int stok, tfhargajualbarang, subtotal, tfhargabelibarang, laba, hpp; 
                    
                    stok = Integer.parseInt(tfqty.getText());
                    tfhargajualbarang = Integer.parseInt(tfhargajual.getText());
                    tfhargabelibarang = Integer.parseInt(tfhargabeli.getText());
                    
                    subtotal = stok * tfhargajualbarang;       
                    hpp = stok * tfhargabelibarang;
                    laba = subtotal - hpp;
                    
                    tftotal.setText(Integer.toString(subtotal));
                    tfhpp.setText(Integer.toString(hpp));
                    tflaba.setText(Integer.toString(laba));
                    
                    
                }
            }
        } 
    }
    
    // MENAMBAH BARANG KE DAFTAR BELANJA
    private void tambahbarangbelanja(){
        if(lfaktur.getText().equals("") || tfbarang.getText().equals("") || tfkode.getText().equals("") || tfsatuan.getText().equals("")  || tfhargajual.getText().equals("") || tfqty.getText().equals("")){
            // TIDAK JALAN
        }
        else{
            String nama = tfbarang.getText();
            String kode = tfkode.getText();
            String satuan = tfsatuan.getText();
            String harga = tfhargajual.getText();
            String qty = tfqty.getText();
            String subtotal = tftotal.getText();
            String hargabeli = tfhargabeli.getText();
            String hpp = tfhpp.getText();
            String laba = tflaba.getText();
           
            try {
                Connection conn=koneksi.GetConnection();
                Statement stt=conn.createStatement();
                
                String sql = "INSERT INTO daftar_belanja VALUES (?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, null);
                ps.setString(2, nama);
                ps.setString(3, kode);
                ps.setString(4, satuan);
                ps.setString(5, harga);
                ps.setString(6, qty);
                ps.setString(7, subtotal);
                ps.setString(8, hargabeli);
                ps.setString(9, hpp);
                ps.setString(10, laba);
                
                ps.executeUpdate();
                ps.close();
            } 
            catch (SQLException e) {
                System.out.println("Terjadi Error");
            } 
            finally {
                nofaktur();
                tfbarang.setText("");
                tfkode.setText("");
                tfsatuan.setText("");
                tfstok.setText("");
                tfhargajual.setText("");
                tfqty.setText("");
                tftotal.setText("");
                tfhargabeli.setText("");
                tfhpp.setText("");
                tflaba.setText("");
                loadData();                
            }
        }
    }
    
    public void bayar(){    
        if(tfbayar.getText().equals("0") || lkembalian.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
        }else{
            
            String a = lkembalian.getText();
            int ab = Integer.parseInt(String.valueOf(lkembalian.getText()));
            if(ab<0){
                JOptionPane.showMessageDialog(null, "Uang Kurang!", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
                tfbayar.setText("0");
                lkembalian.setText("0");
            }
            else{
                
                String faktur = lfaktur.getText();
                String bayar = tfbayar.getText();
                String kembalian = lkembalian.getText();
                try {
                    Connection c = koneksi.GetConnection();
                    Statement s = c.createStatement();

                    String sql = "SELECT * FROM daftar_belanja";
                    ResultSet r = s.executeQuery(sql);

                    while (r.next()) { 
                        long millis=System.currentTimeMillis();  
                        java.sql.Date date=new java.sql.Date(millis);  
                        System.out.println(date); 
                        String tgl = date.toString();
                        
                        String sqla = "INSERT INTO faktur VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement ps = c.prepareStatement(sqla);
                        
                        ps.setString(1, faktur);
                        ps.setString(2, r.getString("nama_barang"));
                        ps.setString(3, r.getString("kode_barang"));
                        ps.setString(4, r.getString("satuan_barang"));
                        ps.setString(5, r.getString("hargasatuan_barang"));
                        ps.setString(6, r.getString("jumlah_barang"));
                        ps.setString(7, r.getString("subtotal_barang"));
                        ps.setString(8, bayar);
                        ps.setString(9, kembalian);
                        ps.setString(10, tgl);
                        ps.setString(11, r.getString("hargabeli_barang"));
                        ps.setString(12, r.getString("hpp"));
                        ps.setString(13, r.getString("laba"));

                        ps.executeUpdate();
                        ps.close(); 
                    }
                    r.close();
                    s.close();
                }
                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ADA YANG ERROR. AYO CEK LAGI PUKIMAY !", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
                }
                finally{
                    try {
                        String sqla ="TRUNCATE daftar_belanja";
                        java.sql.Connection conn=(Connection)koneksi.GetConnection();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "TRANSAKSI SELESAI", "ADVCKasir", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                        tffaktur2.setText(lfaktur.getText());
                        tfbayar.setText("");
                        lkembalian.setText("0");
                        ltotal2.setText("0");
                        ltotal1.setText("0");
                        ljumlahbarang.setText("0");
                        nofaktur();
                        bcetakfaktur.setEnabled(true);
                    } 
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
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
        splistbarang = new javax.swing.JScrollPane();
        tlistbarang = new javax.swing.JTable();
        splistbelanja = new javax.swing.JScrollPane();
        tlistbelanja = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ltotal1 = new javax.swing.JLabel();
        tfcari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ltotal2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tfbayar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lkembalian = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lnamapgw = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lfaktur = new javax.swing.JLabel();
        ljumlahbarang = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfqty = new javax.swing.JTextField();
        jtambah = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tfbarang = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfkode = new javax.swing.JTextField();
        bbayar = new javax.swing.JButton();
        bcetakfaktur = new javax.swing.JButton();
        tfstok = new javax.swing.JTextField();
        tfhargajual = new javax.swing.JTextField();
        tftotal = new javax.swing.JTextField();
        tfsatuan = new javax.swing.JTextField();
        tffaktur2 = new javax.swing.JTextField();
        tftanggal2 = new javax.swing.JTextField();
        tfhargabeli = new javax.swing.JTextField();
        tfhpp = new javax.swing.JTextField();
        tflaba = new javax.swing.JTextField();

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
        jLabel2.setText("ADVCKasir (kasir)");
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

        tlistbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Kode", "Satuan", "Stok", "Harga"
            }
        ));
        tlistbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlistbarangMouseClicked(evt);
            }
        });
        splistbarang.setViewportView(tlistbarang);

        jPanel2.add(splistbarang);
        splistbarang.setBounds(40, 170, 580, 340);

        tlistbelanja.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Kode", "Satuan", "Harga", "Qty", "Subtotal"
            }
        ));
        tlistbelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlistbelanjaMouseClicked(evt);
            }
        });
        splistbelanja.setViewportView(tlistbelanja);

        jPanel2.add(splistbelanja);
        splistbelanja.setBounds(662, 170, 580, 340);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 55)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(207, 28, 45));
        jLabel3.setText("Rp. ");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 90, 60);

        ltotal1.setFont(new java.awt.Font("Calibri", 1, 55)); // NOI18N
        ltotal1.setForeground(new java.awt.Color(207, 28, 45));
        ltotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ltotal1.setText("0");
        jPanel3.add(ltotal1);
        ltotal1.setBounds(78, 0, 210, 60);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(950, 30, 290, 60);

        tfcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfcariKeyReleased(evt);
            }
        });
        jPanel2.add(tfcari);
        tfcari.setBounds(257, 130, 362, 27);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Daftar Belanja");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(662, 150, 120, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kembalian");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(660, 630, 140, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nomor Faktur   :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(951, 90, 170, 25);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Jumlah Barang :");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(950, 110, 170, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bayar");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(660, 580, 110, 29);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        ltotal2.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        ltotal2.setForeground(new java.awt.Color(207, 28, 45));
        ltotal2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ltotal2.setText("0");
        jPanel6.add(ltotal2);
        ltotal2.setBounds(48, 0, 360, 30);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(207, 28, 45));
        jLabel11.setText("Rp.");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(0, 0, 70, 30);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(830, 530, 410, 30);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 204, 0));
        jLabel13.setText("Rp.");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(0, 0, 70, 30);

        tfbayar.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        tfbayar.setForeground(new java.awt.Color(0, 204, 0));
        tfbayar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfbayar.setText("0");
        tfbayar.setBorder(null);
        tfbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfbayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfbayarKeyTyped(evt);
            }
        });
        jPanel5.add(tfbayar);
        tfbayar.setBounds(49, 0, 360, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(830, 580, 410, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        lkembalian.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lkembalian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lkembalian.setText("0");
        jPanel4.add(lkembalian);
        lkembalian.setBounds(48, 0, 360, 30);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel14.setText("Rp.");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(0, 0, 70, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(830, 630, 410, 30);

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel15);
        jLabel15.setBounds(30, 30, 0, 0);

        lnamapgw.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lnamapgw.setForeground(new java.awt.Color(255, 255, 255));
        lnamapgw.setText("Nama Pegawai");
        jPanel2.add(lnamapgw);
        lnamapgw.setBounds(40, 54, 0, 0);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nama Pegawai");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(40, 20, 0, 0);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(660, 530, 110, 29);

        lfaktur.setFont(new java.awt.Font("Tahoma", 2, 20)); // NOI18N
        lfaktur.setForeground(new java.awt.Color(255, 255, 255));
        lfaktur.setText("F0000");
        jPanel2.add(lfaktur);
        lfaktur.setBounds(1120, 90, 120, 25);

        ljumlahbarang.setFont(new java.awt.Font("Tahoma", 2, 20)); // NOI18N
        ljumlahbarang.setForeground(new java.awt.Color(255, 255, 255));
        ljumlahbarang.setText("0");
        jPanel2.add(ljumlahbarang);
        ljumlahbarang.setBounds(1120, 110, 120, 25);

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cari Nama/Kode Barang :");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(40, 133, 220, 26);

        tfqty.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        tfqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfqtyKeyTyped(evt);
            }
        });
        jPanel2.add(tfqty);
        tfqty.setBounds(450, 523, 58, 27);

        jtambah.setBackground(new java.awt.Color(255, 255, 255));
        jtambah.setText("TAMBAH");
        jtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtambahActionPerformed(evt);
            }
        });
        jPanel2.add(jtambah);
        jtambah.setBounds(520, 523, 100, 27);

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Qty :");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(405, 525, 80, 26);

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Barang :");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(40, 525, 80, 26);

        tfbarang.setEditable(false);
        tfbarang.setBackground(new java.awt.Color(255, 255, 255));
        tfbarang.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        tfbarang.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(tfbarang);
        tfbarang.setBounds(113, 523, 140, 27);

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Kode :");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(262, 525, 80, 26);

        tfkode.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel2.add(tfkode);
        tfkode.setBounds(322, 523, 73, 27);

        bbayar.setBackground(new java.awt.Color(255, 255, 255));
        bbayar.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        bbayar.setText("BAYAR");
        bbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbayarActionPerformed(evt);
            }
        });
        jPanel2.add(bbayar);
        bbayar.setBounds(40, 580, 280, 70);

        bcetakfaktur.setBackground(new java.awt.Color(255, 255, 255));
        bcetakfaktur.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        bcetakfaktur.setText("Cetak Faktur"); // NOI18N
        bcetakfaktur.setEnabled(false);
        bcetakfaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetakfakturActionPerformed(evt);
            }
        });
        jPanel2.add(bcetakfaktur);
        bcetakfaktur.setBounds(330, 580, 130, 70);

        tfstok.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        tfstok.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.add(tfstok);
        tfstok.setBounds(470, 600, 0, 0);

        tfhargajual.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel2.add(tfhargajual);
        tfhargajual.setBounds(30, 90, 0, 0);

        tftotal.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel2.add(tftotal);
        tftotal.setBounds(370, 70, 0, 0);

        tfsatuan.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel2.add(tfsatuan);
        tfsatuan.setBounds(510, 620, 0, 0);

        tffaktur2.setText("jTextField1");
        jPanel2.add(tffaktur2);
        tffaktur2.setBounds(690, 60, 0, 0);

        tftanggal2.setText("jTextField1");
        jPanel2.add(tftanggal2);
        tftanggal2.setBounds(680, 90, 0, 0);
        jPanel2.add(tfhargabeli);
        tfhargabeli.setBounds(80, 90, 0, 0);
        jPanel2.add(tfhpp);
        tfhpp.setBounds(50, 40, 0, 0);
        jPanel2.add(tflaba);
        tflaba.setBounds(170, 40, 0, 0);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 49, 1280, 672);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(kasirframe.MAXIMIZED_BOTH);
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

    private void tfcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcariKeyReleased
        find();
    }//GEN-LAST:event_tfcariKeyReleased

    private void tlistbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlistbarangMouseClicked
        tblKeForm();
    }//GEN-LAST:event_tlistbarangMouseClicked

    private void bbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbayarActionPerformed
        bayar();
    }//GEN-LAST:event_bbayarActionPerformed

    private void bcetakfakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakfakturActionPerformed
        try{
            Desktop.getDesktop().browse(new URL("http://localhost/advckasir/invoice.php?lap&fk="+tffaktur2.getText()+"").toURI());
            } catch (Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_bcetakfakturActionPerformed

    private void tlistbelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlistbelanjaMouseClicked
        int jawaban;
        if ((jawaban = JOptionPane.showConfirmDialog(null,"Apakah Anda mau Menghapus Barang dari List Belanja ?", "ADVCKasir", JOptionPane.YES_NO_OPTION)) == 0) {
            try{

            int i = tlistbelanja.getSelectedRow();
            if (i == -1) {
                return;
            }
            String id = (String) tabModel2.getValueAt(i, 0);
            
            Connection conn=(Connection)koneksi.GetConnection();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM daftar_belanja WHERE id_daftarbelanja = '"+id+ "'");

            nofaktur();
            loadData();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        jumlahbarang();
        total();
        tampilData();
    }//GEN-LAST:event_tlistbelanjaMouseClicked

    private void jtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtambahActionPerformed
        hitungjumlah();
        tambahbarangbelanja();
        jumlahbarang();
        total();
        tampilData();
    }//GEN-LAST:event_jtambahActionPerformed

    private void tfqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfqtyKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_tfqtyKeyTyped

    private void tfbayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbayarKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_tfbayarKeyTyped

    private void tfbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbayarKeyReleased
        bayar = Integer.parseInt(String.valueOf(tfbayar.getText()));
        total = Integer.parseInt(String.valueOf(ltotal2.getText()));
        kembali = bayar - total;
        lkembalian.setText(Long.toString(kembali));
    }//GEN-LAST:event_tfbayarKeyReleased

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
            java.util.logging.Logger.getLogger(kasirframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasirframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasirframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasirframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasirframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbayar;
    private javax.swing.JButton bcetakfaktur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jtambah;
    private javax.swing.JLabel lfaktur;
    private javax.swing.JLabel ljumlahbarang;
    private javax.swing.JLabel lkembalian;
    private javax.swing.JLabel lnamapgw;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel ltotal1;
    private javax.swing.JLabel ltotal2;
    private javax.swing.JLabel lwaktu;
    private javax.swing.JScrollPane splistbarang;
    private javax.swing.JScrollPane splistbelanja;
    private javax.swing.JTextField tfbarang;
    private javax.swing.JTextField tfbayar;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tffaktur2;
    private javax.swing.JTextField tfhargabeli;
    private javax.swing.JTextField tfhargajual;
    private javax.swing.JTextField tfhpp;
    private javax.swing.JTextField tfkode;
    private javax.swing.JTextField tflaba;
    private javax.swing.JTextField tfqty;
    private javax.swing.JTextField tfsatuan;
    private javax.swing.JTextField tfstok;
    private javax.swing.JTextField tftanggal2;
    private javax.swing.JTextField tftotal;
    private javax.swing.JTable tlistbarang;
    private javax.swing.JTable tlistbelanja;
    // End of variables declaration//GEN-END:variables
}
