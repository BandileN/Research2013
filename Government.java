import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Government {
	float sugar; //total sugar held by the government
	float spice; //total spice held bythe government
	float flat_tax_rate; //flat tax rate taken from each citizen
	
	/*
	 * Constructor method for government entity
	 */
	public Government(){
		this.sugar = 0;
		this.spice = 0;
		this.flat_tax_rate = 0.1f;
	}
	
	public void Flat_Taxation(Citizen taxpayer){
		float payerSU = taxpayer.getSugar(), payerSP = taxpayer.getSpice();
		//tax the sugar
		if (payerSU > GoLconst.FLAT_TAX_THRESHOLD_SU){
			this.sugar += (flat_tax_rate)*(payerSU);
			taxpayer.setSugar(payerSU-((flat_tax_rate)*(payerSU)));
		}
		//tax the spice
		if (payerSP > GoLconst.FLAT_TAX_THRESHOLD_SP){
			this.spice += (flat_tax_rate)*(payerSP);
			taxpayer.setSpice(payerSP-((flat_tax_rate)*(payerSP)));
		}
	}
	
	public void dynamic_taxation(Citizen taxpayer){
		float payerSU = taxpayer.getSugar(), payerSP = taxpayer.getSpice();
		float taxed_amount;
		//sugar taxation
		if (payerSU <= GoLconst.B1_MAX){
			this.sugar += (GoLconst.B1_TAX_RATE)*(payerSU);
			taxpayer.setSugar(payerSU -((GoLconst.B1_TAX_RATE)*(payerSU)));
		}else if ((GoLconst.B1_MAX < payerSU) && (payerSU <= GoLconst.B2_MAX)){
			taxed_amount = (GoLconst.B1_TAX_RATE)*(GoLconst.B1_MAX) + ((GoLconst.B2_TAX_RATE)*(payerSU - GoLconst.B1_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B2_MAX < payerSU) && (payerSU <= GoLconst.B3_MAX)){
			taxed_amount = (GoLconst.B2_TAX_RATE)*(GoLconst.B2_MAX) + ((GoLconst.B3_TAX_RATE)*(payerSU - GoLconst.B2_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B3_MAX < payerSU) && (payerSU <= GoLconst.B4_MAX)){
			taxed_amount = (GoLconst.B3_TAX_RATE)*(GoLconst.B3_MAX) + ((GoLconst.B4_TAX_RATE)*(payerSU - GoLconst.B3_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B4_MAX < payerSU) && (payerSU <= GoLconst.B5_MAX)){
			taxed_amount = (GoLconst.B4_TAX_RATE)*(GoLconst.B4_MAX) + ((GoLconst.B5_TAX_RATE)*(payerSU - GoLconst.B4_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if (GoLconst.B5_MAX < payerSU){
			taxed_amount = (GoLconst.B5_TAX_RATE)*(GoLconst.B5_MAX) + ((GoLconst.B6_TAX_RATE)*(payerSU - GoLconst.B5_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}
		
		//spice taxation
		if (payerSP <= GoLconst.B1_MAX){
			this.sugar += (GoLconst.B1_TAX_RATE)*(payerSP);
			taxpayer.setSpice(payerSP -((GoLconst.B1_TAX_RATE)*(payerSP)));
		}else if ((GoLconst.B1_MAX < payerSP) && (payerSP <= GoLconst.B2_MAX)){
			taxed_amount = (GoLconst.B1_TAX_RATE)*(GoLconst.B1_MAX) + ((GoLconst.B2_TAX_RATE)*(payerSP - GoLconst.B1_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B2_MAX < payerSP) && (payerSP <= GoLconst.B3_MAX)){
			taxed_amount = (GoLconst.B2_TAX_RATE)*(GoLconst.B2_MAX) + ((GoLconst.B3_TAX_RATE)*(payerSP - GoLconst.B2_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B3_MAX < payerSP) && (payerSP <= GoLconst.B4_MAX)){
			taxed_amount = (GoLconst.B3_TAX_RATE)*(GoLconst.B3_MAX) + ((GoLconst.B4_TAX_RATE)*(payerSP - GoLconst.B3_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B4_MAX < payerSP) && (payerSP <= GoLconst.B5_MAX)){
			taxed_amount = (GoLconst.B4_TAX_RATE)*(GoLconst.B4_MAX) + ((GoLconst.B5_TAX_RATE)*(payerSP - GoLconst.B4_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if (GoLconst.B5_MAX < payerSP){
			taxed_amount = (GoLconst.B5_TAX_RATE)*(GoLconst.B5_MAX) + ((GoLconst.B6_TAX_RATE)*(payerSP - GoLconst.B5_MAX));
			this.sugar += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}
	}
	
	public void equal_distribution(List<Citizen> zenlist){
		float current_sugar, current_spice;
		int current_population = zenlist.size();
		float sugar_share = sugar/current_population;
		float spice_share = spice/current_population;
		for (int i = 0; i < current_population; i++){
			current_sugar = zenlist.get(i).getSugar();
			current_spice = zenlist.get(i).getSpice();
			zenlist.get(i).setSugar(current_sugar + sugar_share);
			zenlist.get(i).setSpice(current_spice + spice_share);
		}
	}
	
	public void flattax_LB(){
		
	}
	public void dynamictax_LB(){
		
	}
	public static void calculate_Gini(List<Citizen> zenlist){
		int pop = zenlist.size();
		List<Float> ordered_SU, ordered_SP;
		ordered_SU = new ArrayList<Float>();
		ordered_SP = new ArrayList<Float>();
		for (int j = 0 ; j<pop ; j++){
			
			ordered_SU.add(zenlist.get(j).getSugar());
			ordered_SP.add(zenlist.get(j).getSpice());
		}
		Collections.sort(ordered_SU);
		Collections.sort(ordered_SP);
		float num_sum_SU = 0f, den_sum_SU = 0f, num_sum_SP = 0f, den_sum_SP = 0f;
		for (int i = 1; i<=pop ; i++){
			num_sum_SU += (pop + 1f - i)*ordered_SU.get(i-1);
			num_sum_SP += (pop + 1f - i)*ordered_SP.get(i-1);
			
			den_sum_SU += ordered_SU.get(i-1);
			den_sum_SP += ordered_SP.get(i-1);
		}
		GoLconst.GINI_SUGAR = (float) (1f/pop)*(pop + 1f - (2f*(num_sum_SU/den_sum_SU)));
		GoLconst.GINI_SPICE = (float) (1f/pop)*(pop + 1f - (2f*(num_sum_SP/den_sum_SP)));
	}
}
