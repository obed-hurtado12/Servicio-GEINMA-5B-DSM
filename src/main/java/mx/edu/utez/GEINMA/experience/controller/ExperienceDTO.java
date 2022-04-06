package mx.edu.utez.GEINMA.experience.controller;

public class ExperienceDTO {
    private long id;
    private String description;
    private int score;

    public ExperienceDTO() {
    }

    public ExperienceDTO(long id, String description, int score) {
        this.id = id;
        this.description = description;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
