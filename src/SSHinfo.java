import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SSHinfo {
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
                } else {
                    System.out.println(Port+" NO_SSH_SERVER");
                }
                socks.close();//结束
            } catch (IOException e){
                System.out.println(Port+" NO_SERVER_INFO");
            }
        }
    }
}
