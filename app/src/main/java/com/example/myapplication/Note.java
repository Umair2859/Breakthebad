package com.example.myapplication;

public class Note {
    String task1, task2, task3, task4, task5, task6, task7, no;
public  Note(){}

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Note(String task1, String task2, String task3, String task4, String task5, String task6, String task7, String no) {
        this.task1 = task1;
        this.task2 = task2;
        this.task3 = task3;
        this.task4 = task4;
        this.task5 = task5;
        this.task6 = task6;
        this.task7 = task7;
        this.no=no;
    }

    public String getTask1() {
        return task1;
    }

    public void setTask1(String task1) {
        this.task1 = task1;
    }

    public String getTask2() {
        return task2;
    }

    public void setTask2(String task2) {
        this.task2 = task2;
    }

    public String getTask3() {
        return task3;
    }

    public void setTask3(String task3) {
        this.task3 = task3;
    }

    public String getTask4() {
        return task4;
    }

    public void setTask4(String task4) {
        this.task4 = task4;
    }

    public String getTask5() {
        return task5;
    }

    public void setTask5(String task5) {
        this.task5 = task5;
    }

    public String getTask6() {
        return task6;
    }

    public void setTask6(String task6) {
        this.task6 = task6;
    }

    public String getTask7() {
        return task7;
    }

    public void setTask7(String task7) {
        this.task7 = task7;
    }
}