import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import reuse.Model;

public class FileRecieve implements Runnable {

    ServerSocket server;

    public FileRecieve() {
        
       
        try {
            
            
            server = new ServerSocket(6066);
            Thread th=new Thread(this);
            th.start();
        } catch (Exception e) {
            
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket client = server.accept();
                InputStream in=client.getInputStream();
                ObjectInputStream object=new ObjectInputStream(in);
                Model m=(Model)object.readObject();
                byte b[]=m.getContent();
                String name=m.getFilename();
                FileOutputStream fout=new 
                    FileOutputStream(
                     new File(System.getProperty(
                            "user.home")+"\\desktop\\"+name));
                fout.write(b);
                fout.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String a[])
    {
        new FileRecieve();
        System.out.println("Server Registered!!!");
    }
}
