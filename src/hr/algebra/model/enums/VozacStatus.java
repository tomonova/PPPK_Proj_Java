package hr.algebra.model.enums;

public enum VozacStatus {
    AKTIVAN(1),
    NEAKTIVAN(2);
    
    private final int vozacStatus;

    public int getVozacStatus() {
        return vozacStatus;
    }

    private VozacStatus(int vozacStatus) {
        this.vozacStatus = vozacStatus;
    }
}
