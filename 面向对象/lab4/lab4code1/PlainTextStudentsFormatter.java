//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;

public class PlainTextStudentsFormatter implements StudentsFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static PlainTextStudentsFormatter singletonInstance = new PlainTextStudentsFormatter();

    public static PlainTextStudentsFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private PlainTextStudentsFormatter() {
    }

    public String formatStudents(StudentCatalog var1) {
        StringBuilder var2 = new StringBuilder("Student Catalog" + NEW_LINE);
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            Student var4 = (Student)var3.next();
            var2.append(var4.getId() + "_" + var4.getName());
            Iterator var5 = var4.getExamPaper().iterator();

            while(var5.hasNext()) {
                TestItem var6 = (TestItem)var5.next();
                var2.append("_" + var6.getTest().getCode());
            }

            var2.append(NEW_LINE);
        }

        return var2.toString();
    }
}
