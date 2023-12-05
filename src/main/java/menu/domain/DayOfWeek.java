package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DayOfWeek {
    MONDAY("월요일"), THUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일");

    private String label;

    DayOfWeek(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static String getDayOfWeekArrange() {
        List<String> days = Arrays.stream(DayOfWeek.values()).
                map(DayOfWeek::getLabel).collect(Collectors.toList());
        return ResultFormatter.makeResultWithTitle("요일", days);
    }
}
