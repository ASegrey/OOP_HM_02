package home_made_02;

public abstract class Vehicle {
    private int id;         //(уникальный идентификатор)
    private String brand;   //(марка)
    private String model;   //(модель)
    private int year;       //(год выпуска)
    /**
     * 
     * @param id уникальный идентификатор
     * @param brand марка
     * @param model модель
     * @param year год выпуска
     */
    public Vehicle(int id, String brand, String model, int year){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    //    Методы:
    public abstract void startEngine();          // запуск двигателя (реализация в подклассах).
    public abstract void stopEngine();           // остановка двигателя (реализация в подклассах).
    public abstract void accelerate(int speed);  // увеличение скорости на указанное значение (реализация в подклассах).
    public abstract void brake();                // прекращение движения (реализация в подклассах).
    public abstract void displayInfo();          // вывод информации о транспортном средстве (реализация в подклассах).
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
