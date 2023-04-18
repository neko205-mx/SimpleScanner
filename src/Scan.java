import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {
    //公用变量 用于接收传入参数并连接到扫描器
    public static String OpenServer;
    public static int[] OpenPort;
    public static ArrayList<Integer> Open = new ArrayList<>();
    public static ArrayList<Integer> Closed = new ArrayList<>();

    public static void GetOpenAll(){
        //Main main = new Main();
        System.out.print("请输入ip地址：");
        Scanner scanner = new Scanner(System.in);
        //String server = scanner.next();
        OpenServer = scanner.next();
        int[] port = new int[65535];
        for (int i=0; i<port.length; i++){
            port[i]=i;
        }
        OpenPort = port;
    }

    public static void GetOpenTop50(){
        //Main main = new Main();
        System.out.print("请输入ip地址：");
        Scanner scanner = new Scanner(System.in);
        //String server = scanner.next();
        OpenServer = scanner.next();
        OpenPort = new int[]{21, 22, 23, 25, 53, 80, 110, 119, 123, 135, 137, 138, 139, 143, 161, 162, 179, 194, 389, 443, 445, 465, 514, 515, 543, 544, 548, 587, 631, 636, 873, 902, 993, 995, 1080, 1194, 1433, 1434, 1521, 1723, 3306, 3389, 5432, 5900, 5901, 5984, 6379, 8080, 8443};
    }

    //扫描器
    public static ArrayList<Integer> ScanAccept(){
        int sum = 0;
        for (int i : OpenPort){
            sum++;
            //进度条
            double percent = ((double) sum / OpenPort.length) * 100;
            System.out.printf("[%s%s] %.2f%%","#".repeat(sum*100/OpenPort.length)," ".repeat(100-sum*100/OpenPort.length),percent);
            System.out.print("\n");
            //end
            try{
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(String.valueOf(OpenServer),i),1000);
                //System.out.println("端口"+i+"开放");
                Open.add(i);
                socket.close();
            } catch (IOException e) {
                //System.out.println("端口"+i+"关闭");
                Closed.add(i);
            }
        }
        return Open;
    }
}
