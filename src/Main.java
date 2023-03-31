import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int port = 65535;//最大端口
        String server = scanner.next();
        //int[] pos ={80,22,8080,2017,1080};
        for (int i=0; i<=port; i++){
            //进度条
            double percent = ((double) i / port) * 100;
            System.out.printf("[%s%s] %.2f%%%n","#".repeat(i*100/port)," ".repeat(100-i*100/port),percent);
            //end
            try{
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(server,i),1000);
                System.out.println("端口"+i+"开放");
                socket.close();
            } catch (IOException e) {
                System.out.println("端口"+i+"关闭");
            }
        }
    }
}