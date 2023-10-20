/**
 * 员工信息表类，以ArrayList的形式储存员工信息。
 * 包含对表中数据的添加、修改和删除等方法
 * @see Person
 */

import java.util.ArrayList;

public class PersonList {

    private ArrayList<Person> personList;

    /**
     * 构造函数，以传入的参数personList构造对象
     * @param personList
     */
    public PersonList(ArrayList<Person> personList){

        this.personList =personList;
    }

    /**
     * 获取PersonList类的对象
     *@param
     *@return java.util.ArrayList<Person>
     */
    public ArrayList<Person> getPersonList() {

        return personList;
    }

    /**
     * 根据person的id获取Person对象
     *@param id
     *@return Person
     */
    public Person getPerson(String id) {

        for (Person index : personList) {
            if (index.getId().equals(id))
                return index;
        }
        return null;
    }

    /**
     * 添加一个Person对象
     *@param person
     *@return boolean
     */
    public boolean addPerson(Person person) {

        return personList.add(person);
    }

    /**
     * 根据person的id删除一个Person对象
     *@param id
     *@return boolean
     */
    public boolean removePerson(String id) {

        for (Person index : personList) {
            if(index.getId().equals(id))
                return personList.remove(index);
        }
        return false;
    }

    /**
     * 删除一个Person对象
     *@param person
     *@return boolean
     */
    public boolean removePerson(Person person){

        return personList.remove(person);
    }

    /**
     * 将所有员工信息以字符串形式返回
     *@param
     *@return java.lang.String
     */
    public String toString(){

        String str="";
        for(Person index :personList){
            str=str.concat(index.toString()+"\n");
            return str;
        }
        return "";
    }
}
