package fit.core;

public class IrpfCalculator {
	private static final double VALOR_DE_ISENCAO = 1903.98;

	public static double calculateBaseSalary(double totalSalary) {

		return totalSalary - (totalSalary * 0.11);
	}

	public static double calculateExemption() {

		return VALOR_DE_ISENCAO;
	}

	public static double calculateTaxLayer(double baseSalary) {
		if (baseSalary < 1903.98)
			return 0;
		if (baseSalary >= 1903.99 && baseSalary <= 2826.65)
			return 0.075;
		if (baseSalary >= 2826.66 && baseSalary <= 3751.05)
			return 0.15;
		if (baseSalary >= 3751.06 && baseSalary <= 4664.68)
			return 0.0225;
		if (baseSalary > 4664.68)
			return 0.275;
		return baseSalary;
	}

	public static double calculateDiscount(double baseSalary) {
		return baseSalary - VALOR_DE_ISENCAO;
	}

	public static double calculateIrpf(double totalSalary) {
		var baseSalary = calculateBaseSalary(totalSalary);
		var desconto = calculateDiscount(baseSalary);
		var taxa = calculateTaxLayer(baseSalary);
		var irpf = desconto * taxa;
		
		return irpf;

	}
}
