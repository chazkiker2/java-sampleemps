package com.lambdaschool.sampleemps.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emails")
public class Email
{
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    private long emailid; // long so we can have many rows

    private String email;

    @ManyToOne
    @JoinColumn(name = "employeeid",
            nullable = false)
    private Employee employee;

    public Email()
    {
        // the default constructor is required by the JPA
    }

    public Email(String email,
                 Employee employee)
    {
        this.email = email;
        this.employee = employee;
    }

    public long getEmailid()
    {
        return emailid;
    }

    public void setEmailid(long emailid)
    {
        this.emailid = emailid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
