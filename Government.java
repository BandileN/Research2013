import java.util.Vector;

class Government{
	//Attributes of the Agent
	float sugarReserve;	//Amount of Sugar required to survive each round
	float sugar;		//Amount of Sugar currently left with citizen
	float govContribution;	//
	float taxedAmount;		

	public Government(){
		sugarReserve 	= 0;
		sugar		= 0f;
	}
	//Declare Getters and Setters of each attribute
	
	public synchronized void setsugarReserve(int metSugar){
		this.sugarReserve = metSugar;
	}
	public synchronized void setSugar(float sr){
		this.sugar = sr;
	}
	public float getSugar(){
		return this.sugar;
	}
	public synchronized void collectTax(Vector<Agent> list, float taxedAmount){
		/* This method collects tax in the form of sugar
		   and spice from citizen who have a sugar level
		   that is above a certain threshold e and adds
		   it to its own reserve to be distributed timeously.
		*/
		int len = list.size();
		float currentSugarValue;
		for(int i=0; i<len; i++){
			currentSugarValue = list.get(i).getSugar();
			list.get(i).setSugar(currentSugarValue - taxedAmount);
			this.sugarReserve = this.sugarReserve + taxedAmount;
		}
		
	}
	public synchronized void distributeRevenueToCitizen(Vector<Agent> list, float perc){
		/*This method takes a percentage of the
		  collected sugar, and distributes this sugar equally
		  amongst all the citizens in the environment who have reserves 
		  below a certain threshold e.
		*/
		float amount = sugarReserve*perc;
		int len = list.size();
		float currentSugarValue;
		govContribution = amount/len;
		for(int i=0; i<len; i++){
			currentSugarValue = list.get(i).getSugar();
			list.get(i).setSugar(currentSugarValue + govContribution);
		}
	
	}
}

