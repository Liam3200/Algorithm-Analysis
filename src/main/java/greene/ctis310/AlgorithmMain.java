package greene.ctis310;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AlgorithmMain 
{
    public static void main( String[] args )
    {
        //initialize a scanner
        Scanner scan = new Scanner(System.in);
        //prompt the user for a number
        System.out.println("Enter the amount of dogs to compare: ");
        //store the number in a variable
        int numDogs = scan.nextInt();
        scan.nextLine();
        //create an array of dogs
        Dog[] dogs = new Dog[numDogs];
        //loop through the array
        for (int i = 0; i < dogs.length; i++) {
            //create a new dog with random values
            Dog dog = new Dog();
            //add the dog to the array
            dogs[i] = dog;
        }
        //print out the dogs in the array
        System.out.println("Dogs before sorting: ");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("====================================");
        //INSERTION SORT: sort the dogs in alphabetical order
        System.out.println("Dogs after O(n^2) insertion sorting: ");
        long startTime = System.nanoTime();
        Algorithms.insertionSortDogs(dogs);
        long endTime = System.nanoTime();
        //print out the dogs in the array
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("Time to sort: " + ((endTime - startTime)/1.e6) + " milliseconds");
        System.out.println("====================================");

        //shuffle the dogs in the array
        shuffleDogs(dogs);
        
        //MERGE SORT: sort the dogs in alphabetical order
        System.out.println("Dogs after O(n log n) merge sorting: ");
        startTime = System.nanoTime();
        Algorithms.mergeSortDogs(dogs);
        endTime = System.nanoTime();
        //print out the dogs in the array
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("Time to sort: " + ((endTime - startTime)/1.e6) + " milliseconds");
        System.out.println("====================================");
        
        //ask the user for a dog name
        System.out.println("Enter a dog name to search for: ");
        //store the name in a variable
        String searchName = scan.nextLine();
        //close the scanner
        scan.close();
        //BINARY SEARCH: search for the dog
        System.out.println("Binary search:");
        //time the search
        startTime = System.nanoTime();
        //search for the dog
        Algorithms.binarySearchDogs(dogs, searchName);
        endTime = System.nanoTime();
        System.out.println("Time to search: " + ((endTime - startTime)/1.e6) + " milliseconds");
        System.out.println("====================================");
        System.out.println("Sequential search:");
        //time the search
        startTime = System.nanoTime();
        System.out.println(Algorithms.sequentialSearchDogs(dogs, searchName));
        endTime = System.nanoTime();
        System.out.println("Time to search: " + ((endTime - startTime)/1.e6) + " milliseconds");
        System.out.println("====================================");

    }

    //method to shuffle the dogs in the array
    public static void shuffleDogs(Dog[] dogs) {
        //loop through the array
        for (int i = 0; i < dogs.length; i++) {
            //generate a random index
            int randomIndex = (int) (Math.random() * dogs.length);
            //store the dog at the random index in a variable
            Dog temp = dogs[randomIndex];
            //swap the dog at the random index with the dog at index i
            dogs[randomIndex] = dogs[i];
            dogs[i] = temp;
        }
    }
}
