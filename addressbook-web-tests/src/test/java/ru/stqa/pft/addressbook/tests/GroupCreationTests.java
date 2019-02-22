package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before= app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        //Assert.assertEquals(after.size(), before.size() + 1);
        MatcherAssert.assertThat(after.size(), CoreMatchers.equalTo(before.size() + 1));

       /* int max=0;
        for (GroupData g:after){
            if (g.getId()>max){
                max=g.getId();
            }
        }
        group.setId(max);
        */

        //улучшенный вариант поиска максимального ид через лямбду
       // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
      //  Assert.assertEquals(before,after);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
