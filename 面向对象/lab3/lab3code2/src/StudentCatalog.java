
/**
 *This class contains all student information.
 *
 * <p>The methods include obtaining, modifying and deleting student information.
 * <p> <Student> is the type of elements in the list </p>
 *
 * @see Student
 *
 */

import java.util.ArrayList;
import java.util.List;


public class StudentCatalog{

    private List<Student> students;

    public StudentCatalog(){
        students=new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     *@param student
     *@return void
     */
    public void addStudent(Student student){

        students.add(student);
    }

    /**
     *@param student
     *@return boolean
     */
    public boolean removeStudent(Student student){

        for (Student n:students) {
            if(student.getId().equals(n.getId())){
                students.remove(n);
                return true;
            }
        }
        return false;
    }

    /**
     *@param id
     *@return Student
     */
    public Student getStudent(String id){

        for (Student n:students) {
            if(n.getId().equals(id))
                return n;
        }
        return null;
    }

    /**
     *@param index
     *@return Student
     */
    public Student getStudent(int index){

        return students.get(index);
}

    /**
     *@param
     *@return int
     */
    public int getNumberOfStudents(){

        return students.size();
    }

}