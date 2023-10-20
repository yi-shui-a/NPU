//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Student {
    private String id;
    private String name;
    private ExamPaper examPaper;

    public Student(String var1, String var2) {
        this.id = var1;
        this.name = var2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ExamPaper getExamPaper() {
        return this.examPaper;
    }

    public String toString() {
        return this.getId() + "_" + this.getName();
    }

    public void setExamPaper(ExamPaper var1) {
        this.examPaper = var1;
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else if (this.getClass() != var1.getClass()) {
            return false;
        } else {
            Student var2 = (Student)var1;
            if (this.id == null) {
                if (var2.id != null) {
                    return false;
                }
            } else if (!this.id.equals(var2.id)) {
                return false;
            }

            return true;
        }
    }
}
