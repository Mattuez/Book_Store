import java.util.Scanner;

public class BookStore {
    static Book[] book = new Book[20]; //object named book array

    //showing the menu
    public static void show_menu() {
        System.out.println("1) Cadastrar um novo livro;\n2)Consultar um livro;\n3)Comprar um livro;\n4)Sair do programa");
    }

    //getting user choice
    public static void get_choice(int[] choice, Scanner scanner) {
        System.out.println("Digite sua escolha: ");
        choice[0] = scanner.nextInt();
    }

    //printing user choice
    public static boolean print_choice(int[] choice, Scanner scanner) {
        switch (choice[0]) {
            case 1 -> {
                register_book(scanner);
                return false;
            }
            case 2 -> {
                consult_book(scanner);
                return false;
            }
            case 3 -> {
                buy_book(scanner);
                return false;
            }
            case 4 -> {
                System.out.println("Programa encerrado!");
                return true;
            }
            default -> {
                System.out.println("Digite uma escolha valida!");
                print_choice(choice, scanner);
            }
        }
        return false;
    }

    private static void buy_book(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o codigo do livro: ");
        String input_code = scanner.nextLine();

        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getCode().equalsIgnoreCase(input_code)) {
                System.out.println("Livro encontrado!");
                System.out.printf("Nome do livro: %s\n", book[i].getName());
                System.out.printf("Preco do livro: R$%.2f\n", book[i].getPrice());
                System.out.printf("Quantidade de livros disponíveis: %d\n", book[i].getQuantity());
                System.out.printf("Quantidade de livros que deseja comprar(max %d): ", book[i].getQuantity());
                int input_quantity = scanner.nextInt();

                if (input_quantity > book[i].getQuantity()) {
                    System.out.printf("O numero disponível de livros é: %d\n", book[i].getQuantity());
                    input_quantity = book[i].getQuantity();
                }

                confirm_purchase(scanner, i, book, input_quantity);
            }
        }
    }

    private static void confirm_purchase(Scanner scanner, int i, Book[] book, int input_quantity) {
        System.out.printf("%d %s por: %f\nDeseja confirmar compra?\n->", input_quantity, book[i].getName(), book[i].getPrice() * input_quantity);
        scanner.nextLine();
        String confirm = scanner.nextLine();

        if(confirm.toLowerCase().equals("sim") || confirm.toLowerCase().equals("s")) {
            System.out.println("Compra confirmada!");
            book[i].setQuantity(book[i].getQuantity() - input_quantity);
            return;
        } else if (confirm.toLowerCase().equals("nao") || confirm.toLowerCase().equals("n")) {
            System.out.println("Compra cancelada!");
            return;
        } else {
            System.out.println("Digite uma escolha valida!");
            confirm_purchase(scanner, i, book, input_quantity);
        }
    }

    //registering book
    private static void register_book(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o codigo do livro: ");
        String input_code = scanner.nextLine();
        System.out.print("Digite a quantidade de livros: ");
        int input_quantity = scanner.nextInt();

        //seeing if the book is already registered
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getCode().equalsIgnoreCase(input_code)) {
                book[i].setQuantity(book[i].getQuantity() + input_quantity);
                System.out.printf("%s foi encontrado no sistema! Nova quantidade de livros: %d\n", book[i].getName(), book[i].getQuantity());
                return;
            }
        }

        scanner.nextLine();
        System.out.print("Digite o nome do livro: ");
        String input_name = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String input_author = scanner.nextLine();
        System.out.print("Digite a linguagem do livro: ");
        String input_language = scanner.nextLine();
        System.out.print("Digite a quantidade de paginas do livro: ");
        int input_pages = scanner.nextInt();
        System.out.print("Digite o preco do livro: ");
        double input_price = scanner.nextDouble();

        //making the object book
        for (int i = 0; i < book.length; i++) {
            if (book[i] == null) {
                book[i] = new Book(input_name, input_author, input_code, input_pages, input_price, input_language, input_quantity);
                return;
            }
        }
    }

    private static void consult_book(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o nome do livro: ");
        String input_name = scanner.nextLine();

        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getName().equalsIgnoreCase(input_name)) {
                System.out.printf("Codigo do livro: %s\n", book[i].getCode());
                System.out.printf("Nome do livro: %s\n", book[i].getName());
                System.out.printf("Nome do autor: %s\n", book[i].getAuthor());
                System.out.printf("Linguagem do livro: %s\n", book[i].getLanguage());
                System.out.printf("Quantidade de paginas do livro: %d\n", book[i].getPages());
                System.out.printf("Preco do livro: R$%.2f\n", book[i].getPrice());
                System.out.printf("Quantidade de livros disponíveis: %d\n", book[i].getQuantity());
                return;
            }
        }
        System.out.println("Livro nao encontrado!");
        return;
    }
}