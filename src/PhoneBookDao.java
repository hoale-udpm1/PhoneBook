import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PhoneBookDao {
    private static final String PHONEBOOK_FILE_NAME = "phoneBook.csv";
    List<PhoneBook> phoneBooks = new ArrayList<>();

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

    public static List getPhoneBookInfor(String line) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\"') {
                if (str.length() > 0 && stack.size() % 2 == 0)
                    str.append(ch);
                stack.push(ch);
            } else if (ch == ',' && stack.size() % 2 == 0) {
                result.add(str.toString());
                stack.clear();
                str = new StringBuilder();
            } else if (ch == ',' && stack.size() % 2 != 0) {
                str.append(ch);
            } else {
                str.append(ch);
            }
        }
        result.add(str.toString());
        return result;

    }

    public void write(List<PhoneBook> phoneBookList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(PHONEBOOK_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneBookList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<PhoneBook> read() {
        List<PhoneBook> phoneBookList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(PHONEBOOK_FILE_NAME));
            ois = new ObjectInputStream(fis);
            phoneBookList = (List<PhoneBook>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return phoneBookList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}