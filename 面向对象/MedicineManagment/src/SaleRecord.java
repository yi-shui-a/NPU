/**
 *每种药品每次销售记录类，在Drug的基础上加了一个销售时间的属性
 *
 * @see Drug
 */

public class SaleRecord extends Drug {

    private String saleTime;

    /**
     * 构造函数，以参数中的变量构造SaleRecord类对象
     * @param saleDrug
     * @param number
     * @param manufacturer
     * @param productionDate
     * @param shelfLife
     * @param purchasePrice
     * @param saleTime
     */
    public SaleRecord(SaleDrug saleDrug, String number, String manufacturer,
                      String productionDate, int shelfLife, double purchasePrice, String saleTime) {

        super(saleDrug, number, manufacturer, productionDate, shelfLife, purchasePrice);
        this.saleTime = saleTime;
    }

    /**
     * 构造函数，在Drug构造函数的基础上构造SaleRecord类对象
     * @param drug
     * @param saleTime
     */
    public SaleRecord(Drug drug, String saleTime) {

        super(drug.getSaleDrug(), drug.getNumber(), drug.getManufacturer(), drug.getProductionDate(),
                drug.getShelfLife(), drug.getPurchasePrice());
        this.saleTime = saleTime;
    }

    /**
     * 构造函数，其中数量变量以购买时的数量为准
     * @param drug
     * @param quantity
     * @param saleTime
     */
    public SaleRecord(Drug drug, int quantity, String saleTime) {

        super(drug.getSaleDrug().getName(), drug.getSaleDrug().getSort(), drug.getSaleDrug().getBatchNumber(),
                drug.getSaleDrug().getDosage(), quantity, drug.getSaleDrug().getPrescriptionDrug(),
                drug.getSaleDrug().getPrice(), drug.getNumber(), drug.getManufacturer(), drug.getProductionDate(),
                drug.getShelfLife(), drug.getPurchasePrice());
        this.saleTime = saleTime;
    }

    /**
     * 获取销售时间
     *@param
     *@return java.lang.String
     */
    public String getSaleTime() {

        return saleTime;
    }

    /**
     * 修改销售时间
     *@param saleTime
     *@return void
     */
    public void setSaleTime(String saleTime) {

        this.saleTime = saleTime;
    }

    /**
     * 将SaleRecord类对象以属性和"_"连接的方式以字符串形式输出
     *@param
     *@return java.lang.String
     */
    public String toString() {

        return saleTime + "_" + getSaleDrug().toString();
    }

    /**
     * 比较SaleRecord累对象之间是否相同
     *@param saleRecord
     *@return boolean
     */
    public boolean equals(SaleRecord saleRecord) {

        if (saleRecord.getSaleDrug().equals(this.getSaleDrug()) && saleRecord.getNumber().equals(this.getNumber()) &&
                saleRecord.getManufacturer().equals(this.getManufacturer()) &&
                saleRecord.getProductionDate().equals(this.getProductionDate()) &&
                saleRecord.getShelfLife() == this.getShelfLife() && saleRecord.getPurchasePrice() == this.getPurchasePrice() &&
                saleRecord.getSaleTime().equals(this.saleTime))
            return true;
        else return false;
    }

}
