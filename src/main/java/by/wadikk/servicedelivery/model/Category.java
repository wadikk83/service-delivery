package by.wadikk.servicedelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    //Integer id;

    private List<Category> childrenList;
    private Category parent;
    private String name;
    private int depth;// глубина

    public Category(String name) {
        this.childrenList = new ArrayList<>();
        this.parent = null;
        this.name = name;
        this.depth = 0; // 0 is the base level (only the root should be on there)
    }

    public Category(String name, Category parent) {
        // new node with a given parent
        this.childrenList = new ArrayList<>();
        this.name = name;
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

    public List<Category> getChildren() {
        return childrenList;
    }

    public void setParent(Category parent) {
        this.setDepth(parent.getDepth() + 1);
        parent.addChild(this);
        this.parent = parent;
    }

    public Category getParent() {
        return this.parent;
    }

    public void addChild(String name) {
        Category child = new Category(name);
        this.childrenList.add(child);
    }

    public void addChild(Category child) {
        this.childrenList.add(child);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRootNode() {
        return (this.parent == null);
    }

    public boolean isLeafNode() {
        return (this.childrenList.size() == 0);
    }

    public void removeParent() {
        this.parent = null;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Node: " + this.getName() + " | Depth: " + this.depth + " | Parent: " +
                (this.getParent() == null ? "None" : this.parent.getName()) +
                " | Children: " + (this.getChildren().size() == 0 ? "None" : "");
        for (Category child : this.getChildren()) {
            out += "\n\t" + child.getName() + " | Parent: " +
                    (child.getParent() == null ? "None" : child.getName());
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
