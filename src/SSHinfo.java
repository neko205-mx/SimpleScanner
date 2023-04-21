import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SSHinfo {
    public static int SSH_Open;
    public static String RSA;
    public static String ECDSA;
    public static String ED25519;
    public static ArrayList<String> MD5 = new ArrayList<>();
    public static ArrayList<String> SSHkeyInfo = new ArrayList<>();

    public static void PortSSHinfo(){
        String ipAddress = Scan.OpenServer;
        for (int Port:Scan.Open){
            try {
                Socket socks = new Socket();
                socks.connect(new InetSocketAddress(ipAddress,Port),1000);//尝试连接
                socks.setSoTimeout(1000);//超时
                InputStream in = socks.getInputStream();
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String response = new String(buf,0,len);
                if (response.startsWith("SSH-")){
                    System.out.println(Port+" SSH_VERSION: "+response);
                    SSH_Open=Port;
                    Main.SSH_verdict = true;
                } else {
                    System.out.println(Port+" NO_SSH_SERVER");
                }
                socks.close();//结束
            } catch (IOException e){
                System.out.println(Port+" NO_SERVER_INFO");
            }
        }
    }

    public static void PortSSHkey() throws IOException {
        List<String> command = new ArrayList<>();
        command.add("ssh-keyscan");
        command.add("-p");
        command.add(String.valueOf(SSH_Open));
        command.add(Scan.OpenServer);

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            SSHkeyInfo.add(line);
        }
    }

    public static void PortSSHkeyMDA_ECDSA() throws IOException {
        String[] command = {"bash", "-c", "ssh-keyscan -t ECDSA -p "+SSH_Open+" "+Scan.OpenServer+" | ssh-keygen -E md5 -lf -"};
        Process process = new ProcessBuilder(command).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            ECDSA=line;
            MD5.add(line);
        }
    }
    public static void PortSSHkeyMDA_RSA() throws IOException {
        String[] command = {"bash", "-c", "ssh-keyscan -t RSA -p "+SSH_Open+" "+Scan.OpenServer+" | ssh-keygen -E md5 -lf -"};
        Process process = new ProcessBuilder(command).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            RSA=line;
            MD5.add(line);
        }
    }
    public static void PortSSHkeyMDA_ED25519() throws IOException {
        String[] command = {"bash", "-c", "ssh-keyscan -t ED25519 -p "+SSH_Open+" "+Scan.OpenServer+" | ssh-keygen -E md5 -lf -"};
        Process process = new ProcessBuilder(command).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            ED25519=line;
            MD5.add(line);
        }
    }

}
