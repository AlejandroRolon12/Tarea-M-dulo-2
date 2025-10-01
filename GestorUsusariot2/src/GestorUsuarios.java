import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalTime;

public class GestorUsuarios extends JFrame {

    private JTextField nombreField;
    private JTextField emailField;
    private JComboBox<String> rolCombo;
    private JCheckBox activoCheck;
    private JTextArea notasArea;
    private JTextArea resumenArea;
    private JTextArea logsArea;

    public GestorUsuarios() {
        setTitle("Gestor de usuarios");
        setSize(900, 600);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        setContentPane(root);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("Gestor de usuarios");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        if (icon != null) {
            titleLabel.setIcon(icon);
            titleLabel.setIconTextGap(10);
        }
        headerPanel.add(titleLabel, BorderLayout.WEST);
        root.add(headerPanel, BorderLayout.NORTH);

        JPanel navPanel = new JPanel(new GridLayout(5, 1, 0, 5));
        navPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] navs = {"Dashboard", "Usuarios", "Informes", "Ajustes", "Ayuda"};
        for (String n : navs) {
            JButton b = new JButton(n);
            b.setFocusable(false);
            navPanel.add(b);
        }
        navPanel.setPreferredSize(new Dimension(140, 0));
        root.add(navPanel, BorderLayout.WEST);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; formPanel.add(new JLabel("Nombre:"), c);
        nombreField = new JTextField();
        c.gridx = 1; c.gridy = 0; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nombreField, c);

        c.gridx = 0; c.gridy = 1; c.weightx = 0; c.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Email:"), c);
        emailField = new JTextField();
        c.gridx = 1; c.gridy = 1; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(emailField, c);

        c.gridx = 0; c.gridy = 2; c.weightx = 0; c.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Rol:"), c);
        rolCombo = new JComboBox<>(new String[]{"Admin", "Editor", "Invitado"});
        c.gridx = 1; c.gridy = 2; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(rolCombo, c);

        c.gridx = 0; c.gridy = 3; c.weightx = 0; c.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Activo:"), c);
        activoCheck = new JCheckBox();
        c.gridx = 1; c.gridy = 3; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(activoCheck, c);

        c.gridx = 0; c.gridy = 4; c.weightx = 0; c.weighty = 0; c.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Notas:"), c);
        notasArea = new JTextArea(6, 30);
        JScrollPane notasScroll = new JScrollPane(notasArea);
        c.gridx = 1; c.gridy = 4; c.weightx = 1; c.weighty = 1; c.fill = GridBagConstraints.BOTH;
        formPanel.add(notasScroll, c);

        JScrollPane centerScroll = new JScrollPane(formPanel);
        centerScroll.setBorder(null);
        root.add(centerScroll, BorderLayout.CENTER);

        JPanel previewPanel = new JPanel(new BorderLayout());
        previewPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        previewPanel.setPreferredSize(new Dimension(260, 0));
        JTabbedPane tabs = new JTabbedPane();

        resumenArea = new JTextArea();
        resumenArea.setEditable(false);
        tabs.add("Resumen", new JScrollPane(resumenArea));

        logsArea = new JTextArea();
        logsArea.setEditable(false);
        tabs.add("Logs", new JScrollPane(logsArea));

        previewPanel.add(tabs, BorderLayout.CENTER);
        root.add(previewPanel, BorderLayout.EAST);

        JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton cancelarBtn = new JButton("Cancelar");
        JButton limpiarBtn = new JButton("Limpiar");
        JButton guardarBtn = new JButton("Guardar");
        getRootPane().setDefaultButton(guardarBtn);

        cancelarBtn.addActionListener(e -> onCancelar());
        limpiarBtn.addActionListener(e -> onLimpiar());
        guardarBtn.addActionListener(e -> onGuardar());

        buttonBar.add(cancelarBtn);
        buttonBar.add(limpiarBtn);
        buttonBar.add(guardarBtn);
        root.add(buttonBar, BorderLayout.SOUTH);

        logsArea.setText("Inicializado el gestor de usuarios.\n");
    }

    private void onCancelar() {
        int r = JOptionPane.showConfirmDialog(this, "¿Salir sin guardar?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (r == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void onLimpiar() {
        nombreField.setText("");
        emailField.setText("");
        rolCombo.setSelectedIndex(0);
        activoCheck.setSelected(false);
        notasArea.setText("");
        resumenArea.setText("");
        logsArea.append("Formulario limpiado.\n");
    }

    private void onGuardar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreField.getText()).append("\n");
        sb.append("Email: ").append(emailField.getText()).append("\n");
        sb.append("Rol: ").append(rolCombo.getSelectedItem()).append("\n");
        sb.append("Activo: ").append(activoCheck.isSelected() ? "Sí" : "No").append("\n\n");
        sb.append("Notas:\n").append(notasArea.getText()).append("\n");
        resumenArea.setText(sb.toString());

        DialogConfirmacion dialog = new DialogConfirmacion(this, "¿Guardar cambios?");
        dialog.setModal(true);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        Boolean accepted = dialog.getAccepted();
        if (Boolean.TRUE.equals(accepted)) {
            logsArea.append(String.format("[%s] Guardado: %s <%s>\n",
                    LocalTime.now().withNano(0), nombreField.getText(), emailField.getText()));
            JOptionPane.showMessageDialog(this, "Datos guardados (simulado).",
                    "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logsArea.append("Guardado cancelado.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorUsuarios g = new GestorUsuarios();
            g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            g.setVisible(true);
        });
    }
}
