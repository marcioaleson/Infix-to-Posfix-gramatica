package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import infixtoprefix.AcoesSemanticas;
import infixtoprefix.infixtoposfixLexer;
import infixtoprefix.infixtoposfixParser;

public class MainGUI implements ActionListener {
	
	JTextField expressao;
	JTextField resultado;

	MainGUI() {
		JFrame jfrm = new JFrame("Text Fields");
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(200, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		expressao = new JTextField(10);
		resultado = new JTextField(10);
		resultado.setEditable(false);

		JPanel inFieldPane = new JPanel();
		inFieldPane.setLayout(new GridLayout(2, 2));
		inFieldPane.add(new JLabel("Expressão:"));
		inFieldPane.add(expressao);
		expressao.addActionListener(this);
		jfrm.add(inFieldPane, BorderLayout.NORTH);

		JPanel submitPane = new JPanel();
		submitPane.setLayout(new FlowLayout());
		JButton submitButton = new JButton("Iniciar");
		submitButton.addActionListener(this);
		submitPane.add(submitButton);
		jfrm.add(submitPane, BorderLayout.CENTER);

		JPanel outFieldPane = new JPanel();
		outFieldPane.setLayout(new GridLayout(1, 2));
		outFieldPane.add(new JLabel("Resultado:"));
		outFieldPane.add(resultado);
		jfrm.add(outFieldPane, BorderLayout.SOUTH);

		jfrm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Iniciar")) {
			
			//Input
			ANTLRInputStream stream = new ANTLRInputStream(expressao.getText() + "\n");
			// Lexico
			infixtoposfixLexer lexer = new infixtoposfixLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Sintatico
			infixtoposfixParser parser = new infixtoposfixParser(tokens);
			ParseTree tree = parser.prog();
			//System.out.println(tree.toStringTree(parser));

			// Acoes Semanticas
			ParseTreeWalker walker = new ParseTreeWalker();
			AcoesSemanticas acoes = new AcoesSemanticas();
			walker.walk(acoes, tree);

			String fullString = resultado.getText().trim() + ", " + acoes.output.trim();
			resultado.setText(fullString);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainGUI();
			}
		});
	}
}