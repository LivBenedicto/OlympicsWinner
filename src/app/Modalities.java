package app;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Modalities {
    static Scanner scanner = new Scanner(System.in);
    private static int chooseModality;

    // initializer
    public static void ChooseModality() {

        do {
            System.out.println("\nDeterminate the winner of: \n1 - Artistic Gymnastics\n2 - Judo"
                    + "\n3 - Shot Put\n4 - Weightlifting\nType a random number to exit.");
            chooseModality = scanner.nextInt();

            switch (chooseModality) {
                case 1:
                    ArtisticGymnasticsModality();
                    break;

                case 2:
                    JudoModality();
                    break;

                case 3:
                    ShotPutModality();
                    break;

                case 4:
                    WeightliftingModality();
                    break;

                default:
                    System.out.println("Exiting...");
                    break;
            }
        } while (chooseModality < 5); // Isn't a valid modality!

        scanner.close();
    }

    private static String FindWinner(Map<String, Double> biggestGradeAthletes) {
        double biggestTotalGrade = Collections.max(biggestGradeAthletes.values());
        for (Entry<String, Double> biggest : biggestGradeAthletes.entrySet()) {
            if (biggest.getValue() == biggestTotalGrade)
                return String.format("Winner: %s, points: %.2f", biggest.getKey(), biggest.getValue());
        }
        return "There's no winner.";
    }

    private static void ArtisticGymnasticsModality() {
        System.out.println("\nRecord the athlete's five grades, one for once." + "\n"
                + "Remember: the lowest grade isn't contabilize!\n" + "\nHow many athletes do you want to compare?");
        int countAthletes = scanner.nextInt();
        Map<String, Double> biggestGradeAthletes = new HashMap<String, Double>(countAthletes);

        for (int countAthlete = 1; countAthlete <= countAthletes; countAthlete++) {
            String numberAthlete = "#" + countAthlete + " Athlete";
            System.out.println(numberAthlete);
            ArtisticGymnastics athlete = new ArtisticGymnastics();

            for (int grade = 1; grade < 6; grade++) {
                System.out.print("Enter with the #" + grade + " grade: ");
                athlete.AddGrade(scanner.nextDouble());
            }
            System.out.println(athlete.FinalSumGrades());
            biggestGradeAthletes.put(numberAthlete, athlete.Get_finalSumGrades());
        }
        System.out.println(FindWinner(biggestGradeAthletes));
    }

    private static void JudoModality() {
        Judo judoFisrt = new Judo();
        judoFisrt.set_athleteNumber("#1 Athlete");
        Judo judoSecond = new Judo();
        judoSecond.set_athleteNumber("#2 Athlete");

        System.out.println("\nRules for athlete score:\n(1) Yuko: more points wins\n"
                + "(2) Wazari: more points wins, independent of Yuko points\n(3) The fight is over, Ippon: wins!\n"
                + "Type a random number exit.\n");
        int enterAttack = 0;

        do {
            System.out.println("First athlete attack: ");
            enterAttack = scanner.nextInt();
            if (enterAttack == 1)
                judoFisrt.set_yuko();
            else if (enterAttack == 2)
                judoFisrt.set_wazari();
            else if (enterAttack == 3) {
                judoFisrt.set_ippon();
                System.out.println("#1 Athlete attack Ippon and wins!");
                break;
            }

            System.out.println("Second athlete attack: ");
            enterAttack = scanner.nextInt();
            if (enterAttack == 1)
                judoSecond.set_yuko();
            else if (enterAttack == 2)
                judoSecond.set_wazari();
            else if (enterAttack == 3) {
                judoSecond.set_ippon();
                System.out.println("#2 Athlete attack Ippon and wins!");
                break;
            }

        } while (enterAttack < 3);
        System.out.println(judoFisrt.Attacks());
        System.out.println(judoSecond.Attacks());
        System.out.println("Existing...");
    }

    private static void ShotPutModality() {
        System.out.println("\nRecord the three pitches"
                + "\nThe classification position are defined by the longest distance between the pitches."
                + "\nRemember: In case of tie, the second longest distance is the valid one"
                + "\nHow many athletes do you want to compare?");
        int countAthletes = scanner.nextInt();

        Map<String, List<Double>> biggestPitchAthletes = new HashMap<String, List<Double>>(countAthletes);

        for (int countAthlete = 1; countAthlete <= countAthletes; countAthlete++) {
            String numberAthlete = "#" + countAthlete + " Athlete";
            System.out.println(numberAthlete);
            ShotPut shotPut = new ShotPut();
            shotPut.set_athleteNumber(numberAthlete);

            for (int pitch = 1; pitch < 4; pitch++) {
                System.out.print("Enter with the #" + pitch + " pitch: ");
                shotPut.AddShotPut(scanner.nextDouble());
            }
            biggestPitchAthletes.put(shotPut.get_athleteNUmber(), shotPut.GetPitches());
        }
        System.out.println(FindWinnerShotPut(biggestPitchAthletes));
    }

    private static String FindWinnerShotPut(Map<String, List<Double>> biggestPitchAthletes) {
        double biggestPitch = 0.0;
        String winner = "";
        for (Entry<String, List<Double>> pichesAthlete : biggestPitchAthletes.entrySet()) {
            if (pichesAthlete.getValue().get(2) > biggestPitch) {
                biggestPitch = pichesAthlete.getValue().get(2);
                winner = pichesAthlete.getKey();
            } else if (pichesAthlete.getValue().get(2) == biggestPitch) {
                biggestPitch = pichesAthlete.getValue().get(1);
                winner = pichesAthlete.getKey();
            }
        }
        return String.format("Winner: %s, points: %.2f", winner, biggestPitch);
    }

    private static void WeightliftingModality() {
        System.out.println("Remember: wins the athlete who care's the greater amount of weight."
                + "\nHow many athletes do you want to compare?");
        int countAthletes = scanner.nextInt();
        Map<String, Double> biggestWeightAthletes = new HashMap<String, Double>(countAthletes);

        for (int countAthlete = 1; countAthlete <= countAthletes; countAthlete++) {
            String numberAthlete = "#" + countAthlete + " Athlete";
            Weightlifting weightlifting = new Weightlifting();

            System.out.print(numberAthlete + " record the weight: ");
            weightlifting.set_weight(scanner.nextDouble());

            biggestWeightAthletes.put(numberAthlete, weightlifting.get_weight());
        }
        System.out.println(FindWinner(biggestWeightAthletes));
    }
}