import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //logo
        String[] logos = {
                "  ____  _                 _      ____                                 ",
                "/ ___|(_)_ __ ___  _ __ | | ___/ ___|  ___ __ _ _ __  _ __   ___ _ __ ",
                " ___  | | '_ ` _  | '_  | |/ _  ___   / __/ _` | '_  | '_   / _   '__|",
                " ___) | | | | | | | |_) | |  __/___) | (_| (_| | | | | | | |  __/ |   ",
                "|____/|_|_| |_| |_| .__/|_| ___|____/  ___ __,_|_| |_|_| |_| ___|_|   ",
                "                  |_|                                                 ",
        };
        for (String logo : logos) {
            System.out.println(logo);
        }
        System.out.print("请输入ip地址：");
        //end
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int port = 65535;//最大端口
        //int[] open = new int[65535];
        //int[] closed = new int[65535];
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> closed = new ArrayList<>();
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
                //System.out.println("端口"+i+"开放");
                open.add(i);
                socket.close();
            } catch (IOException e) {
                //System.out.println("端口"+i+"关闭");
                closed.add(i);
            }
        }
        System.out.println("扫描到开放端口"+open);
    }
}