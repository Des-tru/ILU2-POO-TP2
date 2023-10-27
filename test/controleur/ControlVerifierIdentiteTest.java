package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
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
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
