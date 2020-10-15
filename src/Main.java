import java.util.Scanner;

public class Main {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            String choose = null;
            boolean exit = false;
            BookManager bookManager = new BookManager();
            String phoneBookName;

            // show menu
            showMenu();
            while (true) {
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        bookManager.add();
                        break;
                    case "2":
                        phoneBookName = BookManager.inputName();
                        bookManager.edit(phoneBookName);
                        break;
                    case "3":
                        phoneBookName = bookManager.inputName();
                        bookManager.delete(phoneBookName);
                        break;
                    case "4":
                        bookManager.show();
                        break;
                    case "0":
                        System.out.println("exited!");
                        exit = true;
                        break;
                    default:
                        System.out.println("invalid! please choose action in below menu:");
                        break;
                }
                if (exit) {
                    break;
                }
                showMenu();
            }
        }

        public static void showMenu() {
            System.out.println("-----------menu------------");
            System.out.println("1. Add .");
            System.out.println("2. Edit .");
            System.out.println("3. Delete .");
            System.out.println("4. Show.");
            System.out.println("0. exit.");
            System.out.println("---------------------------");
            System.out.print("Please choose: ");
        }
    }

