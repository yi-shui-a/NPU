/**
 * 读取Drug文件，加载DrugList中的数据信息
 * @see DrugDataLoading
 * @see Drug
 * @see DrugList
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LoadingDrug implements DrugDataLoading{

    /**
     * 空构造函数
     */
    public LoadingDrug() {
    }

    /**
     * 读取Drug文件，加载DrugList中的数据信息
     *@param
     *@return DrugList
     */
    public DrugList loadDrugData() {

        File file = new File("DrugData/DrugData.txt");
        BufferedReader reader = null;
        List<Drug> drugs = new ArrayList<>();
        DrugList drugList = new DrugList(drugs);
        String strTemp;
        String name ="";
        String sort = "";
        String batchNumber = "";
        String dosage = "";
        int quantity = 0;
        boolean isPrescriptionDrug=false;
        double price = 0;
        String number = "";
        String manufacturer = "";
        String productionData = "";
        int shelfLife = 0;
        double purchasePrice = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((strTemp = reader.readLine()) != null) {
                StringTokenizer str=new StringTokenizer(strTemp,"_");
                name = str.nextToken();
                sort = str.nextToken();
                batchNumber = str.nextToken();
                dosage = str.nextToken();
                quantity = Integer.parseInt(str.nextToken());
                isPrescriptionDrug = Boolean.parseBoolean(str.nextToken());
                price = Double.parseDouble(str.nextToken());
                number = str.nextToken();
                manufacturer = str.nextToken();
                productionData = str.nextToken();
                shelfLife = Integer.parseInt(str.nextToken());
                purchasePrice = Double.parseDouble(str.nextToken());
                //System.out.println(productionData);
                SaleDrug saleDrug = new SaleDrug(name, sort, batchNumber, dosage, quantity, isPrescriptionDrug, price);
                Drug drug = new Drug(saleDrug, number, manufacturer, productionData, shelfLife, purchasePrice);
                drugList.addDrug(drug);
            }
            reader.close();
        } catch (IOException e) {
        }
        return drugList;
    }

}
