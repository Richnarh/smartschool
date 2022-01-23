package com.khoders.smartschool.entities;

import com.khoders.resource.jpa.BaseModel;
import com.khoders.resource.utilities.SystemUtils;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author richa
 */
@MappedSuperclass
public class ReferenceNo extends BaseModel implements Serializable
{
    @Column(name = "ref_no")
    private String refNo;

    public String getRefNo()
    {
        return refNo;
    }

    public void setRefNo(String refNo)
    {
        this.refNo = refNo;
    }

    public void genRefNo()
    {
        if (getRefNo() != null)
        {
            setRefNo(getRefNo());
        } else
        {
            setRefNo(SystemUtils.generateCode());
        }
    } 
}
