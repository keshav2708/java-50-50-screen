import java.net.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.JFrame;
import javax.swing.UIManager;
class ScreenServer extends JFrame
{
    ServerSocket server;
    ServerSocket serverKeyboard;
    ServerSocket serverMouseClick;
    ServerSocket serverMouseMove;
	ScreenServer()
	{
         setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
		Thread th1=new Thread(new ScreenThread());
		th1.start();
		Thread th2=new Thread(new MouseThread());
		th2.start();
		Thread th3=new Thread(new MouseClickThread());
		th3.start();
		Thread th4=new Thread(new KeyThread());
		th4.start();
                System.out.println("Server Started");
	}

    

      
	

   public class KeyThread extends Thread
	{
	   
	    KeyThread()
	    {
		try{
		serverKeyboard=new ServerSocket(6074);
		}catch(Exception e)
		{}
	    }
	    public void run()
	    {
		while(true){
		try{
		Socket client=serverKeyboard.accept();
		InputStream in=client.getInputStream();
		byte b[]=new byte[20];
		in.read(b);
		String s=new String(b).trim();	
		String arr[]=s.split("#");
		int keycode=Integer.parseInt(arr[1]);
		if(arr[0].equals("keypress"))
		{
		 Robot rt=new Robot();
		 rt.keyPress(keycode);
		}
		else if(arr[0].equals("keyrelease"))
		{
		 Robot rt=new Robot();
		 rt.keyRelease(keycode);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	       }
	    }
	}
	public class MouseClickThread extends Thread
	{
	    
	    MouseClickThread()
	    {
		try{
		serverMouseClick=new ServerSocket(6072);
		}catch(Exception e)
		{}
	    }
	    public void run()
	    {
		while(true){
		try{
		Socket client=serverMouseClick.accept();
		InputStream in=client.getInputStream();
		byte b[]=new byte[10];
		in.read(b);
		String s=new String(b).trim();
		int n=Integer.parseInt(s);
		Robot rt=new Robot();
		if(n==1)
		{
			rt.mousePress(InputEvent.BUTTON1_MASK);
			rt.mouseRelease(InputEvent.BUTTON1_MASK);	
		}else if(n==3)
		{
			rt.mousePress(InputEvent.BUTTON3_MASK);
			rt.mouseRelease(InputEvent.BUTTON3_MASK);
		}else if(n==4)
		{
			rt.mousePress(InputEvent.BUTTON1_MASK);
			rt.mouseRelease(InputEvent.BUTTON1_MASK);
			rt.mousePress(InputEvent.BUTTON1_MASK);
			rt.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		}catch(Exception e)
		{}
		}
	    }
	}
	public class MouseThread extends Thread
	{
	   
	    MouseThread()
	    {
		try{
		serverMouseMove=new ServerSocket(6070);
		}catch(Exception e)
		{}
	    }
	    public void run()
	    {
		while(true){
		try{
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		double sw=d.getWidth();
		double sh=d.getHeight();
		
		Socket client=serverMouseMove.accept();
		InputStream in=client.getInputStream();
		byte b[]=new byte[10];
		in.read(b);
		String s=new String(b).trim();
		String ar[]=s.split("#");
		int x=Integer.parseInt(ar[0]);
		int y=Integer.parseInt(ar[1]);
		double ratioX=sw/1156;
		double ratioY=sh/650;
		Robot rt=new Robot();
		x=(int)(x*ratioX);
		y=(int)(y*ratioY);
		rt.mouseMove(x,y);
		}catch(Exception e)
		{}
		}
	    }
	}
	public class ScreenThread extends Thread
	{
	  public void run()
	  {
	    while(true)
	    {
	      try{
	      Socket client=server.accept();	
	      OutputStream out=client.getOutputStream();
	      BufferedImage img=getScreenShot();
	      ImageIO.write(img,"PNG",out);     
	      }catch(Exception e)
	      {}
   	    }
	 }
	 ScreenThread()
	 {
	   try{
		server=new ServerSocket(6068);
	   }catch(Exception e)
	   {
		System.out.println(e);
	   }
	 }
	 
	}
	public BufferedImage getScreenShot()
	{
	  BufferedImage img=null;
	  try{
	  Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	  Robot rt=new Robot();
	  img=rt.createScreenCapture(new Rectangle(d));
	  }catch(Exception e)	
	  {}
	  return img; 
	}
public static void main(String a[])
{
                 try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
		new ScreenServer();
}

}