import controller.ChickenHouseController;
import service.ChickenHouseService;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        ChickenHouseController chickenHouseController = new ChickenHouseController(new ChickenHouseService());
        chickenHouseController.run();
    }
}
