
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ChatFormSocket extends javax.swing.JFrame implements Runnable{
    String ip;
    public ChatFormSocket(String ip) 
    {  
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("msg.png")));
       
        JOptionPane.showMessageDialog(null,"Ask Your Friend To Open Chat");
        this.ip=ip;
        setUndecorated(true);
        initComponents();
         setSize(263,286);
        setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int sw=(int)d.getWidth();
        int sh=(int)d.getHeight();
        int w=getWidth();
        int h=getHeight();
        setLocation(sw-w, sh-h-52);
        Thread th=new Thread(this);
        th.start();
    }
    ConnectedThread ct;
    @Override
    public void run() {
        try{
        Socket client=new Socket(ip,6066);
        ct=new ConnectedThread(client);
        ct.start();
        }catch(Exception e)
        {}
    }
    public class ConnectedThread extends Thread
    {
        OutputStream out;
        InputStream in;
        public ConnectedThread(Socket client) 
        {
            try{
            in=client.getInputStream();
            out=client.getOutputStream();
            }catch(Exception e)
            {}
        }
        public void run()
        {
            byte b[]=new byte[100];
            while(true)
            {
                try{
                    flushArray(b);
                    in.read(b);
                    String s=new String(b).trim();
                    if(!s.equals(""))
                    jTextArea1.append(s+"\n");
                }catch(Exception e)
                {}
            }
        }
        public void flushArray(byte b[])
        {
            for(int i=0;i<100;i++)
                b[i]=0;
        }
        public void write(String msg)
        {
            try{
            out.write(msg.getBytes());
            out.flush();
            }catch(Exception e)
            {}
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");

        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(220, 240, 40, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close1.png"))); // NOI18N
        jButton2.setToolTipText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(220, 0, 40, 40);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 260, 190);

        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(15);
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setRows(3);
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 240, 220, 40);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 220, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea2KeyPressed
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER){
            ct.write(jTextArea2.getText());
            jTextArea1.append("Me: "+jTextArea2.getText()+"\n");
            jTextArea2.setText("");
        }
    }//GEN-LAST:event_jTextArea2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ct.write(jTextArea2.getText());
        jTextArea1.append("Me: "+jTextArea2.getText()+"\n");
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
                new ChatFormSocket(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}