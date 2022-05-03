package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Полякова А. В.","20IT11", rndMass());
        Student s2 = new Student("Лопатина А. Д.","20IT37", rndMass());
        Student s3 = new Student("Михайлов А. И.","20IT17", rndMass());
        Student s4 = new Student("Гончаров И. А.","20IT17", rndMass());
        Student s5 = new Student("Миронова М. Е.","20IT47", rndMass());
        Student s6 = new Student("Уткина В. Л.","20IT17", rndMass());
        Student s7 = new Student("Исаев М. Г.","20IT10", rndMass());
        Student s8 = new Student("Сидорова А. А.","20IT17", rndMass());
        Student s9 = new Student("Белкин Т. С.","20IT17", rndMass());
        Student s10 = new Student("Крюкова Д. Я.","20IT57", rndMass());
        Student[] list = new Student[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
        for (var m: list) {
            m.printInfo();
        }
        System.out.println("\n \n \n");
        Student.sortByGrades(list);
        Student.reflectOnly4and5(list);

    }
    public static int[] rndMass(){
        int[] mass = new int[5];
            for(int j = 0; j < 5;j++){
                mass[j] = ThreadLocalRandom.current().nextInt(2,5+1);
            }
            return mass;
    }
}
class Student {
    String name;
    String groupNumber;
    int[] grades;


    Student(String name, String groupNumber, int[] grades) {
        this.name = name;
        this.groupNumber = groupNumber;
        this.grades = grades;
    }
    void printInfo(){
        System.out.printf("Имя :%s, Группа: %s, оценки: %s\n", name,groupNumber, Arrays.toString(grades));
    }

    static void sortByGrades(Student[] list){
        System.out.println("//Сортировка по среденему баллу//");
        double[] averageGrades = new double[list.length];
        int gradesSummary;
        for (int i = 0; i < list.length; i++) {
            gradesSummary = 0;
            for (int j = 0; j < list[i].grades.length; j++) {
                gradesSummary += list[i].grades[j];
            }
            averageGrades[i] = gradesSummary / 5.0;
        }
        double[] sortedAvgGrades = Arrays.copyOf(averageGrades, averageGrades.length);
        Arrays.sort(sortedAvgGrades);
        for(int i =0; i< averageGrades.length; i++){
            for(int j = 0; j<averageGrades.length;j++){
                if (averageGrades[j] == sortedAvgGrades[i]){
                    list[j].printInfo();
                    averageGrades[j] = -1;
                }
            }
        }
    }
    static void reflectOnly4and5(Student[] list){
        System.out.println("//Только с оценками 4 и 5//");
        boolean isGradesGood;
        for(int i = 0;i < list.length; i++){
            isGradesGood = true;
            for(int j = 0; j < list[i].grades.length; j++){
                if (list[i].grades[j] < 4){
                    isGradesGood = false;
                }
            }
            if (isGradesGood){
                System.out.println(list[i].name.split(" ")[0] + " " + list[i].groupNumber);
            }
        }
    }
}