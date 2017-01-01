package ga.zcktn.kololok.resource.enums;

import java.util.Locale;

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
		switch (kuerzel.toUpperCase(Locale.GERMAN)) {
		default:
			return null;
		case "LAB1":
			return EnumChallenge.RealLabor1;
		case "SPY":
			return EnumChallenge.RealLabor2;
		case "SPYREADY":
			return EnumChallenge.RealLabor3;
		case "SM":
			return EnumChallenge.Leben;
		case "SWIMM":
			return EnumChallenge.LebenzuInsel;
		case "INSEL":
			return EnumChallenge.Insel;
		case "ZUG":
			return EnumChallenge.Heilanstalt;
		case "GUCK":
			return EnumChallenge.Freedom1;
		case "RODEO":
			return EnumChallenge.Desperado;
		}
	}
	
}
