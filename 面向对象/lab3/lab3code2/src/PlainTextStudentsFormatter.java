/**
 * This class is a subclass of interface StudentsFormatter，
 The function is to convert data into TXT format for output
 * @see StudentsFormatter
 *
 */
public class PlainTextStudentsFormatter implements StudentsFormatter {

    private static PlainTextStudentsFormatter singletonInstance;

    /**
     *Empty constructed function
     */
    private PlainTextStudentsFormatter() {
    }

    /**
     * Gets an object of the class
     *@param
     *@return PlainTextStudentsFormatter
     */
    public static PlainTextStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            synchronized (PlainTextStudentsFormatter.class) {
                singletonInstance = new PlainTextStudentsFormatter();
            }
        }
        return singletonInstance;
    }

    /**
     * Gets an object of the class TXT
     *@param studentCatalog
     *@return java.lang.String
     */
    public String formatStudents(StudentCatalog studentCatalog) {

        String str;
        str="Student Catalog\n";
        for (Student index : studentCatalog.getStudents()){
            str=str+index.getId();
            str=str+"_";
            str=str+index.getName();
            for(int num=0;num<10;num++){
                str=str+"_";
                str=str+index.getExamPaper().getTestItem(num).getTest().getCode();
            }
            str=str+"\n";
        }
        return str;
    }
}
