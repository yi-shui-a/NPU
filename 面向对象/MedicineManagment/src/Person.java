/**
 * 员工信息类，主要包含员工的个人信息以及相关的调用方法
 */

public class Person {
    private String name;
    private String id;
    private String password;
    private String level;

    /**
     * 构造函数，根据参数构造对象
     * @param name
     * @param id
     * @param password
     * @param level
     */
    public Person(String name, String id, String password, String level) {

        this.name = name;
        this.id = id;
        this.password = password;
        this.level = level;
    }

    /**
     * 获取员工姓名
     *@param
     *@return java.lang.String
     */
    public String getName() {

        return name;
    }

    /**
     * 修改员工姓名
     *@param name
     *@return void
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * 获取员工账号
     *@param
     *@return java.lang.String
     */
    public String getId() {

        return id;
    }

    /**
     * 修改员工账号
     *@param id
     *@return void
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * 获取员工密码
     *@param
     *@return java.lang.String
     */
    public String getPassword() {

        return password;
    }

    /**
     * 修改员工密码
     *@param password
     *@return void
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * 获取员工等级
     *@param
     *@return java.lang.String
     */
    public String getLevel() {

        return level;
    }

    /**
     * 修改员工等级
     *@param level
     *@return void
     */
    public void setLevel(String level) {

        this.level = level;
    }

    /**
     * 将员工信息以以属性和"_"连接的字符串形式输出
     *@param
     *@return java.lang.String
     */
    public String toString() {

        return name + "_" + id + "_" + password + "_" + level;
    }

    /**
     * 将员工信息以介绍、属性和"_"连接的字符串形式输出
     *@param
     *@return java.lang.String
     */
    public String toStringB() {

        return "姓名:" + this.name + "  账号:" + this.id + "  密码:" + this.password + "  等级:" + this.level;
    }

    /**
     * 将员工信息以介绍、属性和"_"连接的字符串形式输出html格式
     *@param
     *@return java.lang.String
     */
    public String toStringHtml() {

        return "<html>姓名:" + this.name + "<br><br>账号:" + this.id + "<br><br>密码:" + this.password + "<br><br>等级:" + this.level;
    }

    /**
     * 比较Person对象之间是否相同
     *@param person
     *@return boolean
     */
    public boolean equals(Person person) {

        if (person.getName().equals(this.name) && person.getId().equals(this.id) &&
                person.getPassword().equals(this.password) && person.getLevel().equals(this.level))
            return true;
        return false;
    }
}
