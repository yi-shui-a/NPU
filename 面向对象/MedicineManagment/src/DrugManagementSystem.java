/**
 * 主类，包含药品管理系统界面的展示和运算部分的函数
 * 主要是用JFrame类绘制界面并进行数据展示
 * @author yishui
 * @version 0.1.0
 * @see Drug
 * @see DrugDataLoading
 * @see DrugList
 * @see FinancialSystem
 * @see LoadingPerson
 * @see LoadingDrug
 * @see Person
 * @see PersonDataLoading
 * @see PersonList
 * @see PurchaseSystem
 * @see SaleDrug
 * @see SaleRecordSheet
 * @see SaleRecord
 * @see SaleSystem
 * @see WarehousingRecordSheet
 * @see WarehousingRecord
 *
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DrugManagementSystem extends JFrame {

    private PersonList personList;
    private SaleSystem saleSystem;
    private PurchaseSystem purchaseSystem;
    private FinancialSystem financialSystem;
    private DrugList drugList;
    private String user;

    /**
     * DrugManagementSystem构造函数，
     * 构造各个系统的对象
     * 导入文本数据到缓存中
     * 打开界面并进入
     */
    public DrugManagementSystem() {

        FinancialSystem financialSystem = new FinancialSystem();
        this.financialSystem = financialSystem;
        //此处添加其他几个系统的构造函数


        //new LoadingPerson();
        LoadingPerson loadingPerson = new LoadingPerson();
        this.personList = loadingPerson.loadPersonData();

        LoadingDrug loadingDrug = new LoadingDrug();
        this.drugList = loadingDrug.loadDrugData();
        List<SaleDrug> saleDrugs = new ArrayList<>();
        for (Drug index : this.drugList.getDrugs()) {
            if (index.getSaleDrug() != null)
                saleDrugs.add(index.getSaleDrug());
        }
        this.saleSystem = new SaleSystem(saleDrugs);

        InterfaceLoading();
    }

    /**
     * 主函数，new一个新的DrugManagementSystem对象，即进入运行状态
     * @param args
     */
    public static void main(String[] args) {

        new DrugManagementSystem();

    }

    /**
     * 登录界面的导入，在该界面中可以输入登录信息
     * 点击确认后将会在该函数内与本地数据相比较确认是否登陆成功。
     * 对输入信息的监控主要通过Jbutton监听器完成
     *@param
     *@return void
     */
    public void InterfaceLoading() {

        int FULL_WIDE = 1000;//界面宽度
        int FUll_HEIGHT = 700;//界面高度
        int BOUND_WIDE = 100;//组件宽度
        int BOUND_HEIGHT = 50;//组件高度

        JLabel jLabelAccount;//定义标签组件，登录标签
        JTextField jLabelAccountTxt;//定义输入框；
        JLabel jLabelPassword;
        JTextField jLabelPasswordTxt;
        JComboBox jComboBoxRegister;//弹出选择框组件
        JButton jButtonRegister;//按钮组件

        setTitle("药品管理系统");
        setSize(FULL_WIDE, FUll_HEIGHT);//设置组件的大小。

        setLocation(BOUND_WIDE, BOUND_HEIGHT);//设置组件在容器/界面中的位置，组件距容器/界面的左、上边界 x、y 个像素。
        setResizable(false);//设置窗口是否可调整大小，窗口默认是可调整大小的.此处设为禁止调节大小

        setLayout(null); // 空布局较为灵活
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 默认关闭操作

        //设置登录界面图片
        JLabel jLabelRegisterPhoto1 = new JLabel(new ImageIcon("photo/jLabelRegisterPhoto1.png"));
        jLabelRegisterPhoto1.setBounds(0, 0, 500, 700);
        add(jLabelRegisterPhoto1);

        //设置登录界面标题
        JLabel jLabelRegisterPhoto2 = new JLabel(new ImageIcon("photo/jLabelRegisterPhoto2.png"));
        jLabelRegisterPhoto2.setBounds(550, 100, 400, 250);
        add(jLabelRegisterPhoto2);

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);
        Font font_title = new Font("楷体", Font.PLAIN, 30);

        // 设置账号文本框
        jLabelAccount = new JLabel("账号:");
        jLabelAccount.setFont(font_normal);//设置字体
        jLabelAccount.setBounds(BOUND_WIDE + FULL_WIDE / 2, BOUND_HEIGHT + FUll_HEIGHT / 2,
                50, 40);//设置组件在容器中的位置和组件的大小。
        add(jLabelAccount);//将组件添加到该容器中。

        jLabelAccountTxt = new JTextField();
        jLabelAccountTxt.setFont(font_normal);
        jLabelAccountTxt.setBounds(BOUND_WIDE + FULL_WIDE / 2 + 50, BOUND_HEIGHT + FUll_HEIGHT / 2 + 5,
                200, 30);
        add(jLabelAccountTxt);

        //设置密码文本框
        jLabelPassword = new JLabel("密码:");
        jLabelPassword.setFont(font_normal);
        jLabelPassword.setBounds(BOUND_WIDE + FULL_WIDE / 2, BOUND_HEIGHT + FUll_HEIGHT / 2 + 50,
                50, 40);//设置组件在容器中的位置和组件的大小。
        add(jLabelPassword);//将组件添加到该容器中。

        jLabelPasswordTxt = new JTextField();
        jLabelPasswordTxt.setFont(font_normal);
        jLabelPasswordTxt.setBounds(BOUND_WIDE + FULL_WIDE / 2 + 50, BOUND_HEIGHT + FUll_HEIGHT / 2 + 55,
                200, 30);
        add(jLabelPasswordTxt);

        //用户组选择
        jComboBoxRegister = new JComboBox();
        String[] additem = {"请选择用户类型", "顶层管理员", "管理员", "进货员", "销售员"};
        for (int i = 0; i < additem.length; i++) {
            jComboBoxRegister.addItem(additem[i]);
        }
        jComboBoxRegister.setFont(font_normal);
        jComboBoxRegister.setBounds(BOUND_WIDE + FULL_WIDE / 2 + 20, BOUND_HEIGHT + FUll_HEIGHT / 2 + 100,
                200, 30);
        add(jComboBoxRegister);
        // 组合框添加动作监听器
        //该部分还未完成，需要拓展
        jComboBoxRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item1 = (String) jComboBoxRegister.getSelectedItem();
            }
        });

        //登录按钮
        jButtonRegister = new JButton("登录");
        jButtonRegister.setFont(font_normal);
        jButtonRegister.setBounds(BOUND_WIDE + FULL_WIDE / 2 + 90, BOUND_HEIGHT + FUll_HEIGHT / 2 + 150,
                80, 40);
        add(jButtonRegister);
        setVisible(true);//显示界面
        // 登录按钮添加动作监听器
        jButtonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemBox = (String) jComboBoxRegister.getSelectedItem();
                String itemAccount = jLabelAccountTxt.getText();
                String itemPassword = jLabelPasswordTxt.getText();
                for (Person index : personList.getPersonList()) {
                    if (index.getId().equals(itemAccount) && index.getPassword().equals(itemPassword)) {
                        if (index.getLevel().equals("TopAdministrator") && itemBox.equals("顶层管理员")) {
                            user = index.toString();
                            remove(jButtonRegister);
                            remove(jComboBoxRegister);
                            remove(jLabelAccount);
                            remove(jLabelPassword);
                            remove(jLabelAccountTxt);
                            remove(jLabelPasswordTxt);
                            remove(jLabelRegisterPhoto1);
                            remove(jLabelRegisterPhoto2);
                            interfaceTopAdministrator();
                        }
                        if (index.getLevel().equals("SalePerson") && itemBox.equals("销售员")) {
                            user = index.toString();
                            remove(jButtonRegister);
                            remove(jComboBoxRegister);
                            remove(jLabelAccount);
                            remove(jLabelPassword);
                            remove(jLabelAccountTxt);
                            remove(jLabelPasswordTxt);
                            remove(jLabelRegisterPhoto1);
                            remove(jLabelRegisterPhoto2);
                            interfaceSalePerson();
                        }
                        if (index.getLevel().equals("InputPerson") && itemBox.equals("进货员")) {
                            user = index.toString();
                            remove(jButtonRegister);
                            remove(jComboBoxRegister);
                            remove(jLabelAccount);
                            remove(jLabelPassword);
                            remove(jLabelAccountTxt);
                            remove(jLabelPasswordTxt);
                            remove(jLabelRegisterPhoto1);
                            remove(jLabelRegisterPhoto2);
                            interfaceInputPerson();
                        }
                        if (index.getLevel().equals("Administrator") && itemBox.equals("管理员")) {
                            user = index.toString();
                            remove(jButtonRegister);
                            remove(jComboBoxRegister);
                            remove(jLabelAccount);
                            remove(jLabelPassword);
                            remove(jLabelAccountTxt);
                            remove(jLabelPasswordTxt);
                            remove(jLabelRegisterPhoto1);
                            remove(jLabelRegisterPhoto2);
                            interfaceAdministrator();
                        }
                    }
                }
            }
        });
    }

    /**
     * 该函数为顶层管理员界面绘制以及界面中各个选项的监听
     * 在该界面选择具体功能后将进入具体的功能函数
     *@param
     *@return void
     */
    public void interfaceTopAdministrator() {

        setTitle("药品管理系统--顶层管理员");

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);

        //设置上部对话框
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        JMenu[] jMenu = {new JMenu("入库管理"), new JMenu("销售管理"), new JMenu("药品分析"),
                new JMenu("员工信息管理"), new JMenu("个人账号设置")};
        for (int j = 0; j < jMenu.length; j++) {
            jMenu[j].setFont(font_normal);
            jmb.add(jMenu[j]);
        }

        JMenuItem[] jMenuitem1 = {new JMenuItem("增加药品"), new JMenuItem("删除药品"),
                new JMenuItem("修改药品"), new JMenuItem("查找药品")};
        JMenuItem[] jMenuitem2 = {new JMenuItem("增加销售记录"), new JMenuItem("删除销售记录"),
                new JMenuItem("查找销售记录")};
        JMenuItem[] jMenuitem3 = {new JMenuItem("销售情况分析"), new JMenuItem("入库情况分析"),
                new JMenuItem("药品总体分析"), new JMenuItem("员工情况分析")};
        JMenuItem[] jMenuitem4 = {new JMenuItem("增加员工信息"), new JMenuItem("删除员工信息"),
                new JMenuItem("修改员工信息"), new JMenuItem("查找员工信息")};
        JMenuItem[] jMenuitem5 = {new JMenuItem("修改密码")};

        //添加入库系统的相关信息以及功能
        for (int i = 0; i < jMenuitem1.length; i++) {
            jMenuitem1[i].setFont(font_normal);
            jMenu[0].add(jMenuitem1[i]);
        }
        for (int i = 0; i < jMenuitem2.length; i++) {
            jMenuitem2[i].setFont(font_normal);
            jMenu[1].add(jMenuitem2[i]);
        }
        for (int i = 0; i < jMenuitem3.length; i++) {
            jMenuitem3[i].setFont(font_normal);
            jMenu[2].add(jMenuitem3[i]);
        }
        for (int i = 0; i < jMenuitem4.length; i++) {
            jMenuitem4[i].setFont(font_normal);
            jMenu[3].add(jMenuitem4[i]);
        }
        for (int i = 0; i < jMenuitem5.length; i++) {
            jMenuitem5[i].setFont(font_normal);
            jMenu[4].add(jMenuitem5[i]);
        }

        //为每个选项添加功能
        //入库管理类
        jMenuitem1[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });
        jMenuitem1[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeDrug();
            }
        });
        jMenuitem1[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetDrug();
            }
        });
        jMenuitem1[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findDrug();
            }
        });

        //销售管理类
        jMenuitem2[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSaleRecord();
            }
        });
        jMenuitem2[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSaleRecord();
            }
        });
        jMenuitem2[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findSaleRecord();
            }
        });

        //员工信息类
        jMenuitem4[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });

        jMenuitem4[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removePerson();
            }
        });

        jMenuitem4[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPerson();
            }
        });

        jMenuitem4[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findPerson();
            }
        });

        //修改密码
        jMenuitem5[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPassword();
            }
        });
        setVisible(true);//显示界面
    }

    /**
     * 该函数为销售员界面绘制以及界面中各个选项的监听
     * 在该界面选择具体功能后将进入具体的功能函数
     *@param
     *@return void
     */
    public void interfaceSalePerson() {

        setTitle("药品管理系统--销售员");
        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);

        //设置上部对话框
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        JMenu[] jMenu = {new JMenu("销售管理"), new JMenu("个人账号设置")};
        for (int j = 0; j < jMenu.length; j++) {
            jMenu[j].setFont(font_normal);
            jmb.add(jMenu[j]);
        }

        JMenuItem[] jMenuitem2 = {new JMenuItem("增加销售记录"), new JMenuItem("删除销售记录"),
                new JMenuItem("查找销售记录")};

        JMenuItem[] jMenuitem5 = {new JMenuItem("修改密码")};

        for (int i = 0; i < jMenuitem2.length; i++) {
            jMenuitem2[i].setFont(font_normal);
            jMenu[0].add(jMenuitem2[i]);
        }

        for (int i = 0; i < jMenuitem5.length; i++) {
            jMenuitem5[i].setFont(font_normal);
            jMenu[1].add(jMenuitem5[i]);
        }

        //销售管理类
        jMenuitem2[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSaleRecord();
            }
        });
        jMenuitem2[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSaleRecord();
            }
        });
        jMenuitem2[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findSaleRecord();
            }
        });

        //修改密码
        jMenuitem5[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPassword();
            }
        });


        setVisible(true);//显示界面
    }

    /**
     * 该函数为管理员界面绘制以及界面中各个选项的监听
     * 在该界面选择具体功能后将进入具体的功能函数
     *@param
     *@return void
     */
    public void interfaceAdministrator() {

        setTitle("药品管理系统--管理员");

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);

        //设置上部对话框
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        JMenu[] jMenu = {new JMenu("入库管理"), new JMenu("销售管理"), new JMenu("药品分析"),
                new JMenu("个人账号设置")};
        for (int j = 0; j < jMenu.length; j++) {
            jMenu[j].setFont(font_normal);
            jmb.add(jMenu[j]);
        }

        JMenuItem[] jMenuitem1 = {new JMenuItem("增加药品"), new JMenuItem("删除药品"),
                new JMenuItem("修改药品"), new JMenuItem("查找药品")};
        JMenuItem[] jMenuitem2 = {new JMenuItem("增加销售记录"), new JMenuItem("删除销售记录"),
                new JMenuItem("查找销售记录")};
        JMenuItem[] jMenuitem3 = {new JMenuItem("销售情况分析"), new JMenuItem("入库情况分析"),
                new JMenuItem("药品总体分析"), new JMenuItem("员工情况分析")};
        JMenuItem[] jMenuitem5 = {new JMenuItem("修改密码")};

        //添加入库系统的相关信息以及功能
        for (int i = 0; i < jMenuitem1.length; i++) {
            jMenuitem1[i].setFont(font_normal);
            jMenu[0].add(jMenuitem1[i]);
        }
        for (int i = 0; i < jMenuitem2.length; i++) {
            jMenuitem2[i].setFont(font_normal);
            jMenu[1].add(jMenuitem2[i]);
        }
        for (int i = 0; i < jMenuitem3.length; i++) {
            jMenuitem3[i].setFont(font_normal);
            jMenu[2].add(jMenuitem3[i]);
        }
        for (int i = 0; i < jMenuitem5.length; i++) {
            jMenuitem5[i].setFont(font_normal);
            jMenu[3].add(jMenuitem5[i]);
        }

        //为每个选项添加功能
        //入库管理类
        jMenuitem1[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });
        jMenuitem1[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeDrug();
            }
        });
        jMenuitem1[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetDrug();
            }
        });
        jMenuitem1[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findDrug();
            }
        });

        //销售管理类
        jMenuitem2[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSaleRecord();
            }
        });
        jMenuitem2[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSaleRecord();
            }
        });
        jMenuitem2[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findSaleRecord();
            }
        });

        //修改密码
        jMenuitem5[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPassword();
            }
        });

        setVisible(true);//显示界面
    }

    /**
     * 该函数为进货员界面绘制以及界面中各个选项的监听
     * 在该界面选择具体功能后将进入具体的功能函数
     *@param
     *@return void
     */
    public void interfaceInputPerson() {

        setTitle("药品管理系统--进货员");

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);

        //设置上部对话框
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        JMenu[] jMenu = {new JMenu("入库管理"), new JMenu("个人账号设置")};
        for (int j = 0; j < jMenu.length; j++) {
            jMenu[j].setFont(font_normal);
            jmb.add(jMenu[j]);
        }

        JMenuItem[] jMenuitem1 = {new JMenuItem("增加药品"), new JMenuItem("删除药品"),
                new JMenuItem("修改药品"), new JMenuItem("查找药品")};
        JMenuItem[] jMenuitem5 = {new JMenuItem("修改密码")};

        //添加入库系统的相关信息以及功能
        for (int i = 0; i < jMenuitem1.length; i++) {
            jMenuitem1[i].setFont(font_normal);
            jMenu[0].add(jMenuitem1[i]);
        }
        for (int i = 0; i < jMenuitem5.length; i++) {
            jMenuitem5[i].setFont(font_normal);
            jMenu[1].add(jMenuitem5[i]);
        }

        //为每个选项添加功能
        //入库管理类
        jMenuitem1[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });
        jMenuitem1[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeDrug();
            }
        });
        jMenuitem1[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetDrug();
            }
        });
        jMenuitem1[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findDrug();
            }
        });

        //修改密码
        jMenuitem5[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPassword();
            }
        });

        setVisible(true);//显示界面
    }

    /**
     * 药品添加界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在DrugList中对数据进行更改
     *@param
     *@return void
     */
    public void addDrug() {

        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JTextField jTextField1;
        JTextField jTextField2;
        JButton jButton1;
        JButton jButton2;
        JLabel jLabelErr;
        JLabel jLabelRight;

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_2 = new Font("宋体", Font.PLAIN, 20);

        // 设置输入提示框
        jLabel1 = new JLabel("请按示例格式输入药品信息：");
        jLabel1.setFont(font_1);
        jLabel1.setBounds(200, 50, 400, 40);
        add(jLabel1);

        // 设置示例提示框
        jLabel2 = new JLabel("<html>第一行：name_sort_batchNumber_dosage_quantity_isPrescriptionDrug_price" +
                "<br>名称_种类_批次号_规格_数量_是否处方药_价格<html>");
        jLabel2.setFont(font_2);
        jLabel2.setBounds(100, 100, 900, 60);
        add(jLabel2);

        jLabel3 = new JLabel("<html>第二行：number_manufacturer_productionData_shelfLife_purchasePrice" +
                "<br>编号_生产厂家_生产日期_保质期_进价<html>");
        jLabel3.setFont(font_2);
        jLabel3.setBounds(100, 170, 900, 60);
        add(jLabel3);

        jLabel4 = new JLabel("阿莫西林胶囊_口服药_H31020363_盒_156_false_10.6_T001_上海信谊万象药业_2021-11-4_36_8.7");
        jLabel4.setFont(font_2);
        jLabel4.setBounds(40, 240, 900, 40);
        add(jLabel4);

        //设置输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_2);
        jTextField1.setBounds(100, 300, 800, 40);
        add(jTextField1);

        jTextField2 = new JTextField();
        jTextField2.setFont(font_2);
        jTextField2.setBounds(100, 360, 800, 40);
        add(jTextField2);

        //设置按钮
        jButton1 = new JButton("确定");
        jButton1.setFont(font_1);
        jButton1.setBounds(200, 420, 100, 50);
        add(jButton1);

        jButton2 = new JButton("取消");
        jButton2.setFont(font_1);
        jButton2.setBounds(500, 420, 100, 50);
        add(jButton2);

        //设置异常提示栏
        jLabelErr = new JLabel("输入出现问题，请检查输入");
        jLabelErr.setFont(font_1);
        jLabelErr.setBounds(200, 500, 600, 40);

        //设置成功提示栏
        jLabelRight = new JLabel("录入成功后将自动返回主界面");
        jLabelRight.setFont(font_2);
        jLabelRight.setBounds(700, 550, 300, 40);
        add(jLabelRight);

        //设置监控栏
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButton2);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jTextField1);
                remove(jTextField2);
                remove(jLabelErr);
                remove(jLabelRight);
                repaint();
            }
        });
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer text1 = new StringTokenizer(jTextField1.getText(), "_");
                StringTokenizer text2 = new StringTokenizer(jTextField2.getText(), "_");
                try {
                    SaleDrug saleDrug = new SaleDrug(text1.nextToken(), text1.nextToken(), text1.nextToken(),
                            text1.nextToken(), Integer.parseInt(text1.nextToken()), Boolean.parseBoolean(text1.nextToken()),
                            Double.parseDouble(text1.nextToken()));
                    Drug drug = new Drug(saleDrug, text2.nextToken(), text2.nextToken(), text2.nextToken(),
                            Integer.parseInt(text2.nextToken()), Double.parseDouble(text2.nextToken()));
                    drugList.addDrug(drug);
                    //文件读写
                    File file = new File("DrugData/DrugData.txt");

                    if (!file.exists()) {
                        try {
                            // 如果文件找不到，就new一个
                            file.createNewFile();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String str = "";
                        String line;
                        while ((line = br.readLine()) != null) {
                            str = str.concat(line + "\n");
                        }
                        str = str.concat(drug.toString());
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        bw.write(str);
                        br.close();
                        bw.flush();
                        bw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    remove(jLabelErr);
                    remove(jButton1);
                    remove(jButton2);
                    remove(jLabel1);
                    remove(jLabel2);
                    remove(jLabel3);
                    remove(jLabel4);
                    remove(jTextField1);
                    remove(jTextField2);
                    remove(jLabelRight);
                    repaint();
                } catch (Exception e1) {
                    add(jLabelErr);
                    repaint();
                }
            }
        });
        repaint();
        setVisible(true);//显示界面

    }

    /**
     * 药品删除界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在DrugList中对数据进行更改
     *@param
     *@return void
     */
    public void removeDrug() {
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JLabel jLabel5;
        JTextField jTextField1;
        JTextField jTextField2;
        JButton jButton1;
        JButton jButton2;
        JButton jButtonReturn;
        final String[] item = {""};
        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_2 = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入药品名称或药品编号：");
        jLabel1.setFont(font_2);
        jLabel1.setBounds(100, 50, 300, 40);
        add(jLabel1);

        jLabel5 = new JLabel("删除成功后将自动返回主界面");
        jLabel5.setFont(font_2);
        jLabel5.setBounds(700, 580, 300, 40);
        add(jLabel5);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_2);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //结果提示栏
        jLabel2 = new JLabel("查询结果\n");
        jLabel2.setFont(font_2);
        jLabel2.setBounds(20, 150, 970, 40);
        add(jLabel2);

        jLabel4 = new JLabel("查询结果\n");
        jLabel4.setFont(font_2);
        jLabel4.setBounds(20, 185, 970, 150);

        //输入确认栏
        jLabel3 = new JLabel("请确认需要删除的药品编号：");
        jLabel3.setFont(font_2);
        jLabel3.setBounds(100, 350, 300, 40);

        jTextField2 = new JTextField();
        jTextField2.setFont(font_2);
        jTextField2.setBounds(400, 350, 200, 40);

        jButton2 = new JButton("确认");
        jButton2.setFont(font_1);
        jButton2.setBounds(400, 450, 200, 40);

        //查询监听
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Drug index : drugList.getDrugs()) {
                    if (index.getSaleDrug().getName().equals(jTextField1.getText()) ||
                            index.getNumber().equals(jTextField1.getText())) {
                        item[0] = item[0].concat(index.toString() + "\n");
                        jLabel4.setText(item[0]);
                        add(jLabel4);
                        add(jLabel3);
                        add(jTextField2);
                        add(jButton2);
                        repaint();
                    }
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Drug index : drugList.getDrugs()) {
                    if (jTextField2.getText().equals(index.getNumber())) {
                        drugList.removeDrug(jTextField2.getText());

                        //文件读写
                        File file = new File("DrugData/DrugData.txt");

                        if (!file.exists()) {
                            try {
                                // 如果文件找不到，就new一个
                                file.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            String str = "";
                            String line;
                            while ((line = br.readLine()) != null) {
                                if (!line.equals(index.toString()))
                                    str = str.concat(line + "\n");
                            }
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                            bw.write(str);
                            br.close();
                            bw.flush();
                            bw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        remove(jButton1);
                        remove(jButton2);
                        remove(jButtonReturn);
                        remove(jLabel1);
                        remove(jLabel2);
                        remove(jLabel3);
                        remove(jLabel4);
                        remove(jLabel5);
                        remove(jTextField1);
                        remove(jTextField2);
                        repaint();
                    }
                }
            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButton2);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jTextField1);
                remove(jTextField2);
                repaint();
            }
        });


        repaint();
        setVisible(true);
    }

    /**
     * 药品信息修改界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在DrugList中对数据进行更改
     *@param
     *@return void
     */
    public void resetDrug() {

        final Drug[] finalDrug = {new Drug()};

        JLabel jLabel0;
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JLabel jLabel5;
        JLabel jLabel6;
        JLabel jLabel7;
        JLabel jLabel8;
        JLabel jLabel9;
        JLabel jLabel10;
        JLabel jLabel11;
        JLabel jLabel12;
        JLabel jLabelInfo1;
        JLabel jLabelInfo2;
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JTextField jTextField3 = new JTextField();
        JTextField jTextField4 = new JTextField();
        JTextField jTextField5 = new JTextField();
        JTextField jTextField6 = new JTextField();
        JTextField jTextField7 = new JTextField();
        JTextField jTextField8 = new JTextField();
        JTextField jTextField9 = new JTextField();
        JTextField jTextField10 = new JTextField();
        JTextField jTextField11 = new JTextField();
        JTextField jTextField12 = new JTextField();
        JButton jButton0 = new JButton("查询");
        JButton jButton1 = new JButton("确认");
        JButton jButton2 = new JButton("取消");

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);
        Font font_1 = new Font("宋体", Font.PLAIN, 26);

        jButton0.setFont(font_1);
        jButton1.setFont(font_1);
        jButton2.setFont(font_1);

        jButton0.setBounds(440, 50, 150, 50);
        add(jButton0);

        jButton1.setBounds(80, 450, 150, 100);
        jButton2.setBounds(320, 450, 150, 100);
        add(jButton1);
        add(jButton2);

        jLabel0 = new JLabel("请在名称栏中输入药品名称进行查询");
        jLabel0.setFont(font_1);
        jLabel0.setBounds(50, 20, 500, 45);
        add(jLabel0);

        jLabel1 = new JLabel("名称：");
        jLabel2 = new JLabel("种类：");
        jLabel3 = new JLabel("批次号：");
        jLabel4 = new JLabel("规格：");
        jLabel5 = new JLabel("数量：");
        jLabel6 = new JLabel("是否处方药：");
        jLabel7 = new JLabel("价格：");
        jLabel8 = new JLabel("编号：");
        jLabel9 = new JLabel("生产厂家：");
        jLabel10 = new JLabel("生产日期：");
        jLabel11 = new JLabel("保质期：");
        jLabel12 = new JLabel("进价：");

        jLabel1.setFont(font_normal);
        jLabel2.setFont(font_normal);
        jLabel3.setFont(font_normal);
        jLabel4.setFont(font_normal);
        jLabel5.setFont(font_normal);
        jLabel6.setFont(font_normal);
        jLabel7.setFont(font_normal);
        jLabel8.setFont(font_normal);
        jLabel9.setFont(font_normal);
        jLabel10.setFont(font_normal);
        jLabel11.setFont(font_normal);
        jLabel12.setFont(font_normal);

        jLabel1.setBounds(50, 60, 150, 30);
        jLabel2.setBounds(50, 90, 150, 30);
        jLabel3.setBounds(50, 120, 100, 30);
        jLabel4.setBounds(50, 150, 150, 30);
        jLabel5.setBounds(50, 180, 150, 30);
        jLabel6.setBounds(50, 210, 150, 30);
        jLabel7.setBounds(50, 240, 150, 30);
        jLabel8.setBounds(50, 270, 100, 30);
        jLabel9.setBounds(50, 300, 100, 30);
        jLabel10.setBounds(50, 330, 100, 30);
        jLabel11.setBounds(50, 360, 100, 30);
        jLabel12.setBounds(50, 390, 100, 30);

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        add(jLabel5);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(jLabel9);
        add(jLabel10);
        add(jLabel11);
        add(jLabel12);

        jTextField1.setFont(font_normal);
        jTextField2.setFont(font_normal);
        jTextField3.setFont(font_normal);
        jTextField4.setFont(font_normal);
        jTextField5.setFont(font_normal);
        jTextField6.setFont(font_normal);
        jTextField7.setFont(font_normal);
        jTextField8.setFont(font_normal);
        jTextField9.setFont(font_normal);
        jTextField10.setFont(font_normal);
        jTextField11.setFont(font_normal);
        jTextField12.setFont(font_normal);

        jTextField1.setBounds(180, 60, 250, 30);
        jTextField2.setBounds(180, 90, 250, 30);
        jTextField3.setBounds(180, 120, 250, 30);
        jTextField4.setBounds(180, 150, 250, 30);
        jTextField5.setBounds(180, 180, 250, 30);
        jTextField6.setBounds(180, 210, 250, 30);
        jTextField7.setBounds(180, 240, 250, 30);
        jTextField8.setBounds(180, 270, 250, 30);
        jTextField9.setBounds(180, 300, 250, 30);
        jTextField10.setBounds(180, 330, 250, 30);
        jTextField11.setBounds(180, 360, 250, 30);
        jTextField12.setBounds(180, 390, 250, 30);

        add(jTextField1);
        add(jTextField2);
        add(jTextField3);
        add(jTextField4);
        add(jTextField5);
        add(jTextField6);
        add(jTextField7);
        add(jTextField8);
        add(jTextField9);
        add(jTextField10);
        add(jTextField11);
        add(jTextField12);

        jLabelInfo1 = new JLabel("若输入错误，结果将不会保存；");
        jLabelInfo1.setFont(font_1);
        jLabelInfo1.setBounds(500, 480, 500, 45);
        add(jLabelInfo1);

        jLabelInfo2 = new JLabel("如果修改成功，系统自动返回主界面。");
        jLabelInfo2.setFont(font_1);
        jLabelInfo2.setBounds(500, 520, 500, 45);
        add(jLabelInfo2);

        jButton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Drug index : drugList.getDrugs()) {
                    if (index.getSaleDrug().getName().equals(jTextField1.getText())) {
                        jTextField2.setText(index.getSaleDrug().getSort());
                        jTextField3.setText(index.getSaleDrug().getBatchNumber());
                        jTextField4.setText(index.getSaleDrug().getDosage());
                        jTextField5.setText(String.valueOf(index.getSaleDrug().getQuantity()));
                        jTextField6.setText(String.valueOf(index.getSaleDrug().getPrescriptionDrug()));
                        jTextField7.setText(String.valueOf(index.getSaleDrug().getPrice()));
                        jTextField8.setText(index.getNumber());
                        jTextField9.setText(index.getManufacturer());
                        jTextField10.setText(index.getProductionDate());
                        jTextField11.setText(String.valueOf(index.getShelfLife()));
                        jTextField12.setText(String.valueOf(index.getPurchasePrice()));
                        finalDrug[0] = index;
                        repaint();
                    }
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Drug index : drugList.getDrugs()) {
                    if (index.getNumber() == finalDrug[0].getNumber()) {
                        index.getSaleDrug().setName(jTextField1.getText());
                        index.getSaleDrug().setSort(jTextField2.getText());
                        index.getSaleDrug().setBatchNumber(jTextField3.getText());
                        index.getSaleDrug().setDosage(jTextField4.getText());
                        index.getSaleDrug().setQuantity(Integer.parseInt(jTextField5.getText()));
                        index.getSaleDrug().setPrescriptionDrug(Boolean.parseBoolean(jTextField6.getText()));
                        index.getSaleDrug().setPrice(Double.parseDouble(jTextField7.getText()));
                        index.setNumber(jTextField8.getText());
                        index.setManufacturer(jTextField9.getText());
                        index.setProductionDate(jTextField10.getText());
                        index.setShelfLife(Integer.parseInt(jTextField11.getText()));
                        index.setPurchasePrice(Double.parseDouble(jTextField12.getText()));
                        //文件读写
                        File file = new File("DrugData/DrugData.txt");

                        if (!file.exists()) {
                            try {
                                // 如果文件找不到，就new一个
                                file.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                            bw.write(personList.toString());
                            bw.flush();
                            bw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

                remove(jButton0);
                remove(jButton1);
                remove(jButton2);
                remove(jLabelInfo1);
                remove(jLabelInfo2);
                remove(jLabel0);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jLabel6);
                remove(jLabel7);
                remove(jLabel8);
                remove(jLabel9);
                remove(jLabel10);
                remove(jLabel11);
                remove(jLabel12);
                remove(jTextField1);
                remove(jTextField2);
                remove(jTextField3);
                remove(jTextField4);
                remove(jTextField5);
                remove(jTextField6);
                remove(jTextField7);
                remove(jTextField8);
                remove(jTextField9);
                remove(jTextField10);
                remove(jTextField11);
                remove(jTextField12);
                repaint();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton0);
                remove(jButton1);
                remove(jButton2);
                remove(jLabelInfo1);
                remove(jLabelInfo2);
                remove(jLabel0);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jLabel6);
                remove(jLabel7);
                remove(jLabel8);
                remove(jLabel9);
                remove(jLabel10);
                remove(jLabel11);
                remove(jLabel12);
                remove(jTextField1);
                remove(jTextField2);
                remove(jTextField3);
                remove(jTextField4);
                remove(jTextField5);
                remove(jTextField6);
                remove(jTextField7);
                remove(jTextField8);
                remove(jTextField9);
                remove(jTextField10);
                remove(jTextField11);
                remove(jTextField12);
                repaint();
            }
        });
        repaint();
    }

    /**
     * 药品查找界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在DrugList中对数据进行更改
     *@param
     *@return void
     */
    public void findDrug() {
        final String[] item = {""};

        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel4;
        JLabel jLabel5;
        JLabel jLabelErr;
        JTextField jTextField1;
        JButton jButton1;
        JButton jButton2;

        // 设置字体
        Font font_normal = new Font("宋体", Font.PLAIN, 18);
        Font font_1 = new Font("宋体", Font.PLAIN, 26);

        //提示栏
        jLabel1 = new JLabel("请输入药品名称或药品编号：");
        jLabel1.setFont(font_1);
        jLabel1.setBounds(100, 50, 400, 40);
        add(jLabel1);

        jLabel5 = new JLabel("删除成功后将自动返回主界面");
        jLabel5.setFont(font_normal);
        jLabel5.setBounds(700, 580, 300, 40);
        add(jLabel5);

        //设置异常提示栏
        jLabelErr = new JLabel("输入出现问题，请检查输入");
        jLabelErr.setFont(font_normal);
        jLabelErr.setBounds(200, 500, 600, 40);

        //结果提示栏
        jLabel2 = new JLabel("查询结果\n");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(20, 150, 970, 40);
        add(jLabel2);

        jLabel4 = new JLabel("查询结果\n");
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(20, 185, 970, 150);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        jButton2 = new JButton("取消");
        jButton2.setFont(font_1);
        jButton2.setBounds(730, 40, 200, 150);
        add(jButton2);

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    for (Drug index : drugList.getDrugs()) {
                        if (index.getSaleDrug().getName().equals(jTextField1.getText()) ||
                                index.getNumber().equals(jTextField1.getText())) {
                            item[0] = item[0].concat(index.toString() + "\n");
                            jLabel4.setText(item[0]);
                            add(jLabel4);
                            repaint();
                        }
                    }
                } catch (Exception e2) {
                    add(jLabelErr);
                    repaint();
                }

            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButton2);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel4);
                remove(jLabel5);
                remove(jTextField1);
                remove(jLabelErr);
                repaint();
            }
        });
        repaint();
    }

    /**
     * 销售记录添加界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在SaleRecordSheet和SaleRecord中对数据进行更改
     *@param
     *@return void
     */
    public void addSaleRecord() {

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        String formatDate = dateFormat.format(date);

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        final SaleDrug[] target = new SaleDrug[1];
        final Drug[] targetDrug = new Drug[1];
        final int number[] = new int[10];
        //item[0]即药品SaleDrug的字符串，item[1]即记录单编号
        final String[] item = {"", ""};
        //information
        SaleRecordSheet saleRecordSheet = new SaleRecordSheet();

        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JTextField jTextField1;
        JButton jButtonReturn;
        JButton jButton1;

        //提示栏
        jLabel1 = new JLabel("请输入药品名称：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 300, 40);
        add(jLabel1);

        jLabel2 = new JLabel("添加成功后将重新刷新界面");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(635, 560, 300, 40);
        add(jLabel2);

        jLabel3 = new JLabel("点击取消返回主界面并自动保存记录");
        jLabel3.setFont(font_normal);
        jLabel3.setBounds(635, 580, 500, 40);
        add(jLabel3);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //第二部分显示
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel("请输入销售的数量：");
        JTextField jTextField2 = new JTextField();
        JButton jButton2 = new JButton("确定");

        //显示药品信息
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(5, 150, 1000, 40);

        jLabel5.setFont(font_normal);
        jLabel5.setBounds(50, 240, 200, 40);

        jTextField2.setFont(font_normal);
        jTextField2.setBounds(230, 240, 150, 40);

        jButton2.setFont(font_1);
        jButton2.setBounds(410, 225, 150, 80);

        //销售成功提示
        JLabel jLabel6 = new JLabel("销售成功");
        jLabel6.setFont(font_1);
        jLabel6.setBounds(350, 370, 200, 50);

        //数量不足提示
        JLabel jLabel7 = new JLabel("药品数量不足");
        jLabel7.setFont(font_1);
        jLabel7.setBounds(330, 370, 300, 50);

        //数据类型错误反馈
        JLabel jLabel8 = new JLabel();
        jLabel7.setFont(font_1);
        jLabel7.setBounds(330, 400, 300, 50);
        add(jLabel8);


//查询监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField1.getText().equals("")) {
                    remove(jLabel4);
                    remove(jLabel6);
                    remove(jLabel7);
                    remove(jLabel5);
                    remove(jTextField2);
                    remove(jButton2);
                    repaint();
                    return;
                }
                for (Drug index : drugList.getDrugs()) {
                    if (index.getSaleDrug().getName().equals(jTextField1.getText())) {
                        target[0] = index.getSaleDrug();
                        item[0] = index.getSaleDrug().toStringSale();
                        jLabel4.setText(item[0]);
                        remove(jLabel6);
                        remove(jLabel7);
                        add(jLabel4);
                        add(jLabel5);
                        add(jTextField2);
                        add(jButton2);
                        repaint();
                    }
                }
            }
        });

        //确认监听
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField2.getText().equals(""))
                    jTextField2.setText("0");
                try {
                    if (target[0].getQuantity() >= Integer.parseInt(jTextField2.getText()) &&
                            Integer.parseInt(jTextField2.getText()) != 0) {
                        //此处因创建一个sheet存储信息
                        target[0].setQuantity(target[0].getQuantity() - Integer.parseInt(jTextField2.getText()));
                        for (Drug index : drugList.getDrugs()) {
                            if (index.getSaleDrug().getName().equals(target[0].getName())) {
                                SaleRecord saleRecord = new SaleRecord(index,
                                        Integer.parseInt(jTextField2.getText()), formatDate);
                                saleRecordSheet.addSaleRecord(saleRecord);
                            }
                        }

                        jTextField2.setText("");
                        add(jLabel6);
                        remove(jLabel4);
                        remove(jLabel5);
                        remove(jLabel7);
                        remove(jLabel8);
                        remove(jTextField2);
                        remove(jButton2);
                        repaint();
                        if (jTextField2.getText().equals(""))
                            jTextField2.setText("0");
                        if (target[0].getQuantity() < Integer.parseInt(jTextField2.getText())) {
                            add(jLabel7);
                            repaint();
                        }
                    }
                } catch (NumberFormatException e1) {
                    jLabel8.setText("请输入正确的数字");
                }
                repaint();
            }
        });

        //取消按钮监听
        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(saleRecordSheet.getSaleRecords().isEmpty())) {
                    for (int i = 0; i < number.length; i++)
                        number[i] = (int) (Math.random() * 10);
                    for (int i = 0; i < number.length; i++)
                        item[1] = item[1].concat(String.valueOf(number[i]));
                    saleRecordSheet.setNumber(item[1]);
                }
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jLabel6);
                remove(jLabel7);
                remove(jLabel8);
                remove(jTextField1);
                remove(jTextField2);
                remove(jButton1);
                remove(jButton2);
                remove(jButtonReturn);
                repaint();
                if (!(saleRecordSheet.getNumber().equals("0000000000"))) {
                    financialSystem.getSaleRecordSheets().add(saleRecordSheet);
                }
            }
        });

        repaint();
    }

    /**
     * 销售记录删除界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在SaleRecordSheet和SaleRecord中对数据进行更改
     *@param
     *@return void
     */
    public void removeSaleRecord() {

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JTextField jTextField1;
        JButton jButton1;
        JButton jButtonReturn;

        //提示栏
        jLabel1 = new JLabel("请输入需要删除的记录单号：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 400, 40);
        add(jLabel1);

        jLabel2 = new JLabel("删除成功后将返回主界面");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(650, 580, 300, 40);
        add(jLabel2);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("确认");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //显示栏
        jLabel3 = new JLabel(financialSystem.toStringSaleRecordSheetsHtml());
        jLabel3.setBounds(50, 130, 900, 600);
        jLabel3.setFont(font_normal);
        add(jLabel3);

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jTextField1);
                repaint();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (SaleRecordSheet index : financialSystem.getSaleRecordSheets()) {
                    if (index.getNumber().equals(jTextField1.getText())) {
                        financialSystem.removeSaleRecordSheet(jTextField1.getText());
                        remove(jButton1);
                        remove(jButtonReturn);
                        remove(jLabel1);
                        remove(jLabel2);
                        remove(jLabel3);
                        remove(jTextField1);
                        repaint();
                        return;
                    }
                }
            }
        });
        repaint();
    }

    /**
     * 销售记录查找界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在SaleRecordSheet和SaleRecord中对数据进行更改
     *@param
     *@return void
     */
    public void findSaleRecord() {
        JLabel jLabel3;
        JButton jButtonReturn;

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        jLabel3 = new JLabel(financialSystem.toStringSaleRecordSheetsHtml());
        jLabel3.setBounds(50, 100, 900, 600);
        jLabel3.setFont(font_normal);
        add(jLabel3);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        repaint();

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(jButtonReturn);
                remove(jLabel3);
                repaint();
            }
        });
        repaint();
    }

    /**
     * 销售记录添加界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在SaleRecordSheet和SaleRecord中对数据进行更改
     *@param
     *@return void
     */
    public void addPerson() {

        JButton jButtonReturn;
        JButton jButton1;
        JTextField jTextField1;
        JTextField jTextField2;
        JTextField jTextField3;
        JTextField jTextField4;
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JLabel jLabel5;

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入相关信息：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 200, 40);
        add(jLabel1);

        jLabel5 = new JLabel("<html>等级输入示例：<br>TopAdministrator<br>Administrator<br>" +
                "SalePerson<br>InputPerson<html>");
        jLabel5.setFont(font_normal);
        jLabel5.setBounds(400, 300, 200, 250);
        add(jLabel5);

        jLabel2 = new JLabel();
        jLabel2.setText("<html>姓名：<br><br>账号：<br><br>密码：<br><br>等级：<html>");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(150, 80, 100, 300);
        add(jLabel2);

        jLabel3 = new JLabel("添加成功后将返回主界面");
        jLabel3.setFont(font_normal);
        jLabel3.setBounds(650, 580, 300, 40);
        add(jLabel3);

        jLabel4 = new JLabel("该员工信息已经录入");
        jLabel4.setFont(font_1);
        jLabel4.setBounds(300, 510, 400, 40);

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField2.setFont(font_normal);
        jTextField3.setFont(font_normal);
        jTextField4.setFont(font_normal);
        jTextField1.setBounds(210, 148, 200, 30);
        jTextField2.setBounds(210, 194, 200, 30);
        jTextField3.setBounds(210, 240, 200, 30);
        jTextField4.setBounds(210, 286, 200, 30);
        add(jTextField1);
        add(jTextField2);
        add(jTextField3);
        add(jTextField4);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        jButton1 = new JButton("确认");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 60, 150, 70);
        add(jButton1);

        repaint();

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jTextField1);
                remove(jTextField2);
                remove(jTextField3);
                remove(jTextField4);
                repaint();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Person index : personList.getPersonList()) {
                    if (jTextField1.getText().equals(index.getName()) &&
                            jTextField2.getText().equals(index.getId())) {
                        add(jLabel4);
                        repaint();
                        return;
                    }
                }

                if ((!(jTextField1.getText().equals("") || jTextField2.getText().equals("") ||
                        jTextField3.getText().equals("") || jTextField4.getText().equals(""))) &&
                        (jTextField4.getText().equals("TopAdministrator") ||
                                jTextField4.getText().equals("Administrator") ||
                                jTextField4.getText().equals("InputPerson") ||
                                jTextField4.getText().equals("SalePerson"))) {
                    Person person = new Person(jTextField1.getText(), jTextField2.getText(),
                            jTextField3.getText(), jTextField4.getText());
                    personList.addPerson(person);

                    //文件读写
                    File file = new File("PersonData/PersonData.txt");

                    if (!file.exists()) {
                        try {
                            // 如果文件找不到，就new一个
                            file.createNewFile();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String str = "";
                        String line;
                        while ((line = br.readLine()) != null) {
                            str = str.concat(line + "\n");
                        }
                        str = str.concat(person.toString());
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        bw.write(str);
                        br.close();
                        bw.flush();
                        bw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                    remove(jButton1);
                    remove(jButtonReturn);
                    remove(jLabel1);
                    remove(jLabel2);
                    remove(jLabel3);
                    remove(jLabel4);
                    remove(jLabel5);
                    remove(jTextField1);
                    remove(jTextField2);
                    remove(jTextField3);
                    remove(jTextField4);
                    repaint();
                }
            }
        });

        repaint();
    }

    /**
     * 员工添加界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在PersonList和Person中对数据进行更改
     *@param
     *@return void
     */
    public void removePerson() {
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JLabel jLabel5;
        JTextField jTextField1;
        JTextField jTextField2;
        JButton jButton1;
        JButton jButton2;
        JButton jButtonReturn;
        final String[] item = {""};
        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入员工姓名或账号：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 300, 40);
        add(jLabel1);

        jLabel5 = new JLabel("删除成功后将自动返回主界面");
        jLabel5.setFont(font_normal);
        jLabel5.setBounds(700, 580, 300, 40);
        add(jLabel5);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //结果提示栏
        jLabel2 = new JLabel("查询结果\n");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(20, 150, 970, 40);
        add(jLabel2);

        jLabel4 = new JLabel();
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(50, 185, 970, 150);

        //输入确认栏
        jLabel3 = new JLabel("请确认需要删除的员工账号：");
        jLabel3.setFont(font_normal);
        jLabel3.setBounds(100, 350, 300, 40);

        jTextField2 = new JTextField();
        jTextField2.setFont(font_normal);
        jTextField2.setBounds(400, 350, 200, 40);

        jButton2 = new JButton("确认");
        jButton2.setFont(font_1);
        jButton2.setBounds(400, 450, 200, 40);

        //查询监听
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Person index : personList.getPersonList()) {
                    if (jTextField1.getText().equals(index.getId()) ||
                            jTextField1.getText().equals(index.getName())) {
                        jLabel4.setText(index.toStringB());
                        add(jLabel4);
                        add(jLabel3);
                        add(jTextField2);
                        add(jButton2);
                        repaint();
                    }
                }
            }
        });

        //确认监听
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Person index : personList.getPersonList()) {
                    if (jTextField2.getText().equals(index.getId())) {
                        personList.getPersonList().remove(index);
                        //文件读写
                        File file = new File("PersonData/PersonData.txt");

                        if (!file.exists()) {
                            try {
                                // 如果文件找不到，就new一个
                                file.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            String str = "";
                            String line;
                            while ((line = br.readLine()) != null) {
                                if (!line.equals(index.toString()))
                                    str = str.concat(line + "\n");
                            }
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                            bw.write(str);
                            br.close();
                            bw.flush();
                            bw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        remove(jButton1);
                        remove(jButton2);
                        remove(jButtonReturn);
                        remove(jLabel1);
                        remove(jLabel2);
                        remove(jLabel3);
                        remove(jLabel4);
                        remove(jLabel5);
                        remove(jTextField1);
                        remove(jTextField2);
                        repaint();
                    }
                }
            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButton2);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jLabel5);
                remove(jTextField1);
                remove(jTextField2);
                repaint();
            }
        });
        repaint();
    }

    /**
     * 员工信息修改界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在PersonList和Person中对数据进行更改
     *@param
     *@return void
     */
    public void setPerson() {

        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel4;
        JLabel jLabel5;
        JLabel jLabel6;
        JTextField jTextField1;
        JTextField jTextField2;
        JTextField jTextField3;
        JTextField jTextField4;
        JTextField jTextField5;
        JButton jButton1;
        JButton jButton2;
        JButton jButtonReturn;
        final Person[] person = new Person[1];
        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入员工姓名或账号：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 300, 40);
        add(jLabel1);

        jLabel5 = new JLabel("修改成功后将自动返回主界面");
        jLabel5.setFont(font_normal);
        jLabel5.setBounds(700, 580, 300, 40);
        add(jLabel5);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //结果提示栏
        jLabel2 = new JLabel("查询结果");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(50, 150, 970, 40);
        add(jLabel2);

        jLabel6 = new JLabel("修改栏");
        jLabel6.setFont(font_normal);
        jLabel6.setBounds(320, 150, 970, 40);
        add(jLabel6);

        jLabel4 = new JLabel();
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(50, 200, 970, 200);


        //输入栏
        jTextField2 = new JTextField();
        jTextField2.setFont(font_normal);
        jTextField2.setBounds(270, 220, 250, 30);

        jTextField3 = new JTextField();
        jTextField3.setFont(font_normal);
        jTextField3.setBounds(270, 265, 250, 30);

        jTextField4 = new JTextField();
        jTextField4.setFont(font_normal);
        jTextField4.setBounds(270, 313, 250, 30);

        jTextField5 = new JTextField();
        jTextField5.setFont(font_normal);
        jTextField5.setBounds(270, 360, 250, 30);

        jButton2 = new JButton("确认");
        jButton2.setFont(font_1);
        jButton2.setBounds(600, 300, 200, 100);

        //查询监听
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Person index : personList.getPersonList()) {
                    if (jTextField1.getText().equals(index.getId()) ||
                            jTextField1.getText().equals(index.getName())) {
                        person[0] = index;
                        jLabel4.setText(index.toStringHtml());
                        jTextField2.setText(index.getName());
                        jTextField3.setText(index.getId());
                        jTextField4.setText(index.getPassword());
                        jTextField5.setText(index.getLevel());
                        add(jLabel4);
                        add(jTextField2);
                        add(jTextField3);
                        add(jTextField4);
                        add(jTextField5);
                        add(jButton2);
                        repaint();
                    }
                }
            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButton2);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel4);
                remove(jLabel5);
                remove(jLabel6);
                remove(jTextField1);
                remove(jTextField2);
                remove(jTextField3);
                remove(jTextField4);
                remove(jTextField5);
                repaint();
            }
        });

        //确认监听
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jTextField5.getText().equals("") || jTextField2.getText().equals("") ||
                        jTextField3.getText().equals("") || jTextField4.getText().equals(""))) {
                    for (Person index : personList.getPersonList()) {
                        if (index.toString().equals(person[0].toString())) {
                            index.setName(jTextField2.getText());
                            index.setId(jTextField3.getText());
                            index.setPassword(jTextField4.getText());
                            index.setLevel(jTextField5.getText());

                            //文件读写
                            File file = new File("PersonData/PersonData.txt");

                            if (!file.exists()) {
                                try {
                                    // 如果文件找不到，就new一个
                                    file.createNewFile();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                                bw.write(personList.toString());
                                bw.flush();
                                bw.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                            remove(jButton1);
                            remove(jButton2);
                            remove(jButtonReturn);
                            remove(jLabel1);
                            remove(jLabel2);
                            remove(jLabel4);
                            remove(jLabel5);
                            remove(jLabel6);
                            remove(jTextField1);
                            remove(jTextField2);
                            remove(jTextField3);
                            remove(jTextField4);
                            remove(jTextField5);
                            repaint();
                        }
                    }
                }
            }
        });

        repaint();
    }

    /**
     * 员工查找界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在PersonList和Person中对数据进行更改
     *@param
     *@return void
     */
    public void findPerson() {
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel4;
        JLabel jLabel5;
        JTextField jTextField1;
        JButton jButton1;
        JButton jButtonReturn;
        final String[] item = {""};
        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入员工姓名或账号：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 300, 40);
        add(jLabel1);

        jLabel5 = new JLabel("删除成功后将自动返回主界面");
        jLabel5.setFont(font_normal);
        jLabel5.setBounds(700, 580, 300, 40);
        add(jLabel5);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(100, 90, 400, 40);
        add(jTextField1);

        jButton1 = new JButton("查询");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 90, 150, 40);
        add(jButton1);

        //结果提示栏
        jLabel2 = new JLabel("查询结果\n");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(20, 150, 970, 40);
        add(jLabel2);

        jLabel4 = new JLabel();
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(50, 185, 970, 150);

        //查询监听
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Person index : personList.getPersonList()) {
                    if (jTextField1.getText().equals(index.getId()) ||
                            jTextField1.getText().equals(index.getName())) {
                        jLabel4.setText(index.toStringB());
                        add(jLabel4);
                        repaint();
                    }
                }
            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel4);
                remove(jLabel5);
                remove(jTextField1);
                repaint();
            }
        });

        repaint();
    }

    /**
     * 密码修改界面的绘制以及数据变化的函数
     * 将在监控器中检测输入数据是否合乎规定并在PersonList和Person中对数据进行更改
     *@param
     *@return void
     */
    public void setPassword() {

        JButton jButtonReturn;
        JButton jButton1;
        JTextField jTextField1;
        JTextField jTextField2;
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;

        // 设置字体
        Font font_1 = new Font("宋体", Font.PLAIN, 30);
        Font font_normal = new Font("宋体", Font.PLAIN, 20);

        //提示栏
        jLabel1 = new JLabel("请输入新密码：");
        jLabel1.setFont(font_normal);
        jLabel1.setBounds(100, 50, 200, 40);
        add(jLabel1);

        jLabel3 = new JLabel("请输入确认密码：");
        jLabel3.setFont(font_normal);
        jLabel3.setBounds(100, 90, 200, 40);
        add(jLabel3);

        jLabel2 = new JLabel("修改成功后将返回主界面");
        jLabel2.setFont(font_normal);
        jLabel2.setBounds(650, 580, 300, 40);
        add(jLabel2);

        jButtonReturn = new JButton("取消");
        jButtonReturn.setFont(font_1);
        jButtonReturn.setBounds(750, 50, 180, 90);
        add(jButtonReturn);

        //输入栏
        jTextField1 = new JTextField();
        jTextField1.setFont(font_normal);
        jTextField1.setBounds(265, 50, 200, 40);
        add(jTextField1);

        jTextField2 = new JTextField();
        jTextField2.setFont(font_normal);
        jTextField2.setBounds(265, 90, 200, 40);
        add(jTextField2);

        jButton1 = new JButton("确认");
        jButton1.setFont(font_1);
        jButton1.setBounds(520, 60, 150, 70);
        add(jButton1);

        StringTokenizer person = new StringTokenizer(this.user, "_");
        String item = "";
        item = item.concat("<html>用户当前信息");
        item = item.concat("<br>姓名： " + person.nextToken());
        item = item.concat("<br>账号： " + person.nextToken());
        item = item.concat("<br>密码： " + person.nextToken());
        item = item.concat("<br>等级： " + person.nextToken());

        jLabel4 = new JLabel(item);
        jLabel4.setFont(font_normal);
        jLabel4.setBounds(100, 200, 500, 400);
        add(jLabel4);

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(jButton1);
                remove(jButtonReturn);
                remove(jLabel1);
                remove(jLabel2);
                remove(jLabel3);
                remove(jLabel4);
                remove(jTextField1);
                remove(jTextField2);
                repaint();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField1.getText().equals(jTextField2.getText())) {
                    for (Person index : personList.getPersonList()) {
                        if (index.toString().equals(user)) {
                            index.setPassword(jTextField1.getText());
                            user = index.toString();
                            //文件读写
                            File file = new File("PersonData/PersonData.txt");

                            if (!file.exists()) {
                                try {
                                    // 如果文件找不到，就new一个
                                    file.createNewFile();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                                bw.write(personList.toString());
                                bw.flush();
                                bw.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                            remove(jButton1);
                            remove(jButtonReturn);
                            remove(jLabel1);
                            remove(jLabel2);
                            remove(jLabel3);
                            remove(jLabel4);
                            remove(jTextField1);
                            remove(jTextField2);
                            repaint();
                        }
                    }
                }
            }
        });
        repaint();
    }

}
