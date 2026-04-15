package co.edu.poli.examen2_sanabria.servicios;

public interface CRUD<T, K> {

    boolean insertar(T objeto);

    T buscarPorId(K id);

    boolean actualizar(T objeto);

    boolean eliminar(K id);
}