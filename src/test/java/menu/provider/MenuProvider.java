package menu.provider;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import menu.constant.ErrorMessage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MenuProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        String coachNames = "구구,제임스";
        return Stream.of(
                arguments(ErrorMessage.MENU_COUNT_OUT_OF_RANGE, new String[]{coachNames, "김밥,깐풍기,그라탱", "떡볶이"}),
                arguments(ErrorMessage.MENU_NOT_EXIST, new String[]{coachNames, "김밥", "떡볶이,만두"}),
                arguments(ErrorMessage.MENU_DUPLICATED, new String[]{coachNames, "김밥,김밥", "떡볶이"})
        );
    }
}
