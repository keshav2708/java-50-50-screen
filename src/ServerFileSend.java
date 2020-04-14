
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class ServerFileSend extends javax.swing.JFrame 
{
    String ip;
 
    
    public ServerFileSend() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    Toolkit t =Toolkit.getDefaultToolkit();
    Dimension d=t.getScreenSize();
    int sw=(int) d.getWidth();
    int sh=(int) d.getHeight();
        initComponents();
        setSize(901,609);
         int w=getWidth();
        int h=getHeight();
        setLocation((sw-w)/2,(sh-h)/2);
        setVisible(true);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(290, 250, 280, 50);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1469153652_navigation-right-button_sticker - Copy.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 330, 50, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(837, 10, 40, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimise.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(800, 10, 40, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FileTranferWindow.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 901, 607);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null,"Ask Your Friend To Recieve A File");
        JOptionPane.showMessageDialog(null,"File Will Be Delivered To Your Friend's Desktop");
        if (jTextField1.getText().length()!=0)
        {    ip=jTextField1.getText();
              
                       
             new FileTransfer(ip);
             dispose();
            
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"IP Cannot Be Left Blank");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
         int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER)
        {
           
           
        if (jTextField1.getText().length()!=0)
        {  ip=jTextField1.getText();
           
             new FileTransfer(ip);
            dispose();
           
           
        }
        else
        {
             JOptionPane.showMessageDialog(null,"IP Cannot Be Left Blank");
        }
        
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      setState(ICONIFIED);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) 
    {
     
          try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFileSend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
