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
        //end
        Scan scan= new Scan();
        Scanner  scanner = new Scanner(System.in);
        System.out.print("输入0为暴力扫描 输入1为top50端口扫描：");
        int a = scanner.nextInt();
        ArrayList<Integer> open;
        if (a == 0){
            scan.GetOpenAll();
            open=scan.ScanAccept();
            if (open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+open);
            }
        }
        if (a == 1) {
            scan.GetOpenTop50();
            open=scan.ScanAccept();
            if (open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+open);
            }
        }
    }
}