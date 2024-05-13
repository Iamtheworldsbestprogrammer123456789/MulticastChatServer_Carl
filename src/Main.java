import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        throw Exception{
            int portnumber = 6969;
            if (args.length >= 1){
                portnumber = Integer.parseInt(args[0]);
        }

            MulticastSocket serverMulticastSocket = new MulticastSocket(portnumber);

            InetAddress group = InetAddress.getByName("222.4.5.6");

            serverMulticastSocket.joinGroup(group);
            System.out.println("joinGroup method is callec...");
            boolean infinite = true;

            while(infinite){
                byte buf[] = new byte[1024];
                DatagramPacket data = new DatagramPacket(buf, buf.length);
                serverMulticastSocket.receive(data);
                String msg = new String(data.getData()).trim();
                System.out.println("Message recived from client = " + msg);
            }
            serverMulticastSocket.close();
        }
    }
}