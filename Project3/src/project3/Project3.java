
package project3;
import java.util.Scanner; 
/**
 *
 * @author Neura1Nerd
 */
public class Project3 {
    public static char[] eachDNA() {
        char[] eachDNA = new char[128]; 
        
        for (int i = 0; i < eachDNA.length; i++) {
          int threeChar = (int)(Math.random()*3+1);
            switch (threeChar) {
                case 1: 
                    eachDNA[i] = 'C';
                    break;
                case 2:
                    eachDNA[i] = 'E';
                    break;
                default:
                    eachDNA[i] = 'S';
            } 
        }
        return eachDNA;
    }//End of eachDNA
    //— — — — — — — — — — — — — — — — — — — — —
    public static int Health(char[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length-2; i++) { //finding health
            if (arr[i] == 'C') {
                if (arr[i+1] == 'S') {
                    if (arr[i+2] == 'E') {
                        counter++;
                    }
                }
            }//End of if's
        }
        return counter;
    }//End of Health
    //— — — — — — — — — — — — — — — — — — — — —
    public static String Gender(char[] arr) {
        if (arr[arr.length-1] == 'S') { //finding gender
                return "Male";
                
            } else {
                return "Female";
            }
    }//End of Gender
    //— — — — — — — — — — — — — — — — — — — — —
    public static void entrance() {
        System.out.println("Choose an option:");
        System.out.println("(1) Mate two compAliens"); 
        System.out.println("(2) Randomly mate a set of compAliens");
        System.out.println("(3) Show statistics");
        System.out.println("(4) Finding friends with the same-sex");
        System.out.println("(5) Capability of Military Service");
        System.out.println("Press q to exit the program");
    }//End of Entrance
    //— — — — — — — — — — — — — — — — — — — — —
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      
      System.out.print("Enter the size of compAlien population: "); 
      int Psize = scn.nextInt();  
      
      int[] id = new int[Psize];
      int[] health = new int[Psize];
      String[] gender = new String[Psize];
      
         System.out.println("Simulating compAlien species...");
         System.out.println("——————————————————");
      for (int i = 0; i < Psize; i++) {
          char[] arr = eachDNA();
          
          id[i] = i + 1;
          health[i] = Health(arr);
          gender[i] = Gender(arr);
          
          System.out.print("ID:" + (i + 1) + " Gender: " + Gender(arr) + " Health: " + Health(arr));
          System.out.println("");
      }  
         System.out.println("——————————————————");
         System.out.println("compAlien population is generated!");
         
         String i = scn.nextLine();
         while(!i.equalsIgnoreCase("q")) {
            System.out.println("");
            entrance();
            int modes = scn.nextInt();
          
          switch (modes) {
              case 1: 
                  mateTwoAliens(gender,health);
                  break;
              case 2:
                  mateSetOfAliens(Psize,health,gender);
                  break;
              case 3:
                  statistics(Psize,gender,health);
                  break;
              case 4:
                  findingFriends(gender);
                  //uzaylı seçilir same-sex arkadaşlar bulunur
                  break;
              default:
                  MScapability(gender,health);
                  //koşullar erkek olmak ve sağlıklı olmak id istiyosun capable mı
          }//End of switch
     }//End of while
      
    }//End of main
//— — — — — — — — — — — — — — — — — — — — —     
    public static int reproduction(int[] health, int num1, int num2) {
        double oldP_reproduce = (health[num1-1] + health[num2-1]) / 26.0 ;
        double p_reproduce = ((int)(oldP_reproduce*100)) / 100.0;
        int stat = (int)(p_reproduce * 100);
        
        return stat;
    }// End of reproduction
//— — — — — — — — — — — — — — — — — — — — — 
    public static void mateTwoAliens(String[] gender, int[] health) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Mating two compAliens");
        System.out.println("—————————————");
        
        System.out.print("Enter ID of first compAlien: ");
        int ID1 = scn.nextInt();
        System.out.print("Enter ID of second compAlien: ");
        int ID2 = scn.nextInt();
        
        if(gender[ID1-1].equals("Female") && gender[ID2-1].equals("Male")) { //case1 F + M
             int stat = reproduction(health,ID1,ID2);     
               System.out.print("compAlien " + ID1 + "(F) and " + ID2 +
                  "(M) Mate: Offspring chance " + stat + "%." );
                       if (stat > 50) {
                        System.out.print(" They have 1 offspring :)");
                        System.out.println("");
                       } else {
                        System.out.print(" They don't have an offspring :(");
                        System.out.println("");
                       }
        } else if (gender[ID2-1].equals("Female") && gender[ID1-1].equals("Male")) { //case2 M + F
            int stat = reproduction(health,ID1,ID2);
                System.out.print("compAlien " + ID1 + "(M) and " + ID2 +
                  "(F) Mate: Offspring chance " + stat + "%." );
                       if (stat >= 50) {
                        System.out.print(" They have 1 offspring :)");
                        System.out.println("");
                       } else {
                        System.out.print(" They don't have an offspring :(");
                        System.out.println("");
                       }
        } else if(gender[ID1-1].equals("Female") && gender[ID2-1].equals("Female")){ //case3 F + F
          System.out.println("compAlien " + ID1 + "(F) and " + ID2 + "(F) Mate: no mate"); 
        } else if (gender[ID1-1].equals("Male") && gender[ID2-1].equals("Male")) { //case4 M + M
          System.out.println("compAlien " + ID1 + "(M) and " + ID2 + "(M) Mate: no mate"); 
        }
        
    }//End of mateTwoAliens
