package com.code;

import javax.swing.*;
import java.awt.*;

class WhiteKey extends JButton implements Key {

    private int note;

    WhiteKey(int pos) {
        note = KeyBoard.firstNote + 2 * pos - (pos + 4) / 7 - pos / 7;
        int WWD = (WD * 3) / 2;
        int left = 10 + WWD * pos;
        setBackground(Color.WHITE);
        int WHT = (HT * 3) / 2;
        setBounds(left, 10, WWD, WHT);
    }

    void update(int n, int p) {
        this.note = n + 2 * p - (p + 4) / 7 - p / 7;
    }

    public int getNote() {
        return note;
    }
}
