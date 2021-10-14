package gui;

import javax.jws.WebMethod;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.Account;

import java.awt.Font;

public class AccountGUI extends JFrame {
	public AccountGUI() {
		getContentPane().setLayout(null);
		setSize(392, 275);
		
		JLabel lblUserInformation = new JLabel("Account Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUserInformation.setBounds(21, 21, 180, 29);
		getContentPane().add(lblUserInformation);
		
		JLabel lblNombreApellido = new JLabel("NOMBRE, APELLIDO");
		lblNombreApellido.setBounds(21, 61, 314, 23);
		getContentPane().add(lblNombreApellido);
		lblNombreApellido.setText(getAccountInfo("name") + " " + getAccountInfo("surname"));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(21, 90, 79, 23);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(21, 111, 79, 23);
		getContentPane().add(lblPassword);
		
		JLabel lblBankAccount = new JLabel("Bank Account:");
		lblBankAccount.setBounds(21, 145, 90, 23);
		getContentPane().add(lblBankAccount);
		
		JLabel lblWallet = new JLabel("Wallet:");
		lblWallet.setBounds(21, 168, 46, 14);
		getContentPane().add(lblWallet);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(21, 200, 329, 23);
		getContentPane().add(lblEmail);
		lblEmail.setText(getAccountInfo("email"));
		
		JLabel lblUsername_1 = new JLabel("username");
		lblUsername_1.setBounds(90, 95, 260, 19);
		getContentPane().add(lblUsername_1);
		lblUsername_1.setText(getAccountInfo("username"));
		
		JLabel lblContrasena = new JLabel("contrasena");
		lblContrasena.setBounds(83, 115, 267, 14);
		getContentPane().add(lblContrasena);
		lblContrasena.setText(getAccountInfo("password"));
		
		JLabel lblDineros = new JLabel("dineros");
		lblDineros.setBounds(65, 168, 285, 14);
		getContentPane().add(lblDineros);
		lblDineros.setText(getAccountInfo("wallet"));
		
		JLabel lblDineroscuenta = new JLabel("dinerosCuenta");
		lblDineroscuenta.setBounds(98, 149, 252, 14);
		getContentPane().add(lblDineroscuenta);
		lblDineroscuenta.setText(getAccountInfo("card"));
		
		
	}

	/**
	 * Method to get the actual user information
	 * @param info
	 * @return
	 */
	@WebMethod public String getAccountInfo(String info){
		Account cuenta =LoginRegisterGUI.getBusinessLogic().getAccount(LoginRegisterGUI.getBusinessLogic().getLoggedUsername());
    	String s = null;

		switch (info.toLowerCase()) {
    	
		case "username":
			s = cuenta.getUserName();
			break;
		case "password":
			s = cuenta.getPassword();
			break;
		case "name":
			s = cuenta.getRealName();
			break;
		case "surname":
			s = cuenta.getSurname();
			break;
		case "card":
			s = cuenta.getUserBankCard();
			break;
		case "email":
			s = cuenta.getUserEmail();
			break;
		case "wallet":
			s = Double.toString(cuenta.getWallet());
			break;
		default:
			System.out.println("Error. La informacion deseada no esta contemplada. Codigo 12");
			break;
		} 
    	return s;
    }
    
}
