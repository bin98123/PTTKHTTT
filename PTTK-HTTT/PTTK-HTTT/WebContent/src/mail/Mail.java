package mail;

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

public class Mail {
	public static void sendMail(String recepient) throws MessagingException {
		System.out.println("Preparing to send mail.....");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

//		String myAccountEmail = "quockhanhtl156@gmail.com";
		String myAccountEmail = "quockhanhtl156@gmail.com";
		String userAccountEmail = "tranhungd264@gmail.com";
//		String userAccountEmail = "18130112@st.hcmuaf.edu.vn";
		String password = "lbuoeixyqfzkgmgt";
//		String password = "xxxxxx";
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccountEmail, password);

			}
		});
		Message message = prepareMessge(session, myAccountEmail, recepient);
		Transport.send(message);
		System.out.println("Message have sent successfully!!!");

	}

	private static Message prepareMessge(Session session, String myAccountEmail, String recepient) {
		// TODO Auto-generated method stub
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//			message.setSubject("My first java mail app");
			message.setSubject("REQUIRE CREATING A ACCOUNT HAS BEEN ACCEPTED");
//			message.setText(
//					"Xin chào, \n Yêu cầu tạo tài khoản RacingGame đã được chấp nhận, vui lòng xác nhận qua đường liên kết! \n google.com");
//			message.setText(
//					"Hello,\n RacingGame account creation request has been accepted, please confirm the link! \n google.com");
			message.setText(
					"Hello,\n RacingGame account creation request has been accepted, please confirm the link! \n http://localhost:8080/TypingGame/home.jsp");
//			message.setText("Xin chào, Yêu cầu tạo tài khoản RacingGame đã được chấp nhận");
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public static void main(String[] args) throws MessagingException {
//		new Mail().sendMail("tranhungd264@gmail.com");
		// gửi ko đc có thể do phần mềm diệt virus
		new Mail().sendMail("18130112@st.hcmuaf.edu.vn");
	}
}
