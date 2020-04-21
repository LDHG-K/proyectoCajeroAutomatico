package servidor;

import db.conexion;
import interfaces.IDto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class executeSql<T extends IDto>
{
    protected conexion con;
    private Class<T> entityClass;

    public executeSql(Class<T> entityClass)
    {
        con = conexion.getInstance();
        this.entityClass = entityClass;
    }

    public IDto getOneOnlyResult(String sql)
    {
        T newObject = newObject();
        ResultSet rs = con.executeQuery(sql);
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

    public List<IDto> getManyResults(String sql)
    {
        ResultSet rs = con.executeQuery(sql);
        List<IDto> allData = new LinkedList<>();
        try
        {
            while (rs.next())
            {
                T newObject = newObject();
                newObject = dataForObject(rs, newObject);
                allData.add(newObject);
            }
        }
        catch (SQLException e)
        {

        }
        return new ArrayList<IDto>(allData);

    }
    private T dataForObject(ResultSet rs, T newObject)
    {
        try
        {
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                String nameMethodSet = getNameSet(metaData.getColumnName(i));

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

    private String setFirstLetterToUpperCase(String word)
    {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    private String getNameSet(String columnName)
    {
        while(columnName.indexOf("_") > 0)
        {
            int pos = columnName.indexOf("_");
            columnName = columnName.substring(0,pos) +
                    setFirstLetterToUpperCase(columnName.substring(pos +1));
        }

        return "set"+setFirstLetterToUpperCase(columnName.substring(0));
    }

}
