import java.util.LinkedList;

public class ElectionSystem {

    public static void main(String[] args) {
        LinkedList<String> people = new LinkedList<>();
        people.add("Chris Motionless");
        people.add("Oliver Sykes");
        people.add("Matty Mullins");
        people.add("Danny Worsnop");
        people.add("Sam Carter");
        people.add("Ronnie Radke");
        people.add("Leigh Kakaty");
        people.add("Moriah Rose Pereira");
        people.add("Spencer Charnas");

        Election elect = new Election();

        elect.initializeCandidates(people);

        int totalVotes = 5;
        elect.setTotalVotes(totalVotes);

        elect.castVote("Moriah Rose Pereira");
        elect.castVote("Spencer Charnas");
        elect.castVote("Leigh Kakaty");
        elect.castRandomVote();
        elect.castRandomVote();
        elect.castVote("Moriah Rose Pereira");

        System.out.println("\nTop 3 candidates: " + elect.getTopKCandidates(3));
        elect.auditElection();


        elect.rigElection("Chris Motionless");

        System.out.println("Top 3 candidates after rigging the election: " + elect.getTopKCandidates(3));

        System.out.println("\nAudit of election:");
        elect.auditElection();
    }
}
