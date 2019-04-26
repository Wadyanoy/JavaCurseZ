//package ru.stqa.pft.addressbook.tests;
//
//import org.testng.annotations.Test;
//import ru.stqa.pft.addressbook.model.ContactData;
//
//public class ContactPhoneTests extends TestBase {
//    @Test
//    public void testContactPhones() {
//        app.goTo().gotoHomePage();
//        ContactData contact = app.contact().all().iterator().next();
//        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
//
//    }
//
//    public String cleaned(String phone) {
//        return phone.replaceAll("\\s", "").replaceAll("-()", "");  // регулярки, которые удаляют  пробел \\s,знаки "-", "(", ")"  заменой на ""
//    }
//}



