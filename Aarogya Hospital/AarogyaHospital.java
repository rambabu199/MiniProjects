
//package aarogya_hospital;
import java.util.ArrayList;
import java.util.Scanner;

public class AarogyaHospital {

  class AarogyaMember {
    private int id;
    private String name;
    private int age;
    private String gender;
    private long aadharCard;
    private long contactNumber;
    private String city;
    private String address;
    private String dateOfAdmission;
    private String guardianName;
    private String guardianAddress;
    private long guardianContactNumber;
    private boolean recovered;

    public AarogyaMember() {
    }

    public AarogyaMember(int id, String name, int age, String gender, long aadharCard, long contactNumber, String city,
        String address, String dateOfAdmission, String guardianName, String guardianAddress, long grdianContactNumber) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.gender = gender;
      this.aadharCard = aadharCard;
      this.contactNumber = contactNumber;
      this.city = city;
      this.address = address;
      this.dateOfAdmission = dateOfAdmission;
      this.guardianName = guardianName;
      this.guardianAddress = guardianAddress;
      this.guardianContactNumber = guardianContactNumber;
      this.recovered = false;
    }

    public int getId() {
      return id;
    }

    public boolean isRecovered() {
      return recovered;
    }

    public void markRecovered() {
      recovered = true;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public long getAadharCard() {
      return aadharCard;
    }

    public void setAadharCard(long aadharCard) {
      this.aadharCard = aadharCard;
    }

    public long getContactNumber() {
      return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
      this.contactNumber = contactNumber;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getDateOfAdmission() {
      return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
      this.dateOfAdmission = dateOfAdmission;
    }

    public String getGuardianName() {
      return guardianName;
    }

    public void setGuardianName(String guardianName) {
      this.guardianName = guardianName;
    }

    public String getGuardianAddress() {
      return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
      this.guardianAddress = guardianAddress;
    }

    public long getGuardianContactNumber() {
      return guardianContactNumber;
    }

    public void setGuardianContactNumber(long guardianContactNumber) {
      this.guardianContactNumber = guardianContactNumber;
    }

    public String toString() {
      return "AarogyaMember{" + "ID" + id +
          "name='" + name + '\'' +
          ", age=" + age +
          ", gender='" + gender + '\'' +
          ", aadharCard=" + aadharCard +
          ", contactNumber=" + contactNumber +
          ", city='" + city + '\'' +
          ", address='" + address + '\'' +
          ", dateOfAdmission='" + dateOfAdmission + '\'' +
          ", guardianName='" + guardianName + '\'' +
          ", guardianAddress='" + guardianAddress + '\'' +
          ", guardianContactNumber=" + guardianContactNumber +
          '}';
    }

  }

  private ArrayList<AarogyaMember> patients = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    AarogyaHospital hospital = new AarogyaHospital();
    hospital.run();
  }

