package model;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.AccountDao;

public class MailAPI {
	public int sendMail(String recepient) throws MessagingException {
		int result = 0;
		System.out.println("Preparing to send mail.....");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		String myAccountEmail = "quockhanhtl156@gmail.com";
//		String myAccountEmail = "18130112@st.hcmuaf.edu.vn";
//		String userAccountEmail = "tranhungd264@gmail.com";
//		String userAccountEmail = "18130112@st.hcmuaf.edu.vn";
		String password = "lbuoeixyqfzkgmgt";
//		String password = "xxxxxx";
		AccountDao dao = new AccountDao();
		String pass = dao.getPasswordByMail(recepient);
		String name = dao.getAccountNameByMail(recepient);
		if (pass != null) {
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(myAccountEmail, password);

				}
			});
			Message message = prepareMessge(name, pass, session, myAccountEmail, recepient);
			Transport.send(message);
			result = 1;
			System.out.println("Message have sent successfully!!!");
		}
		return result;
	}

	private Message prepareMessge(String name, String pass, Session session, String myAccountEmail, String recepient) {
		// TODO Auto-generated method stub
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//			message.setSubject("My first java mail app");
			message.setSubject("REQUIRE GET PASSWORD HAS BEEN ACCEPTED");
//			message.setText(
//					"Xin ch??o, \n Y??u c???u t???o t??i kho???n RacingGame ???? ???????c ch???p nh???n, vui l??ng x??c nh???n qua ???????ng li??n k???t! \n google.com");
//			message.setText(
//					"Hello,\n RacingGame account creation request has been accepted, please confirm the link! \n google.com");
			String text = "Hello," + name + "\n Get password request has been accepted, " + "Your password is: " + pass
					+ "\n Please confirm the link! \n http://localhost:8080/PTTK-HTTT/login.jsp";
			message.setText(text);
//			message.setText(
//					"Hello,\n Reset password request has been accepted, please confirm the link! \n http://localhost:8080/PTTK-HTTT/login.jsp");
//			message.setText("Xin ch??o, Y??u c???u t???o t??i kho???n RacingGame ???? ???????c ch???p nh???n");
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(MailAPI.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public MailAPI() {

	}

	public static void main(String[] args) throws MessagingException {
//		new Mail().sendMail("tranhungd264@gmail.com");
		// g????i ko ??c co?? th???? do ph????n m????m di????t virus
//		new MailAPI().sendMail("quockhanhtl156@gmail.com");
//		new MailAPI().sendMail("18130112@st.hcmuaf.edu.vn");
	}
}
