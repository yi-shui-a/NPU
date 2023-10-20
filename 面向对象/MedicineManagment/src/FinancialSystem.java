/**
 * FinancialSystem类，该类主要管理入库记录表和销售记录表并根据表中内容分析药品销售和进货情况
 *
 * @see WarehousingRecordSheet
 * @see SaleRecordSheet
 *
 */

import java.util.ArrayList;
import java.util.List;

public class FinancialSystem {

    private ArrayList<WarehousingRecordSheet> warehousingRecordSheets;
    private ArrayList<SaleRecordSheet> saleRecordSheets;

    /**
     * 构造函数1，
     * 根据参数中的WarehousingRecordSheet类和SaleRecordSheet类的ArrayList数组构造对象
     * @param warehousingRecordSheets
     * @param saleRecordSheets
     */
    public FinancialSystem(ArrayList<WarehousingRecordSheet> warehousingRecordSheets,
                           ArrayList<SaleRecordSheet> saleRecordSheets) {

        this.warehousingRecordSheets = warehousingRecordSheets;
        this.saleRecordSheets = saleRecordSheets;
    }

    /**
     * 构造函数2，
     * 创建WarehousingRecordSheet类和SaleRecordSheet类的ArrayList数组构造对象
     */
    public FinancialSystem() {

        ArrayList<WarehousingRecordSheet> warehousingRecordSheets = new ArrayList<>();
        ArrayList<SaleRecordSheet> saleRecordSheets = new ArrayList<>();
        this.warehousingRecordSheets = warehousingRecordSheets;
        this.saleRecordSheets = saleRecordSheets;
    }

    /**
     * 获取WarehousingRecordSheet类的List
     *@param
     *@return java.util.List<WarehousingRecordSheet>
     */
    public List<WarehousingRecordSheet> getWarehousingRecordSheets() {

        return warehousingRecordSheets;
    }

    /**
     * 获取SaleRecordSheet类的List
     *@param
     *@return java.util.List<SaleRecordSheet>
     */
    public List<SaleRecordSheet> getSaleRecordSheets() {

        return saleRecordSheets;
    }

    /**
     * 删除SaleRecordSheets中的某一条记录
     *@param number
     *@return boolean
     */
    public boolean removeSaleRecordSheet(String number){

        for(SaleRecordSheet index: this.saleRecordSheets){
            if(index.getNumber().equals(number)){
                return saleRecordSheets.remove(index);
            }
        }
        return false;
    }

    /**
     * 将SaleRecordSheets以html格式的字符串输出
     *@param
     *@return java.lang.String
     */
    public String toStringSaleRecordSheetsHtml() {

        String html = "";
        html=html.concat("<html> <br>");
        for (SaleRecordSheet index : saleRecordSheets)
            html=html.concat(index.toStringHtml());

        html=html.concat("<html>");
        return html;
    }

    /**
     * 删除SaleRecordSheets中的某一条记录
     *@param saleRecordSheet
     *@return boolean
     */
    public boolean removeSaleRecordSheet(SaleRecordSheet saleRecordSheet){

        return saleRecordSheets.remove(saleRecordSheet);
    }
}
