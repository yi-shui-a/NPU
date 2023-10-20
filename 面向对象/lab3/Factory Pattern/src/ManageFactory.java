/**
 * Implementation factory class
 * @see PlainTextStudentsFormatter
 * @see HTMLStudentsFormatter
 * @see XMLStudentsFormatter
 * @see StudentsFormatter
 *
 */
public class ManageFactory {

    /**
     *Get object Txt
     *@param
     *@return StudentsFormatter
     */
    public static StudentsFormatter cteatText(){

        return PlainTextStudentsFormatter.getSingletonInstance();
    }

    /**
     * Get object html
     *@param
     *@return StudentsFormatter
     */
    public static StudentsFormatter cteatHtml(){

        return HTMLStudentsFormatter.getSingletonInstance();
    }

    /**
     * Get object xml
     *@param
     *@return StudentsFormatter
     */
    public static StudentsFormatter cteatXml(){

        return XMLStudentsFormatter.getSingletonInstance();
    }
}
