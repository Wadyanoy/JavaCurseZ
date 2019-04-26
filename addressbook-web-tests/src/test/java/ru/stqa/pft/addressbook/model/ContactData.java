package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
    private int id;
    private String firstname;
    private String lastname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }




    public ContactData() {

    }

    public int getId() {
        return id;
    }

    public String getHomePhone() {
        return homePhone;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public ContactData(String firstname, String secondname, String group) {
        this.firstname = firstname;
        this.lastname = secondname;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withMobilePhone (String mobilePhone){
        this.mobilePhone = mobilePhone;
        return  this;
    }

    public ContactData withHomePhone (String mobilePhone){
        this.homePhone = homePhone;
        return  this;
    }

    public ContactData withWorkPhone (String workPhone){
        this.workPhone = workPhone;
        return  this;
    }

    public ContactData withId (int id){
        this.id = id;
        return  this;
    }

    public ContactData withFirstname (String firstname){
        this.firstname = firstname;
        return  this;
    }
    public ContactData withLastname (String lastname){
        this.lastname = lastname;
        return  this;
    }
}
