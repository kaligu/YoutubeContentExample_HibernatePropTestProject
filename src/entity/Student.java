/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : HibernatePropTest
  @ Date         : 4/8/2023
  @ Time         : 11:55 AM
*/
package entity;

//add annotations

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @Column
    private String id; //primary key

    @Column
    private String name; //normal column

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
