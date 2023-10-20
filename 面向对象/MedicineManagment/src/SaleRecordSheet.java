/**
 *SaleRecordSheet销售记录单类，记录每次销售的药品以及一个编号
 * @see SaleRecord
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaleRecordSheet {

    private ArrayList<SaleRecord> saleRecords;
    private String number;

    /**
     * 构造函数，根据参数中的变量构造对象
     * @param saleRecords
     * @param number
     */
    public SaleRecordSheet(ArrayList<SaleRecord> saleRecords, String number) {

        this.saleRecords = saleRecords;
        this.number = number;
    }

    /**
     * 构造函数，在构造函数中new一个ArrayList变量
     * 初始化number为“0000000000”
     */
    public SaleRecordSheet() {

        this.saleRecords=new ArrayList<>();
        this.number="0000000000";
    }

    /**
     * 获取记录单编号
     *@param
     *@return java.lang.String
     */
    public String getNumber() {

        return number;
    }

    /**
     * 修改记录单编号
     *@param number
     *@return void
     */
    public void setNumber(String number) {

        this.number = number;
    }

    /**
     * 获取记录的ArrayList数组
     *@param
     *@return java.util.ArrayList<SaleRecord>
     */
    public ArrayList<SaleRecord> getSaleRecords() {

        return saleRecords;
    }

    /**
     * 为记录单添加记录
     *@param saleRecord
     *@return boolean
     */
    public boolean addSaleRecord(SaleRecord saleRecord) {

        return saleRecords.add(saleRecord);
    }

    /**
     * @param number 药品编号在Drug类中
     * @return boolean
     */
    public boolean removeSaleRecord(String number) {

        for (SaleRecord index : saleRecords) {
            if (index.getNumber().equals(number))
                return saleRecords.remove(index);
        }
        return false;
    }

    /**
     * 根据记录，删除记录单中的记录
     *@param saleRecord
     *@return boolean
     */
    public boolean removeSaleRecord(SaleRecord saleRecord) {

        return saleRecords.remove(saleRecord);
    }

    /**
     * 将记录单信息转换为html格式的字符串返回
     *@param
     *@return java.lang.String
     */
    public String toStringHtml() {

        String html = "";
        html = html.concat("编号：" + number);
        for (SaleRecord index : saleRecords) {
            html = html.concat("<br>" +index.toString());
        }
        html = html.concat("<br><br>");
        return html;
    }
}

