package menu.domain;

public enum DayOfWeek {
    MONDAY("월요일"), THUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일");

    private String label;

    DayOfWeek(String label) {
        this.label = label;
    }
}
