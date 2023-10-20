/**
 * 进货记录单类，包含进货记录以及进货单的编号
 * @see WarehousingRecord
 */

import java.util.List;

public class WarehousingRecordSheet {

    private List<WarehousingRecord> warehousingRecords;
    private String number;//入库表单编号

    /**
     * 构造函数，根据参数构造类的对象
     * @param warehousingRecords
     * @param number
     */
    public WarehousingRecordSheet(List<WarehousingRecord> warehousingRecords,String number){

        this.warehousingRecords=warehousingRecords;
        this.number=number;
    }

    /**
     * 获取记录单号
     *@param
     *@return java.lang.String
     */
    public String getNumber() {

        return number;
    }

    /**
     * 修改记录单号
     *@param number
     *@return void
     */
    public void setNumber(String number) {

        this.number = number;
    }

    /**
     * 获取记录得List数组
     *@param
     *@return java.util.List<WarehousingRecord>
     */
    public List<WarehousingRecord> getWarehousingRecords() {

        return warehousingRecords;
    }

    /**
     * 添加进货记录
     *@param warehousingRecord
     *@return boolean
     */
    public boolean addWarehousingRecord (WarehousingRecord warehousingRecord){

        return warehousingRecords.add(warehousingRecord);
    }

    /**
     *@param number 药品编号在Drug类中
     *@return boolean
     */
    public boolean removeWarehousingRecord(String number){

        for(WarehousingRecord index:warehousingRecords){
            if(index.getNumber().equals(number))
                return warehousingRecords.remove(index);
        }
        return false;
    }

    /**
     * 根据参数中的记录删除记录
     *@param warehousingRecord
     *@return boolean
     */
    public boolean removeWarehousingRecord(WarehousingRecord warehousingRecord){

        return warehousingRecords.remove(warehousingRecord);
    }

}
