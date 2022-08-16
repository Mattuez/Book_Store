import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] choice = {0}; //responsible for getting users choice
        boolean exit; //if true the loop will end
        Scanner scanner = new Scanner(System.in);

        do{
            BookStore.show_menu();
            BookStore.get_choice(choice, scanner);
            exit = BookStore.print_choice(choice, scanner);
        } while(!exit);
    }

}
