package by.sivko.model;

import javax.persistence.*;
import java.io.Serializable;

/*
https://stackoverflow.com/questions/3765948/how-do-i-query-for-only-superclass-entities-in-a-jpql-query
only entities superclass
-----------------------------------------------
entity_type_expression ::=
        type_discriminator |
        entity_type_literal |
        input_parameter
        type_discriminator ::=
        TYPE(identification_variable |
        single_valued_object_path_expression |
        input_parameter )
-----------------------------------------------
SELECT e
        FROM Employee e
        WHERE TYPE(e) IN (Exempt, Contractor)

        SELECT e
        FROM Employee e
        WHERE TYPE(e) IN (:empType1, :empType2)

        SELECT e
        FROM Employee e
        WHERE TYPE(e) IN :empTypes

        SELECT TYPE(e)
        FROM Employee e
        WHERE TYPE(e) <> Exempt
------------------------------------------------
*/

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("User")
@NamedQueries({
        @NamedQuery(name = "User.findByName", query = "select u from User u where u.name=:name and TYPE(u) <> Employer"),
        @NamedQuery(name = "User.getAllUsers", query = "select u from User u where TYPE(u) <> Employer")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE Table-per-class
    private Long id;

    private String name;
    private String password;
    private Integer age;

    public User() {
    }

    public User(String name, String password, Integer age) {
        super();
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
