/**
 * This class is a subclass of interface StudentsFormatter，
 The function is to convert data into XML format for output
 * @see StudentsFormatter
 *
 */
public class XMLStudentsFormatter implements StudentsFormatter {
    private static XMLStudentsFormatter singletonInstance;

    /**
     *Empty constructed function
     */
    private XMLStudentsFormatter() {
    }

    /**
     * Get object XML
     *@param
     *@return XMLStudentsFormatter
     */
    public static XMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            synchronized (XMLStudentsFormatter.class) {
                singletonInstance = new XMLStudentsFormatter();
            }
        }
        return singletonInstance;
    }

    /**
     * Format output class content XML
     *@param studentCatalog
     *@return java.lang.String
     */
    public String formatStudents(StudentCatalog studentCatalog) {

        String str;
        str = "<StudentCatalog>\n";
        for (Student i : studentCatalog.getStudents()) {
            str = str.concat("  <student id=");
            str = str.concat("\"" + i.getId() + "\"" + "name=" + "\"" + i.getName() + "\">\n");
            str = str.concat("    <ExamPaper>\n");
            for (TestItem j : i.getExamPaper().getTestItems()) {
                str = str.concat("      <Test code=\"" + j.getTest().getCode()+"\">"+j.getTest().getTitle()+"</Test>\n");
            }
            str = str.concat("    </ExamPaper>\n");
            str = str.concat("  </Student>\n");
        }
        str=str.concat("</StudentCatalog>");
        return str;
    }
}
