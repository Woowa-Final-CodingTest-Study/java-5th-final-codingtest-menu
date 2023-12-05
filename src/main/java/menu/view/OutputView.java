package menu.view;

public class OutputView {
    public void printStartManager() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printEndManager() {
        System.out.println("추천을 완료했습니다.");
    }

    public void requestCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void requestHateFood(String name) {
        System.out.printf("%s가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printSelectionResult(String days, String categorys, String selectionResult) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(days + categorys + selectionResult);
    }
}
