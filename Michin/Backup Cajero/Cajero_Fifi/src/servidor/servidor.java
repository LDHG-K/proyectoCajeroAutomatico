package servidor;

import java.net.ServerSocket;
import java.net.Socket;


public class servidor
{
    private final int puerto = 2029;
    private final int noConexiones = 20;

    public void escuchar()
    {
        try
        {
            ServerSocket servidor = new ServerSocket(puerto,noConexiones);

            while(true)
            {
                System.out.println("Conectado...");

                Socket cliente = servidor.accept();
                Runnable run = new hiloServidor(cliente);
                Thread hilo = new Thread(run);

                hilo.start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args)
    {
        servidor servidor= new servidor();
        servidor.escuchar();
    }
}
