package ru.sbt.jschool.session7.Problem5;

import java.io.Serializable;

/**
 */
public class ReadFile implements Serializable{
    String name;
    String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ReadFile(String name, String data) {

        this.name = name;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadFile readFile = (ReadFile) o;

        return name.equals(readFile.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "ReadFile{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
