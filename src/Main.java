import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> Open = new ArrayList<>();
    public static boolean SSH_verdict = false;
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
                Webinfo.ProtWebServer();
                Webinfo.PortWebCode();
                System.out.println("尝试获取SSH端口信息");
                SSHinfo.PortSSHinfo();
                if (SSH_verdict){
                    SSHinfo.PortSSHkey();
                    SSHinfo.PortSSHkeyMDA_RSA();
                    SSHinfo.PortSSHkeyMDA_ECDSA();
                    SSHinfo.PortSSHkeyMDA_ED25519();
                }
                System.out.println("比对可能端口信息");
                Analyser();//执行端口信息比对
                SumOutput();
            }
        }
        if (a == 1) {
            Scan.GetOpenTop50();
            Open=Scan.ScanAccept();
            if (Open.isEmpty()){
                System.out.println("不存在开放端口");
            }else{
                System.out.println("存在开放端口"+Open);
                System.out.println("尝试获取webserver信息");
                Webinfo.ProtWebServer();
                Webinfo.PortWebCode();
                System.out.println("尝试获取SSH端口信息");
                SSHinfo.PortSSHinfo();
                if (SSH_verdict){
                    SSHinfo.PortSSHkey();
                    SSHinfo.PortSSHkeyMDA_RSA();
                    SSHinfo.PortSSHkeyMDA_ECDSA();
                    SSHinfo.PortSSHkeyMDA_ED25519();
                }
                System.out.println("比对可能端口信息");
                Analyser();
                SumOutput();
            }
        }
    }
    public static void Analyser(){
        OpenData.PortData();
        for (String datas : OpenData.portData) {
            System.out.println(datas);
        }
    }
    public static void SumOutput(){
        System.out.println("-------------------------END OUTPUT---------------------------");
        System.out.println("WebServer：");
        for(String server : Webinfo.WebServer){
            System.out.println(server);
        }
        System.out.println("WebCode：");
        for (String code : Webinfo.WebCode){
            System.out.println(code);
        }
        System.out.println("SSH端口："+SSHinfo.SSH_Open);
        System.out.println("Public_Key：");
        for (String key : SSHinfo.SSHkeyInfo) {
            System.out.println(key);
        }
        System.out.println("Public_Key_MD5：");
        for (String key_MD5 : SSHinfo.MD5){
            System.out.println(key_MD5);
        }
    }
}