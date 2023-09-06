import java.util.*;
class Contact
  {
    private int id;
    private String name;
  private ArrayList<String> mobilenumber;
    private String email;
    private String catagery;
    
    Contact(
      int id,
    String name,
    ArrayList<String> mobilenumber,
    String email,
    String catagery)
    {
      this.id=id;
      this.name=name;
      this.mobilenumber=mobilenumber;
      this.email=email;
      this.catagery=catagery;
    }
    public int getId()
    {
      return id;
    }
    public String getName()
    {
      return name;
    }
    public String setName(String name)
    {
      return this.name=name;
    }
    public ArrayList<String> getMobile()
    {
      return mobilenumber;
    }
    public void addMobile(String mobileNumber) {
        mobilenumber.add(mobileNumber);
    }
    public ArrayList<String> setMobile(ArrayList<String>mobile)
    {
      return this.mobilenumber=mobile;
    }
    public String getEmail()
    {
      return email;
    }
    public String setEmail(String email)
    {
      return this.email=email;
    }
    public String getCatagery()
    {
      return catagery;
    }
    public String setCatagery(String cat)
    {
      return this.catagery=cat;
    }
    public String toString()
    {
      return "id: "+id+" \n name:"+name+"\n mobile number: "+mobilenumber+"\n email: "+email+"\n catagery: "+catagery;
    }
    
  }//end of the contact class


