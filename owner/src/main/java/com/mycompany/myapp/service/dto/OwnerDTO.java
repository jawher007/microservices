package com.mycompany.myapp.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Owner} entity.
 */
public class OwnerDTO implements Serializable {
    
    private Long id;

    private String name;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OwnerDTO)) {
            return false;
        }

        return id != null && id.equals(((OwnerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OwnerDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
