package by.sivko.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by SIvko on 28.06.2017.
 */
@Entity
@Table(name = "employes")
public class Employer extends User {

    private String position;

    public Employer() {
    }

    public Employer(String position) {
        this.position = position;
    }

    public Employer(String name, String password, Integer age, String position) {
        super(name, password, age);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
