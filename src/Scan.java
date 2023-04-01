import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {
    public ArrayList<Integer> Getopen(){
        Main main = new Main();
        System.out.print("请输入ip地址：");
        Scanner scanner = new Scanner(System.in);
        String server = scanner.next();
        int port = 65535;//最大端口
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> closed = new ArrayList<>();
        for (int i=0; i<=port; i++){
            //进度条
            double percent = ((double) i / port) * 100;
            System.out.print(String.format("[%s%s] %.2f%%","#".repeat(i*100/port)," ".repeat(100-i*100/port),percent));
            System.out.print("\r");
            //end
            try{
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(String.valueOf(server),i),1000);
                //System.out.println("端口"+i+"开放");
                open.add(i);
                socket.close();
            } catch (IOException e) {
                //System.out.println("端口"+i+"关闭");
                closed.add(i);
            }
        }
        return open;

    }
}
