package main.test.Experiment3;


import main.java.Experiment3.Back4TSP;
import main.java.Experiment3.GAOperations;

class GATest2 {
    static String printTime(Long time) {
        return (((time / 86400000) > 0) ? ((time / 86400000) + "d ") : "") +
                ((((time / 86400000) > 0) || ((time % 86400000 / 3600000) > 0)) ? ((time % 86400000 / 3600000) + "h ") : ("")) +
                ((((time / 3600000) > 0) || ((time % 3600000 / 60000) > 0)) ? ((time % 3600000 / 60000) + "m ") : ("")) +
                ((((time / 60000) > 0) || ((time % 60000 / 1000) > 0)) ? ((time % 60000 / 1000) + "s ") : ("")) +
                ((time % 1000) + "ms ");
    }

    public static void main(String[] args) {
        // �����ģ
        int ns[] = new int[]{0, 5, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        for (int i = 1; i < ns.length; i++) {
            int n = ns[i];
            System.out.println("�����ģn = " + n);
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
            // ִ�л����㷨��Ⲣ��¼ִ��ʱ��ͽ��
            if (n <= 17) {
                Back4TSP back4TSP = new Back4TSP();
                start = System.currentTimeMillis();
                back4TSP.backtrack4TSP(m.clone(), n);
                end = System.currentTimeMillis();
                System.out.println("���ݷ�ִ����ϣ�����ʱ��Ϊ" + printTime(end - start));
                System.out.println("���·������Ϊ" + back4TSP.bestc);
            }

            int length_ = n;
            int popNum_ = 100000 * n;
            int[] code = new int[n];
            int[] codeCounts = new int[n];
            int[][] iniPop_ = new int[popNum_][length_];
            int[][] b_ = new int[n][n];

            for (int q = 0; q < n; q++) {
                code[q] = q + 1;
                codeCounts[q] = 1;
            }

            for (int q = 0; q < n; q++) {
                for (int j = q; j < n; j++) {
                    if (m[q + 1][j + 1] == -1) {
                        b_[q][j] = 100;
                    } else {
                        b_[q][j] = m[q + 1][j + 1];
                    }
                    b_[j][q] = b_[q][j];
                }
            }

            for (int q = 0; q < n; q++) {
                b_[q][q] = 100;
            }

            // ִ���Ŵ��㷨
            GAOperations GA = new GAOperations();
            start = System.currentTimeMillis();
            GA.RandomInitialization(popNum_, length_, code, n, codeCounts, iniPop_);
            int cost = GA.getBest(iniPop_, popNum_, length_, b_);
            end = System.currentTimeMillis();
            System.out.println("�Ŵ��㷨ִ����ϣ�����ʱ��Ϊ" + printTime(end - start));
            System.out.println("����·������Ϊ" + cost);
        }
    }
}