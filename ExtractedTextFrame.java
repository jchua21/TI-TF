import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ExtractedTextFrame extends JFrame {
    public ExtractedTextFrame(File file) {
        setTitle("Extracted Text");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Área de texto para mostrar el texto simulado
        JTextArea extractedText = new JTextArea();
        extractedText.setEditable(false);
        extractedText.setText("Simulated text: This is an example of text extracted from the image.");

        // Añadir el área de texto al frame
        add(new JScrollPane(extractedText), BorderLayout.CENTER);
    }
}
