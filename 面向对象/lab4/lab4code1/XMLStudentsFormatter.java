//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;

public class XMLStudentsFormatter implements StudentsFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static XMLStudentsFormatter singletonInstance = new XMLStudentsFormatter();

    public static XMLStudentsFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private XMLStudentsFormatter() {
    }

    public String formatStudents(StudentCatalog var1) {
        StringBuilder var2 = new StringBuilder("<StudentCatalog>" + NEW_LINE);

        for(Iterator var3 = var1.iterator(); var3.hasNext(); var2.append("\t</Student>" + NEW_LINE)) {
            Student var4 = (Student)var3.next();
            var2.append("\t<student id=\"" + var4.getId() + "\" name=\"");
            var2.append(var4.getName() + "\">" + NEW_LINE);
            ExamPaper var5 = var4.getExamPaper();
            if (var5.getNumberOfItems() > 0) {
                var2.append("\t\t<ExamPaper>" + NEW_LINE);
                Iterator var6 = var5.iterator();

                while(var6.hasNext()) {
                    TestItem var7 = (TestItem)var6.next();
                    Test var8 = var7.getTest();
                    var2.append("\t\t\t<Test code=\"" + var8.getCode() + "\">");
                    var2.append(var8.getTitle() + "</Test>" + NEW_LINE);
                }

                var2.append("\t\t</ExamPaper>" + NEW_LINE);
            }
        }

        var2.append("</StudentCatalog>");
        return var2.toString();
    }
}
