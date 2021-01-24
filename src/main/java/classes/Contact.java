package classes;

public class Contact {
  
  private int idContact;
  private static int idCounter = 1;
  private Lead lead;
  
  public Contact() {
    this.idContact = Contact.idCounter++;
    this.lead = lead;
  }
  
  public int getIdContact() {
    return idContact;
  }
  
  public void setIdContact() {
    this.idContact = idContact;
  }

  public Lead getLead() {
    return lead;
  }

  public void setLead(Lead lead) {
    this.lead = lead;
  }
  
  @Override
  public String toString() {
    return "Contact{" +
        "idContact=" + idContact +
       ", lead=" + lead +
        '}';
  }
  
}
