package com.example.coderspool;

public class QModel {
    private String quizName;
    private int quizImage;

    public QModel(){

    }

    public QModel(String quizName, int quizImage) {
        this.quizName = quizName;
        this.quizImage = quizImage;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getQuizImage() {
        return quizImage;
    }

    public void setQuizImage(int quizImage) {
        this.quizImage = quizImage;
    }
}
