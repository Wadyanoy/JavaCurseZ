package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.sql.SQLOutput;

public class ContactCreationTests extends TestBase{
    @Test (enabled = true)
    public void testContactCreation(){
        app.goTo().gotoHomePage();
        app.getContactHelper().initContactCreation();
        File photo = new File("src/test/resources/stru.png");
        app.getContactHelper().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo),true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

//    @Test
//    public void testCurrentDir() {
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/stru.png");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }

}
