
import org.zkoss.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarViewModel {

    private String keyword;
    private List<Car> carList;
    private Car selectedCar;
    private int totalSum;

    @Init
    public void init() {
        carList = new ArrayList<>();
        carList.add(new Car(1, "Model A", "Make X", "previewA.jpg", "Description A", 20000));
        carList.add(new Car(2, "Model B", "Make Y", "previewB.jpg", "Description B", 25000));
        carList.add(new Car(3, "Model C", "Make Z", "previewC.jpg", "Description C", 30000));
        totalSum = carList.stream().mapToInt(Car::getPrice).sum();
    }


    @Command
    @NotifyChange("carList")
    public void search() {
        carList = carList.stream()
            .filter(car -> car.getModel().toLowerCase().contains(keyword.toLowerCase())
                || car.getMake().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
    }

    @Command
    @NotifyChange("carList")
    public void sortByModel() {
        carList.sort(Comparator.comparing(Car::getModel));
    }

    @Command
    @NotifyChange("carList")
    public void sortByMake() {
        carList.sort(Comparator.comparing(Car::getMake));
    }

    @Command
    @NotifyChange("carList")
    public void sortByPrice() {
        carList.sort(Comparator.comparing(Car::getPrice));
    }

    @Command
    @NotifyChange({"carList", "totalSum"})
    public void buyCar() {
        if (selectedCar != null) {
            totalSum -= selectedCar.getPrice();
            carList.remove(selectedCar);
            selectedCar = null;
        }
    }
}
