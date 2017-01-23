package ga.zcktn.kololok.resource.enums;

public enum EnumChallenge {

	RealLabor1("LAB1"),
	RealLabor2("Spy"),
	RealLabor3("Spyready"),
	Leben("SM"),
	LebenzuInsel("schwimm"),
	Insel("Insel"),
	Varo3("Varo"),
	Heilanstalt("Zug"),
	Freedom1("guck"),
	Desperado("Rodeo");
	
	String kuerzel;
	
	EnumChallenge(String kuerzel){
		this.kuerzel = kuerzel;
	}
	
	public String getKuerzel(){
		return kuerzel;
	}
	
	public EnumChallenge getbyKuerzel(String kuerzel){
		if(kuerzel.toUpperCase().equals("LAB1")) {
			return EnumChallenge.RealLabor1;
		}
		if(kuerzel.toUpperCase().equals("SPY")) {
			return EnumChallenge.RealLabor2;
		}
		if(kuerzel.toUpperCase().equals("SPYREADY")) {
			return EnumChallenge.RealLabor3;
		}
		if(kuerzel.toUpperCase().equals("SM")) {
			return EnumChallenge.Leben;
		}
		if(kuerzel.toUpperCase().equals("INSEL")) {
			return EnumChallenge.LebenzuInsel;
		}
		if(kuerzel.toUpperCase().equals("VARO")) {
			return EnumChallenge.Insel;
		}
		if(kuerzel.toUpperCase().equals("ZUG")) {
			return EnumChallenge.Heilanstalt;
		}
		if(kuerzel.toUpperCase().equals("GUCK")) {
			return EnumChallenge.Freedom1;
		}
		if(kuerzel.toUpperCase().equals("RODEO")) {
			return EnumChallenge.Desperado;
		}
		return null;
	}
	
}
