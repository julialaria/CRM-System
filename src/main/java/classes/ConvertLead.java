package classes;

public class ConvertLead {

    public Account convertLead(Lead lead){
        Contact contact = createContact(lead);
        Opportunity opportunity = createOpportunity(contact);
        Account account = createAccount(contact, opportunity);
        return account;
    }

    private Contact createContact(Lead lead) {
        System.out.println("Introduce los datos del contacto");
        //Aqui se escanea, validan todos los datos y si son correctos se comprueba el objeto, si no se repiten, etc.

        return null;
    }

    private Opportunity createOpportunity(Contact contact) {
        System.out.println("Introduce los datos de la oportunidad");
        //Aqui se escanea, validan todos los datos y si son correctos se comprueba el objeto, si no se repiten, etc.


        return null;
    }

    private Account createAccount(Contact contact, Opportunity opportunity) {
        System.out.println("Introduce los datos de la cuenta");
        //Aqui se escanea, validan todos los datos y si son correctos se comprueba el objeto, si no se repiten, etc.

        return null;
    }
}
