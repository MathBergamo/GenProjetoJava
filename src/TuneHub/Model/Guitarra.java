package TuneHub.Model;

public class Guitarra {
    private int id;
    private String nome;
    private int ano;
    private Float preco;

    public Guitarra() {
    }

    public Guitarra(Integer id, String nome, Integer ano, Float preco) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public void show(){
        System.out.println("\n\n***********************************************************");
        System.out.println("Dados da Guitarra:");
        System.out.println("***********************************************************");
        System.out.println("Identificador: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Ano: " + this.ano);
        System.out.println("Preço: " + this.preco);
    }
}
