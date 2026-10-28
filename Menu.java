public class Menu {
    public static void main(String[] args) {

        int opcao = 0;

        while (opcao > 8 && opcao < 0) {

            System.out.println("+------------------------------------+");
            System.out.println("|        Menu de opções              |");
            System.out.println("+------------------------------------+");
            System.out.println("| Opção 1 - Cadastrar pet            |");
            System.out.println("| Opção 2 - Cadastrar pessoa         |");
            System.out.println("| Opção 3 - Adotar                   |");
            System.out.println("| Opção 4 - Listar tudo              |");
            System.out.println("| Opção 5 - Listar por tipo de pet   |");
            System.out.println("| Opção 6 - Salvar                   |");
            System.out.println("| Opção 7 - Carregar                 |");
            System.out.println("| Opção 8 - Sair                     |");
            System.out.println("+------------------------------------+");

            opcao = Teclado.leInt("Digite uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do pet: ");
                    String nomePet = Teclado.leString();

                    System.out.println("Digite o sexo do pet: ");
                    String sexoPet = Teclado.leString();

                    System.out.println("Digite a raça do pet: ");
                    String tipoPet = Teclado.leString();

                    Pet p = new Pet(nomePet, sexoPet, tipoPet);
                    Pet.add(p);
                    break;
                case 2:
                    System.out.println("Digite seu nome: ");
                    String nomePessoa = Teclado.leString();

                    System.out.println("Digite o seu genero: ");
                    String sexoPessoa = Teclado.leString();

                    Pessoa pessoa = new Pessoa(nomePessoa, sexoPessoa);
                    Pessoa.add(pessoa);
                    break;
                case 3:
                    System.out.println("Digite seu nome: ");
                    String encontraNomePessoa = Teclado.leString();

                    System.out.println("Digite o nome do pet: ");
                    String encontraNomePet = Teclado.leString();
                    
                    Pessoa encontraPessoa = Pessoa.getByNome(encontraNomePessoa);
                    Pet encontraPet = Pet.getByNome(encontraNomePet);
                    
                    if (encontraPessoa == null) {
                        System.out.println("Pessoa não encontrada!");
                        return;
                    }

                    if (encontraPet == null) {
                        System.out.println("Pet não encontrado!");
                        return;
                    }
                    


                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    Pessoa.salvar();
                    Pet.salvar();
                    System.out.println("Objetos salvos no arquivo!");
                    break;
                case 7:
                    Pessoa.carregar();
                    Pet.carregar();
                    break;
                case 8:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inexistente!");
            }
        }
    }
}
