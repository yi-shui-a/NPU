//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class TestItem {
    private double score;
    private Test test;

    public TestItem(Test var1, double var2) {
        this.test = var1;
        this.score = var2;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double var1) {
        this.score = var1;
    }

    public String toString() {
        return this.test.toString() + "|" + this.getScore();
    }

    public Test getTest() {
        return this.test;
    }
}
