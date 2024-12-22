package bsu.rfe.java.group9.lab1.Marozau.varA10;

public class Lemonade extends Food {

    private String taste;

    public Lemonade(String taste) {
        super("Lemonade");
        this.setTaste(taste);
    }
    public void consume() {
        System.out.println(this + " was drunk");
    }
    // Селектор для доступа к полю данных ВКУС
    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        if (taste.equals("strawberry") || taste.equals("chocolate") || taste.equals("vanilla")) {
            this.taste = taste;
        } else throw new IllegalArgumentException("Incorrect taste. Tastes are 'strawberry', 'chocolate', 'vanilla'.");
    }
    // Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Lemonade)) return false; // Шаг 2
            return taste.equals(((Lemonade)arg0).taste); // Шаг 3
        } else
            return false;
    }
    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " taste '" + taste.toUpperCase() + "'";
    }
}

