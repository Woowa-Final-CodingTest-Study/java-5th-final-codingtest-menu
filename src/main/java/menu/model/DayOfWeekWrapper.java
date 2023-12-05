package menu.model;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class DayOfWeekWrapper {
    public static List<DayOfWeek> weekDays() {
        return List.of(Arrays.copyOfRange(DayOfWeek.values(), 0, 5));
    }
}
