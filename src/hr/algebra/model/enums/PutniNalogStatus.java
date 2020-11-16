package hr.algebra.model.enums;

public enum PutniNalogStatus {
    ZATVOREN(1),
    OTVOREN(2),
    BUDUCI(3);
    
    private final int PutniNalogStatus;

    private PutniNalogStatus(int PutniNalogStatus) {
        this.PutniNalogStatus = PutniNalogStatus;
    }

    public int getPutniNalogStatus() {
        return PutniNalogStatus;
    }
}
