
package com.khoders.smartschool.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "class_rooms")
public class ClassRoom extends UserAccountRecord implements Serializable
{
    @Column(name = "class_code")
    private String classCode;
    
    @Column(name = "class_name")
    private String className;
    
    @Column(name = "class_size")
    private int classSize;
    
    @JoinColumn(name = "class_prefect", referencedColumnName = "id")
    @ManyToOne
    private Student classPrefect;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public int getClassSize()
    {
        return classSize;
    }

    public void setClassSize(int classSize)
    {
        this.classSize = classSize;
    }

    public Student getClassPrefect()
    {
        return classPrefect;
    }

    public void setClassPrefect(Student classPrefect)
    {
        this.classPrefect = classPrefect;
    }
}
