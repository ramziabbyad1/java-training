public class CarApp {

	public static void main(String[] args) {
		//
		Car car = new Car();
		car.setName("Volvo");
		car.setVehicleId(0);
		car.setEngineStatus(Car.EngineStatus.ON);
		car.setCurrentSpeed(10);
		car.accelerate();
		car.accelerate();
		System.out.println(car);
		car.decelerate();
		car.decelerate();
		System.out.println(car);
		car.accelerate(100);
		System.out.println(car);
		car.accelerate(10);
		System.out.println(car);
		car.accelerate(30);
		System.out.println(car);
		car.accelerate();
		System.out.println(car);
		car.decelerate();
		System.out.println(car);
		car.decelerate(150);
		System.out.println(car);
		car.accelerate();
		System.out.println(car);
		car.setEngineStatus(Car.EngineStatus.OFF);
		System.out.println(car);
		car.accelerate();
		System.out.println(car);
		car.decelerate();
		System.out.println(car);
		
		Car car2 = new Car("Ferrari", 0, Car.EngineStatus.ON);
		System.out.println(car2);
		System.out.println("VehicleId: " + car2.getVehicleId());
		car2.decelerate();
		System.out.println(car2);
		car2.decelerate(20);
		Car car3 = new Car("Ferrari", 0, Car.EngineStatus.ON);
		System.out.println(car3.getVehicleId());
	}

}
