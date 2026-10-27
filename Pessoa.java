import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    private String sexo;
    private Pet pet;
    private static String separador = ";";
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    // Construtor com todos os atributos tipados
    public Pessoa(int id, String nome, String sexo, Pet pet) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.pet = pet;
    }

    // Construtor para desserializar a partir de uma linha do arquivo
    public Pessoa(String linha) {
        this.deserializar(linha);
    }

    // Método que adiciona uma Pessoa a lista de pessoas
    public static void add(Pessoa pessoa) {
        Pessoa.pessoas.add(pessoa);
    }

    // Método que exibe os dados de todas as pessoas
    public static void exibirDados() {
        for (Pessoa pessoa : Pessoa.pessoas)
            System.out.println(pessoa);
    }

    // Método para carregar os dados das pessoas a partir de um arquivo
    public static void carregar() {
        try {
            String linha;

            FileReader reader = new FileReader("pessoas.txt");
            BufferedReader buffer = new BufferedReader(reader);
            buffer.readLine(); // Descarta o cabeçalho

            while ((linha = buffer.readLine()) != null) {
                Pessoa.pessoas.add(new Pessoa(linha));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para salvar os dados das pessoas em arquivo
    public static void salvar() {
        try {
            FileWriter writer = new FileWriter("pessoas.txt", false);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(Pessoa.cabecalho());
            for (Pessoa p : Pessoa.pessoas) {
                buffer.write(p.serializar());
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que retorna o cabeçalho do arquivo
    public static String cabecalho() {
        return
            "id" + separador +
            "nome" + separador +
            "sexo" + separador +
            "petId";
    }

    // Método que serializa o objeto em uma linha de texto
    public String serializar() {
        return
            System.lineSeparator() +
            id + separador +
            nome + separador +
            sexo + separador +
            pet.getId();
    }

    // Método que deserializa uma linha de texto em um objeto
    public void deserializar(String linha) {
        String[] campos = linha.split(separador);
        this.id = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.sexo = campos[2];
        this.pet = Pet.getById(Integer.parseInt(campos[3]));
    }

    // Método que retorna uma representação do objeto
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", pet=" + (pet == null ? "null" : pet) + "]";
    }

}
