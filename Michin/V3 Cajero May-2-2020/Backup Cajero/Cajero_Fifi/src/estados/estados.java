package estados;

import interfaces.IDto;

import java.io.Serializable;

public class estados implements IDto, Serializable
{

    private static final long serialVersionUID = 9891209481243L;


    private Integer tipoEstado;
    private String estado;



    public estados ()
    {

    }

    public estados (Integer tipoEstado)
    {
    this.tipoEstado = tipoEstado;
    }

    public estados (Integer tipoEstado, String estado)
    {
        this.tipoEstado = tipoEstado;
        this.estado = estado;
    }


    public Integer getTipoEstado()
    {
        return this.tipoEstado;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public void setTipoEstado(Integer tipoEstado)
    {
        this.tipoEstado = tipoEstado;
    }

    public String toString()
    {
        return "estados{" +  "tipo_estado=" + this.tipoEstado + ", estado='" + this.estado + '\'' +'}';
    }


    @Override
    public String insert()
    {
        return "insert into estados values("
                +getTipoEstado()+",'"+
                getEstado().trim()+"');"
                ;
    }

    @Override
    public String update()
    {
        return "update estados set estado = '"+getEstado().trim()+"' where tipo_estado = "+tipoEstado;
    }

    @Override
    public String delete() {
        return ("delete from estados where tipo_estado ="+tipoEstado);
    }

    @Override
    public String findAll() {
        return "select * from estados;";
    }

    @Override
    public String findById() {
        return "select * from estados where tipo_estado = "+tipoEstado;
    }
}
