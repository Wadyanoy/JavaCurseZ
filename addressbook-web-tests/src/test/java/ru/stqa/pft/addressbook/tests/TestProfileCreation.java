package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ProfileData;

public class TestProfileCreation extends TestBase {

    @Test
    public void TestProfileCreation() {
        app.goTo().gotoProfilePage();
        app.group().fillProfileForm(new ProfileData("Wadya","Sergeevi4","Seledtsov" , "Wadyanoy", "otr" , "Wadyanoy@gmail.com"));
        app.group().submitProfile();
    }

}
