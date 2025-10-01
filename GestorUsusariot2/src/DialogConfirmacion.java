import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DialogConfirmacion extends JDialog {

    private Boolean accepted = null;

    public DialogConfirmacion(Window owner, String message) {
        super(owner, "Confirmación", ModalityType.APPLICATION_MODAL);
        initComponents(message);
    }

    private void initComponents(String message) {
        JPanel root = new JPanel(new BorderLayout(10,10));
        root.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel lbl = new JLabel(message);
        root.add(lbl, BorderLayout.CENTER);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        JButton ok = new JButton("Aceptar");
        JButton cancel = new JButton("Cancelar");

        ok.addActionListener((ActionEvent e) -> {
            accepted = Boolean.TRUE;
            setVisible(false);
            dispose();
        });
        cancel.addActionListener((ActionEvent e) -> {
            accepted = Boolean.FALSE;
            setVisible(false);
            dispose();
        });

        btns.add(ok);
        btns.add(cancel);
        root.add(btns, BorderLayout.SOUTH);

        setContentPane(root);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(320,120));
    }

    public Boolean getAccepted() {
        return accepted;
    }
}
