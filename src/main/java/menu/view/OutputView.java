package menu.view;

import menu.constant.message.SystemMessage;

public class OutputView {

    public void printStartRecommend() {
        System.out.println(SystemMessage.START_RECOMMEND);
    }

    public void printInputCoachNamesPrompt() {
        System.out.println(SystemMessage.INPUT_COACH_NAMES);
    }

    public void printInputCannotEatPrompt(String coach) {
        System.out.printf(SystemMessage.INPUT_CANNOT_EAT, coach);
    }

    public void printCommendResult(StringBuilder result) {
        System.out.println(SystemMessage.MENU_COMMEND_RESULT);
        System.out.println(result);
        System.out.println(SystemMessage.FINISH_RECOMMEND);
    }
}
