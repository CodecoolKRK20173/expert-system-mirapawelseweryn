import java.util.*;

class RuleRepository {
    private List<Question> questions;

    public RuleRepository() {
        List<Question> questions = new ArrayList<Question>();

    }
    public void addQuestion(Question question){
        this.questions.add(question);
    }
    public Iterator<Question> getIterator() {
        Iterator<Question> qIter = questions.listIterator();
        return qIter;
    }
}