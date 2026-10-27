import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pet {
    private int id;
    private String nome;
    private String sexo;
    private String tipo;
    private static String separador = ";";
    private static ArrayList<Pet> pets = new ArrayList<>();

    // Construtor com todos os atributos tipados
    public Pet(int id, String nome, String sexo, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.tipo = tipo;
    }
    
    // Construtor para desserializar a partir de uma linha do arquivo
    public Pet(String linha) {
        this.deserializar(linha);
     }

    // Método que adiciona um Pet a lista de pets
    public static void add(Pet pet) {
        pets.add(pet);
    }
    
    // Método que retorna o identificador único do pet
    public int getId() {
        return this.id;
    }

    // Método que retorna o pet a partir do identificador único
    public static Pet getById(int id) {
        for (Pet pet : pets)
            if (pet.getId() == id)
                return pet;
        return null;
    }   

    // Método que exibe os dados de todos os pets
    public static void exibirDados() {
        for (Pet pet : Pet.pets)
            System.out.println(pet);
    }

    // Método para carregar os dados dos pets a partir de um arquivo
    public static void carregar() {
        try {
            String linha;

            FileReader reader = new FileReader("pets.txt");
            BufferedReader buffer = new BufferedReader(reader);
            buffer.readLine(); // Descarta o cabeçalho

            while ((linha = buffer.readLine()) != null) {
                Pet.pets.add(new Pet(linha));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para salvar os dados dos pets em arquivo
    public static void salvar() {
        try {
            FileWriter writer = new FileWriter("pets.txt", false);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(Pet.cabecalho());
            for (Pet pet : Pet.pets) {
                buffer.write(pet.serializar());
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
            "tipo";
    }

    // Método que serializa o objeto em uma linha de texto
    public String serializar() {
        return
            System.lineSeparator() +
            id + separador +
            nome + separador +
            sexo + separador +
            tipo;
    }
    
    // Método que deserializa uma linha de texto em um objeto
    public void deserializar(String linha) {
        String[] campos = linha.split(separador);
        this.id = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.sexo = campos[2];
        this.tipo = campos[3];
    }

    // Método que retorna uma representação do objeto
    @Override
    public String toString() {
        return "Pet [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", tipo=" + tipo + "]";
    }
}
