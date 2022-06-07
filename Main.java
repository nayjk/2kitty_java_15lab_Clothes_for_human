enum ClothesSize{
    XXS(38){
        public String getDescription(){
            return "Детский размер.";
        }
    }, XS(40), S(42), M(46), L(50);
    private final int Eurosize;

    ClothesSize(int i) {
        Eurosize = i;
    }
    public String getDescription(){
        return "Взрослый размер.";
    }
    public String toString(){
        return name() + " (" + Eurosize + ") " + getDescription();
    }
}
interface ClothesOfMen{
    default void dressAMen(){
        System.out.println("Одеть мужчину.");
    }
}
interface ClothesOfWomen{
    default void dressAWomen(){
        System.out.println("Одеть девушку.");
    }
}
abstract class Clothes{
    private final ClothesSize size;
    private double price;
    private final String color;
    Clothes(ClothesSize size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public ClothesSize getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}
class Atelier{
    void dressAMan(Clothes[] clothes){
        System.out.println("Мужская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof ClothesOfMen){
                System.out.println(c);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("Женская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof ClothesOfWomen){
                System.out.println(c);
            }
        }
    }
    public static class TShirt extends Clothes implements ClothesOfMen, ClothesOfWomen{
        TShirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }
        public String toString() {
            return "\n" + "Размер футболки " + getSize() + "\n" + "Цена: " + getPrice() + "\n" + "Цвет: " + getColor();
        }
    }
    public static class Trousers extends Clothes implements ClothesOfMen, ClothesOfWomen{
        Trousers(ClothesSize size, String color, double price){
            super(size, color, price);
        }
        public String toString() {
            return "\n" + "Размер штанов " + getSize() + "\n" + "Цена: " + getPrice() + "\n" + "Цвет: " + getColor();
        }
    }
    public static class Skirt extends Clothes implements ClothesOfWomen{
        Skirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }
        public String toString() {
            return "\n" + "Размер юбки " + getSize() + "\n" + "Цена: " + getPrice() + "\n" + "Цвет: " + getColor();
        }
    }
    public static class Tie extends Clothes implements ClothesOfMen{
        Tie(ClothesSize size, String color, double price){
            super(size, color, price);
        }
        public String toString() {
            return  "\n" + "Размер галстука " + getSize() + "\n" + "Цена: " + getPrice() + "\n" + "Цвет: " + getColor();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Atelier.TShirt(ClothesSize.M, "Синий", 150),
                new Atelier.TShirt(ClothesSize.S, "Синий", 150),
                new Atelier.Trousers(ClothesSize.XXS, "Синий", 5000),
                new Atelier.Trousers(ClothesSize.M, "Синий", 5000),
                new Atelier.Skirt(ClothesSize.XS, "Синий", 1000),
                new Atelier.Skirt(ClothesSize.L, "Синий", 1000),
                new Atelier.Tie(ClothesSize.XS, "Синий", 500),
                new Atelier.Tie(ClothesSize.XXS, "Синий", 500),
        };
        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        System.out.println();
        atelier.dressAWoman(clothes);
    }
}