
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class ClientFunctionPanel extends javax.swing.JFrame {
   ScreenClient sc;
   String ip;
    public ClientFunctionPanel(String ip) 
    {   
         setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
        this.ip=ip;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    Toolkit t =Toolkit.getDefaultToolkit();
    Dimension d=t.getScreenSize();
    int sw=(int) d.getWidth();
     
        System.out.println(ip);
       sc=new ScreenClient(ip);
        initComponents();
        
        setSize(220,63);
        int w=getWidth();
       
        setLocation((sw-w)/2,2);
         setVisible(true);
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 0);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton4.setToolTipText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 10, 40, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
      
       
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
         try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFunctionPanel(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
