package fixture_builder;

import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int teamNumber;

        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> teamsFixture = new ArrayList<>();

        System.out.println("Enter the number of teams: ");
        teamNumber = input.nextInt();

        addTeam(teams, teamNumber);
        fixtureBuilder(teamsFixture, teams);

    }

    public static void print(ArrayList<String> list) {
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void addTeam(ArrayList<String> list, int number) {
        System.out.println("Enter the name of team: ");
        for (int i=0; i<number; i++) {
            System.out.println((i+1)+". team: ");
            list.add(input.next());
        }
        if(list.size()%2!=0) {
            list.add("Bay");
        }
        System.out.println("\nTeams ---> ");
        print(list);
    }


    public static void fixtureBuilder(ArrayList<String> fixtureList, ArrayList<String> list) {
        Collections.shuffle(list);
        for (int i=0; i<list.size()/2; i++) {
                fixtureList.add(list.get(i)+" vs "+list.get(list.size()-1-i));
        }
        System.out.println("\nFixtures of Teams ---> ");
        print(fixtureList);
    }
}
