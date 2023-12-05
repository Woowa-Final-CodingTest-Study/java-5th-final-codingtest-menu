package menu.domain;

import java.util.List;

public class ResultFormatter {
    public static String makeResultWithTitle(String title, List<String> element) {
        element.add(0, title);
        return "[ " + String.join(" | ", element) + " ]\n";

    }
}
