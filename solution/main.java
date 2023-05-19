package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.tests.Examples;

public class main {
    public static void main(String[] args){
        for(int i=0;i<400;i++){
            IGrid ex= Examples.getExample(i);
            Solver solver = new Solver(ex);
            long begin = System.currentTimeMillis();
            boolean isSolved = solver.solve();
            long timeTaken = System.currentTimeMillis()- begin;
                System.out.println("Test ID " + i);
                System.out.println("Number of gaps " + Examples.getGapCount(i));
                System.out.println("Time " + timeTaken);
                System.out.println();
            }
        }
    }

