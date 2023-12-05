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
}
