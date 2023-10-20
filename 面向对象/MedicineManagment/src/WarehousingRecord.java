/**
 * 进货记录类，继承自Drug类，多出了进货时间的属性
 *
 * @see Drug
 */

import java.util.Objects;

public class WarehousingRecord extends Drug{

    private String purchaseTime;

    /**
     * 构造函数，根据参数构造类的对象
     * @param saleDrug
     * @param number
     * @param manufacturer
     * @param productionDate
     * @param shelfLife
     * @param purchasePrice
     * @param purchaseTime
     */
    public WarehousingRecord(SaleDrug saleDrug, String number, String manufacturer,
                             String productionDate, int shelfLife, double purchasePrice,String purchaseTime){

        super(saleDrug,number,manufacturer,productionDate,shelfLife,purchasePrice);
        this.purchaseTime=purchaseTime;
    }

    /**
     *获取进货时间
     *@param
     *@return java.lang.String
     */
    public String getPurchaseTime() {

        return purchaseTime;
    }

    /**
     * 修改进货时间
     *@param purchaseTime
     *@return void
     */
    public void setPurchaseTime(String purchaseTime) {

        this.purchaseTime = purchaseTime;
    }

    /**
     * 比较进货的记录是否相同
     *@param
     *@return boolean
     */
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehousingRecord that = (WarehousingRecord) o;
        return Objects.equals(purchaseTime, that.purchaseTime);
    }

}
