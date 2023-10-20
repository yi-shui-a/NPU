//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDatabase implements Iterable<Test> {
    private List<Test> tests = new ArrayList();

    public TestDatabase() {
    }

    public void addTest(Test var1) {
        this.tests.add(var1);
    }

    public void romoveTest(Test var1) {
        this.tests.remove(var1);
    }

    public Iterator<Test> iterator() {
        return this.tests.iterator();
    }

    public int getNumberOfTests() {
        return this.tests.size();
    }

    public Test getTest(int var1) {
        return (Test)this.tests.get(var1);
    }
}
