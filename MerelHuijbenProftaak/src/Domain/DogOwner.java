package Domain;


public class DogOwner {
    
    private String firstname;
    private String lastname;
    private String street;
    private String houseNumber;
    private String city;
    private String phoneNumber;
    private Dog dog;
    
       public DogOwner (String firstname, String lastname) {
          this.firstname = firstname;
          this.lastname = lastname;
       }
       
        

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    
      public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
   
}
    
}
