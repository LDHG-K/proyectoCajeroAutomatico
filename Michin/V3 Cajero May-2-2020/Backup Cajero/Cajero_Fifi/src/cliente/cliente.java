package cliente;

import interfaces.IDto;
import tiposCuentas.tiposCuentas;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class cliente
{
    private Socket cliente;
    private DataOutputStream out;
    private ObjectInputStream ois;

    private int puerto = 2029;
    private String host = "localhost";


    public static void main(String[] args)
    {
        new cliente();
    }
    public cliente()
    {
        try
        {
            cliente = new Socket(host,puerto);
            this.out = new DataOutputStream(cliente.getOutputStream());
            this.ois = new ObjectInputStream(cliente.getInputStream());

           // HobbiesDao hobbiesDao = new HobbiesDao();

          //getOneObject(Hobbies.class.getName()+"#"+hobbiesDao.getById(new Hobbies(1)));
            getOneObject(tiposCuentas.class.getName() + "#select * from tipos_cuentas where id = 1");
            this.ois.close();
            this.out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void getOneObject(String sql)
    {
        try
        {
            this.out.writeUTF(sql);
            this.out.flush();

            IDto response = (IDto) ois.readObject();
            System.out.println(response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
