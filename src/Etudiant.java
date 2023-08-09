public class Etudiant {
    private static int nextId = 1;
    private int id;
    private String nom;
    private String prenom;
    private String matricule;
    private String filiere;

    public Etudiant(String nom, String prenom, String matricule, String filiere) {
        this.id = nextId++;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.filiere = filiere;
    }

    public Etudiant(int id, String nom, String prenom, String matricule, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.filiere = filiere;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getFiliere() {
        return filiere;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String toString() {
        return "ID: " + id + "\nNom: " + nom + "\nPrénom: " + prenom + "\nMatricule: " + matricule + "\nFilière: " + filiere;
    }
}