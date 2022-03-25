
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
@Table(name = "student_class_room")
public class StudentClassRoom extends UserAccountRecord
{
    @JoinColumn(name = "class_rooms", referencedColumnName = "id")
    @ManyToOne
    private ClassRoom classRoom ;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
    
}
