package com.friendsurance.impl.executer;


import com.friendsurance.impl.model.Member;
import com.friendsurance.processing.ItemReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileItemReader implements ItemReader<Member> {

    private BufferedReader dataResourceReader;

    public FileItemReader(String filePath) throws FileNotFoundException {
        this.dataResourceReader = new BufferedReader(new FileReader(filePath));
    }

    public Member read() {

        Member member = null;
        try {
            String itemString = dataResourceReader.readLine();
            if (itemString == null) {
                dataResourceReader.close();
            }
            member = Member.clone(itemString);
        } catch (Exception e) {

        }
        return member;
    }
}
