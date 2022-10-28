import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class server1 {
    public static void main(String[] args) throws IOException, SocketException {
        int count = 1;//счетчик
        ServerSocket serverSocker = new ServerSocket(8000);//серверный сокет с портом коннекта
        Socket socket;//сокет подключения с клиентом
        while (count < 6) {//пока верно
            socket = serverSocker.accept();//создаю сокет для подключения и ожидаю подключения
            System.out.println("Client entered " + (count));//отображаю вход клиента и его номер
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());//открываю выводящий поток
            osw.write("HTTP/1.0 200 OK\n" +
                    "Content-type: text/html\n" +
                    "\n" + "<h1>client " + count + "</h1>");//передаю информацию клиенту
            count++;//уеличиваю счетчик
            osw.close();//закрываю поток
            socket.close();//закрываю сокет
            if (count == 6) {
                serverSocker.close();
            }
        }
    }
}
