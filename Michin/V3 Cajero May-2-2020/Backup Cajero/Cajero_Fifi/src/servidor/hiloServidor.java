
package servidor;

import interfaces.IDto;

import java.io.*;
import java.net.Socket;


public class hiloServidor implements Runnable
{
    private Socket socket;
    private DataInputStream in;

    public hiloServidor(Socket soc)
    {
        socket = soc;
    }
    
    @Override
    public void run()
    {
        try
        {
//DataOutputStream
            InputStream inputStream = socket.getInputStream();
            in = new DataInputStream(socket.getInputStream());

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            while(true)
            {
                /**
                 * Insert, update, delete ==>identificarlas
                 * Select {un objeto o un lista }
                 * Desconexión {Bye, Adios, hasta la vista....} ===>break
                 */
               String request = in.readUTF();
                System.out.println(request);

               if(request.contains("select"))
               {
                   IDto response = getData(request);
                   oos.writeObject(response);
                   oos.flush();
               }
               else
                   {
                        break;
                   }
            }
            in.close();;
            oos.close();
        }
        catch (IOException e)
        {

        }
    }

    public IDto getData(String sql)
    {
        String nameIDto = sql.substring(0,sql.indexOf("#"));
        sql = sql.substring(sql.indexOf("#")+1);
        IDto result = null;
        try
        {
            Class classIDto = Class.forName(nameIDto);
            executeSql<IDto> executeSql = new executeSql<IDto>(classIDto);
            result = executeSql.getOneOnlyResult(sql);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
