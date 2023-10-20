/**
 * 含有员工信息导入函数的接口
 * 建立此接口的原因是可以有多种方法可以完成导入员工信息的任务
 * 如果未来需要添加方式，只需要在该接口的基础上创建类即可
 */

public interface PersonDataLoading {

    /**
     * 员工信息导入函数
     * @return
     */
    public PersonList loadPersonData();
}
