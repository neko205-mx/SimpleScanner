import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;


public class Accinfo {
    public static void Protf() {
        for (Integer Prot : Scan.Open) {
            try {
                URL url = new URL("http://" + Scan.OpenServer + ":" + Prot);
                URLConnection connection = url.openConnection();//尝试连接
                connection.setConnectTimeout(1000); // 设置连接超时时间为1秒
                connection.setReadTimeout(1000); // 设置读取超时时间为1秒
                String server = connection.getHeaderField("Server");//尝试读取头
                System.out.println("Server: " + Prot + " " + server);
            } catch (SocketTimeoutException e) {
                System.out.println("连接而到端口超时 " + Prot);
            } catch (IOException e) {
                System.out.println("连接到端口失败 " + Prot);
            }
        }
    }

}
