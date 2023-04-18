import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;



public class Accinfo {
    public static void ProtWebServer() {
        for (Integer Prot : Scan.Open) {
            try {
                URL url = new URL("http://" + Scan.OpenServer + ":" + Prot);
                URLConnection connection = url.openConnection();//尝试连接
                connection.setConnectTimeout(1000); // 设置连接超时时间为1秒
                connection.setReadTimeout(1000); // 设置读取超时时间为1秒
                String server = connection.getHeaderField("Server");//尝试读取头
                //int code = connectionCode.getResponseCode();
                if (server==null){
                    server="NO_WEBSERVER_INFO";
                }
                System.out.println("Server: " + Prot + " " + server);
            } catch (SocketTimeoutException e) {
                System.out.println("连接而到端口超时 " + Prot);
            } catch (IOException e) {
                System.out.println("连接到端口失败 " + Prot);
            }
        }
    }
    public static void PortWebCode(){
        for (Integer Prot: Scan.Open){
            try{
                URL url = new URL("http://" + Scan.OpenServer + ":" + Prot);
                HttpURLConnection connectionCode = (HttpURLConnection) url.openConnection();// 获取code示例
                connectionCode.setConnectTimeout(5000);//超时判定
                connectionCode.setReadTimeout(5000);//超时判定
                int code = connectionCode.getResponseCode();
                System.out.println("Code: " + Prot + " " + code);
            }catch (SocketTimeoutException e){
                System.out.println("Code: "+ Prot +" Code扫描连接超时");
            }catch (IOException e){
                System.out.println("Code: "+ Prot +" Code扫描连接异常");
            }
        }
    }
}
