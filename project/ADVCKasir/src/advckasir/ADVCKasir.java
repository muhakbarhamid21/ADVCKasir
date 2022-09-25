package advckasir;

import db.koneksi;
import formmasuk.loading.loadingframe;
import formmasuk.mulai.mulaiframe;


public class ADVCKasir {
    public static void main(String[] args) {
        koneksi koneksi = new koneksi();
        loadingframe lf = new loadingframe();
        lf.setVisible(true);
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(40);
                lf.loadingbar.setValue(i);
            }
        }
        catch(Exception e){
        }
        mulaiframe mf = new mulaiframe();
        mf.setVisible(true);
        lf.dispose();
    }
}
