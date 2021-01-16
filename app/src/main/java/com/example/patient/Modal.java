package com.example.patient;

public class Modal {

    String Name,Address,Phone,Website,Email;/* Doc1,Doc2,Doc3,Emergency1,Emergency2;*/

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

/*    public String getDoc1() {
        return Doc1;
    }

    public void setDoc1(String doc1) {
        Doc1 = doc1;
    }

    public String getDoc2() {
        return Doc2;
    }

    public void setDoc2(String doc2) {
        Doc2 = doc2;
    }

    public String getDoc3() {
        return Doc3;
    }

    public void setDoc3(String doc3) {
        Doc3 = doc3;
    }

    public String getEmergency1() {
        return Emergency1;
    }

    public void setEmergency1(String emergency1) {
        Emergency1 = emergency1;
    }

    public String getEmergency2() {
        return Emergency2;
    }

    public void setEmergency2(String emergency2) {
        Emergency2 = emergency2;
    }
*/
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }
}
