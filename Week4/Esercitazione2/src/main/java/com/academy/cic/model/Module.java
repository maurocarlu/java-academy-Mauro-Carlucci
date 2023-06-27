package com.academy.cic.model;

public class Module {
    private int module_id;
    private String name;
    private String teacher;

    public Module(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}

