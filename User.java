import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {

    private String familyName, name, surname, birthDate, phoneNumber, gender;

    public User() {

    }

    public User(String familyName, String name, String surname, String birthDate, String phoneNumber, String gender) {
        this.familyName = familyName;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        dateFormat.parse(birthDate);
        this.birthDate = birthDate;
    }

    public void setFamilyName(String familyName) throws ShortStringException {
        this.familyName = inputCount(familyName);
    }

    public void setGender(String gender) throws ShortStringException {
        this.gender = genderCount(gender);
    }

    public void setName(String name) throws ShortStringException {
        this.name = inputCount(name);
    }
    public void setPhoneNumber(String phoneNumber) {
        Long.parseLong(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setSurname(String surname) throws ShortStringException {
        this.surname = inputCount(surname);
    }

    public String getFamilyName() {
        return familyName;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    @Override
    public String toString() {
        String result = "<" + familyName + ">"
                + "<" + name + ">"
                + "<" + surname + ">"
                + "<" + birthDate + ">"
                + "<" + phoneNumber + ">"
                + "<" + gender + ">";
        return result;
    }

    private static String inputCount(String input) throws ShortStringException{
        if(input.length() < 2) {
            throw new ShortStringException("Ошибка: ФИО меньше 2х символов");
        }
        return input;
    }

    private static String genderCount(String input) throws ShortStringException{
        if(!input.equals("f") && !input.equals("m")) {
            throw new ShortStringException("Ошибка: Введен неверный пол");
        }
        return input;
    }
}

class ShortStringException extends Exception {
    public ShortStringException(String message) {
        super(message);
    }
}
