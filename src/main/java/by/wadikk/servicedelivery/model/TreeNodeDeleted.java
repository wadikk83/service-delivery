package by.wadikk.servicedelivery.model;

import java.util.*;

public class TreeNodeDeleted<T> {
    private final List<TreeNodeDeleted<T>> children;
    private TreeNodeDeleted<T> parent;
    private T data;
    private int depth;// глубина

    public TreeNodeDeleted(T data) {
        // a fresh node, without a parent reference
        this.children = new ArrayList<>();
        this.parent = null;
        this.data = data;
        this.depth = 0; // 0 is the base level (only the root should be on there)
    }

    public TreeNodeDeleted(T data, TreeNodeDeleted<T> parent) {
        // new node with a given parent
        this.children = new ArrayList<>();
        this.data = data;
        this.parent = parent;
        this.depth = (parent.getDepth() + 1);
        parent.addChild(this);
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<TreeNodeDeleted<T>> getChildren() {
        return children;
    }

    public void setParent(TreeNodeDeleted<T> parent) {
        this.setDepth(parent.getDepth() + 1);
        parent.addChild(this);
        this.parent = parent;
    }

    public TreeNodeDeleted<T> getParent() {
        return this.parent;
    }

    public void addChild(T data) {
        TreeNodeDeleted<T> child = new TreeNodeDeleted<>(data);
        this.children.add(child);
    }

    public void addChild(TreeNodeDeleted<T> child) {
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRootNode() {
        return (this.parent == null);
    }

    public boolean isLeafNode() {
        return (this.children.size() == 0);
    }

    public void removeParent() {
        this.parent = null;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Node: " + this.getData().toString() + " | Depth: " + this.depth + " | Parent: " + (this.getParent() == null ? "None" : this.parent.getData().toString()) + " | Children: " + (this.getChildren().size() == 0 ? "None" : "");
        for (TreeNodeDeleted<T> child : this.getChildren()) {
            out += "\n\t" + child.getData().toString() + " | Parent: " + (child.getParent() == null ? "None" : child.getParent().getData());
        }
        return out;
    }

    /*static void traverse(TreeNode obj) {
        if (obj != null) {
            for (int i = 0; i < obj.childCount; i++) {
                System.out.println(obj.childrens[i].value);
                traverse(obj.childrens[i]);
            }
        }
        return;
    }*/
}
