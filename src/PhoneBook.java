import java.io.Serializable;

public class PhoneBook implements Serializable {
    private String name;
    private String phone;
    private String address;
    private String sex;
    private String email;

    public PhoneBook(String trim, String s, String trim1, String s1, String trim2) {

    }

    public PhoneBook(String name, String phone, String address, String sex, String date, String email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
//        this.date = date;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
