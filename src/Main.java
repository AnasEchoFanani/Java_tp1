import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EtudiantMetier etudiantMetier = new EtudiantMetier();

        boolean continuer = true;
        while (continuer) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Sélectionner un étudiant par ID");
            System.out.println("3. Sélectionner tous les étudiants");
            System.out.println("4. Sélectionner les étudiants par filière");
            System.out.println("5. Sélectionner les étudiants par matricule");
            System.out.println("6. Supprimer un étudiant");
            System.out.println("7. Modifier un étudiant");
            System.out.println("8. Quitter");

            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choix) {
                case 1:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Matricule: ");
                    String matricule = scanner.nextLine();
                    System.out.print("Filière: ");
                    String filiere = scanner.nextLine();
                    Etudiant etudiant = new Etudiant(nom, prenom, matricule, filiere);
                    etudiantMetier.ajouterEtudiant(etudiant);
                    System.out.println("Étudiant ajouté.");
                    break;
                case 2:
                    System.out.print("ID de l'étudiant: ");
                    int id = scanner.nextInt();
                    Etudiant etudiantSelectionne = etudiantMetier.selectionnerEtudiantParId(id);
                    if (etudiantSelectionne != null) {
                        System.out.println(etudiantSelectionne);
                    } else {
                        System.out.println("Aucun étudiant trouvé avec cet ID.");
                    }
                    break;
                case 3:
                    System.out.println("Liste des étudiants:");
                    for (Etudiant etud : etudiantMetier.selectionnerTousLesEtudiants()) {
                        System.out.println(etud);
                    }
                    break;
                case 4:
                    System.out.print("Filière: ");
                    String filiereSelection = scanner.nextLine();
                    System.out.println("Liste des étudiants de la filière " + filiereSelection + ":");
                    for (Etudiant etud : etudiantMetier.selectionnerEtudiantsParFiliere(filiereSelection)) {
                        System.out.println(etud);
                    }
                    break;
                case 5:
                    System.out.print("Début du matricule: ");
                    String debutMatricule = scanner.nextLine();
                    System.out.println("Liste des étudiants avec matricule commençant par " + debutMatricule + ":");
                    for (Etudiant etud : etudiantMetier.selectionnerEtudiantsParMatricule(debutMatricule)) {
                        System.out.println(etud);
                    }
                    break;
                case 6:
                    System.out.print("ID de l'étudiant à supprimer: ");
                    int idSuppression = scanner.nextInt();
                    etudiantMetier.supprimerEtudiant(idSuppression);
                    System.out.println("Étudiant supprimé.");
                    break;
                case 7:
                    System.out.print("ID de l'étudiant à modifier: ");
                    int idModification = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    Etudiant etudiantModifie = etudiantMetier.selectionnerEtudiantParId(idModification);
                    if (etudiantModifie != null) {
                        System.out.print("Nouveau nom: ");
                        etudiantModifie.setNom(scanner.nextLine());
                        System.out.print("Nouveau prénom: ");
                        etudiantModifie.setPrenom(scanner.nextLine());
                        System.out.print("Nouveau matricule: ");
                        etudiantModifie.setMatricule(scanner.nextLine());
                        System.out.print("Nouvelle filière: ");
                        etudiantModifie.setFiliere(scanner.nextLine());
                        etudiantMetier.modifierEtudiant(etudiantModifie);
                        System.out.println("Étudiant modifié.");
                    } else {
                        System.out.println("Aucun étudiant trouvé avec cet ID.");
                    }
                    break;
                case 8:
                    continuer = false;
                    System.out.println("Merci, au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }

            if (continuer) {
                System.out.print("Voulez-vous continuer ? (O/N) ");
                String reponse = scanner.nextLine();
                if (!reponse.equalsIgnoreCase("O")) {
                    continuer = false;
                }
            }
        }

        scanner.close();
    }
}