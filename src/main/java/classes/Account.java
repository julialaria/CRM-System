package classes;

import enums.Industry;

import java.util.List;

public class Account {

    private static int ID_COUNTER = 1;

    private final int id;
    private final Industry industry;
    private final int employeeCount;
    private final String city;
    private final String country;
    private final List<Contact> contactList;
    private final List<Opportunity> opportunityList;

    public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
        this.id = ID_COUNTER++;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public int getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }


    public int getEmployeeCount() {
        return employeeCount;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}
