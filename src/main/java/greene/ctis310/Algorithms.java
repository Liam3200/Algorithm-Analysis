package greene.ctis310;

public class Algorithms {
    //method to sort the dogs in alphabetical order using insertion sort 
    //time compexity is O(n^2)
    public static void insertionSortDogs(Dog[] dogs) {
        //loop through the array
        for (int i = 1; i < dogs.length; i++) {
            //store the current dog in a variable
            Dog currentDog = dogs[i];
            //store the index of the previous dog in a variable
            int j = i - 1;
            //loop through the array backwards
            while (j >= 0 && dogs[j].compareTo(currentDog) > 0) {
                //move the dog at index j up one index
                dogs[j + 1] = dogs[j];
                //decrement j
                j--;
            }
            //insert the current dog at the correct index
            dogs[j + 1] = currentDog;
        }
    }

    //method to sort the dogs in alphabetical order using merge sort
    //if two Dogs have the same letter, compare the next letter util either the names are equal or one is greater than the other
    //time complexity is O(n log n)
    public static void mergeSortDogs(Dog[] dogs) {
        //if the array has more than one element
        if (dogs.length > 1) {
            //find the middle index
            int mid = dogs.length / 2;
            //create a left array
            Dog[] left = new Dog[mid];
            //create a right array
            Dog[] right = new Dog[dogs.length - mid];
            //copy the first half of the dogs array into the left array
            for (int i = 0; i < left.length; i++) {
                left[i] = dogs[i];
            }
            //copy the second half of the dogs array into the right array
            for (int i = 0; i < right.length; i++) {
                right[i] = dogs[mid + i];
            }
            //sort the left array
            mergeSortDogs(left);
            //sort the right array
            mergeSortDogs(right);
            //merge the left and right arrays
            merge(left, right, dogs);
        }
    }

    //method to merge two arrays
    public static void merge(Dog[] left, Dog[] right, Dog[] dogs) {
        //create variables to store the index of the left, right, and merged arrays
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        //while the left and right arrays have elements
        while (leftIndex < left.length && rightIndex < right.length) {
            //if the left dog is less than the right dog
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                //add the left dog to the merged array
                dogs[mergedIndex] = left[leftIndex];
                //increment the left index
                leftIndex++;
            } else {
                //add the right dog to the merged array
                dogs[mergedIndex] = right[rightIndex];
                //increment the right index
                rightIndex++;
            }
            //increment the merged index
            mergedIndex++;
        }
        //while the left array has elements
        while (leftIndex < left.length) {
            //add the left dog to the merged array
            dogs[mergedIndex] = left[leftIndex];
            //increment the left index
            leftIndex++;
            //increment the merged index
            mergedIndex++;
        }
        //while the right array has elements
        while (rightIndex < right.length) {
            //add the right dog to the merged array
            dogs[mergedIndex] = right[rightIndex];
            //increment the right index
            rightIndex++;
            //increment the merged index
            mergedIndex++;
        }
    }

    //method to search the dogs using sequential search
    //time complexity is O(n)
    public static Dog sequentialSearchDogs(Dog[] dogs, String name) {
        //loop through the array
        for (Dog dog : dogs) {
            //if the dog's name matches the name
            if (dog.getName().equals(name)) {
                //print out the dog
                return dog;
            }
        }
        return null;
    }

    //method to search the dogs using binary sort
    //time complexity is O(log n)
    public static void binarySearchDogs(Dog[] dogs, String name) {
        //create variables to store the start and end indexes
        int start = 0;
        int end = dogs.length - 1;
        //while the start index is less than or equal to the end index
        while (start <= end) {
            //find the middle index
            int mid = (start + end) / 2;
            //if the dog's name matches the name
            if (dogs[mid].getName().equals(name)) {
                //print out the dog
                System.out.println(dogs[mid]);
                //break out of the loop
                break;
            //if the dog's name is less than the name
            } else if (dogs[mid].getName().compareTo(name) < 0) {
                //set the start index to the middle index plus one
                start = mid + 1;
            //if the dog's name is greater than the name
            } else {
                //set the end index to the middle index minus one
                end = mid - 1;
            }
        }
    }
}