package freeedit;
import java.awt.*;
import javax.swing.*;
public class FreeEdit {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Free Editor");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    JMenuBar jbar1 = new JMenuBar();
	    JMenu file_op= new JMenu("File");
	    JMenu edit_op= new JMenu("Edit");
	    JMenu help_op= new JMenu("Help");
	    JMenuItem save_op = new JMenuItem("Save");
	    JMenuItem saveall_op = new JMenuItem("Save All");
	    JMenuItem exit_op = new JMenuItem("Exit");
	    JMenuItem cut_op = new JMenuItem("Cut");
	    JMenuItem copy_op = new JMenuItem("Copy");
	    JMenuItem paste_op = new JMenuItem("Paste");
	    JMenuItem undo_op = new JMenuItem("Undo");
	    JMenuItem redo_op = new JMenuItem("Redo");
	    jbar1.add(file_op);
	    jbar1.add(edit_op);
	    jbar1.add(help_op);
	    file_op.add(save_op);
	    file_op.add(saveall_op);
	    file_op.add(exit_op);
	    edit_op.add(cut_op);
	    edit_op.add(copy_op);
	    edit_op.add(paste_op);
	    edit_op.add(undo_op);
	    edit_op.add(redo_op);
	    JLabel edtxt=new JLabel("Set filename:");
	    JTextField txtfname = new JTextField(20);
	    JButton FreeSave= new JButton("Save as .free file");
	    JTextArea sourcode= new JTextArea();
	    JPanel panel = new JPanel();
	    panel.add(edtxt);
	    panel.add(txtfname);
	    panel.add(FreeSave);
	   frame.getContentPane().add(BorderLayout.NORTH,jbar1);
	   frame.getContentPane().add(BorderLayout.SOUTH,panel);
	   frame.getContentPane().add(BorderLayout.CENTER,sourcode);
	   frame.setVisible(true);
	    
	}
	}
