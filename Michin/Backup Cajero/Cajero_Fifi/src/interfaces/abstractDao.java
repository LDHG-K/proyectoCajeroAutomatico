package interfaces;

import db.conexion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//El dao es un patron de diseno que se encarga de hacer la persistencia con la base de datos
//dao trabaja directamente con la base de datos
public abstract class abstractDao<T extends IDto> implements IDao
{
    protected conexion con;

    private Class<T> entityClass;

    public abstractDao(Class<T> entityClass)
    {
        con = conexion.getInstance();
        this.entityClass = entityClass;
    }

    @Override
    public boolean insert(IDto dto)
    {
        return con.executeUpdate(dto.insert()) > 0;
    }

    @Override
    public boolean update(IDto dto)
    {
        return con.executeUpdate(dto.update()) > 0;
    }


    @Override
    public boolean delete(IDto dto)
    {
        return con.executeUpdate(dto.delete()) > 0;
    }

    //retorna el objeto de la llave primaria que le estamos pasando por parametro
    //entityclass es un objeto que almacena la clase
    public IDto getById(IDto dto)
    {
        T newObject = newObject();

        ResultSet rs = con.executeQuery(dto.findById());

        try
        {
            while (rs.next())
            {
                newObject = dataForObject(rs, newObject);
            }
        }

        catch (SQLException e)
        {

        }

        return newObject;
    }


    private T dataForObject(ResultSet rs, T newObject)
    {
        try
        {
            ResultSetMetaData metaData = rs.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                String nameMethodSet = getNameSet(metaData.getColumnName(i)); // id setId(Int)
                Method methodToExecute = entityClass.getMethod(nameMethodSet, Class.forName(metaData.getColumnClassName(i)));
                methodToExecute.invoke(newObject, rs.getObject(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return newObject;
    }


    private String setFirstLetterToUpperCase(String word)
    {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    private String getNameSet(String columnName)
    {
        while(columnName.indexOf("_") > 0)
        {
            int pos = columnName.indexOf("_");
            columnName = columnName.substring(0,pos) + setFirstLetterToUpperCase(columnName.substring(pos +1));
        }
        return "set"+setFirstLetterToUpperCase(columnName.substring(0));
    }

    //getAll hacer, es el getById con 3 o mas lines, hay que delcarar un linkedlist de tipo idto y lo crean,
    //y tambien tienen que declarar el newobject, y ejecutamos el getall y el result set va a traer varias filas,



    public List <IDto> getAll()
    {
        ResultSet rs = con.executeQuery(newObject().findAll());

        List<IDto> getAllList = new LinkedList<>();

        try
        {
            while (rs.next())
            {

                T newObject = newObject();

                newObject = dataForObject(rs, newObject);
                getAllList.add(newObject);

            }

        }

        catch (SQLException e)
        {

        }

        return new ArrayList<IDto>(getAllList);

    }


    public T newObject()
    {
        T newObject = null;

        try
        {
            newObject = entityClass.getConstructor().newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return newObject;
    }

    protected Field[] getFields()
    {
        return entityClass.getFields();
    }

}
/**
 * Genericidad => genericos => clases parámetrizadas
 *
 * Recursividad (Class)
 *      Como crear Objetos
 *      Cómo recuperar los métodos que tiene una clase
 *      Cómo recuperar los atributos con sus características de una clase
 *      Cómo ejecutar métodos de uan clase
 */