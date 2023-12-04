package menu.constant;

public enum MenuCategory {

    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINE("중식", 3),
    ASIAN("아시안", 4),
    WEST("양식", 5);

    private final String category;
    private final int categoryNumber;

    MenuCategory(String category, int categoryNumber) {
        this.category = category;
        this.categoryNumber = categoryNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }
}
