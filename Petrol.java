/*create a class Petroleum have data members with price and quality of  Petroleum liquid. Assume starting  1 liter Petroleum liquid is Rs.20. Extend this class by India with method addGst() will add 30%gst to basic 1 liter Petroleum liquid. Further extend India class by States class have its own method call finalPrice() , this method gives final price of liter Petroleum liquid based on number of liters */

// by using heirachical inheritance
import java.util.*;
class Base
  {
    int price=20;
    int bprice;
    void baseprice()
    {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter the number of liters");
      int n=sc.nextInt();
      bprice=n*price;
    }
  }
class Central extends Base
  {
    int cgst;
    void cgst()
    {
      cgst=(bprice*10)/100;
      System.out.println("central gst amount"+cgst);
    }
    
  }
class TS extends Central
  {
    int sgst;
    void sgst()
    {
      sgst=(bprice*10)/100;
      System.out.println("state gst amount"+sgst);
    }
    void total()
    {
      int total=bprice+cgst+sgst;
      System.out.println("the total cost of petrol in Telangana State is : "+total);
    }
  }
class AP extends Central
  {
    int sgst;
    void sgst()
    {
      sgst=(bprice*15)/100;
      System.out.println("state gst amount"+sgst);
    }
    void total()
    {
      int total=bprice+cgst+sgst;
      System.out.println("total price"+total);
    }
  }
class Petrol
  {
    public static void main(String args[])
    {
       AP ap=new AP();
       ap.baseprice();
       ap.cgst();
       ap.sgst();
       ap.total();
       TS ts=new TS();
       ts.cgst();
       ts.sgst();
       ts.total();     
      
    }
  }