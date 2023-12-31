/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;
import java.util.*;
public class Assignment1 {
    public static Pet[] petArray = new Pet[100];
    static int petCounter=0;
    public static void main(String[] args) {
        while(true){
        switch( getUserChoice()){
            case 1:showAllPets();
            break;
            case 2:addPets();
            break;
            case 3:searchPetsByName();
            break;
            case 4:searchPetsByAge();
            break;
            case 5:updatePets();
            break;
            case 6:removeExistingPet();
            break;
            case 7:
                System.out.println("Goodbye!");
                return;
        }
        }
       
    }
    public static int getUserChoice(){
        Scanner input= new Scanner(System.in);
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Search pets by name");
        System.out.println("4) Search pets by age");
        System.out.println("5) Update an existing pet");
        System.out.println("6) Remove an existing pet");
        System.out.println("7) Exit Program");
        System.out.println("What would you like to do? ");
        int userInput=input.nextInt();
        return userInput;
    }
    public static void addPets(){
        Scanner input=  new Scanner(System.in);
        while(true){
        System.out.print("Add pet(name,age):");
        String newPets=input.nextLine();
         if (newPets.equalsIgnoreCase("done")){
            break;
        }
        String name = newPets.substring(0,newPets.indexOf(" "));
        String age = newPets.substring(newPets.indexOf(" ")+1).trim();
        int Age=Integer.parseInt(age);
        petArray[petCounter] = new Pet(name,Age);
        petCounter++;
        }
         showAllPets();
    }
    public static void showAllPets(){
        printTableHeader();
        printTableRow();
        printTableFooter();
    }
    
        public static void searchPetsByName(){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the name of the pet: ");
        String nameSearch=input.nextLine();
        for(int i = 0;i<petCounter;i++){
            if(nameSearch.equals(petArray[i].getName())){
                printTableHeader();
                System.out.println(petArray[i].getName()+" "+petArray[i].getAge());
                printTableFooter();}
    }
    }
    public static void searchPetsByAge(){
        Scanner input= new Scanner(System.in);
        System.out.print("Eneter the pets age: ");
        int ageSearch=input.nextInt();
        for(int i = 0;i<petCounter;i++){
            if(ageSearch==(petArray[i].getAge())){
                printTableHeader();
                System.out.println(petArray[i].getName()+" "+petArray[i].getAge());
                printTableFooter();}
        }
    }
        public static void updatePets(){
        Scanner input= new Scanner(System.in);
        showAllPets();
        System.out.print("Enter ID of Pet you want to update: ");
        int updatePet=input.nextInt();
        System.out.print("Enter updated name and/or age:");
        String updatedName =input.next();
        int updatedAge= input.nextInt();
        petArray[updatePet] = new Pet(updatedName,updatedAge);
        showAllPets();
    }

        public static void removeExistingPet(){
        Scanner input= new Scanner(System.in);
        showAllPets();
        System.out.print("Enter ID of Pet you want to remove: ");
        int removePet=input.nextInt();
        for(int i=removePet;i<petCounter;i++){
            petArray[i]=petArray[i+1];
            petCounter--;
        }
        showAllPets();
        }

    public static void printTableHeader(){
        System.out.println("------------------");
        System.out.println("ID    Name    Age");
        System.out.println("------------------");
    }
    public static void printTableRow(){
        for(int i = 0;i<petCounter;i++){
        System.out.println(i+"      "+petArray[i].getName()+"      "+petArray[i].getAge()+"     ");}
    }
    public static void printTableFooter(){
        System.out.println("__________________");
    }
        }

    class Pet{
    private String name;
        private int age;
        Pet(String name1, int age1){
            name=name1;
            age=age1;
        }
        public String getName(){
            return name;
        }
       
        public int getAge(){
            return age;
        }
        public void setName(String newName) {
            name = newName;
        }
   
        public void setAge(int newAge){
            age = newAge;
        }
    }
