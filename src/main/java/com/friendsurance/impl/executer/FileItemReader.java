package com.friendsurance.impl.executer;


import com.friendsurance.impl.model.Member;
import com.friendsurance.processing.ItemReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileItemReader implements ItemReader<Member> {

    private BufferedReader bufferedReader;

    public FileItemReader(String filePath) throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public Member read() {
        Member member = null;
        try {
            String itemString = bufferedReader.readLine();

            if (itemString == null)
                return null; //ToDo handle for exception

            member = Member.clone(itemString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return member;
    }
}
