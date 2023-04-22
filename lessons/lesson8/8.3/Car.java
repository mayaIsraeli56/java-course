public class Car {
	private int _carNum;
	private int _ownerId;
	public Car(int carNum, int ownerId) {
		_carNum = carNum;
		_ownerId = ownerId;
	}


	public boolean equals(Object obj ) {
		if (!(obj instanceof  Car ))
			return false ;
		

                Car  c = (Car ) obj;
		return (_carNum == c._carNum  && 

                        _ownerId  == c._ownerId);
	}


	public String  toString () {
		return "Car number: " +_carNum  + 

                       ", owner id: " + _ownerId ;
	}
}