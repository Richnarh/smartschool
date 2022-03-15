
package com.khoders.smartschool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "academic_level")
public class AcademicLevel extends UserAccountRecord
{
    @Column(name = "level_name")
    private String levelName;

    public String getLevelName()
    {
        return levelName;
    }

    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }

    @Override
    public String toString()
    {
        return levelName;
    }
}
