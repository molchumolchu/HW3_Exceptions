public class PersonData {
    String firstName, lastName, surName, birthDate;
    char gender;
    Long phoneNumber;

    public void Persona() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return (lastName + " " + firstName + " " + surName + " " + birthDate + " " + phoneNumber + " " + gender);
    }

    public void setPersona(String [] arr) throws NumberFormatException{
        
        for (int i = 0; i < arr.length; i++) {
            this.lastName = arr[0];
            this.firstName = arr[1];
            this.surName = arr[2];
            this.birthDate = arr[3];
            this.phoneNumber = Long.parseLong(arr[4]);
            this.gender = arr[5].charAt(0);
        }
    }

    public String getLastName() {
        return lastName;
    }
    public Character gerGender(){
        return gender;
    }

}
