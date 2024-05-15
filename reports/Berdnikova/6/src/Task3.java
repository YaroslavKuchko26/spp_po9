interface ButtonStrategy {
    void onClick();
}

class Button {
    private ButtonStrategy strategy;

    public Button(ButtonStrategy strategy) {
        this.strategy = strategy;
    }

    public void onClick() {
        strategy.onClick();
    }

    public void setStrategy(ButtonStrategy strategy) {
        this.strategy = strategy;
    }
}

class DigitButtonClick implements ButtonStrategy {
    private int digit;

    public DigitButtonClick(int digit) {
        this.digit = digit;
    }

    @Override
    public void onClick() {
        System.out.println("Нажата цифровая кнопка: " + digit);
    }
}

class AdditionButtonClick implements ButtonStrategy {
    @Override
    public void onClick() {
        System.out.println("Нажата кнопка сложения");
    }
}

class SubtractionButtonClick implements ButtonStrategy {
    @Override
    public void onClick() {
        System.out.println("Нажата кнопка вычитания");
    }
}

class MultiplicationButtonClick implements ButtonStrategy {
    @Override
    public void onClick() {
        System.out.println("Нажата кнопка умножения");
    }
}

class DivisionButtonClick implements ButtonStrategy {
    @Override
    public void onClick() {
        System.out.println("Нажата кнопка деления");
    }
}

class CustomButton {
    private ButtonStrategy strategy;

    public CustomButton() {
        this.strategy = () -> {
            System.out.println("Действие по умолчанию");
        };
    }

    public void setStrategy(ButtonStrategy strategy) {
        this.strategy = strategy;
    }

    public void onClick() {
        strategy.onClick();
    }
}

public class Task3 {
    public static void main(String[] args) {
        Button digitButton = new Button(new DigitButtonClick(5));
        Button additionButton = new Button(new AdditionButtonClick());
        digitButton.onClick();
        additionButton.onClick();

        CustomButton customButton = new CustomButton();
        customButton.onClick();
        customButton.setStrategy(() -> System.out.println("Новое действие"));
        customButton.onClick();
    }
}