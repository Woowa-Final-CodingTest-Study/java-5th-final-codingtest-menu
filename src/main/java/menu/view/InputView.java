package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constant.NumberConstant;
import menu.constant.message.ErrorMessage;

public class InputView {

    public String inputNames() {
        String input = Console.readLine();
        validateInputName(input);
        return input;
    }

    public void validateInputName(String input){
        validateNull(input);
        validateSeparator(input);
        validateNameCharacterCount(input);
        validateNameCount(input);
    }

    public void validateNull(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.CHECK_INPUT_NULL);
        }
    }

    public void validateSeparator(String input) {
        String deleteSeparator = input.replaceAll("[0-9ㄱ-ㅎ가-힣a-zA-Z,]", "");
        if(!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CHECK_NAME_SEPARATOR);
        }
    }

    public void validateNameCharacterCount(String input) {
        String[] names = input.split(",");
        for(int i=0; i<names.length; i++){
            if(names[i].length() < NumberConstant.MIN_CHARACTER_LIMIT ||
                    names[i].length() > NumberConstant.MAX_CHARACTER_LIMIT) {
                throw new IllegalArgumentException(ErrorMessage.CHECK_NAME_CHARACTER_COUNT);
            }
        }
    }

    public void validateNameCount(String input) {
        String[] names = input.split(",");
        if(names.length < NumberConstant.MIN_NAME_COUNT_LIMIT || names.length > NumberConstant.MAX_NAME_COUNT_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CHECK_NAME_COUNT);
        }
    }
}
