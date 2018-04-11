import java.util.List;

public class Bill {


	private float amount_paid;
	private String paidBy;
	private List<String> toBeDividedInto;
	private String billDate;
	
	public Bill(float amount_paid, String paidBy, List<String> toBeDividedInto, String billDate) {
		this.amount_paid = amount_paid;
		this.paidBy = paidBy;
		this.toBeDividedInto = toBeDividedInto;
		this.billDate = billDate;
		
	}
	
	public float getAmount_paid() {
		return amount_paid;
	}
	public String getPaidBy() {
		return paidBy;
	}

	public List<String> getToBeDividedInto() {
		return toBeDividedInto;
	}
	public String getBillDate(){
		return billDate;
	}
	
	@Override
	public String toString() {
		return "Total amount paid = " + amount_paid + "\t Payer = " + paidBy + "\t Splitted into = " + toBeDividedInto
				+ "\t Bill detail = " + billDate;
	}

}
