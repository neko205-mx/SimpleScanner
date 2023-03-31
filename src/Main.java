import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String server = scanner.next();
        int[] pos = new int[65535];
        for (int i = 0; i<= 65534; i++) {
            pos[i] = i + 1; //第一次循环会出现 pos[0]=0+1
        }

        //int[] pos ={80,22,8080,2017,1080};
        for (int po : pos){
            try{
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(server,po));
                System.out.println("端口"+po+"开放");
                socket.close();
            } catch (IOException e) {
                System.out.println("端口"+po+"关闭");

            }
        }
    }
}