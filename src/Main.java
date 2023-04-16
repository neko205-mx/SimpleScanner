import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> Open = new ArrayList<>();
    //public static ArrayList<String> Data = new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
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
        //end
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入0为暴力扫描 输入1为top50端口扫描：");
        int a = scanner.nextInt();
        //ArrayList<Integer> open;

        if (a == 0){
            Scan.GetOpenAll();
            Open= Scan.ScanAccept(); //从扫描器获取开放端口
            if (Open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+Open);
                System.out.println("检查是否为web服务器");
                Accinfo.Protf();
                System.out.println("比对可能端口信息");
                Analyser();//执行端口信息比对
            }
        }
        if (a == 1) {
            Scan.GetOpenTop50();
            Open=Scan.ScanAccept();
            if (Open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+Open);
                System.out.println("检查是否为web服务器");
                Accinfo.Protf();
                System.out.println("比对可能端口信息");
                Analyser();
            }
        }
    }
    public static void Analyser(){
        OpenData.PortData();
        for (String datas : OpenData.portData) {
            System.out.println(datas);
        }
    }
}