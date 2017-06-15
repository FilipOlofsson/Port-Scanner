import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PortScanner {

    static List<Integer> openPorts = new LinkedList<>();
    static Socket socket;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What IP address would you like to scan?");
        String IP = scan.nextLine();
        System.out.println("What port would you like to start on?");
        int lowest = scan.nextInt();
        System.out.println("What upper limit would you like to use?");
        int highest = scan.nextInt();
        System.out.println("What timeout do you want to use? (100-500 recommended, depends on your ping.)");
        int timeout = scan.nextInt();
        startScanning(IP, lowest, highest, timeout);
    }

    public static void startScanning(String IP, int lowest, int highest, int timeout) {
        for(int i = lowest; i <= highest; i++) {
            scan(IP, i, timeout);
        }
        for(int i : openPorts) {
            System.out.println(i + " is open.");
        }
    }
    public static void scan(String IP, int current, int timeout) {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(IP, current), timeout);
            openPorts.add(current);
        } catch(IOException e) {
            
        }
    }

}
