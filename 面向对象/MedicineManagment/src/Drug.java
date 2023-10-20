/**
 * 药品类，主要包含药品的属性以及调用的方法
 * @see SaleDrug
 */

public class Drug {

    private SaleDrug saleDrug;
    private String number;//药品编号
    private String manufacturer;//生产厂家
    private String productionDate;//生产日期
    private int shelfLife;//保质期
    private double purchasePrice;//进货价

    /**
     * 空构造方法
     */
    public Drug() {
    }

    /**
     *构造方法
     * @param saleDrug
     * @param Number
     * @param manufacturer
     * @param productionDate
     * @param shelfLife
     * @param purchasePrice
     */
    public Drug(SaleDrug saleDrug, String Number, String manufacturer,
                String productionDate, int shelfLife, double purchasePrice) {

        this.saleDrug = saleDrug;
        this.number = Number;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
        this.purchasePrice = purchasePrice;
    }

    /**
     * 使用全部底层属性构造
     * @param name
     * @param sort
     * @param batchNumber
     * @param dosage
     * @param quantity
     * @param isPrescriptionDrug
     * @param price
     * @param Number
     * @param manufacturer
     * @param productionDate
     * @param shelfLife
     * @param purchasePrice
     */
    public Drug(String name, String sort, String batchNumber,
                String dosage, int quantity, Boolean isPrescriptionDrug, double price, String Number, String manufacturer,
                String productionDate, int shelfLife, double purchasePrice) {
        this.saleDrug = new SaleDrug(name, sort, batchNumber, dosage, quantity, isPrescriptionDrug, price);
        this.number = Number;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取SaleDrug属性值
     *@param
     *@return SaleDrug
     */
    public SaleDrug getSaleDrug() {

        return saleDrug;
    }

    /**
     * 修改SaleDrug属性值
     *@param saleDrug
     *@return void
     */
    public void setSaleDrug(SaleDrug saleDrug) {

        this.saleDrug = saleDrug;
    }

    /**
     * 获取number属性值
     *@param
     *@return java.lang.String
     */
    public String getNumber() {

        return number;
    }

    /**
     * 修改number属性值
     *@param number
     *@return void
     */
    public void setNumber(String number) {

        this.number = number;
    }

    /**
     * 获取manufacturer属性值
     *@param
     *@return java.lang.String
     */
    public String getManufacturer() {

        return manufacturer;
    }

    /**
     * 修改manufacturer属性值
     *@param manufacturer
     *@return void
     */
    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }

    /**
     * 获取productionDate变量值
     *@param
     *@return java.lang.String
     */
    public String getProductionDate() {

        return productionDate;
    }

    /**
     * 修改productionDate变量值
     *@param productionDate
     *@return void
     */
    public void setProductionDate(String productionDate) {

        this.productionDate = productionDate;
    }


    /**
     * 获取shelfLife变量值
     *@param
     *@return int
     */
    public int getShelfLife() {

        return shelfLife;
    }

    /**
     * 修改shelfLife变量值
     *@param shelfLife
     *@return void
     */
    public void setShelfLife(int shelfLife) {

        this.shelfLife = shelfLife;
    }

    /**
     * 获取purchasePrice变量值
     *@param
     *@return double
     */
    public double getPurchasePrice() {

        return purchasePrice;
    }

    /**
     * 修改purchasePrice变量值
     *@param purchasePrice
     *@return void
     */
    public void setPurchasePrice(double purchasePrice) {

        this.purchasePrice = purchasePrice;
    }

    /**
     * 将Drug对象转换为属性与"_"相连的字符串
     *@param
     *@return java.lang.String
     */
    public String toString() {

        return saleDrug.toString() + "_" + number + "_" + manufacturer + "_" + productionDate + "_" + shelfLife + "_" + purchasePrice;
    }

    /**
     * 比较Drug对象是否相同
     *@param drug
     *@return boolean
     */
    public boolean equals(Drug drug) {

        if (drug.getSaleDrug().equals(this.saleDrug) && drug.getNumber().equals(this.number) &&
                drug.getManufacturer().equals(this.manufacturer) &&
                drug.getProductionDate().equals(this.productionDate) &&
                drug.getShelfLife() == this.shelfLife && drug.getPurchasePrice() == this.purchasePrice)
            return true;
        return false;

    }
}
