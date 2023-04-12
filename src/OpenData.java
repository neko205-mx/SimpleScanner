import java.util.ArrayList;
import java.util.HashMap;

public class OpenData {
    public static ArrayList<String> portData = new ArrayList<>();
    //public Integer OutPut;
    public static void PortData(){
        HashMap<Integer, String> portMap = new HashMap<>();
        portMap.put(21, "21 FTP (File Transfer Protocol)");
        portMap.put(22, "22 SSH (Secure Shell)");
        portMap.put(23, "23 Telnet");
        portMap.put(25, "25 SMTP (Simple Mail Transfer Protocol)");
        portMap.put(53, "53 DNS (Domain Name System)");
        portMap.put(80, "80 HTTP (Hypertext Transfer Protocol)");
        portMap.put(110, "110 POP3 (Post Office Protocol version 3)");
        portMap.put(115, "115 SFTP (Simple File Transfer Protocol)");
        portMap.put(119, "119 NNTP (Network News Transfer Protocol)");
        portMap.put(123, "123 NTP (Network Time Protocol)");
        portMap.put(137, "137 NetBIOS Name Service");
        portMap.put(138, "138 NetBIOS Datagram Service");
        portMap.put(139, "139 NetBIOS Session Service");
        portMap.put(143, "143 IMAP (Internet Message Access Protocol)");
        portMap.put(161, "161 SNMP (Simple Network Management Protocol)");
        portMap.put(194, "194 IRC (Internet Relay Chat)");
        portMap.put(443, "443 HTTPS (HTTP Secure)");
        portMap.put(445, "445 SMB (Server Message Block)");
        portMap.put(465, "465 SMTPS (Simple Mail Transfer Protocol Secure)");
        portMap.put(502, "502 Modbus");
        portMap.put(514, "514 Syslog");
        portMap.put(522, "522 RIP (Routing Information Protocol)");
        portMap.put(554, "554 RTSP (Real Time Streaming Protocol)");
        portMap.put(587, "587 SMTP (Mail Submission Protocol)");
        portMap.put(631, "631 IPP (Internet Printing Protocol)");
        portMap.put(993, "993 IMAPS (Internet Message Access Protocol Secure)");
        portMap.put(995, "995 POP3S (Post Office Protocol version 3 Secure)");
        portMap.put(1080, "1080 SOCKS (Socket Secure)");
        portMap.put(1433, "1433 Microsoft SQL Server");
        portMap.put(1434, "1434 Microsoft SQL Server");
        portMap.put(1701, "1701 L2TP (Layer 2 Tunneling Protocol)");
        portMap.put(1723, "1723 PPTP (Point-to-Point Tunneling Protocol)");
        portMap.put(1883, "1883 MQTT (Message Queuing Telemetry Transport)");
        portMap.put(1900, "1900 UPnP (Universal Plug and Play)");
        portMap.put(2082, "2082 cPanel");
        portMap.put(2083, "2083 cPanel");
        portMap.put(2086, "2086 WHM (Web Host Manager)");
        portMap.put(2087, "2087 WHM (Web Host Manager)");
        portMap.put(2095, "2095 Webmail");
        portMap.put(2096, "2096 Webmail");
        portMap.put(3306, "3306 MySQL");
        portMap.put(3389, "3389 RDP (Remote Desktop Protocol)");
        portMap.put(5432, "5432 PostgreSQL");
        portMap.put(5900, "5900 VNC (Virtual Network Computing)");
        portMap.put(5901, "5901 VNC (Virtual Network Computing)");
        portMap.put(8080, "8080 HTTP (Alternate Port)");
        portMap.put(8443, "8443 HTTPS (Alternate Port)");

        for (int open : Main.Open){
            String output = portMap.get(open);
            if (output==null){
                output= open + " 无数据";
            }
            portData.add(output);
        }
    }

}
