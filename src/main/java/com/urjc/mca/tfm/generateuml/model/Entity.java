package com.urjc.mca.tfm.generateuml.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Entity {

    public final String name;
    private Set<Entity> partList = new HashSet<>();
    private Set<Entity> base = new HashSet<>();
    private Set<Entity> elements = new HashSet<>();
    private Set<Entity> associates = new HashSet<>();
    private Set<Entity> used = new HashSet<>();

    public Entity(String name) {
        this.name = name;
    }

    public void addPart(Entity entity) {
        partList.add(entity);
    }

    public void addElement(Entity entity){
        elements.add(entity);
    }

    public void addAssociate(Entity entity){
        associates.add(entity);
    }

    public void addBase(Entity entity) {
        base.add(entity);
    }

    public void addUsed(Entity entity){
        used.add(entity);
    }

    public Set<Entity> getBase() {
        return this.base;
    }

    public Set<Entity> getPartList() {
        return this.partList;
    }

    public Set<Entity> getElements(){
        return this.elements;
    }

    public Set<Entity> getAssociates(){
        return this.associates;
    }

    public Set<Entity> getUsed(){
        return this.used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
