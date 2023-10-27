package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		asterix = new Gaulois("Asterix", 50);
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] nomVillageois = {"Abraracourcix","Asterix"};
		for (int i = 0; i < nomVillageois.length; i++) {
			assertEquals(nomVillageois[i], controlAfficherVillage.donnerNomsVillageois()[i]);
		}
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
		assertNotEquals("Toulouse", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
		assertNotEquals(6, controlAfficherVillage.donnerNbEtals());
	}

}
