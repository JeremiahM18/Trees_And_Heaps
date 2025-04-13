import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;

public class Election {
    private Candidate[] heap;
    private int size = 0;

    private int total;
    private int currentVotes;
    private Random random = new Random();


    // Initialize the election system with the list of candidates given
    public void initializeCandidates(LinkedList<String> candidates) {
        size = candidates.size();
        heap = new Candidate[size];
        //indexMap.clear();
        currentVotes = 0;

        for(int i = 0; i < size; i++) {
            heap[i] = new Candidate(candidates.get(i));
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left].votes > heap[largest].votes) {
            largest = left;
        }
        if (right < size && heap[right].votes > heap[largest].votes) {
            largest = right;
        }

        if (largest != i) {
            Candidate temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }

    public void setTotalVotes(int p){
        total = p;
    }
    // Simulate a vote for the specified candidate and update the priority queue
    public void castVote(String name){
        if(currentVotes >= total) return;

        for(Candidate c : heap) {
            if(c.name.equals(name)) {
                c.votes++;
                currentVotes++;
                break;
            }
        }
        buildHeap();
    }
    // Simulate a vote for a random candidate and update the priority queue
    public void castRandomVote(){
        if(currentVotes >= total) return;

        int randomIndex = random.nextInt(size);
        heap[randomIndex].votes++;
        currentVotes++;

        buildHeap();
    }

    // Simulate enough votes for the given candidate to win the election
    // and update the priority queue
    public void rigElection(String winner){
       for(Candidate c : heap) {
           if(c.name.equals(winner)) {
               c.votes = total;
           } else {
               c.votes = 0;
           }
       }
        currentVotes = total;
       buildHeap();
    }

    // Return the top k candidates with the most votes
    public LinkedList<String> getTopKCandidates(int k){
        buildHeap();
        LinkedList<String> standings = new LinkedList<>();

        for (int i = 0; i < k && i < size; i++) {
            standings.add(heap[i].name);
        }
        return standings;
    }

    //Print to console all the candidates and how many votes they got in order from the
    // candidate with the most votes to the candidate with the least amount of votes.
    public void auditElection(){
        buildHeap();
        for(int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }
}
