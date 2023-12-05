package menu.provider;

import menu.constant.ErrorMessage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

public class CoachNameProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(ErrorMessage.COACH_COUNT_OUT_OF_RANGE, "구구"),
                arguments(ErrorMessage.COACH_COUNT_OUT_OF_RANGE, "구구1,구구2,구구3,구구4,구구5,구구6"),
                arguments(ErrorMessage.COACH_NAME_LENGTH_OUT_OF_RANGE, "구,구구"),
                arguments(ErrorMessage.COACH_NAME_LENGTH_OUT_OF_RANGE, "구구,구구구구구"),
                arguments(ErrorMessage.COACH_DUPLICATED, "구구,구구")
        );
    }
}
