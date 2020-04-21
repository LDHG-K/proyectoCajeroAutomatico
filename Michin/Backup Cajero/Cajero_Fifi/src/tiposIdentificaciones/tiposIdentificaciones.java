package tiposIdentificaciones;

import interfaces.IDto;

import java.io.Serializable;

public class tiposIdentificaciones implements IDto, Serializable
{

    private  static final long serialVersionUID = -3200491895225117038L;

    private Integer id;
    private String nombre;


    public tiposIdentificaciones(Integer id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }


    public tiposIdentificaciones()
    {

    }


    public Integer getId()
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
        return "tipos_identificaciones{" +  "id=" + id + ", nombre='" + nombre + '\'' +'}';
    }

    @Override
    public String insert()
    {
        return "insert into tipos_identificaciones values("
                +getId()+",'"+
                getNombre().trim()+"');"
                ;
    }

    @Override
    public String update()
    {
        return "update tipos_identificaciones set nombre = '"+getNombre().trim()+"' where id = "+id;
    }

    @Override
    public String delete()
    {
        return ("delete from tipos_identificaciones where id ="+id);
    }


    @Override
    public String findAll()
    {
        return "select * from tipos_identificaciones";
    }

    @Override
    public String findById()
    {
        return "select * from tipos_identificaciones where id = "+id;
    }
}
