import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> Open = new ArrayList<>();
    //public static ArrayList<String> Data = new ArrayList<>();
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
        //end
        Scan scan= new Scan();
        Scanner  scanner = new Scanner(System.in);
        System.out.print("输入0为暴力扫描 输入1为top50端口扫描：");
        int a = scanner.nextInt();
        //ArrayList<Integer> open;

        if (a == 0){
            scan.GetOpenAll();
            Open=scan.ScanAccept(); //从扫描器获取开放端口
            if (Open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+Open);
                System.out.println("正在获取端口信息");
                Analyser();//执行端口信息比对
            }
        }
        if (a == 1) {
            scan.GetOpenTop50();
            Open=scan.ScanAccept();
            if (Open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+Open);
                System.out.println("正在获取端口信息");
                Analyser();
            }
        }
    }
    public static void Analyser(){
        OpenData.PortData();
        for (String datas : OpenData.portData) {
            if (datas==null){
                datas="无数据";
                System.out.println(datas);
            }else{
                System.out.println(datas);
            }
        }
    }
}