
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.UIManager;
import reuse.Model;


public class FileTransfer extends javax.swing.JFrame 
{
     

    String ip;
    public FileTransfer(String ip)
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
         initComponents();
         this.ip=ip;
        int opt=jFileChooser1.showDialog(this, 
                "Send File");
        if(opt==0){
            try{
            File f=jFileChooser1.getSelectedFile();
            String name=f.getName();
            FileInputStream fin=new FileInputStream(f);
            int totalBytes=fin.available();
            byte b[]=new byte[totalBytes];
            int readBytes=0,bytes=0;
            while(readBytes<totalBytes){
                bytes=fin.read(b, readBytes, totalBytes);
                readBytes+=bytes;
            }
            fin.close();
            Model m=new Model(b, name);
            Socket client=new Socket(this.ip,6066);
            OutputStream out=client.getOutputStream();
            ObjectOutputStream oout=new ObjectOutputStream(out);
            oout.writeObject(m);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
             
    }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
         try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileTransfer(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
