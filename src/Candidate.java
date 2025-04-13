public class Candidate {
    public String name;
    public int votes;

    public Candidate(String n) {
        name = n;
        this.votes = 0;
    }

    public String toString() {
        return name + " - " + votes;
    }
}
