package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CoachGroup {
    List<Coach> coaches;

    public CoachGroup(List<String> coaches) {
        this.coaches = coaches.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