class  ContactMenu
  {
      HashMap<Integer,Contact> contacts;
    ContactMenu()
    {
      contacts=new HashMap<Integer,Contact>();
    }
    void addContact(int id,String name,ArrayList<String> mobilenumber,String email,String catagery)
    {
      int ids=id;
      contacts.put(id,new Contact(ids,name,mobilenumber,email,catagery));
      System.out.println("contact added successfully");
    }
    void removeContact(int id)
    {
      if(contacts.containsKey(id))
      {
        contacts.remove(id);
        System.out.println("contact deleted successfully");
      }
      else
        System.out.println("contact not found");
    }
    void updatContact(int id,String name,ArrayList<String> mobilenumber,String email,String catagery)
    {
      if(contacts.containsKey(id))
      {
        contacts.replace(id,new Contact(id,name,mobilenumber,email,catagery) );
         System.out.println("contact updated successfully");
      }
    }
    void displayContactDetails(int id)
    {
      if(contacts.containsKey(id))
      {
        Contact c=contacts.get(id);
         System.out.println("contact ID: "+id);
        System.out.println("contact name: "+c.getName());
        System.out.println("contact mobile number: "+c.getMobile());
        System.out.println("contact emailId: "+c.getEmail());
        System.out.println("contact catagery: "+c.getCatagery());
      }
      else 
        System.out.println("id not found");
    }
    void displayAll()
    {
      if(contacts.isEmpty())
      {
        System.out.println("no data found");
      }
      else{
        System.out.println("\n Displaying all contact's details: \n");
      for(int id:contacts.keySet())
        {
          displayContactDetails(id);
        }
      }
    }
   void displayContactCatagery(String catagery)
    {
      boolean status=false;
      
      for(Contact c:contacts.values()){
      if(c.getCatagery().equalsIgnoreCase(catagery))
      {
         System.out.println(c);
  
      }
      }
       if(status==false)
        {
          System.out.println("name not found");
        }
    }
  void displayNameWise(String name)
    {
      boolean status=false;
      for(Contact c:contacts.values()){
      if(c.getName().equalsIgnoreCase(name))
      {
         System.out.println(c);
         status=true;
      }      
        
      }
       if(status==false)
        {
          System.out.println("name not found");
        }
    }
    void displayMobileWise(String mobile)
    {
      boolean status=false;
      for(Contact c:contacts.values()){
        List<String> mobileNumbers = c.getMobile();
        for(String s:mobileNumbers){
      if(s.equalsIgnoreCase(mobile))
      {
         System.out.println(c);
         status=true;
      } 
        }
        
      }
       if(!status)
        {
          System.out.println("name not found");
        }
    }
    void updateName(int id,String name)
    {
      for(Contact c:contacts.values())
        {
          if(c.getId()==id)
          {
            c.setName(name);
            System.out.println("name updated success fully");
          }
        }
    }
    void updateMobile(int id,ArrayList<String>mobile)
    {
      
      for(Contact c:contacts.values())
        {
          if(c.getId()==id)
          {
            c.setMobile(mobile);
            System.out.println("mobile number(s) updated successfully");
          }
        }
    }
    void addMobileNumber(int id, String mobileNumber) {
      if (contacts.containsKey(id)) {
        Contact contact = contacts.get(id);
        List<String> mobileNumbers = contact.getMobile();

        // Check if the mobile number already exists in the list
        if (!mobileNumbers.contains(mobileNumber)) {
            mobileNumbers.add(mobileNumber);
            System.out.println("Mobile number added successfully");
        } else {
            System.out.println("Number already exists");
        }
    } else {
        System.out.println("Contact not found");
    }
      


      
    }
    void updateEmail(int id,String email)
    {
      for(Contact c:contacts.values())
        {
          if(c.getId()==id)
          {
            c.setEmail(email);
            System.out.println("email updated successfully");
          }
        }
    }
    void updateCatagery(int id,String cat)
    {
      for(Contact c:contacts.values())
        {
          if(c.getId()==id)
          {
            c.setCatagery(cat);
            System.out.println("catagery updated successfully");
          }
        }
    }
    void displayAllSortedByName() {
    if (contacts.isEmpty()) {
        System.out.println("no data found");
    } else {
        System.out.println("\n Displaying all contact's details (sorted by Name): \n");
        
        List<Contact> sortedContacts = new ArrayList<>(contacts.values());
        sortedContacts.sort(Comparator.comparing(Contact::getName));
        
        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }
}

    public void menuOptions()
    {
      Scanner sc=new Scanner(System.in);
      ContactMenu cm=new ContactMenu();
      String no,email,uno,uemail,uname,ucatagery;
      int uid,f;
      ArrayList <String>p1=new ArrayList<String>();
      char ch,co;
      do{
      System.out.println("********MENU*************");
      System.out.println("\n 1) Add contact \n2)Remove contact \n3)Display All Contacts \n 4)Display one contact details \n 5) Display contacts by catagory \n 6) Display contacts by name \n 7) update contact information \n 8)DisplayAll in Sorted Order \n 9)Add mobile number \n 10)Display by mobile number");
      
      System.out.println("enter your choice");
      int n=sc.nextInt();
      switch(n){
        case 1:
          System.out.println(" enter contact id: ");
          int id=sc.nextInt();
          System.out.println(" enter contact name: ");
          String name=sc.next();
          p1=new ArrayList<String>();
          do{
          do{
          System.out.println(" enter contact mobile number: ");
           no=sc.next();
          }while(!validateMobile(no));
             boolean isUnique = true;
        for (String existingMobile : p1) {
            if (existingMobile.equalsIgnoreCase(no)) {
                System.out.println("Mobile number already exists. Please enter a unique mobile number.");
                isUnique = false;
                break;
            }
        }

        if (isUnique) {
            p1.add(no);
            System.out.println("Mobile number added successfully.");
        }
            
         
            System.out.println(" do you want to add another mobile number:(y/n) ");
            co=sc.next().charAt(0);
          }while(co!='n');
          do{
          System.out.println(" enter contact emailId: ");
           email=sc.next();
          }while(!isValidEmail(email));
          System.out.println(" enter contact catagery: ");
          String catagery=sc.next();          
          cm.addContact(id,name,p1,email,catagery);
          break;
        case 2:
           System.out.println(" enter contact id to remove: ");
          int rid=sc.nextInt();
          cm.removeContact(rid);
          break;
        case 3:
          cm.displayAll();
          break;
        case 4:
          System.out.println("Enter contact id that you want to display details ");
          int did=sc.nextInt();
          cm.displayContactDetails(did);
          break;
        case 5: 
          System.out.println("Enter contact catagery(friends/family etc.,)that you want to display details ");
          String str=sc.next();
          cm.displayContactCatagery(str);
          break;
        case 6:
           System.out.println("Enter contact name that you want to display details ");
          String str1=sc.next();
          cm.displayNameWise(str1);
          break;
        case 7:
          do{
           System.out.println(" enter contact id: ");
           uid=sc.nextInt();
          }while(!cm.conatinID(uid));
          System.out.println(" what feilds do you want to update: \n 1)name \n 2) mobile number \n 3)emailId \n 4)catagery \n5) All details \n enter your choice");
          f=sc.nextInt();
          switch(f)
            {
              case 1:
                 System.out.println(" enter contact name: ");
                 uname=sc.next();
                cm.updateName(uid,uname);
                break;
              case 2:
                 p1=new ArrayList<String>();
                do{
                  do{
                    System.out.println(" enter contact mobile number: ");
                 uno=sc.next();
                  }while(!validateMobile(uno));
                  p1=new ArrayList<String>();
                  p1.add(uno);
                System.out.println(" do you want to add another mobile number:(y/n) ");
            co=sc.next().charAt(0);
          }while(co!='n');
                cm.updateMobile(uid,p1);
                break;
              case 3:
                do{
          System.out.println(" enter contact emailId: ");
          uemail=sc.next();
          }while(!isValidEmail(uemail));
                cm.updateEmail(uid,uemail);
                break;
              case 4:                
                System.out.println(" enter contact catagery: ");
           ucatagery=sc.next();
                cm.updateCatagery(uid,ucatagery);
                break;
              case 5:
                 System.out.println(" enter contact name: ");
                uname=sc.next();
                 p1=new ArrayList<String>();
                do{
                  do{
                    System.out.println(" enter contact mobile number: ");
                 uno=sc.next();
                  }while(!validateMobile(uno));
                  p1=new ArrayList<String>();
                  p1.add(uno);
                System.out.println(" do you want to add another mobile number:(y/n) ");
            co=sc.next().charAt(0);
          }while(co!='n');
                do{
          System.out.println(" enter contact emailId: ");
          uemail=sc.next();
          }while(!isValidEmail(uemail));
                 System.out.println(" enter contact catagery: ");
          ucatagery=sc.next();
          cm.updatContact(uid, uname, p1, uemail, ucatagery);
                break;
              default:
                System.out.println("wrong choice");
                break;
            }
          break;
        case 8:
           cm.displayAllSortedByName();
            break;
        case 9:
    System.out.println("Enter contact id to add another mobile number: ");
    int aid = sc.nextInt();
    System.out.println("Enter mobile number to add: ");
    String anotherMobile = sc.next();
    cm.addMobileNumber(aid, anotherMobile);
    break;
        case 10:
          System.out.println("enter mobile number: ");
          String s=sc.next();
          cm.displayMobileWise(s);
          break;
        default:
          System.out.println("wrong choice");
          break;
      }
        System.out.println("do you want to continue:(y/n)");
        ch=sc.next().charAt(0);
      }while(ch!='n');
    }
    
   

    public static boolean validateMobile(String mobile)
    {
      if(mobile.length()==10)
      {
        if(mobile.charAt(0)=='9'||mobile.charAt(0)=='8'||mobile.charAt(0)=='7'||mobile.charAt(0)=='6')
        {
          for(int i=0;i<mobile.length();i++)
            {
              char c=mobile.charAt(i);
              if(!Character.isDigit(c))
              {
                return false;
              }
             
            }
           return true;
        
        }
        else
        {
          System.out.println("please enter mobile number starting with (9/8/7/6)");
          return false;
        }
      }
      else
        return false;
    }
    public static boolean isValidEmail(String email)
    {
       if (email == null || email.isEmpty()) {
            return false;
        }
      else if(email.contains("@gmail.com")||email.contains("@yahoo.com")||email.contains("@rediff.com")||email.contains("@outlook.com"))
      {
        return true;
      }
      else
        return false;
    }
     public boolean conatinID(int id)
    {
      if(contacts.containsKey(id))
        return true;
      else
      {
        System.out.println("id not found,please enter valid id");
        return false;
      }
    }

     public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      ContactMenu cm=new ContactMenu();
       cm.menuOptions();
    }
  }