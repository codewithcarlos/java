// UnionFind.class
class UnionFind {
  private int[] root;

  public UnionFind(int size) {
    root = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      root[rootY] = rootX;
    }
  }

  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }
}

class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(6);
    uf.union(0, 1);
    uf.union(1, 2);
    uf.union(2, 3);
    uf.union(3, 4);
    uf.union(4, 5);
    System.out.println(uf.find(5));
    System.out.println(uf.find(2));
    System.out.println(uf.find(4));
  }
}