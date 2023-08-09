import java.util.ArrayList;
import java.util.List;

public class EtudiantMetier {
    private List<Etudiant> etudiants;

    public EtudiantMetier() {
        etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public Etudiant selectionnerEtudiantParId(int id) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null;
    }

    public List<Etudiant> selectionnerTousLesEtudiants() {
        return etudiants;
    }

    public List<Etudiant> selectionnerEtudiantsParFiliere(String filiere) {
        List<Etudiant> etudiantsFiliere = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getFiliere().equalsIgnoreCase(filiere)) {
                etudiantsFiliere.add(etudiant);
            }
        }
        return etudiantsFiliere;
    }

    public List<Etudiant> selectionnerEtudiantsParMatricule(String debutMatricule) {
        List<Etudiant> etudiantsMatricule = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule().startsWith(debutMatricule)) {
                etudiantsMatricule.add(etudiant);
            }
        }
        return etudiantsMatricule;
    }

    public void supprimerEtudiant(int id) {
        Etudiant etudiantASupprimer = null;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                etudiantASupprimer = etudiant;
                break;
            }
        }
        if (etudiantASupprimer != null) {
            etudiants.remove(etudiantASupprimer);
        }
    }

    public void modifierEtudiant(Etudiant etudiantModifie) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == etudiantModifie.getId()) {
                etudiant.setNom(etudiantModifie.getNom());
                etudiant.setPrenom(etudiantModifie.getPrenom());
                etudiant.setMatricule(etudiantModifie.getMatricule());
                etudiant.setFiliere(etudiantModifie.getFiliere());
                break;
            }
        }
    }
}
