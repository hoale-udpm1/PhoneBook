import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IOFile {
    BookManager bookManager = new BookManager();
    public void writeFile(ArrayList<PhoneBook> list) throws IOException {
        File file = new File("phoneBook.csv");
        PrintWriter fileWriter = new PrintWriter(file);
        for (PhoneBook phonebook :bookManager.phoneBookList) {
            fileWriter.println(phonebook.toCSV());
        }
        fileWriter.close();
    }
    public ArrayList<PhoneBook> readFromFile() throws IOException {
        File file = new File("phoneBook.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        ArrayList<PhoneBook> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            PhoneBook phonebook = new PhoneBook(data[0], data[1], data[2], data[3], data[4], data[5]);
            list.add(phonebook);
        }
        return list;
    }

//    public void
//    List<PhoneBook> phoneBooks = new ArrayList<>();
//
//        try(BufferedReader bir = new BufferedReader(new FileReader(path))) {
//        String line = bir.readLine();
//        while (line != null) {
//            List<String> result = getPhoneBookInfor(line);
//            phoneBooks.add(new PhoneBook(result.get(0).trim(), result.get(1).trim(), result.get(2).trim(), result.get(3).trim(), result.get(4).trim()));
//            line = bir.readLine();
//        }
//        System.out.println("SHOW ALL");
//        System.out.println("----------------------------------------");
//        phoneBooks.forEach(phoneBook -> {
//            System.out.println("Name: " + phoneBook.getName());
//            System.out.println("Phone: " + phoneBook.getPhone());
//            System.out.println("Address: " + phoneBook.getAddress());
//            System.out.println("Sex: " + phoneBook.getSex());
//            System.out.println("Email: " + phoneBook.getEmail());
//            System.out.println("----------------------------------------");
//        });
//
//        System.out.println("\n\n\n");
//
//        phoneBooks.stream().filter(phoneBook -> phoneBook.getAddress().equals("SomeTown"))
//                .forEach(phoneBook -> {
//                    System.out.println("Name: " + phoneBook.getName());
//                    System.out.println("Phone: " + phoneBook.getPhone());
//                    System.out.println("Address: " + phoneBook.getAddress());
//                    System.out.println("Sex: " + phoneBook.getSex());
//                    System.out.println("Email: " + phoneBook.getEmail());
//                    System.out.println("----------------------------------------");
//                });
//    } catch(IOException e){
//        e.printStackTrace();
//    }
//
//    public static List getPhoneBookInfor(String line) {
//        List<String> result = new ArrayList<>();
//        Stack<Character> stack = new Stack<>();
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < line.length(); i++) {
//            char ch = line.charAt(i);
//            if (ch == '\"') {
//                if (str.length() > 0 && stack.size() % 2 == 0)
//                    str.append(ch);
//                stack.push(ch);
//            } else if (ch == ',' && stack.size() % 2 == 0) {
//                result.add(str.toString());
//                stack.clear();
//                str = new StringBuilder();
//            } else if (ch == ',' && stack.size() % 2 != 0) {
//                str.append(ch);
//            } else {
//                str.append(ch);
//            }
//        }
//        result.add(str.toString());
//        return result;
//
//    }
}
