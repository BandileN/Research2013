import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Government {
	static float sugar = 0; //total sugar held by the government
	static float spice = 0; //total spice held bythe government
	
	/*
	 * Constructor method for government entity
	 */
	public Government(){
		sugar = 0;
		spice = 0;
	}
	
	public static void Flat_Taxation(Citizen taxpayer){
		float payerSU = taxpayer.getSugar(), payerSP = taxpayer.getSpice();
		//tax the sugar
		if (payerSU > GoLconst.FLAT_TAX_THRESHOLD_SU){
			sugar += (GoLconst.FLAT_TAX_RATE)*(payerSU);
			taxpayer.setSugar(payerSU-((GoLconst.FLAT_TAX_RATE)*(payerSU)));
		}
		//tax the spice
		if (payerSP > GoLconst.FLAT_TAX_THRESHOLD_SP){
			spice += (GoLconst.FLAT_TAX_RATE)*(payerSP);
			taxpayer.setSpice(payerSP-((GoLconst.FLAT_TAX_RATE)*(payerSP)));
		}
	}
	
	public static void Dynamic_taxation(Citizen taxpayer){
		float payerSU = taxpayer.getSugar(), payerSP = taxpayer.getSpice();
		float taxed_amount;
		//sugar taxation
		if (payerSU <= GoLconst.B1_MAX){
			sugar += (GoLconst.B1_TAX_RATE)*(payerSU);
			taxpayer.setSugar(payerSU -((GoLconst.B1_TAX_RATE)*(payerSU)));
		}else if ((GoLconst.B1_MAX < payerSU) && (payerSU <= GoLconst.B2_MAX)){
			taxed_amount = (GoLconst.B1_TAX_RATE)*(GoLconst.B1_MAX) + ((GoLconst.B2_TAX_RATE)*(payerSU - GoLconst.B1_MAX));
			sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B2_MAX < payerSU) && (payerSU <= GoLconst.B3_MAX)){
			taxed_amount = (GoLconst.B2_TAX_RATE)*(GoLconst.B2_MAX) + ((GoLconst.B3_TAX_RATE)*(payerSU - GoLconst.B2_MAX));
			sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B3_MAX < payerSU) && (payerSU <= GoLconst.B4_MAX)){
			taxed_amount = (GoLconst.B3_TAX_RATE)*(GoLconst.B3_MAX) + ((GoLconst.B4_TAX_RATE)*(payerSU - GoLconst.B3_MAX));
			sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if ((GoLconst.B4_MAX < payerSU) && (payerSU <= GoLconst.B5_MAX)){
			taxed_amount = (GoLconst.B4_TAX_RATE)*(GoLconst.B4_MAX) + ((GoLconst.B5_TAX_RATE)*(payerSU - GoLconst.B4_MAX));
			sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}else if (GoLconst.B5_MAX < payerSU){
			taxed_amount = (GoLconst.B5_TAX_RATE)*(GoLconst.B5_MAX) + ((GoLconst.B6_TAX_RATE)*(payerSU - GoLconst.B5_MAX));
			sugar += taxed_amount;
			taxpayer.setSugar(payerSU - taxed_amount);
		}
		
		//spice taxation
		if (payerSP <= GoLconst.B1_MAX){
			spice += (GoLconst.B1_TAX_RATE)*(payerSP);
			taxpayer.setSpice(payerSP -((GoLconst.B1_TAX_RATE)*(payerSP)));
		}else if ((GoLconst.B1_MAX < payerSP) && (payerSP <= GoLconst.B2_MAX)){
			taxed_amount = (GoLconst.B1_TAX_RATE)*(GoLconst.B1_MAX) + ((GoLconst.B2_TAX_RATE)*(payerSP - GoLconst.B1_MAX));
			spice += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B2_MAX < payerSP) && (payerSP <= GoLconst.B3_MAX)){
			taxed_amount = (GoLconst.B2_TAX_RATE)*(GoLconst.B2_MAX) + ((GoLconst.B3_TAX_RATE)*(payerSP - GoLconst.B2_MAX));
			spice += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B3_MAX < payerSP) && (payerSP <= GoLconst.B4_MAX)){
			taxed_amount = (GoLconst.B3_TAX_RATE)*(GoLconst.B3_MAX) + ((GoLconst.B4_TAX_RATE)*(payerSP - GoLconst.B3_MAX));
			spice += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if ((GoLconst.B4_MAX < payerSP) && (payerSP <= GoLconst.B5_MAX)){
			taxed_amount = (GoLconst.B4_TAX_RATE)*(GoLconst.B4_MAX) + ((GoLconst.B5_TAX_RATE)*(payerSP - GoLconst.B4_MAX));
			spice += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}else if (GoLconst.B5_MAX < payerSP){
			taxed_amount = (GoLconst.B5_TAX_RATE)*(GoLconst.B5_MAX) + ((GoLconst.B6_TAX_RATE)*(payerSP - GoLconst.B5_MAX));
			spice += taxed_amount;
			taxpayer.setSpice(payerSP - taxed_amount);
		}
	}
	
	public static void equal_distribution(List<Citizen> zenlist){
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
		sugar = 0f;
		spice = 0f;
		
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
		//will be averaged and shown after 500 cycles
		GoLconst.GINI_SUM_SU += GoLconst.GINI_SUGAR;
		GoLconst.GINI_SUM_SP += GoLconst.GINI_SPICE;
	}
}
