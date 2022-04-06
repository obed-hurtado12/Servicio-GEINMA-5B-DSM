package mx.edu.utez.GEINMA.role.controller;

public class RoleDTO {

    private long id;
    private String description;

    public RoleDTO() {
    }

    public RoleDTO(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
