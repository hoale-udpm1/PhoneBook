import java.util.List;
import java.util.Scanner;

public class BookManager {
    public static Scanner scanner = new Scanner(System.in);
    public List<PhoneBook> phoneBookList;
    private PhoneBookDao phoneBookDao;


    public BookManager() {
        phoneBookDao = new PhoneBookDao();
        phoneBookList = phoneBookDao.read();
    }

    public void add() {
        int id = (phoneBookList.size() > 0) ? (phoneBookList.size() + 1) : 1;
        System.out.println("phonebook id =" + id);
        String name = inputName();
        String phone = inputPhone();
        String sex = inputSex();
        String address = inputAddress();
        String email = inputEmail();

        PhoneBook phoneBook = new PhoneBook(id, name, phone, sex, address, email);
        phoneBookList.add(phoneBook);
        phoneBookDao.write(phoneBookList);
    }


    public void edit(int id) {
        boolean isExisted = false;
        int size = phoneBookList.size();
        for (int i = 0; i < size; i++) {
            if (phoneBookList.get(i).getId() == id) {
                isExisted = true;
                phoneBookList.get(i).setName(inputName());
                phoneBookList.get(i).setPhone(inputPhone());
                phoneBookList.get(i).setAddress(inputAddress());
                phoneBookList.get(i).setSex(inputSex());
                phoneBookList.get(i).setEmail(inputEmail());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            phoneBookDao.write(phoneBookList);
        }
    }

    public void delete(int id) {
        PhoneBook phoneBook = null;
        int size = phoneBookList.size();
        for (int i = 0; i < size; i++) {
            if (phoneBookList.get(i).getId() == id) {
                phoneBook = phoneBookList.get(i);
                break;
            }
        }
        if (phoneBook != null) {
            phoneBookList.remove(phoneBook);
            phoneBookDao.write(phoneBookList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void show() {
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.format("%5d | ", phoneBook.getId());
            System.out.format("%20s | ", phoneBook.getName());
            System.out.format("%20s | ", phoneBook.getPhone());
            System.out.format("%20s | ", phoneBook.getSex());
            System.out.format("%20s | ", phoneBook.getAddress());
            System.out.format("%20s|", phoneBook.getEmail());
        }
    }

    public int inputId() {
        System.out.print("Input id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input id again: ");
            }
        }
    }

    public String inputName() {
        System.out.print("Input name: ");
        return scanner.nextLine();
    }
    private String inputPhone() {
        System.out.print("Input Phone: ");
        return scanner.nextLine();
    }
    private String inputSex() {
        System.out.print("Input sex: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Input address: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Input email: ");
        return scanner.nextLine();
    }


    // getter && setter
    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }
}
