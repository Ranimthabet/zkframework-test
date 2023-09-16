
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car(1, "Camry", "Toyota", "preview1.jpg", "Description 1", 25000));
        cars.add(new Car(2, "Civic", "Honda", "preview2.jpg", "Description 2", 23000));
        cars.add(new Car(3, "Mustang", "Ford", "preview3.jpg", "Description 3", 35000));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public List<Car> search(String keyword) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().toLowerCase().contains(keyword.toLowerCase()) ||
                car.getMake().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(car);
            }
        }
        return result;
    }
}
