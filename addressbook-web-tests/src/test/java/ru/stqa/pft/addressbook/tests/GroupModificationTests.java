package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() ==0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName( "edit2664").withHeader("edit3").withFooter("edit4");
        app.group().modify(group);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size()); //можно сократить запись , как в других классах спомощью импорта статических методов

        MatcherAssert.assertThat(after,     //можно сократить запись , как в других классах спомощью импорта статических методов
                CoreMatchers.equalTo(before
                        .without(modifiedGroup)
                        .withAdded(group)));

    }


}
