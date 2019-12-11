

	//Creation of getters and setters
	public static Dbconnection getTotalF() {
		return totalF;
	}

	public static void setTotalF(Dbconnection totalF) {
		Dbconnection.totalF = totalF;
	}

	public static Float getT_fees() {
		return t_fees;
	}

	public static void setT_fees(Float t_fees) {
		Dbconnection.t_fees = t_fees;
	}

	public static Float getMin_fees() {
		return min_fees;
	}

	public static void setMin_fees(Float min_fees) {
		Dbconnection.min_fees = min_fees;
	}

	public static String getMail() {
		return mail;
	}

	public static void setMail(String mail) {
		Dbconnection.mail = mail;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Dbconnection.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Dbconnection.id = id;
	}

	//Constructor with the arguments that the list contains
	public Dbconnection(Float t_fees, Float min_fees, String mail, String name, int id) {
		Dbconnection.t_fees = t_fees;
		Dbconnection.min_fees = min_fees;
		Dbconnection.mail = mail;
		Dbconnection.name = name;
		Dbconnection.id = id;
		totalFees.add(this);
	}

	//default constructor
	public Dbconnection() {

	}

}
