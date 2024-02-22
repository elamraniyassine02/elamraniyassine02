package gestionemploye;

public class Employe {
    private String nom;
    private double salaire;
    private String dateEmbauche;
    private String employeeId;
    private double heuresTravaillees;
    private double tauxHoraire;
    private double bonus;

    // Constructor
    public Employe(String nom, double salaire, String dateEmbauche, String employeeId, double heuresTravaillees, double tauxHoraire) {
        this.nom = nom;
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
        this.employeeId = employeeId;
        this.heuresTravaillees = heuresTravaillees;
        this.tauxHoraire = tauxHoraire;
        // Calculate bonus and hourly rate based on employee type
        setBonusAndHourlyRate();
    }

    // Définit le taux horaire et le bonus en fonction du type d'employé
    private void setBonusAndHourlyRate() {
        // Switch statement to determine hourly rate and bonus based on employee type
        switch (employeeId) {
            case "directeur":
                this.tauxHoraire = 100.0;
                this.bonus = 500.0;
                break;
            case "secretaire":
                this.tauxHoraire = 75.0;
                this.bonus = 350.0;
                break;
            case "employe":
                this.tauxHoraire = 45.0;
                this.bonus = 220.0;
                break;
            default:
                // Valeurs par défaut pour un type non reconnu
                this.tauxHoraire = 0.0;
                this.bonus = 0.0;
                System.out.println("Type d'employé non reconnu");
        }
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getHours() {
        return heuresTravaillees;
    }

    public void setHours(double heuresTravaillees) {
        this.heuresTravaillees = heuresTravaillees;
    }

    public double getHourlyRate() {
        return tauxHoraire;
    }

    public void setHourlyRate(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getSalary() {
        return calculerSalaire();
    }

    // Méthode pour calculer le salaire total de l'employé
    public double calculerSalaire() {
        return (tauxHoraire * heuresTravaillees) + bonus;
    }
}
