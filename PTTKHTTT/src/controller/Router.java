package controller;

import java.util.ArrayList;
import java.util.List;

public class Router {
	public Router() {

	}

	public Result dijsktra(int s, int d, int[] P, double[] L) {
		P = new int[10];
		L = new double[10];
		List<Integer> R = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			L[i]=Double.POSITIVE_INFINITY;
			P[i]=-1;
		}
		return null;
	}
}
