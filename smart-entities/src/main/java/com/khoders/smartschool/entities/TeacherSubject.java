package com.khoders.smartschool.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "teacher_subject")
public class TeacherSubject extends UserAccountRecord
{
   @JoinColumn(name = "class_room", referencedColumnName = "id")
   @ManyToOne
   private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
