package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class GroupCreationTests extends TestBase {

    Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        //List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
        String xml ="";
        String line = reader.readLine();
        while (line != null){
//            String[] split=line.split(";");
//            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            xml+=line ;

            line=reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class); // obrabotat annotacii @  !!!
        List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml); // пришлось явно преобразовать тип потому что fromXML(xml) возвращает не тот тип
        return groups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator(); //  функциональное программирование !
        // к каждому объекту (типа GroupData) нужно применить функцию , которая каждый объект завернет в массив, который состоит из одного этого объекта!  Потом вызываем collect который должен из потока собрать обратно список и берем у него итератор , его и возвращаем
    }

    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        logger.info("Start test testGroupCreation");
        app.goTo().groupPage();
        Groups before = app.group().all();
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
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        logger.info("Stop test testGroupCreation");
    }

}
