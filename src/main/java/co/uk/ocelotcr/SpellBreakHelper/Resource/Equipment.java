package co.uk.ocelotcr.SpellBreakHelper.Resource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @Column(name = "effect")
    private String description;
    private String tier;
    private String type;

    public Equipment(String name, String description, String tier, String type) {
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.type = type;
    }

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tier='" + tier + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}


