package ru.job4j.professions;

public class Profession {
    private String name;
    private String position;
    private boolean healthy;
    private boolean compliance;
    private boolean trained;

    public Profession(String _name, String _position, boolean _healthy, boolean _compliance, boolean _trained) {
        this.name = _name;
        this.position = _position;
        this.healthy = _healthy;
        this.compliance = _compliance;
        this.trained = _trained;
    }

    public Profession() {

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public boolean isHealthy() {

        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isCompliance() {

        return compliance;
    }

    public void setCompliance(boolean compliance) {
        this.compliance = compliance;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
}
