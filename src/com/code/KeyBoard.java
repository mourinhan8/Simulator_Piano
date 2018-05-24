package com.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class KeyBoard extends JFrame implements MouseListener {

    private WhiteKey[] whiteKeys = new WhiteKey[10];
    private BlackKey[] blackKeys = new BlackKey[7];

    private MidiChannel channel;

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
        JPanel contentPane = new JPanel(null) {
            @Override
            public Dimension getPreferredSize() {
                int c = getComponentCount();
                Component last = getComponent(c - 1);
                Rectangle bound = last.getBounds();
                int width = 10 + bound.x + bound.width;
                int height = 10 + bound.y + bound.height;
                return new Dimension(width, height);
            }

            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };

        for (int i = 0; i < blackKeys.length; i++) {
            blackKeys[i] = new BlackKey(i);
            contentPane.add(blackKeys[i]);
            blackKeys[i].addMouseListener(this);
        }
        for (int i = 0; i < whiteKeys.length; i++) {
            whiteKeys[i] = new WhiteKey(i);
            contentPane.add(whiteKeys[i]);
            whiteKeys[i].addMouseListener(this);
        }
        JFrame frame = new JFrame("Vitural Piano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(contentPane);
        frame.add(new JScrollPane(contentPane));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

interface Key {
    int WD = 50;
    int HT = (WD * 9) / 2;
    int firstNote = 48;

    int getNote();
}
