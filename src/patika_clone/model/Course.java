package patika_clone.model;

import java.util.ArrayList;

public class Course {
    private String title;
    private String explanation;
    private String link;
    public static ArrayList<String> questions;
    private String lesson;
    private String educator;

    public static ArrayList<String> students;

    public static String comment;

    public Course(String title, String explanation, String lesson) {
        this.title = title;
        this.explanation = explanation;
        this.link = null;
        this.lesson = lesson;
        this.educator = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
