/**
 * 销售系统类，在销售界面的类
 * 包含相关的方法
 * @see SaleDrug
 */

import java.util.List;

public class SaleSystem {

    private List<SaleDrug> saleDrugs;

    /**
     * 构造函数，利用参数构造类的对象
     * @param saleDrugList
     */
    public SaleSystem(List<SaleDrug> saleDrugList){
        this.saleDrugs=saleDrugs;
    }

    /**
     * 获取销售的药品信息的数据List数据
     *@param
     *@return java.util.List<SaleDrug>
     */
    public List<SaleDrug> getSaleDrugs() {

        return saleDrugs;
    }

    /**
     * 添加销售药品信息
     *@param saleDrug
     *@return boolean
     */
    public boolean addSaleDrugList(SaleDrug saleDrug){

        return saleDrugs.add(saleDrug);
    }

    /**
     * 删除销售药品信息
     *@param number
     *@return boolean
     */
    public boolean removeSaleDrug(String number){

        for (SaleDrug index : saleDrugs) {
            if(index.getName().equals(number))
                return saleDrugs.remove(index);
        }
        return false;
    }


}
