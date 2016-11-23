// ���ö��̷߳�ʽʵ�ֵķ���˳��� 
import java.io.*;
import java.net.*;
import java.util.*;

public class MTEchoServer {
    public static void main(String[] args)throws IOException {
        List<EchoThread> threads = new ArrayList<EchoThread>();
        if (args.length != 1) {
            System.out.println("�÷���MTServer <�˿ں�>");
            return ;
        }
        ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("����������ڼ����˿ڣ�" + args[0]);
        for (;;) {
            Socket s = ss.accept();
            boolean need_create_new_thread = true;
            for (int i = 0; i < threads.size(); i++) {
                if (threads.get(i).isSuspend == true) {
                    System.out.println("���ѹ���Ľ��̣����̺�Ϊ��" + i);
                    threads.get(i).setSocket(s);
                    threads.get(i).resume();
                    threads.get(i).isSuspend = false;
                    need_create_new_thread = false;
                    break;
                }
            }
            if (need_create_new_thread) {
                System.out.println("�������½���һ���߳�");
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
            System.out.println("����Ϊ�ͻ������ṩ����" + socket);
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(socket + "����" + message);
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
                System.out.println("���̱�������");
                isSuspend = true;
                suspend();
            }
        }
    }
}
