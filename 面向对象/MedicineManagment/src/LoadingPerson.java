/**
 * 读取Person文件，加载PersonList数据信息
 * @see PersonDataLoading
 * @see PersonList
 * @see Person
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadingPerson implements PersonDataLoading{

    /**
     * 空构造函数
     */
    public LoadingPerson(){}

    /**
     * 读取Person文件，加载PersonList数据信息
     * @return
     */
    public PersonList loadPersonData() {

        File file =new File("PersonData/PersonData.txt");
        BufferedReader reader = null;
        ArrayList<Person> persons =new ArrayList<>();
        PersonList personList =new PersonList(persons);
        try {
            reader = new BufferedReader(new FileReader(file));
            String strTemp;
            String name="";
            String id="";
            String password="";
            String level="";
            while ((strTemp=reader.readLine())!=null){
                String[] information=strTemp.split("_");
                name=information[0];
                id=information[1];
                password=information[2];
                level=information[3];
                Person person=new Person(name,id,password,level);
                personList.addPerson(person);

            }
            reader.close();

        }catch (IOException e){}


        return personList;
    }
}
