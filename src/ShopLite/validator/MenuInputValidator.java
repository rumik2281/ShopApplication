package ShopLite.validator;

public class MenuInputValidator {

    public boolean isChoiceCorrect(int choice, int leftBorder, int rightBorder) {
        return choice >= leftBorder && choice <= rightBorder;
    }

}
