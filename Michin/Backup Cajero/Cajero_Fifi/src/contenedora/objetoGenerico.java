package contenedora;

public class objetoGenerico<T>
{
    //Objeto generico
    private T valor;

    //El siguiente pero gennerico xd
    private objetoGenerico<T> siguiente;

    //COntructor ultra generico ateo
    public objetoGenerico(T valor)
    {
        this.valor = valor;
        siguiente = null;
    }


    public T getValor ()
    {
        return valor;
    }

    public void setValor (T valor)
    {
        this.valor = valor;
    }


    public objetoGenerico<T> getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(objetoGenerico<T> pSiguiente)
    {
        this.siguiente = pSiguiente;
    }




}
