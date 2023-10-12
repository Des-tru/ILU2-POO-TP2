package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Quel est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		int effetPotionMax = -1;
		int effetPotionMin = -2;
		do {
			StringBuilder questionPotionMin = new StringBuilder();
			questionPotionMin.append("Quel est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMin = Clavier.entrerEntier(questionPotionMin.toString());
			StringBuilder questionPotionMax = new StringBuilder();
			questionPotionMax.append("Quel est la force de potion la plus forte que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier(questionPotionMax.toString());
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum\n");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		
	}
}

