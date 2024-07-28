
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)
    {
        ServerSocket ServerSocket = new ServerSocket(8000);

        Socket clientSocet = ServerSocket.accept();
        
        clientSocet.getOutputStream().write(52);

        //OutputStreamWriter o = new OutputStreamWriter(clientSocet.getOutputStream());
        // o.write("<!DOCTYPE html>\r\n" + //
        //                 "<html lang=\"en\">\r\n" + //
        //                 "<head>\r\n" + //
        //                 "    <meta charset=\"UTF-8\">\r\n" + //
        //                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
        //                 "    <title>Document</title>\r\n" + //
        //                 "</head>\r\n" + //
        //                 "<body>\r\n" + //
        //                 "    <p>Hello world</p>\r\n" + //
        //                 "</body>\r\n" + //
        //                 "</html>");
        // o.flush();
        
        System.out.println("hello");
        ServerSocket.close();
        clientSocet.close();
    }
}
