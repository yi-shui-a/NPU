package main.test.Experiment2;

import main.java.Experiment2.BB4TSP;
import main.java.Experiment2.Back4TSP;
import main.java.Experiment2.Back4TSPBound;
import org.junit.Test;

import java.util.Arrays;

public class TestMultiScale {
    String printTime(Long time) {
        return (((time / 86400000) > 0) ? ((time / 86400000) + "d ") : "") +
                ((((time / 86400000) > 0) || ((time % 86400000 / 3600000) > 0)) ? ((time % 86400000 / 3600000) + "h ") : ("")) +
                ((((time / 3600000) > 0) || ((time % 3600000 / 60000) > 0)) ? ((time % 3600000 / 60000) + "m ") : ("")) +
                ((((time / 60000) > 0) || ((time % 60000 / 1000) > 0)) ? ((time % 60000 / 1000) + "s ") : ("")) +
                ((time % 1000) + "ms ");
    }

    @Test
    public void main() {
        // �����ģ
        int ns[] = new int[]{0, 5, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 40, 80, 100, 120, 160, 180, 200, 500};
        for (int i = 1; i < ns.length; i++) {
            int n = ns[i];
            System.out.println("============��" + i + "�β��Կ�ʼ(�����ģn = " + n + ")============");
            // ������ɳ��о������ m
            int[][] m = new int[n + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j == 0 || k == 0 || j == k) {
                        m[j][k] = -1;
                        continue;
                    }
                    // �� 10 �� 1000 ���������
                    m[j][k] = 1 + (int) (Math.random() * 1000);
                }
            }

            long start = 0;
            long end = 0;
            Back4TSP back4TSP = new Back4TSP();
            if (n <= 24) {
                // ִ�л����㷨��Ⲣ��¼ִ��ʱ��ͽ��
                back4TSP = new Back4TSP();
                start = System.currentTimeMillis();
                back4TSP.backtrack4TSP(m.clone(), n);
                end = System.currentTimeMillis();
                System.out.println("���ݷ�ִ����ϣ�����ʱ��Ϊ" + printTime(end - start));
                System.out.println("���·��Ϊ" + Arrays.toString(back4TSP.bestx) + " ��С·��Ϊ" + back4TSP.bestc);
            }


            if (n <= 13) {
                // ִ�з�֧�޽��㷨 ��Ⲣ��¼ִ��ʱ��ͽ��
                BB4TSP bb4TSP = new BB4TSP();
                start = System.currentTimeMillis();
                bb4TSP.bb4TSP(m.clone(), n);
                end = System.currentTimeMillis();
                System.out.println("��֧�޽編(�������ȼ�����)ִ����ϣ�����ʱ��Ϊ" + printTime(end - start));
                System.out.println("���·��Ϊ" + bb4TSP.bestX + " ��С·��Ϊ" + bb4TSP.getMinCost());
            }

            // ִ�з�֧�޽��㷨һ ��Ⲣ��¼ִ��ʱ��ͽ��
            Back4TSPBound back4TSPBound = new Back4TSPBound();
            start = System.currentTimeMillis();
            back4TSPBound.backtrack4TSP(m.clone(), n);
            end = System.currentTimeMillis();
            System.out.println("��֧�޽編ִ����ϣ�����ʱ��Ϊ" + printTime(end - start));
            System.out.println("���·��Ϊ" + Arrays.toString(back4TSPBound.bestx) + " ��С·��Ϊ" + back4TSPBound.bestc);

        }
    }
}
