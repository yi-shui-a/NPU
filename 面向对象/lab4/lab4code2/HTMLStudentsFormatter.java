/**
 * This class is a subclass of interface StudentsFormatter，
 The function is to convert data into HTML format for output
 * @see StudentsFormatter
 *
 */
public class HTMLStudentsFormatter implements StudentsFormatter {

    private static HTMLStudentsFormatter singletonInstance;

    /**
     *Empty constructed function
     */
    private HTMLStudentsFormatter() {
    }

    /**
     * Gets an object of the class
     *@param
     *@return HTMLStudentsFormatter
     */
    public static HTMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            synchronized (HTMLStudentsFormatter.class) {
                singletonInstance = new HTMLStudentsFormatter();
            }
        }
        return singletonInstance;
    }

    /**
     * Gets an object of the class HTML
     *@param studentCatalog
     *@return java.lang.String
     */
    public String formatStudents(StudentCatalog studentCatalog) {

        String str;
        str = "<html>\n";
        str=str.concat("  <body>\n");
        str=str.concat("    <center><h2>学生目录</h2></center>\n");
        for (Student i : studentCatalog.getStudents()) {
            str=str.concat("    <hr/>\n");
            str=str.concat("    <h4> " + i.getId() + "  " + i.getName() + "</h4>\n");
            if(i.getExamPaper()==null){
                str=str.concat("    该学生还未生成试卷。\n");
                continue;
            }
            str=str.concat("    <blockquote>\n");
            for (TestItem j : i.getExamPaper().getTestItems()) {
                str=str.concat("        ");
                str=str.concat(j.getTest().toString()+"<br>"+"\n");
            }
            str=str.concat("    </blockquote>\n");
        }
        str=str.concat("  <body>\n");
        str=str.concat("<html>");
        return str;
    }
}
