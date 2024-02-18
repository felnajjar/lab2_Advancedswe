package com.example.demo.models;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private String Color;

    public Fruit() {
    }

    public Fruit(Long Id, String Name, String Color) {
        this.Id = Id;
        this.Name = Name;
        this.Color = Color;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getColor() {
        return this.Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public Fruit Id(Long Id) {
        setId(Id);
        return this;
    }

    public Fruit Name(String Name) {
        setName(Name);
        return this;
    }

    public Fruit Color(String Color) {
        setColor(Color);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(Id, fruit.Id) && Objects.equals(Name, fruit.Name) && Objects.equals(Color, fruit.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Color);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", Name='" + getName() + "'" +
            ", Color='" + getColor() + "'" +
            "}";
    }
    
}
