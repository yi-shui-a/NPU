package main.java.Experiment2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class BB4TSP {

    int NoEdge = -1; //��ʾû�б�
    private int minCost = Integer.MAX_VALUE; //��ǰ��С����

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    Comparator<HeapNode> cmp = new Comparator<HeapNode>() {
        public int compare(HeapNode e1, HeapNode e2) {
            return e2.lcost - e1.lcost;
        }
    };

    private PriorityQueue<HeapNode> priorHeap = new PriorityQueue<HeapNode>(100, cmp);//�洢��ڵ�

    private Vector<Integer> bestH = new Vector<Integer>();
    Vector<Integer> mini = new Vector<>();

    public Vector<Integer> bestX = new Vector<>();

    @SuppressWarnings("rawtypes")
    public static class HeapNode implements Comparable {
        Vector<Integer> cityArrange = new Vector<Integer>();//��������
        int lcost; //���۵��½�
        int level;//0-level�ĳ������Ѿ��źõ�


        //���췽��
        public HeapNode(Vector<Integer> cities, int lb, int lev) {
            cityArrange.addAll(0, cities);
            lcost = lb;
            level = lev;
        }

        @Override
        public int compareTo(Object x) {//��������, ÿһ��pollFirst
            int xu = ((HeapNode) x).lcost;
            if (lcost < xu) return -1;
            if (lcost == xu) return 0;
            return 1;
        }

        public boolean equals(Object x) {
            return lcost == ((HeapNode) x).lcost;
        }

    }


    /**
     * ���㲿�ֽ���½�.
     *
     * @param cityArrange ���е�����
     * @param level       ��ǰȷ���ĳ��еĸ���.
     * @param cMatrix     �ڽӾ��󣬵�0�У�0�в���
     * @throws IllegalArgumentException
     */
    public int computeLB(Vector<Integer> cityArrange, int level, int[][] cMatrix) {
        //TODO
        int res = 0;
        Vector<Boolean> traveled = new Vector<>(cMatrix.length + 1);

        for (int i = 0; i < cMatrix.length; ++i) {
            traveled.add(false);
        }

        for (int i = 2; i <= level; ++i) {
            res += cMatrix[cityArrange.get(i - 1)][cityArrange.get(i)];
            traveled.set(cityArrange.get(i - 1), true);
            traveled.set(cityArrange.get(i), true);
        }

        if (level == cMatrix.length - 1)
            res += cMatrix[cityArrange.get(level)][1];
        else
            for (int i = 1; i < traveled.size(); ++i) {
                if (!traveled.get(i)) {
                    res += mini.get(i);
                }
            }

        return res;
    }

    void makemini(int[][] cMatrix) {
        for (int[] matrix : cMatrix) {
            int minimal = Integer.MAX_VALUE;
            for (int i : matrix) {
                if (i < minimal && i != -1)
                    minimal = i;
            }
            mini.add(minimal);
        }
    }

    boolean notTraveled(Vector<Integer> cityArrange, int level, int city) {
        for (int i = 1; i <= level; ++i) {
            if (city == cityArrange.get(i))
                return false;
        }
        return true;
    }

    /**
     * ����TSP�������С���۵�·��.
     *
     * @param cMatrix �ڽӾ��󣬵�0�У�0�в���
     * @param n       ���и���.
     * @throws IllegalArgumentException
     */
    public int bb4TSP(int[][] cMatrix, int n) {
        makemini(cMatrix);

        //�����ʼ�ڵ�
        Vector<Integer> cityArrange = new Vector<Integer>();//��������
        cityArrange.add(0);//�ճ�һ�����У���cMatrixһ��
        for (int i = 1; i <= n; i++) cityArrange.add(i);
        int level = 1;//0-level�ĳ������Ѿ��źõ�
        int lcost = computeLB(cityArrange, level, cMatrix); //���۵��½�


        HeapNode cNode;
        HeapNode nNode = new HeapNode(cityArrange, lcost, level);
        priorHeap.add(nNode);
        while (!priorHeap.isEmpty()) {
            //TODO
            //�ο����ȶ��У���ͣ��չ�ڵ�,ѡȡ��һ���ڵ�
            cNode = priorHeap.peek();
            priorHeap.remove();
            cityArrange = cNode.cityArrange;
            level = cNode.level;

            if (level == n) {
                if (cNode.lcost < minCost) {
                    minCost = cNode.lcost;
                    bestX = (Vector<Integer>) cNode.cityArrange.clone();
                }
            } else
                for (int i = 1; i <= n; ++i) {

                    int nEdge = cMatrix[cityArrange.get(level)][i];
                    cityArrange.set(level + 1, i);
                    if (nEdge != NoEdge && notTraveled(cityArrange, level, i)) {
                        lcost = computeLB(cityArrange, level + 1, cMatrix);
                        nNode = new HeapNode(cityArrange, lcost, level + 1);
                        priorHeap.add(nNode);
                    }
                }
        }

        return minCost;
    }

}
