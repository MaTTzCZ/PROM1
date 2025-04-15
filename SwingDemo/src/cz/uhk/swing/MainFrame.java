package cz.uhk.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private Action actExit;

    public MainFrame() {
        setTitle("Moje první okno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // křížek okno vypne aplikaci
        add(createToolBar(), BorderLayout.NORTH);
//        add(new JButton("Sever"), BorderLayout.NORTH);
//        add(new JButton("Sever"), "NORTH");
//        add(new JButton("Jih"), BorderLayout.SOUTH);
//        add(new JButton("Západ"), BorderLayout.WEST);
//        add(new JButton("Východ"), BorderLayout.EAST);
//        add(new JButton("Center"), BorderLayout.CENTER);

        initMouseActions();
        createActions();
        createMenu();

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();

        JMenu mnFile = new JMenu("Soubor");
        mb.add(mnFile);

        mnFile.add(actExit);

        setJMenuBar(mb);
    }

    private void createActions() {
        actExit = new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        actExit.putValue(Action.SHORT_DESCRIPTION, "Ukončuje aplikaci");
        actExit.putValue(Action.ACCELERATOR_KEY,
                KeyStroke.getKeyStroke('X', KeyEvent.ALT_DOWN_MASK)
                );
    }

    private void initMouseActions() {
        addMouseMotionListener(
                new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        getGraphics().fillOval(e.getX(), e.getY(), 5, 5);
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        setTitle(String.format("[%d,%d]", e.getX(), e.getY()));
                    }
                }
        );
    }

    private JToolBar createToolBar() {
        JToolBar p = new JToolBar();
        p.add(new JToggleButton("Prvni"));
        p.add(new JButton("Druhý"));

        JButton btExit = new JButton("Konec");
        p.add(btExit);
//        btExit.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("Aplikace byla ukončena");
//                        System.exit(0); //setVisible(false);
//                    }
//                }
//        );
        btExit.addActionListener(
                (e) -> System.exit(0)
        );

        p.add(actExit);

        return p;
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
