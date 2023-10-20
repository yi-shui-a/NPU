//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;

public class HTMLStudentsFormatter implements StudentsFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static HTMLStudentsFormatter singletonInstance = new HTMLStudentsFormatter();

    public static HTMLStudentsFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private HTMLStudentsFormatter() {
    }

    public String formatStudents(StudentCatalog var1) {
        StringBuilder var2 = new StringBuilder("<html>" + NEW_LINE + "\t<body>" + NEW_LINE);
        var2.append("\t\t<center><h2>Student Catalog</h2></center>" + NEW_LINE);
        Iterator var3 = var1.iterator();

        while(true) {
            ExamPaper var5;
            do {
                if (!var3.hasNext()) {
                    var2.append("\t</body>" + NEW_LINE + "</html>");
                    return var2.toString();
                }

                Student var4 = (Student)var3.next();
                var2.append("\t\t<hr/>" + NEW_LINE + "\t\t<h4>" + var4.getId() + " " + var4.getName() + "</h4>" + NEW_LINE);
                var5 = var4.getExamPaper();
            } while(var5.getNumberOfItems() <= 0);

            var2.append("\t\t<blockquote>" + NEW_LINE);
            Iterator var6 = var5.iterator();

            while(var6.hasNext()) {
                TestItem var7 = (TestItem)var6.next();
                var2.append("\t\t\t" + var7.getTest().toString() + "<br/>" + NEW_LINE);
            }

            var2.append("\t\t</blockquote>" + NEW_LINE);
        }
    }
}
