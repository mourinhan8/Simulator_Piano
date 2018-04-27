package com.code;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class PianoTest {
    @Test
    public void button() {
        KeyBoard st = new KeyBoard();
        JButton button = new JButton("C#");
        String s = button.getText();
        assertTrue( s.contains("#"));
        assertEquals("Music_notes\\C#.wav", st.link(s));
        JButton button1 = new JButton("Bb");
        String s1 = button1.getText();
        assertTrue(s1.contains("b"));
        assertEquals("Music_notes\\Bb.wav", st.link(s1));
        JButton button2 = new JButton("D");
        String s2 = button2.getText();
        assertFalse(button2.getText().contains("b"));
        assertFalse(button2.getText().contains("#"));
        assertEquals("Music_notes\\D.wav", st.link(s2));
    }
}
