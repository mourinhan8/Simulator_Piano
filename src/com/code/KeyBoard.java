package com.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class KeyBoard extends JFrame implements MouseListener {

    private WhiteKey[] whiteKeys = new WhiteKey[10];
    private BlackKey[] blackKeys = new BlackKey[7];

    private MidiChannel channel;

    static int firstNote = 48;


    KeyBoard() {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());
            Instrument[] instruments = synthesizer.getLoadedInstruments();
            MidiChannel[] channels = synthesizer.getChannels();
            for (MidiChannel ch : channels) {
                if (ch != null) {
                    this.channel = ch;
                    break;
                }
            }
            for (int i = 0; i < instruments.length; i++) {
                if (instruments[i].toString().startsWith("Instrument MidiPiano")) {
                    this.channel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    private void changeOctave() {
        for (int i = 0; i < whiteKeys.length; i++)
            whiteKeys[i].update(firstNote, i);
        for (int i = 0; i < blackKeys.length; i++)
            blackKeys[i].update(firstNote, i);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        this.channel.noteOn(key.getNote(), 127);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        this.channel.noteOff(key.getNote());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void createAndShowPiano() {
        JPanel panel = new JPanel(null) {

            @Override
            public Dimension getPreferredSize() {
                int c = getComponentCount();
                Component last = getComponent(c - 1);
                Rectangle bound = last.getBounds();
                int width = 10 + bound.x + bound.width;
                int height = 50 + bound.y + bound.height;

                return new Dimension(width, height);
            }

            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };

        for (int i = 0; i < blackKeys.length; i++) {
            blackKeys[i] = new BlackKey(i);
            panel.add(blackKeys[i]);
            blackKeys[i].addMouseListener(this);
        }
        for (int i = 0; i < whiteKeys.length; i++) {
            whiteKeys[i] = new WhiteKey(i);
            panel.add(whiteKeys[i]);
            whiteKeys[i].addMouseListener(this);
        }
        JButton plus = new JButton("+ octave");
        plus.setBounds(780, 270, 100, 30);
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KeyBoard.firstNote += 16;
                changeOctave();
            }
        });
        JButton minus = new JButton("- octave");
        minus.setBounds(780, 310, 100, 30);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KeyBoard.firstNote -= 16;
                changeOctave();
            }
        });
        panel.add(plus);
        panel.add(minus);
        JFrame frame = new JFrame("Vitural Piano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(new JScrollPane(panel));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


interface Key {
    int WD = 50;
    int HT = (WD * 9) / 2;

    int getNote();
}
