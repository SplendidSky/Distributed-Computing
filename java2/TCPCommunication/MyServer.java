// �򵥵��������׽���ʵ��ͨ�ŵķ���˳���
import java.io.*;
import java.net.*;

class MTServer implements Runnable {
    Socket client;
    MTServer(Socket s) {
        client = s;
    }

    public void run() {
        System.out.println("����Ϊ�ͻ������ṩ����" + client);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            // �ӿͻ��˶�ȡ���ݣ�����ӡ����Ļ�ϣ�������յ���End�������˳�����
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                System.out.println("�յ�����" + str);
                out.println("������Ѿ��յ�����" + str);
                out.flush();
                if (str.equals("end")) {
                    System.out.println("ͨ���Ѿ���ֹ");
                    break;
                }
            }
            // �ر�����
            out.close();
            in.close();
            client.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class MyServer {
    public static void main(String[] args)throws IOException {
        if (args.length != 1) {
            System.out.println("�÷���EchoServer <�˿ں�>");
            return ;
        }
        // ���� ServerSocket ʵ������������
        ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("���������ڼ����˿ڣ�" + args[0]);
        for (;;) {
            MTServer mtServer = new MTServer(server.accept());
            Thread thread = new Thread(mtServer);
            thread.start();
        }

    }
}
