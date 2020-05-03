package contenedora;

public class listaGenerica<T>
{
    private objetoGenerico<T> cabecera;


    public listaGenerica ()
    {
        cabecera = null;
    }

    //Agrega xd
    public void add (T pNuevo)
    {
        objetoGenerico<T> parametro = new objetoGenerico<T>(pNuevo);

        if(cabecera == null)
        {
            cabecera = parametro;
            return;
        }

        objetoGenerico<T> temporal = cabecera;

        while(temporal.getSiguiente() != null)
        {
            temporal = temporal.getSiguiente();
        }

        temporal.setSiguiente(parametro);

    }

    //Eliminar por posicion
    public void remove(int index)
    {
        if(index >= 0 && index < size())
        {
            if(index == 0)
            {
                cabecera = cabecera.getSiguiente();
            }
            else
            {
                objetoGenerico<T> aux = cabecera;

                for (int i = 0; i < index -1 ; i++)
                {
                    aux = aux.getSiguiente();
                }

                objetoGenerico<T> siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
        }
    }

    //Eliminar por parametro
    public void remove(T pParametro)
    {
        objetoGenerico<T> cabecita = cabecera;
        objetoGenerico<T> parametro = new objetoGenerico<T>(pParametro);


        while (cabecita != null)
        {
            if (cabecita.getSiguiente().getValor() == parametro.getValor())
            {
                cabecita.setSiguiente(cabecita.getSiguiente().getSiguiente());
                return;
            }
            cabecita=cabecita.getSiguiente();
        }
    }

    //Limpia la lista y la deja vacia
    public void clear()
    {
        cabecera = null;
    }

    //Metodo que retorna el tamano de la contenedora
    public int size()
    {
        objetoGenerico<T> temporal = cabecera;
        int contador = 0;

            while(temporal != null)
            {
                temporal = temporal.getSiguiente();
                contador++;
            }

        return contador;
    }


    @Override
    public String toString()
    {
        objetoGenerico<T> temporal = cabecera;

        String lista = "";

        while(temporal != null)
        {
            lista += " "+temporal.getValor();
            temporal = temporal.getSiguiente();
        }

        return lista;
    }


    //Metodo que retorna un objeto por posicion
    public T get(int index)
    {
        objetoGenerico<T> temporal = cabecera;

        int contador = 0;

            while(temporal != null)
            {
                if(contador == index)
                {
                    break;
                }
                temporal = temporal.getSiguiente();
                contador++;
            }

        return temporal.getValor();
    }









}
