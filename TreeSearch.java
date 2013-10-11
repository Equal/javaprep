import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class TreeSearch {

  static class TreeNode<T> {
    T value;
    List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
    
    //Wow, I totally forgot about queues. I had to look it up because any non-queue solution was dumb.
    boolean search(T value) {
        Queue<TreeNode<T>> queue = new ArrayDeque<TreeNode<T>>();
        queue.add(this);
        while (!queue.isEmpty())
        {
            TreeNode<T> node = queue.remove();
            System.out.println(node.value);
            if (node.value == value)
            {
                return true;
            }
            for (TreeNode<T> child : node.children)
            {
                queue.add(child);
            }
        }
      return false;
    }

    boolean depthSearch(T value)
    {
        System.out.println(this.value);
        if (this.value == value)
        {
            return true;
        }
        for (TreeNode<T> child : this.children)
        {
            if (child.depthSearch(value))
            {
                return true;
            }
        }
        return false;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeNode<Integer> root = new TreeNode<Integer>();
    root.value = 0;
    TreeNode<Integer> a = new TreeNode<Integer>();
    a.value = 1;
    TreeNode<Integer> b = new TreeNode<Integer>();
    b.value = 2;
    root.children.add(a);
    root.children.add(b);
    TreeNode<Integer> c = new TreeNode<Integer>();
    c.value = 3;
    a.children.add(c);

    if (!root.search(0) || !root.search(1)  || !root.search(2) || !root.search(3)) {
      throw new Exception("Failed to find existing node!");
    }
    if (root.search(4)) {
      throw new Exception("Found non-existent node!");
    }

    System.out.println("Depth first!");
    if (!root.depthSearch(0) || !root.depthSearch(1)  || !root.depthSearch(2) || !root.depthSearch(3)) {
      throw new Exception("Failed to find existing node!");
    }
    if (root.depthSearch(4)) {
      throw new Exception("Found non-existent node!");
    }
  }
}
