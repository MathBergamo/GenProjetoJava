package TuneHub.Controller;

import TuneHub.Model.Guitarra;
import TuneHub.Repository.GuitarraRepository;

import java.util.ArrayList;

public class GuitarraController implements GuitarraRepository {
    ArrayList<Guitarra> guitarraLista = new ArrayList<>();

    int id;

    public int gerarId() {
        return ++id;
    }

    @Override
    public Guitarra findInCollection(int numero) {
        for (Guitarra guitarra: guitarraLista) {
            if (guitarra.getId() == numero){
                return guitarra;
            }
        }
        return null;
    }

    @Override
    public void findById(int numero) {
        Guitarra guitarra = findInCollection(numero);

        if (guitarra != null){
            guitarra.show();
        } else {
            System.out.println("\nA Guitarra com número Identificador: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void listGuitarra() {
        for (Guitarra guitarra: guitarraLista) {
            guitarra.show();
        }
    }

    @Override
    public void create(Guitarra guitarra) {
        guitarraLista.add(guitarra);
        System.out.println("\nGuitarra Registrada com sucesso!");
    }

    @Override
    public void update(Guitarra guitarra) {
        Guitarra buscarGuitarra = findInCollection(guitarra.getId());

        if (buscarGuitarra != null){
            guitarraLista.set(guitarraLista.indexOf(buscarGuitarra), guitarra);
            System.out.println("A Guitarra com o Número Identificador: " + guitarra.getId() + " foi atualizada com sucesso!");
        } else {
            System.out.println("A Guitarra com o Número Identificador: " + guitarra.getId() + " não foi encontrada!");
        }
    }

    @Override
    public void delete(int numero) {
        Guitarra guitarra = findInCollection(numero);

        if (guitarra != null){
            if (guitarraLista.remove(guitarra)){
                System.out.println("A guitarra com Número Identificador: " + numero + " foi excluída com sucesso!");
            } else {
                System.out.println("A guitarra com Número Identificador: " + numero + " não existe!");
            }
        }
    }

}
