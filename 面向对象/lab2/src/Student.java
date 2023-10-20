/**
 *This class contains students' personal information.
 *
 * <p>The methods include the modification of student information acquisition and test paper information
 *
 * @see ExamPaper
 *
 */

public class Student {

    private String id;
    private String name;
    private ExamPaper examPaper;

    public Student() {
    }

    public Student(String initialId, String initialName) {
        id = initialId;
        name = initialName;
    }

    public Student(String initialId, String initialName, ExamPaper initialExamPaper) {
        id = initialId;
        name = initialName;
        examPaper = initialExamPaper;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getId() {

        return id;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getName() {

        return name;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    /**
     *@param [examPaper]
     *@return void
     */
    public void setExamPaper(ExamPaper examPaper) {

        this.examPaper=examPaper;
    }
}