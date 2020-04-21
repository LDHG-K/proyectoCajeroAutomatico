package tiposCuentas;

import interfaces.IDto;

import java.io.Serializable;


public class tiposCuentas implements IDto, Serializable
{

    //Para que yo pueda enviar objetos de un lado para otro los hago serialiaables
    private static final long serialVersionUID = 100L;


    //En los DTO almaceno la informacion de la tabla
    //En los metodos DTO se hacen 3 constructores, uno vacio, uno con la pk y uno con todos los atributos
    private Integer id;
    private String nombre;


    public tiposCuentas(Integer id)
    {
        this.id = id;
    }

    public tiposCuentas(Integer id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }


    public tiposCuentas()
    {

    }



    public int getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "tipos_cuentas{" +  "id=" + id + ", nombre='" + nombre + '\'' +'}';
    }


    //Funcion: el dto genera su propio codigo sql
    @Override
    public String insert()
    {
        return "insert into tipos_cuentas values("
                +getId()+",'"+
                getNombre().trim()+"');"
                ;
    }

    @Override
    public String update()
    {
        return "update tipos_cuentas set nombre = '"+getNombre().trim()+"' where id = "+id;
    }

    @Override
    public String delete()
    {
        return ("delete from tipos_cuentas where id ="+id);
    }




    @Override
    public String findAll()
    {
        return "select * from tipos_cuentas";
    }

    @Override
    public String findById()
    {
        return "select * from tipos_cuentas where id = "+id;
    }

    //Las llaves foraneas son validaciones,


}
