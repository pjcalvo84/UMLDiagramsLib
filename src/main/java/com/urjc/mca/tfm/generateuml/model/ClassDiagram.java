package com.urjc.mca.tfm.generateuml.model;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagram {

    List<Entity> classes = new ArrayList();

    public ClassDiagram addClass(Entity entity){
        classes.add(entity);
        return this;
    }

    public ClassDiagram addClasses(List<Entity> entities){
        entities.forEach(e -> this.addClass(e));
        return this;
    }

    public String print(){
        StringBuilder className = new StringBuilder();
        StringBuilder relations = new StringBuilder();

        classes.forEach(e -> {
            className.append(printClassName(e));
            relations.append(printBase(e));
            relations.append(printPart(e));
            relations.append(printElement(e));
        });
        return className.toString() + relations.toString();
    }

    public String printClassName(Entity entity){
        return "class " + entity.name + "\n";
    }

    public String printPart(Entity entity){
        StringBuilder cadena = new StringBuilder();
        if(!entity.getPartList().isEmpty()){
            entity.getPartList().forEach( p -> cadena.append(entity.name + " *--> " + p.name + "\n"));
        }
        return cadena.toString();
    }
    public String printBase(Entity entity){
        StringBuilder cadena = new StringBuilder();
        if(!entity.getBase().isEmpty()){
            entity.getBase().forEach(b -> cadena.append( b.name + " <|-- " + entity.name + "\n"));
        }
        return cadena.toString();
    }
    public String printElement(Entity entity){
        StringBuilder cadena = new StringBuilder();
        if(!entity.getElements().isEmpty()){
            entity.getElements().forEach(e -> cadena.append( entity.name +" o--> " + e.name + "\n"));
        }
        return cadena.toString();
    }
}
