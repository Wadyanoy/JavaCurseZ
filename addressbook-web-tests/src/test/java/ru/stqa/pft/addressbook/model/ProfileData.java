package ru.stqa.pft.addressbook.model;

public class ProfileData {
    private final String firstName;
    private final String midName;
    private final String lastName;
    private final String nickName;
    private final String company;
    private final String email;


    public ProfileData(String firstName, String midName, String lastName, String nickName, String company, String email) {

        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.company = company;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getNickName() {
        return nickName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }
}
