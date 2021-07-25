package by.wadikk.repository.model;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Data
public class Category {
    Integer id;

    private List<Category> childrenList;
    private Category parent;
    private String name;
    private int depth;// глубина

    public Category(Integer id, String name) {
        this.id = id;
        this.childrenList = new ArrayList<>();
        this.parent = null;
        this.name = name;
        this.depth = 0; // 0 is the base level (only the root should be on there)
        log.info("Create root category with name -> " + name);
    }

    public Category(Integer id, String name, Category parent) {
        // new node with a given parent
        if (parent != null) {
            this.id = id;
            this.childrenList = new ArrayList<>();
            this.name = name;
            this.parent = parent;
            this.depth = (parent.getDepth() + 1);
            parent.addChild(this);
            log.info("Create new category with name -> " + name + " , parent -> " + parent.getName());
        } else {
            log.info("Attempt to create new category with null parent -> " + name);
        }
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

    /*public void addChild(String name) {
        Category child = new Category(name);
        this.childrenList.add(child);
    }*/

    public void addChild(Category child) {
        this.childrenList.add(child);
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


    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth);
    }
}
