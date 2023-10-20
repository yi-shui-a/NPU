/**
 * 销售时所需要的药品信息所组成的类
 * 包含这些信息的获取、修改和删除等方法
 */

public class SaleDrug {
    private String name;
    private String sort;
    private String batchNumber;//批次号
    private String dosage;//剂量或规格
    private int quantity;//数量
    private boolean isPrescriptionDrug;//是否是处方药
    private double price;

    /**
     * 构造函数，由参数中的变量构造一个SaleDrug类的对象
     * @param name
     * @param sort
     * @param batchNumber
     * @param dosage
     * @param quantity
     * @param isPrescriptionDrug
     * @param price
     */
    public SaleDrug(String name, String sort, String batchNumber,
                    String dosage, int quantity, Boolean isPrescriptionDrug, double price) {

        this.name = name;
        this.sort = sort;
        this.batchNumber = batchNumber;
        this.dosage = dosage;
        this.quantity = quantity;
        this.isPrescriptionDrug = isPrescriptionDrug;
        this.price = price;
    }

    /**
     * 获取药品名称
     *@param
     *@return java.lang.String
     */
    public String getName() {

        return name;
    }

    /**
     * 修改药品名称
     *@param name
     *@return void
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * 获取药品类型
     *@param
     *@return java.lang.String
     */
    public String getSort() {

        return sort;
    }

    /**
     * 修改药品类型
     *@param sort
     *@return void
     */
    public void setSort(String sort) {

        this.sort = sort;
    }

    /**
     * 获取药品批号
     *@param
     *@return java.lang.String
     */
    public String getBatchNumber() {

        return batchNumber;
    }

    /**
     * 修改药品批号
     *@param batchNumber
     *@return void
     */
    public void setBatchNumber(String batchNumber) {

        this.batchNumber = batchNumber;
    }

    /**
     * 获取药品规格
     *@param
     *@return java.lang.String
     */
    public String getDosage() {

        return dosage;
    }

    /**
     * 修改药品规格
     *@param dosage
     *@return void
     */
    public void setDosage(String dosage) {

        this.dosage = dosage;
    }

    /**
     * 获取药品数量
     *@param
     *@return int
     */
    public int getQuantity() {

        return quantity;
    }

    /**
     * 修改药品数量
     *@param quantity
     *@return void
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * 获取药品是否为处方药的信息
     *@param
     *@return boolean
     */
    public boolean getPrescriptionDrug() {

        return isPrescriptionDrug;
    }

    /**
     * 修改药品是否是处方药的信息
     * *@param [prescriptionDrug]
     *@return void
     */
    public void setPrescriptionDrug(Boolean prescriptionDrug) {

        isPrescriptionDrug = prescriptionDrug;
    }

    /**
     * 获取药品价格
     *@param
     *@return double
     */
    public double getPrice() {

        return price;
    }

    /**
     * 修改药品价格
     *@param price
     *@return void
     */
    public void setPrice(double price) {

        this.price = price;
    }

    /**
     * 将SaleDrug类的对象以属性和“_"连接的方式返回字符串
     *@param
     *@return java.lang.String
     */
    public String toString() {

        return name + "_" + sort + "_" + batchNumber + "_" + dosage + "_" + quantity + "_" + isPrescriptionDrug + "_" + price;
    }

    /**
     * 将SaleDrug类的对象以介绍、属性和“_"连接的方式返回字符串
     *@param
     *@return java.lang.String
     */
    public String toStringSale() {

        return "名称:" + name + " " + "种类:" + sort + " " + "批次号:" + batchNumber + " " +
                "规格:" + dosage + " " + "数量:" + quantity + " " + "是否处方药:" + isPrescriptionDrug + " " + "价格:" + price;
    }

    /**
     * 比较两个SaleDrug对象是否相同
     *@param saleDrug
     *@return boolean
     */
    public boolean equals(SaleDrug saleDrug) {

        if (saleDrug.getName().equals(this.name) && saleDrug.getSort().equals(this.sort) &&
                saleDrug.getBatchNumber().equals(this.batchNumber) && saleDrug.getDosage().equals(this.dosage) &&
                saleDrug.getQuantity() == this.quantity && saleDrug.getPrescriptionDrug() == this.isPrescriptionDrug &&
                saleDrug.getPrice() == this.price)
            return true;
        return false;
    }
}