//— — — — — — — — — — — — — — — — — — — — —
    public static void mateSetOfAliens(int Psize, int[] health, String[] gender) {
      Scanner scn = new Scanner(System.in);
        System.out.println("Simulating Random compAlien Reproduction");
        System.out.println("—————————————————————————");
        
        System.out.print("Enter number of compAlien pairs to reproduce: ");
        int num = scn.nextInt();
        
        for (int i = 0; i < num; i++) {
        int randID1 = (int)(Math.random()*Psize +1);
        int randID2 = (int)(Math.random()*Psize +1);
        if (randID1 == randID2) {
            randID1 = (int)(Math.random()*Psize +1); 
        }
      if(gender[randID1-1].equals("Female") && gender[randID2-1].equals("Male")) {
          int stat = reproduction(health,randID1,randID2); 
          if (stat >= 50 && randID1 != randID2) {
            System.out.println("Alien " + randID1 + "(F) and " + randID2 + "(M) mate: " +
                   "Offspring chance " + stat + "%. Result: 1 OffSpring");
          } else if (randID1 != randID2) {
            System.out.println("Alien " + randID1 + "(F) and " + randID2 + "(M) mate: " +
                   "Offspring chance " + stat + "%. Result: no offSpring");  
          }
      } else if(gender[randID2-1].equals("Female") && gender[randID1-1].equals("Male")) {
          int stat = reproduction(health,randID1,randID2);
          if (stat >= 50 && randID1 != randID2) {
            System.out.println("Alien " + randID1 + "(M) and " + randID2 + "(F) mate: " +
                   "Offspring chance " + stat + "%. Result: 1 OffSpring");
          } else if (randID1 != randID2) {
            System.out.println("Alien " + randID1 + "(M) and " + randID2 + "(F) mate: " +
                   "Offspring chance " + stat + "%. Result: no offSpring");  
          }
      } else if (randID1 == randID2) {
          if (gender[randID1-1].equals("Female")) {
            System.out.println("Alien " + randID1 + "(F) and " + randID2 + "(F) mate: no mate (same alien)");
          } else {
            System.out.println("Alien " + randID1 + "(M) and " + randID2 + "(M) mate: no mate (same alien)"); 
          }
      } else if(gender[randID1-1].equals("Female") && gender[randID2-1].equals("Female")) {
            System.out.println("Alien " + randID1 + "(F) and " + randID2 + "(F) mate: no mate"); 
      } else if (gender[randID1-1].equals("Male") && gender[randID2-1].equals("Male")){
            System.out.println("Alien " + randID1 + "(M) and " + randID2 + "(M) mate: no mate");
      }
      
        }//End of for loop
        
    }//End of mateSetOfAliens
    //— — — — — — — — — — — — — — — — — — — — —
    public static void statistics(int Psize, String gender[], int[] health) {
        Scanner scn = new Scanner(System.in);
        System.out.println("compAlien Population Statistics");
        System.out.println("———————————————————");
      //------GENDER RATE--------- 
      int femalePC= 0;
      for (int i = 0; i < gender.length; i++) {
          if (gender[i].equals("Female")) {
              femalePC++;
          }
      }
        int femaleP = (femalePC * 100) / Psize;
        System.out.println("FEMALE population = " + femaleP + "%");
        System.out.println("MALE population = " + (100 - femaleP) + "%");
        System.out.println("");
        //-------HEALTH THRESHOLD-------
        System.out.print("Enter an health threshold: ");
        int threshold = scn.nextInt();
        int healtyPC = 0;
          for (int i = 0; i < health.length; i++) {
            if (health[i] >= threshold) {
                healtyPC++;
            }
          }
        int healtyP = (healtyPC * 100) / Psize;
        System.out.println(healtyP + "% of compAlien population have a health of "
        + threshold + " or higher");
        System.out.println("");
        //--------HEALTHIER RATE---------
        System.out.println("Enter an ID number and see the rate of Alien that "
                + "are healtier than your Alien");
        int ID = scn.nextInt();
        int healthierPC = 0;
          for (int i = 0; i < health.length; i++) {
              if (health[i] > health[ID-1] && i != ID) {
                  healthierPC++;
              }
          }  
        int healthierP = (healthierPC * 100) / (Psize-1);
        System.out.println(healthierP + "% of compAlien population healthier than "
                + "your compAlien");
    }//End of statistics
    //— — — — — — — — — — — — — — — — — — — — —
    public static void findingFriends(String[] gender) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Finding Friends With the Same Sex");
        System.out.println("—————————————————————");
        
        System.out.print("Please pick your alien with its ID: ");
        int ID = scn.nextInt();
        
            for (int m = 0; m < gender.length; m++) {
               if (gender[ID-1].equals("Female") && gender[m].equals("Female") && (m+1) != ID) {
                System.out.println("Your Alien can be friends with ID " + (m+1) + " alien :)");
               }
               if (gender[ID-1].equals("Male") && gender[m].equals("Male") && (m+1)!= ID) {
                System.out.println("Your Alien can be friends with ID " + (m+1) + " alien :)");   
               } 
            }  
    }//End of findingFriends
    //— — — — — — — — — — — — — — — — — — — — —
    public static void MScapability(String[] gender, int[] health) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Capability of Military Service");
        System.out.println("———————————————————");
        
        System.out.print("Please enter ID number of the alien: ");
        int ID = scn.nextInt();
        
        if (health[ID-1] >= 6 && gender[ID-1].equals("Male")) {
          System.out.println("Your alien capable for Military Service");
            for (int i = 0; i <= 6; i++) { //star pattern
          for (int s = 0; s <= 4; s++) { 
                for (int m = 0; m <= i; m++) {
                  System.out.print(" ");
                }
                for (int n = 0; n <= 6-1-i; n++) {
                  System.out.print("*");
              }
          }      
              System.out.println("");
            }
        } else {
          System.out.println("Your alien doesn't capable for Military Service");
        }
    }//End of MScapability
}//End of class