import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static Node[] nodes;
    static class Node {
        int x, y;
        Node(int x, int y) { this.x = x; this.y = y; }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N+2];
            parent = new int[N+2];
            for (int i = 0; i < N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                parent[i] = i;
            }


            // 모든 쌍을 union
            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    if (dist(nodes[i], nodes[j]) <= 1000) {
                        union(i, j);
                    }
                }
            }

            if (find(0) == find(N+1)) sb.append("happy\n");
            else sb.append("sad\n");
        }
        System.out.print(sb);
    }

    private static int dist(Node node, Node node2) {
		// TODO Auto-generated method stub
		return Math.abs(node.x - node2.x) + Math.abs(node.y - node2.y);
	}

	static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) parent[py] = px;
    }
}
