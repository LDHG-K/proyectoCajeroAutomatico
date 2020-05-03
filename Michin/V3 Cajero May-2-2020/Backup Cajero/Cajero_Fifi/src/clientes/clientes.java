package clientes;

import interfaces.IDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class clientes implements IDto, Serializable
{
    //-------------------------------
    private static final long serialVersionUID = 9891209481243L;
    private Integer idCliente ;
    private Integer clave;
    private Integer identificacion;
    private String nombre;
    private String apellido;
    private Integer cuenta;
    private BigDecimal saldo;
    private Integer tipoIdentificacion;
    private Integer tipoCuenta;
    private Integer estadoCuenta;

    //--------------------------------
 public clientes (Integer idcliente, Integer clave, Integer identificacion, String nombre, String  apellido, Integer cuenta, BigDecimal saldo, Integer tipoIdentificacion, Integer tipoCuenta, Integer estadoCuenta){

     this.idCliente = idcliente ;
     this.clave = clave;
     this.identificacion = identificacion;
     this.apellido = apellido;
     this.nombre = nombre;
     this.cuenta = cuenta;
     this.saldo = saldo;
     this.tipoIdentificacion=tipoIdentificacion;
     this.tipoCuenta= tipoCuenta;
     this.estadoCuenta=estadoCuenta;
 }
 public clientes (Integer idCliente) {this.idCliente = idCliente;}
 public clientes () { }
    //-------------------------------------

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Integer estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    //--------------------------------------
    @Override
    public String insert() {
        return "insert into clientes values ("+getIdCliente()+","+getIdentificacion()+","+getNombre()+","+getApellido()+","+getCuenta()+","+getSaldo()+","+
                getTipoIdentificacion()+","+getTipoCuenta()+","+getEstadoCuenta()+");";
    }

    @Override
    public String update() {
        return "update clientes set id_cliente   ='"+setIdCliente()+"' where";
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public String findById() {
        return null;
    }
//-----------------------------------------

    @Override
    public String toString() {
        return "clientes{" +
                "idCliente=" + idCliente +
                ", clave=" + clave +
                ", identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cuenta=" + cuenta +
                ", saldo=" + saldo +
                ", tipoIdentificacion=" + tipoIdentificacion +
                ", tipoCuenta=" + tipoCuenta +
                ", estadoCuenta=" + estadoCuenta +
                '}';
    }
}
