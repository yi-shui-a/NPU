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
     * Gets an object of the class
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
     * Gets an object of the class XML
     *@param studentCatalog
     *@return java.lang.String
     */
    public String formatStudents(StudentCatalog studentCatalog) {

        String str;
        str = "<StudentCatalog>\n";
        for (Student i : studentCatalog.getStudents()) {
            str = str.concat("  <student id=");
            str = str.concat("\"" + i.getId() + "\"" + "name=" + "\"" + i.getName() + "\">\n");
            if(i.getExamPaper()==null){
                str=str.concat("    该学生还未生成试卷。\n");
                str = str.concat("  </Student>\n");
                continue;
            }
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