  public void run() {
    while (true) {
      long option = choices();

      if (option == 1) {
        addNewMember();
      } else if (option == 2) {
        viewAllMembers();
      } else if (option == 3) {
        searchMemberByID();
      } else if (option == 4) {
        searchMembersByCity();
      } else if (option == 5) {
        searchMembersByAgeGroup();
      } else if (option == 6) {
        markMemberRecovered();
      } else if (option == 7) {
        deleteMember();
      } else if (option == 0) {
        break;
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private long choices() {
    System.out.println("Press 1 for adding a new member");
    System.out.println("Press 2 to view the list of all available members");
    System.out.println("Press 3 to search for a member by ID");
    System.out.println("Press 4 to search for members from a particular city");
    System.out.println("Press 5 to search for members in a particular age group");
    System.out.println("Press 6 to mark recovery of a member");
    System.out.println("Press 7 to delete data of a member");
    System.out.println("Press 0 to exit");

    return scanner.nextLong();
  }

  private void addNewMember() {
    AarogyaMember newMember = new AarogyaMember();

    Scanner input = new Scanner(System.in);

    System.out.print("Enter name: ");
    String name = input.nextLine();
    newMember.setName(name);

    System.out.print("Enter age: ");
    int age = input.nextInt();
    newMember.setAge(age);

    input.nextLine(); // Consume the newline character

    System.out.print("Enter gender: ");
    String gender = input.nextLine();
    newMember.setGender(gender);

    System.out.print("Enter Aadhar Card number: ");
    long aadharCard = input.nextLong();
    newMember.setAadharCard(aadharCard);

    System.out.print("Enter contact number: ");
    long contactNumber = input.nextLong();
    newMember.setContactNumber(contactNumber);

    input.nextLine(); // Consume the newline character

    System.out.print("Enter city: ");
    String city = input.nextLine();
    newMember.setCity(city);

    System.out.print("Enter address: ");
    String address = input.nextLine();
    newMember.setAddress(address);

    System.out.print("Enter date of admission: ");
    String dateOfAdmission = input.nextLine();
    newMember.setDateOfAdmission(dateOfAdmission);

    System.out.print("Enter guardian name: ");
    String guardianName = input.nextLine();
    newMember.setGuardianName(guardianName);

    System.out.print("Enter guardian address: ");
    String guardianAddress = input.nextLine();
    newMember.setGuardianAddress(guardianAddress);

    System.out.print("Enter guardian contact number: ");
    long guardianContactNumber = input.nextLong();
    newMember.setGuardianContactNumber(guardianContactNumber);

    // Adding the new member to the 'patients' ArrayList
    patients.add(newMember);

    System.out.println("New member added successfully!");

  }

  private void viewAllMembers() {
    for (AarogyaMember member : patients) {
      System.out.println(member);
    }
  }

  private void searchMemberByID() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter member ID: ");
    long memberId = input.nextLong();

    boolean memberFound = false;
    for (AarogyaMember member : patients) {
      if (memberId == member.getId()) {

        memberFound = true;
        System.out.println("Member details:");
        System.out.println(member);

      }
    }
    if (!memberFound) {
      System.out.println("Member with ID " + memberId + " does not exist.");
    }
  }

  private void searchMembersByCity() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter city name: ");
    String cityToSearch = input.nextLine();
    boolean membersFound = false;
    for (AarogyaMember member : patients) {
      if (cityToSearch.equalsIgnoreCase(member.getCity())) {
        if (!membersFound) {
          System.out.println("Members from " + cityToSearch + ":");
          membersFound = true;
        }
        System.out.println("Member details:");
        System.out.println(member);
      }
    }
    if (!membersFound) {
      System.out.println("No members from " + cityToSearch + " found.");
    }
  }

  private void searchMembersByAgeGroup() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter minimum age: ");
    int minAge = input.nextInt();
    System.out.print("Enter maximum age: ");
    int maxAge = input.nextInt();
    boolean membersFound = false;
    for (AarogyaMember member : patients) {
      int age = member.getAge();
      if (age >= minAge && age <= maxAge) {
        if (!membersFound) {
          System.out.println("Members in the age group " + minAge + " to " + maxAge + ":");
          membersFound = true;
        }
        System.out.println("Member details:");
        System.out.println(member);

      }
    }
    if (!membersFound) {
      System.out.println("No members in the age group " + minAge + " to " + maxAge + " found.");
    }
  }

  private void markMemberRecovered() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter member ID to mark as recovered: ");
    long memberId = input.nextLong();
    boolean memberFound = false;
    for (AarogyaMember member : patients) {
      if (memberId == member.getId()) {
        memberFound = true;
        member.markRecovered();
        System.out.println("Member with ID " + memberId + " has been marked as recovered.");
      }
    }
    if (!memberFound) {
      System.out.println("Member with ID " + memberId + " does not exist.");
    }
  }

  private void deleteMember() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter member ID to delete: ");
    long memberId = input.nextLong();
    AarogyaMember memberToRemove = null;
    for (AarogyaMember member : patients) {
      if (memberId == member.getId()) {
        memberToRemove = member;
        break;
      }
    }
    if (memberToRemove != null) {
      patients.remove(memberToRemove);
      System.out.println("Member with ID " + memberId + " has been deleted.");
    } else {

      System.out.println("Member with ID " + memberId + " does not exist.");
    }
  }
}
