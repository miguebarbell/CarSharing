package carsharing;

public class Company {
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public int getID() {
		return ID;
	}

	private int ID;

	public Company(int ID, String companyName) {
		this.companyName = companyName;
		this.ID = ID;
	}
	public Company(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company{" +
				"companyName='" + companyName + '\'' +
				", ID=" + ID +
				'}';
	}
}
