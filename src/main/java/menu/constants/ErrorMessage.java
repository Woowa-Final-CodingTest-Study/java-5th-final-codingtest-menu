package menu.constants;

import static menu.constants.SystemWords.MAX_HATE_FOOD_COUNT;
import static menu.constants.SystemWords.MAX_NAME_LENGTH;
import static menu.constants.SystemWords.MAX_NUMBER_COACH;
import static menu.constants.SystemWords.MIN_NAME_LENGTH;
import static menu.constants.SystemWords.MIN_NUMBER_COACH;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String NOT_EXIST_FOOD = ERROR + "존재하지 않는 메뉴입니다.";
    public static final String INCREASE_COACH_NUMBER = ERROR + "코치는 최소 "+MIN_NUMBER_COACH+"명 이상 입력해야 합니다.";
    public static final String REDUCE_COACH_NUMBER = ERROR + "코치는 최대 "+MAX_NUMBER_COACH+"명 이하로 입력해야 합니다.";
    public static final String HAVE_DUPLICATE_NAME = ERROR + "중복된 이름이 있습니다.";
    public static final String WRONG_NAME_FORMAT = ERROR + "각 이름은 한글 또는 영어 한자리 이상이어야 합니다";
    public static final String INCREASE_NAME_LENGTH = ERROR + "각 이름은 "+MIN_NAME_LENGTH+"글자 이상이어야 합니다.";
    public static final String REDUCE_NAME_LENGTH = ERROR + "각 이름은 "+MAX_NAME_LENGTH+"글자 이하이어야 합니다.";
    public static final String REDUCE_HATE_FOOD = ERROR + "못먹는 메뉴는 "+MAX_HATE_FOOD_COUNT+"가지 이하여야 합니다.";
    public static final String HAVE_DUPLICATE_FOOD = ERROR + "중복된 이름이 있습니다.";
}
