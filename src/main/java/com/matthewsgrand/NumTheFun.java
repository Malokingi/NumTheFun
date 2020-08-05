package com.matthewsgrand;

public final class NumTheFun {
    private NumTheFun() {}
    public static void main(String[] args) {
        TempFakeDatabase fakeDB = new TempFakeDatabase();
        System.out.println(fakeDB.getIntroDialogue("Main"));
        System.out.println(fakeDB.getMenuDialogue("Main"));
    }
}
