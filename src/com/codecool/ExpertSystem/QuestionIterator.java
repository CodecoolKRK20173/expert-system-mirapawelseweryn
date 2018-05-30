import java.util.*;

public class QuestionIterator implements Iterator<Question> {
    private List<Question> questions;
    private int index;

    public QuestionIterator(ArrayList<Question> questions) {
        this.index = 0;
        this.questions = questions;
    }

    @Override
    public boolean hasNext() {
        return index < questions.size();
    }

    @Override
    public Question next() {
        return questions.get(this.index++);
    }
}