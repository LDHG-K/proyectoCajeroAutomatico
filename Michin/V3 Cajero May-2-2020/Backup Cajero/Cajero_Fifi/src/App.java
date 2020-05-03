import contenedora.listaGenerica;
import estados.estados;
import estados.estadosDao;
import tiposCuentas.tiposCuentas;
import tiposCuentas.tiposCuentasDao;
import tiposIdentificaciones.tiposIdentificaciones;
import tiposIdentificaciones.tiposIdentificacionesDao;
import transacciones.transacciones;
import transacciones.transaccionesDao;

public class App
{
    public static void main(String[] args)
    {
        //clienteGUI interfazCliente = new clienteGUI();
        //interfazCliente.setVisible(true);

       // System.out.println("Interfaz Fifi Del Cajerito\n");
       new App();
    }
    public App (String pero)
    {
        listaGenerica<tiposCuentas> listobitch;
        listobitch = new listaGenerica<tiposCuentas>();

        tiposCuentas cuentaTipo1 = new tiposCuentas(1, "Ahorros");
        tiposCuentas cuentaTipo2 = new tiposCuentas(2, "Corriente");
        tiposCuentas cuentaTipo3 = new tiposCuentas(3, "Nomina");

        listobitch.add(cuentaTipo1);
        listobitch.add(cuentaTipo2);
        listobitch.add(cuentaTipo3);


       // listobitch.remove(cuentaTipo3);


        System.out.println(listobitch.toString());
        System.out.println(listobitch.get(0));
        System.out.println(listobitch.get(1));
        System.out.println(listobitch.get(2));



    }

    public App()
    {
        tiposIdentificacionesDao identificacionesDao = new tiposIdentificacionesDao();

        tiposIdentificaciones identificaciones = new tiposIdentificaciones();


        System.out.println(identificacionesDao.getAll());


        estadosDao estadosDao = new estadosDao();
        estados estados = new estados();

        System.out.println(estadosDao.getAll());


        transaccionesDao transaccionesDao = new transaccionesDao();
        transacciones transacciones = new transacciones();

        System.out.println(transaccionesDao.getAll());






        tiposCuentasDao cuentasDao = new tiposCuentasDao();
                tiposCuentas cuentas = new tiposCuentas(1);


        System.out.println(cuentasDao.getById(cuentas)+"\n");







/*
        tipos_cuentasDao cuentasDao = new tipos_cuentasDao();

        tipos_cuentas cuentas = new tipos_cuentas();


        System.out.println(cuentasDao.getAll(cuentas));
*/








    }



        /*
        Conexion con = Conexion.getInstance();


        //Comando para borrar todos los registros de la tabla
        con.executeUpdate("delete from tipos_cuentas;");

        System.out.println("Ahora Agreguemos 3 Registros en tipos_cuentas\n");
        //Agregaremos 3 Registros a nuestra tablita pambisita
        tipos_cuentas reg1 = new tipos_cuentas(1,"ahorros");
        tipos_cuentas reg2 = new tipos_cuentas(2,"corriente");
        tipos_cuentas reg3 = new tipos_cuentas(3,"nomina");

        con.executeUpdate(reg1.insert());
        con.executeUpdate(reg2.insert());
        con.executeUpdate(reg3.insert());

        //Observemos los registros

        tipos_cuentasDao cuentasDao = new tipos_cuentasDao();

        List<IDto> grupoCuentas = cuentasDao.getAll();
        grupoCuentas.forEach(tiposDeCuentas -> System.out.println(tiposDeCuentas));


        System.out.println("\n");
        System.out.println("Ahora Eliminemos Corriente\n");
        //Eliminamos el registro de corriente
        con.executeUpdate(reg2.delete());


        //Otra forma de mostrar todos los datos pero con texto en bruto
        ResultSet rs = con.executeQuery(reg1.findAll());



        try
        {
            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id") +" "+
                                rs.getString("nombre"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        System.out.println("\n");


        //Comando para borrar todos los registros de la tabla
        con.executeUpdate("delete from tipos_identificaciones;");

        //Agregaremos 3 Registros a nuestra tablita pambisita
        tipos_identificaciones regID1 = new tipos_identificaciones(1,"cedula");
        tipos_identificaciones regID2 = new tipos_identificaciones(2,"pasaporte");
        tipos_identificaciones regID3 = new tipos_identificaciones(3,"nit");

        con.executeUpdate(regID1.insert());
        con.executeUpdate(regID2.insert());
        con.executeUpdate(regID3.insert());


        //Observemos los registros
        tipos_identificacionesDao identificacionesDao = new tipos_identificacionesDao();

        List<IDto> grupoIdentificaciones = identificacionesDao.getAll();
        grupoIdentificaciones.forEach(tiposDeIdentificaciones -> System.out.println(tiposDeIdentificaciones));


    }



*/









}
