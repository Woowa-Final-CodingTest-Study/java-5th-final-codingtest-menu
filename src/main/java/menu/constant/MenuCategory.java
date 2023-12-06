package menu.constant;

public enum MenuCategory {

    JAPAN("일식", 1, 0),
    KOREA("한식", 2, 0),
    CHINE("중식", 3, 0),
    ASIAN("아시안", 4, 0),
    WEST("양식", 5, 0);

    private final String category;
    private final int categoryNumber;
    private int categoryCount;

    MenuCategory(String category, int categoryNumber, int categoryCount) {
        this.category = category;
        this.categoryNumber = categoryNumber;
        this.categoryCount = categoryCount;
    }

    public String getCategory() {
        return category;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public int getCategoryCount() {
        return categoryCount;
    }

    public void countCategory() {
        this.categoryCount++;
    }

    public static String findByCategory(int categoryNumber) {
        for (MenuCategory menuCategory : MenuCategory.values()) {
            if (menuCategory.categoryNumber == categoryNumber) {
                return menuCategory.getCategory();
            }
        }
        throw new IllegalArgumentException();
    }
}
