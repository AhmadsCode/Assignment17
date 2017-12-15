/*
  Author: Ahmad
  CSC 201-004N
  Assignment 17
  Problem 17.3
  (Sum all the integers in a binary data file)
  Suppose a binary data file named Exercise17_03.dat
  has been created and its data are created using writeInt(int)
  in DataOutputStream. The file contains an unspecified number
  of integers. Write a program to find the sum of the integers.
 */


import java.io.*;

public class Homework17 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/text files/Exercise17_03.dat");

        // if no file, than create a file.
        if (!file.exists() || true) {
            try (DataOutputStream out =
                         new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

                int random = (int) (Math.random() * 300);

                for (int i = 0; i < random; i++) {
                    out.writeInt((int)(Math.random() * 300));
                }
            }
        }

        // Reads file and displays sum of num
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {

            int sumOfFile = 0;
            int count = input.available() / 4;
            System.out.println(count);
            while (count > 0) {
                sumOfFile += input.readInt();
                count--;
            }
            System.out.println("The sum of numbers in file is " + sumOfFile);
        }
    }
}