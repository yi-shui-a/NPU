//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentCatalog implements Iterable<Student> {
    private List<Student> students = new ArrayList();

    public StudentCatalog() {
    }

    public List<Student> getStudents(){
        return students;
    }

    public void addStudent(Student var1) {
        this.students.add(var1);
    }

    public void removeStudent(Student var1) {
        this.students.remove(var1);
    }

    public Iterator<Student> iterator() {
        return this.students.iterator();
    }

    public Student getStudent(String var1) {
        Iterator var2 = this.students.iterator();

        Student var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (Student)var2.next();
        } while(!var3.getId().equals(var1));

        return var3;
    }

    public int getNumberOfStudents() {
        return this.students.size();
    }
}