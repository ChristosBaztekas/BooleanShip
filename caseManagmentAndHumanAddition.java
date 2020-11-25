package gr.projAboutCovid.leo.proj;

public interface caseManagmentAndHumanAddition {
	public void insertHumanToOrganisation(Human human);// αυτή η μέθοδος πρέπει να υλοποιηθεί σε ολα τα
	// <<παιδιά κλάσεις>>χρησιμοποιώντας την θα εισάγουμε
	// ανθρώπους στην
	// λίστα της κλάσης αλλά και στην allHuman της Human

	public void managementCases(Human anyH);

	public void declareCase();// αυτή η μέθοδος πρέπει να υλοποιηθεί σε ολα τα <<παιδιά κλάσεις>>
	// και θα υλοποιεί τα διάφορα πρωτόκολλα των οργανισμών
}
