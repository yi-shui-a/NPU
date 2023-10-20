/**
 * 进货系统类，管理药品的进货情况
 *
 * @see WarehousingRecordSheet
 */

import java.util.List;

public class PurchaseSystem {

    private List<WarehousingRecordSheet> warehousingRecordSheets;

    /**
     * 构造函数，根据参数中的warehousingRecordSheets构建一个PurchaseSystem对象
     * @param warehousingRecordSheets
     */
    public PurchaseSystem(List<WarehousingRecordSheet> warehousingRecordSheets) {

        this.warehousingRecordSheets = warehousingRecordSheets;
    }

    /**
     * 获取WarehousingRecordSheet的List
     *@param
     *@return java.util.List<WarehousingRecordSheet>
     */
    public List<WarehousingRecordSheet> getWarehousingRecordSheets() {

        return warehousingRecordSheets;
    }
}
