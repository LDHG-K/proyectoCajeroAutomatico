package interfaces;

import contenedora.listaGenerica;

public interface IDao
{
    public boolean insert(IDto dto);

    public boolean update(IDto dto);

    public boolean delete(IDto dto);

    public IDto getById(IDto dto);

    public listaGenerica<IDto> getAll();




}
