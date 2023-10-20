/**
 * 药品列表类，该类包含对药品库中药品的添加、修改、删除等功能
 * @see Drug
 * @see SaleDrug
 */

import java.util.List;

public class DrugList {

    private List<Drug> drugs;

    /**
     * 构造函数，构造一个Drug数列作为属性
     * @param drugs
     */
    public DrugList(List<Drug> drugs){
        this.drugs=drugs;
    }

    /**
     * 获取DrugList的方法
     *@param
     *@return java.util.List<Drug>
     */
    public List<Drug> getDrugs() {

        return drugs;
    }

    /**
     * 添加药品的方法
     *@param drug
     *@return boolean
     */
    public boolean addDrug(Drug drug){

        return drugs.add(drug);
    }

    /**
     * 删除DrugList中某一药品的方法
     *@param drug
     *@return boolean
     */
    public boolean removeDrug(Drug drug){
        return drugs.remove(drug);
    }

    /**
     * 删除DrugList中某一药品的方法
     *@param number
     *@return boolean
     */
    public boolean removeDrug(String number){
        for(Drug index:drugs){
            if(index.getNumber().equals(number))
                return drugs.remove(index);
        }
        return false;
    }
}
