package main.java.Experiment3;

import java.util.Arrays;

public class Back4TSP {

	int NoEdge = -1;
	int bigInt = Integer.MAX_VALUE;
	int[][] a; // �ڽӾ���
	int cc = 0; // �洢��ǰ����
	public int bestc = bigInt;// ��ǰ���Ŵ���
	int[] x; // ��ǰ��
	public int[] bestx;// ��ǰ���Ž�
	int n = 0; // �������


	private void backtrack(int t) {
		//iΪ��ʼ���
		if (t > n) {
			bestc = cc;
			bestx = Arrays.copyOf(x, n + 1);
		} else {
			for (int j = t; j <= n; j++) {
				if (check(t, j, a)) {
					swap(t, j);
					if (t < n && cc + a[x[t - 1]][x[t]] <= bestc) {
						cc = cc + a[x[t - 1]][x[t]]; //�������x[t]�����cc
						backtrack(t + 1);
						cc = cc - a[x[t - 1]][x[t]];
					}
					if (t == n && cc + a[x[t - 1]][x[t]] + a[x[t]][x[1]] <= bestc) {
						cc = cc + a[x[t - 1]][x[t]] + a[x[t]][x[1]];
						backtrack(t + 1);
						cc = cc - a[x[t - 1]][x[t]] - a[x[t]][x[1]];
					}
					swap(t, j); //�ָ��ֳ�
				}
			}
		}

	}

	private void swap(int i, int j) {
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}

	public boolean check(int t, int j, int[][] m) {
		if (t < 2) return true;
		if (t < n && m[x[t - 1]][x[j]] != NoEdge) return true;
		if (t == n && m[x[t - 1]][x[j]] != NoEdge && m[x[j]][x[1]] != NoEdge) return true;
		return false;
	}

	public void backtrack4TSP(int[][] b, int num) {
		n = num;
		x = new int[n + 1];
		for (int i = 0; i <= n; i++)
			x[i] = i;
		a = b;
		backtrack(2);
	}

}
