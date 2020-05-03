package transacciones;

import interfaces.IDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class transacciones implements IDto, Serializable
{
    private static final long serialVersionUID = 1234592356L;

    private Integer transaccionId;
    private Integer clienteId;
    private Timestamp fecha;
    private String movimiento;
    private BigDecimal valor;

    public transacciones (Integer transaccionId, Integer clienteId, Timestamp fecha, String movimiento, BigDecimal valor)
    {
        this.transaccionId = transaccionId;
        this.clienteId= clienteId;
        this.fecha = fecha;
        this.movimiento = movimiento;
        this.valor = valor;
    }

    public transacciones()
    {
    }


    public Integer getTransaccionId()
    {
        return this.transaccionId;
    }

    public Integer getClienteId()
    {
        return this.clienteId;
    }

    public Timestamp getFecha()
    {
        return this.fecha;
    }

    public String getMovimiento()
    {
        return this.movimiento;
    }

    public BigDecimal getValor()
    {
        return this.valor;
    }

    public void setTransaccionId(Integer transaccionId)

    {
        this.transaccionId = transaccionId;
    }

    public void setClienteId(Integer clienteId)
    {
        this.clienteId = clienteId;
    }

    public void setFecha(Timestamp fecha)
    {
        this.fecha = fecha;
    }

    public void setMovimiento(String movimiento)
    {
        this.movimiento = movimiento;
    }

    public void setValor(BigDecimal valor)
    {
        this.valor = valor;
    }


    public String toString()
    {
        return "transacciones{" +  "transaccion_id= " + this.transaccionId + ", cliente_id= " + this.clienteId
                +  ", fecha= " + this.fecha + ", movimiento= " + this.movimiento + ", valor= " + this.valor +'\'' +'}';
    }

    @Override
    public String insert()
    {
        return "insert into transacciones values("+getTransaccionId()+","+getClienteId()+",'"+getFecha()+"','"+getMovimiento()+"',"+getValor()+");"       ;
    }


    //En un banco o cajero no se actualizan transacciones que ya fueron creadas anteriormente.
    @Override
    public String update()
    {
        return null;
    }

    //En un banco o cajero las transacciones (Asi sean un error) jamas no se eliminan.
    @Override
    public String delete()
    {
        return null;
    }

    @Override
    public String findAll()
    {
        return "select * from transacciones" + ";";
    }

    @Override
    public String findById()
    {
        return "select * from transacciones where transaccion_id = "+this.transaccionId+ ";";
    }
}
