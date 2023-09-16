public class Car {
    private Integer id;
    private String model;
    private String make;
    private String preview;
    private String description;
    private Integer price;

    public Car() {
    }

    public Car(Integer id, String model, String make, String preview, String description, Integer price) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.preview = preview;
        this.description = description;
        this.price = price;
    }
}
