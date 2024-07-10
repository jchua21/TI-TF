import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageUploadApp {
    private JFrame uploadFrame;
    private JLabel imageLabel;
    private File selectedFile;

    public ImageUploadApp() {
        // Configuración de la ventana de carga de imagen
        uploadFrame = new JFrame("Image Upload");
        uploadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uploadFrame.setSize(600, 400);
        uploadFrame.setLayout(new BorderLayout());

        // Botón para cargar la imagen
        JButton uploadButton = new JButton("Upload Image");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(uploadFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    displayImage(selectedFile);
                }
            }
        });

        // Botón para mostrar el texto extraído
        JButton showTextButton = new JButton("Show Extracted Text");
        showTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFile != null) {
                    new ExtractedTextFrame(selectedFile).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(uploadFrame, "Please upload an image first.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel para mostrar la imagen
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Añadir componentes al frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);
        buttonPanel.add(showTextButton);

        uploadFrame.add(buttonPanel, BorderLayout.NORTH);
        uploadFrame.add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        uploadFrame.setVisible(true);
    }

    private void displayImage(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageUploadApp();
            }
        });
    }
}
