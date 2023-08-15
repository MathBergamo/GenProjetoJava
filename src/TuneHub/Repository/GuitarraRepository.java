package TuneHub.Repository;

import TuneHub.Model.Guitarra;

public interface GuitarraRepository {
    public void findById(int numero);

    void listGuitarra();

    public void create(Guitarra guitarra);

    public void update(Guitarra guitarra);

    public void delete(int numero);

    Guitarra findInCollection(int numero);
}
