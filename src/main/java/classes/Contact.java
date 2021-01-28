package classes;

public class Contact extends Lead {

    private int idContact;
    private static int idCounter = 1;
    private Lead lead;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.idContact = idContact;
        this.lead = lead;
        idContact++;
    }

    public int getIdContact() {
        return idContact;
    }

    public Lead getLead() {
        return lead;
    }

    @Override
    public String toString() {
        return "Contact with id" + idContact +
                ", corresponds to lead: " + lead ;
    }

}
