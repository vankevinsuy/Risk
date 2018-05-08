package introduction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse_control extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		System.out.println("ddd");
	}
}
