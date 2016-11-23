// 采用多线程方式实现的服务端程序 
import java.io.*;
import java.net.*;
import java.util.*;

public class MTEchoServer {
    public static void main(String[] args)throws IOException {
        List<EchoThread> threads = new ArrayList<EchoThread>();
        if (args.length != 1) {
            System.out.println("用法：MTServer <端口号>");
            return ;
        }
        ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("服务程序正在监听端口：" + args[0]);
        for (;;) {
            Socket s = ss.accept();
            boolean need_create_new_thread = true;
            for (int i = 0; i < threads.size(); i++) {
                if (threads.get(i).isSuspend == true) {
                    System.out.println("唤醒挂起的进程，进程号为：" + i);
                    threads.get(i).setSocket(s);
                    threads.get(i).resume();
                    threads.get(i).isSuspend = false;
                    need_create_new_thread = false;
                    break;
                }
            }
            if (need_create_new_thread) {
                System.out.println("服务器新建了一个线程");
                EchoThread thread =  new EchoThread(s);
                thread.start();
                threads.add(thread);
            }
        }
    }
}

class EchoThread extends Thread {
    Socket socket;
    public boolean isSuspend = false;
    EchoThread(Socket s) {
        socket = s;
    }
    void setSocket(Socket s) {
        socket = s;
    }
public void run() {
    while (true) {
            System.out.println("正在为客户程序提供服务：" + socket);
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(socket + "请求：" + message);
                    out.println(message.toUpperCase());
                }
                out.close();
                in.close();
                socket.close();
            } 
            catch (Exception exc) {
                exc.printStackTrace();
            }
            finally {
                System.out.println("进程被挂起了");
                isSuspend = true;
                suspend();
            }
        }
    }
}
