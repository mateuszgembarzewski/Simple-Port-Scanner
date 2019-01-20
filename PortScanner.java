import java.io.IOException;
import java.net.*;

//collaboration with Brian Reiskin and Vlad Verba

class PortScanner {
    public static void main(String[] args) {
        int closed = 0;
        int filtered = 0;
        int open = 0;
        for (int port = 1; port <= 100; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("compsci.adelphi.edu", port), 3500);
                socket.close();
                System.out.println("Port " + port + " is open");
                open++;
            } catch (java.net.SocketTimeoutException e) {
                System.out.println("Port " + port + " is filtered.");
                filtered++;
            } catch (IOException e) {
                System.out.println("Port " + port + " is closed.");
                closed++;
            }

        }
        System.out.print("Closed ports: " + closed + "\n");
        System.out.print("Filtered ports: " + filtered + "\n");
        System.out.print("Open ports: " + open + "\n");
    }
}
