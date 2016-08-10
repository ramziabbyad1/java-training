
class Car {
	private static int vehicleId;
	private String name;
	private int currentSpeed = 0;	
	public enum EngineStatus{
		ON,
		OFF
	}
	private EngineStatus engineStatus;
	public Car(){
		
	}
	public Car(final String name, final int currentSpeed, final EngineStatus engineStatus){
		vehicleId++;
		this.name = name;
		this.currentSpeed = currentSpeed;
		this.engineStatus = engineStatus;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(final int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(final int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public EngineStatus getEngineStatus() {
		return engineStatus;
	}
	public void setEngineStatus(final EngineStatus engineStatus) {
		this.engineStatus = engineStatus;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", currentSpeed=" + currentSpeed
				+ ", engineStatus=" + engineStatus + "]";
	}
	public void accelerate(){
		if(engineStatus == EngineStatus.ON && currentSpeed < 140){
			currentSpeed++;
		}
		if(currentSpeed >= 120){
			System.out.println("WARNING! VERY FAST!");
		}
	}
	public void accelerate(final int speed){
		if(engineStatus == EngineStatus.ON && currentSpeed < 140){
			currentSpeed += speed;
		}
		if(currentSpeed > 140){
			currentSpeed = 140;
		}
		if(currentSpeed >= 120){
			System.out.println("WARNING! VERY FAST!");
		}

	}
	public void decelerate(){
		if(engineStatus == EngineStatus.ON && currentSpeed > 0){
			currentSpeed--;
		}
	
	}
	public void decelerate(final int speed){
		if(engineStatus == EngineStatus.ON && currentSpeed >= 0){
			currentSpeed -= speed;
		}
		if(currentSpeed < 0){
			currentSpeed = 0;
		}
	
	}
	
	
	
	
	
}
