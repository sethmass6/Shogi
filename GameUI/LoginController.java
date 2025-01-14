package GameUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginController implements ActionListener{

	LoginPanel loginPanel; 
	GameGUI view; 
	public LoginController(LoginPanel loginPanel, GameGUI view) {
		// TODO Auto-generated constructor stub
		this.loginPanel = loginPanel; 
		this.view = view; 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JButton) {
			JButton actionButton = (JButton)arg0.getSource(); 
			if (actionButton.getName().equals("Submit")) {
			   //later logic can be added here... for the time being, we will rotate back to the initial panel so i dont have to restart for testing
				String username = this.loginPanel.getUsernameField().getText(); 
				String password = this.loginPanel.getPasswordField().getPassword().toString(); 
				System.out.println("Made it here");
				if (username.length() < 6 || password.length() < 6) {
					this.setError("Both fields are, by default, required to be longer than 6 characters");
					return; 
				}
				else {
					System.out.println(String.format("username: %s\npassword: %s", username, password));
				}
				
				//need to contact the communication object HERE
				
				this.view.shuffleSelectCreateGameOrSelectGamePanel();
			}
			else if(actionButton.getName().equals("Cancel")) {
				setError(" ");
				this.view.shuffleToInitial();
			}
		}
		
	}
	
	//call this if there is a login failure
	public void loginFailure(String error) {
		this.setError(error);
	}
	
	
	private void setError(String error) {
		//if you try to add a blank error, it will mess up my formatting
		if (error.contentEquals("")) {
			error = " "; 
		}
		this.loginPanel.getErrorLabel().setText(error); 
		

	}

	//call this is there is a login success
	public void loginSuccess() {
	}
}
