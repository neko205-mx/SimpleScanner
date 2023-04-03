import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {
    public ArrayList<Integer> GetOpenAll(){
        //Main main = new Main();
        System.out.print("请输入ip地址：");
        Scanner scanner = new Scanner(System.in);
        String server = scanner.next();
        int port = 65535;//最大端口
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> closed = new ArrayList<>();
        for (int i=0; i<=port; i++){
            //进度条
            double percent = ((double) i / port) * 100;
            System.out.printf("[%s%s] %.2f%%","#".repeat(i*100/port)," ".repeat(100-i*100/port),percent);
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
    public ArrayList<Integer> GetOpenTop50(){
        //Main main = new Main();
        System.out.print("请输入ip地址：");
        Scanner scanner = new Scanner(System.in);
        String server = scanner.next();
        int[] port = {21, 22, 23, 25, 53, 80, 110, 119, 123, 135, 137, 138, 139, 143, 161, 162, 179, 194, 389, 443, 445, 465, 514, 515, 543, 544, 548, 587, 631, 636, 873, 902, 993, 995, 1080, 1194, 1433, 1434, 1521, 1723, 3306, 3389, 5432, 5900, 5901, 5984, 6379, 8080, 8443};
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> closed = new ArrayList<>();
        //for (int i=0; i<=port; i++){
        int sum=0;
        for (int i : port){
            sum++;
            //进度条
            double percent = ((double) sum / port.length) * 100;
            System.out.printf("[%s%s] %.2f%%","#".repeat(sum*100/port.length)," ".repeat(100-sum*100/port.length),percent);
            System.out.print("\n");
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
